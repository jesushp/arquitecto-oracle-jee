package org.apz.curso.media;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;

import org.apz.curso.bean.MediaGroup;
import org.apz.curso.bean.MediaItem;

public class FileMediaManagerImpl implements MediaManager, Constants {

    
	private static final long serialVersionUID = -9119090271865428250L;

	private static final Logger logger = Logger.getLogger("org.apz.curso.media.FileMediaManagerImpl");

    private File dir;

    private String hiddenLocationPrefix = null;

   
    /**
     * Creates a MediaManager which uses a directory as a source of MediaItem
     * objects.
     *
     * @param dir The directory containing media pictures and videos.
     * @param idFormat The IdFormat.FX value causes received and returned
     * MediaItem ids to be based on the File.getAbsolutePath() result while a
     * IdFormat.WEB value will use ContainingDir/file.jpg as the format.
     * @throws FileNotFoundException
     */
    public FileMediaManagerImpl(File dir, IdFormat idFormat) throws FileNotFoundException {
        if (dir == null | !dir.isDirectory()) {
            logger.log(Level.SEVERE, "FileMediaManager must be constructed with a directory {0}", dir);
            throw new IllegalArgumentException("Argument must be a directory");
        }
        this.dir = dir;
        if (idFormat == IdFormat.WEB) {
            //hiddenLocationPrefix = dir.getParent();
            hiddenLocationPrefix = dir.toString();
            
        }
        logger.log(Level.INFO, "FileMediaManager created with a directory of {0}", dir);
        logger.log(Level.INFO, "FileMediaManager created with a IdFormat of {0}", idFormat);
    }

    @Override
    public void createMediaItem(MediaItem item, InputStream content) throws IOException {
        File f = new File(dir, item.getId());
        String realId = generateMediaId(f);
        item.setId(realId);
        Files.copy(content, f.toPath(), StandardCopyOption.REPLACE_EXISTING);
    }

    @Override
    public MediaItem getMediaItem(String id) throws FileNotFoundException {
        File f = new File(hiddenLocationPrefix, id);
        if (f == null || !f.isFile()) {
            throw new FileNotFoundException(id);
        }
        MediaItem mediaItem = null;
        if (mediaItem == null) {
            String title = f.getName();
            mediaItem = new MediaItem(title, id, new Date(f.lastModified()));
        }
        return mediaItem;
    }

    @Override
    public void updateMediaItem(MediaItem item) throws FileNotFoundException {
        File f = new File(hiddenLocationPrefix, item.getId());
        if (f == null || !f.isFile()) {
            throw new FileNotFoundException(item.getId());
        }
        f.setLastModified(item.getDate().getTime());
    }

    @Override
    public void deleteMediaItem(String id) throws FileNotFoundException {
        File f = new File(hiddenLocationPrefix, id);
        if (f != null && f.isFile()) {
            f.delete();
        } else {
            throw new FileNotFoundException(id);
        }
    }

    @Override
    public List<MediaGroup> listMediaItems(MediaQualifier filter) throws FileNotFoundException {
       
    	List<MediaGroup> groups = new ArrayList<>();

        // MediaTypeFilenameFilter uses ids(filenames) to restrict the type of items listed
        File[] files = dir.listFiles(new MediaTypeFilenameFilter(filter));

        List<MediaItem> items = new ArrayList<>();
        if (files != null) {
            for (File f : files) {
                logger.log(Level.FINEST, "Found file {0}", f.getAbsolutePath());
                String id = generateMediaId(f);
                MediaItem mediaItem = getMediaItem(id);
                items.add(mediaItem);
            }
            switch (filter.getSortOrder()) {
                case DATE_DESC:
                    sortItemsByDescDate(items);
                    groupItemsByDate(groups, items);
                    break;
                case DATE_ASC:
                    sortItemsByAscDate(items);
                    groupItemsByDate(groups, items);
                    break;
                case TITLE_DESC:
                    sortItemsByDescTitle(items);
                    groupItemsByTitle(groups, items);
                    break;
                case TITLE_ASC:
                    sortItemsByAscTitle(items);
                    groupItemsByTitle(groups, items);
                    break;
            }
        }
        return groups;
    }

    private String generateMediaId(File f) {
        String id = f.getAbsolutePath();
        //when ids are relative paths they always use forwards slashes
        if (hiddenLocationPrefix != null) {
            id = id.replaceFirst(Matcher.quoteReplacement(hiddenLocationPrefix), "");
            //id = id.replaceAll(Matcher.quoteReplacement(File.separator), "/");
            id = id.replaceAll(Matcher.quoteReplacement(File.separator), "");
        }
        return id;
    }

    private void sortItemsByDescDate(List<MediaItem> items) {
        Collections.sort(items, new Comparator<MediaItem>() {

            @Override
            public int compare(MediaItem o1, MediaItem o2) {
                if (o1.getDate().getTime() > o2.getDate().getTime()) {
                    return -1;
                } else if (o1.getDate().getTime() < o2.getDate().getTime()) {
                    return 1;
                } else {
                    return o1.getId().compareTo(o2.getId());
                }
            }
        });
    }

    private void sortItemsByAscDate(List<MediaItem> items) {
        Collections.sort(items, new Comparator<MediaItem>() {

            @Override
            public int compare(MediaItem o1, MediaItem o2) {
                if (o1.getDate().getTime() < o2.getDate().getTime()) {
                    return -1;
                } else if (o1.getDate().getTime() > o2.getDate().getTime()) {
                    return 1;
                } else {
                    return o1.getId().compareTo(o2.getId());
                }
            }
        });
    }

    private void groupItemsByDate(List<MediaGroup> groups, List<MediaItem> items) {
        String previousDate = "notequal";
        MediaGroup group = null;
        for (MediaItem mediaItem : items) {
            String date = SimpleDateFormat.getDateInstance().format(mediaItem.getDate());
            if (!previousDate.equals(date)) {
                previousDate = date;
                group = new MediaGroup(date);
                groups.add(group);
            }
            group.getItems().add(mediaItem);
        }
    }

    private void sortItemsByAscTitle(List<MediaItem> items) {
        Collections.sort(items, new Comparator<MediaItem>() {

            @Override
            public int compare(MediaItem o1, MediaItem o2) {
                int order = o1.getTitle().compareToIgnoreCase(o2.getTitle());
                if (order == 0) {
                    return o1.getId().compareTo(o2.getId());
                }
                return order;
            }
        });
    }

    private void sortItemsByDescTitle(List<MediaItem> items) {
        Collections.sort(items, new Comparator<MediaItem>() {

            @Override
            public int compare(MediaItem o1, MediaItem o2) {
                int order = o1.getTitle().compareToIgnoreCase(o2.getTitle());
                if (order == 0) {
                    return o1.getId().compareTo(o2.getId());
                }
                if (order > 0) {
                    order = -1;
                } else {
                    order = 1;
                }
                return order;
            }
        });
    }

    private void groupItemsByTitle(List<MediaGroup> groups, List<MediaItem> items) {
        char previousLetter = '\u0000';
        MediaGroup group = null;
        for (MediaItem mediaItem : items) {
            char letter = mediaItem.getTitle().toUpperCase().charAt(0);
            if (previousLetter != letter) {
                previousLetter = letter;
                group = new MediaGroup(Character.toString(letter));
                groups.add(group);
            }
            group.getItems().add(mediaItem);
        }
    }
}
