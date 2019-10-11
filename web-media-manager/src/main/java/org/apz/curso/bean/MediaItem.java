package org.apz.curso.bean;

import java.io.Serializable;
import java.util.Date;

import org.apz.curso.media.Constants;

public class MediaItem implements Serializable, Constants {

    private static final long serialVersionUID = -3797906893835659028L;
	
    private String title;
    private Date date;
    private String id;
    private String uri;

    public MediaItem() {}
    
    public MediaItem(String title, String id, Date date) {
        this.title = title;
        this.date = date;
        this.id = id;
    }

    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return String.format("Title: %s\n Date:  %s\n Id: %s\n URI:   %s", title, date, id, uri);
    }
}