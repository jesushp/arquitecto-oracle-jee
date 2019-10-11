package org.apz.curso.media;

import java.io.File;
import java.io.FilenameFilter;

/**
 * implementa una Interfaz funcional con el metodo accept que filtra que no son imagenes, flash o videos
 *
 */
public class MediaTypeFilenameFilter implements FilenameFilter, Constants {

    private MediaQualifier mediaQualifier = null;
    
    public MediaTypeFilenameFilter(MediaQualifier mediaQualifier) {
        this.mediaQualifier = mediaQualifier;
    }
    
    @Override
    public boolean accept(File dir, String name) {
        StringBuilder regexParts = new StringBuilder();
        for (MediaType type : mediaQualifier.getTypes()) {
        	regexParts.append(type.getRegexExtension());
        }
        regexParts.deleteCharAt(regexParts.length() - 1);
        
        if (name.toLowerCase().matches(regexParts.toString())) {
            File f = new File(dir, name);
            return f.isFile();
        } else {
            return false;
        }
    }
}