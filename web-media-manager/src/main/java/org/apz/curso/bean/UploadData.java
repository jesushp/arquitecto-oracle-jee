package org.apz.curso.bean;


public class UploadData {

	private final String fileName;
    private final String title;
    private final String extension;

    public UploadData(String fileName, String title, String extension) {
        this.fileName = fileName;
        this.title = title;
        this.extension = extension;
    }

    public String getFileName() {
        return fileName;
    }

    public String getTitle() {
        return title;
    }

    public String getExtension() {
        return extension;
    }
    
    
}
