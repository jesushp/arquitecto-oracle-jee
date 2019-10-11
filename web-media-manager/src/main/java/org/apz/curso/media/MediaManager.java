package org.apz.curso.media;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.List;

import org.apz.curso.bean.MediaGroup;
import org.apz.curso.bean.MediaItem;


public interface MediaManager extends Serializable {
    
    void createMediaItem(MediaItem item, InputStream content) throws IOException;
    
    MediaItem getMediaItem(String id) throws FileNotFoundException ;
    
    void updateMediaItem(MediaItem item) throws FileNotFoundException;
    
    void deleteMediaItem(String id) throws FileNotFoundException;
    
    List<MediaGroup> listMediaItems(MediaQualifier filter) throws FileNotFoundException;

}