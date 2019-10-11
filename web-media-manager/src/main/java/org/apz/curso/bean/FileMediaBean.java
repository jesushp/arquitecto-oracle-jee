package org.apz.curso.bean;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.activation.MimetypesFileTypeMap;

import org.apz.curso.media.Constants;
import org.apz.curso.media.FileMediaManagerImpl;
import org.apz.curso.media.MediaManager;
import org.apz.curso.media.MediaQualifier;


public class FileMediaBean implements Constants{

    private static final Logger logger = Logger.getLogger("org.apz.curso.bean.FileMediaBean");
    
    private final String appURL = "fxmedia/";
    
    private MediaManager mm;
    private int pictureCount, videoCount;
    private List<MediaGroup> groups = new ArrayList<>();
    private MediaQualifier mq = new MediaQualifier();

    public FileMediaBean(String path) {
        try {
            mm = new FileMediaManagerImpl(new File(path), FileMediaManagerImpl.IdFormat.WEB);
            mq.setSortOrder(MediaOrder.TITLE_ASC);
            mq.setTypes(MediaType.IMAGE, MediaType.OGV_VIDEO, MediaType.MP4_VIDEO);
        } catch (FileNotFoundException e) {
            logger.log(Level.SEVERE, "FileMediaManager failed to access its files", e);
        }
    }
    
    // Use the default MediaQualifier object
    public void loadData() {
        loadData(mq);
    }

    public void loadData(MediaQualifier mq) {
        pictureCount = 0; 
        videoCount = 0;
        try {
            groups = mm.listMediaItems(mq);
        } catch (FileNotFoundException ex) {
            logger.log(Level.SEVERE, "FileMediaManager failed to access its files", ex);
        }
        // Update the counts
        for (MediaGroup group : groups) {
            for (MediaItem mediaItem : group.getItems()) {
                switch (getType(mediaItem)) {
                    case IMAGE:
                        pictureCount++;
                        break;
                    case MP4_VIDEO:
                    case OGV_VIDEO:
                        videoCount++;
                        break;
                    default:
					break;
                }
                mediaItem.setUri(appURL + mediaItem.getId());
            }
        }
    }
    
    private MediaType getType(MediaItem mediaItem) {
        String type = new MimetypesFileTypeMap().getContentType(mediaItem.getId()); 
        if (type.startsWith("image")) {
            return MediaType.IMAGE;
        } else if (type.contains("application/ogg") || type.contains("video/ogg")) {
            return MediaType.OGV_VIDEO;
        } else if (type.contains("video/mp4")) {
            return MediaType.MP4_VIDEO;
        } else if (type.contains("video/x-flv")) {
            return MediaType.FLASH_VIDEO;
        } else {
            return MediaType.OTHER;
        }
    }

    public int getPictureCount() {
        return pictureCount;
    }

    public int getVideoCount() {
        return videoCount;
    }

    public List<MediaGroup> getGroups() {
        return groups;
    }
    
    public MediaItem getMediaItem(String id) throws FileNotFoundException {
        MediaItem item = mm.getMediaItem(id);
        item.setUri(appURL + item.getId());
        return item;
    }

    public MediaQualifier getQualifier() {
        return mq;
    }

    public MediaManager getMediaManager() {
        return mm;
    }
}

