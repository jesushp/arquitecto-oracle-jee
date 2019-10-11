package org.apz.curso.rest;

import java.util.List;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.apz.curso.bean.FileMediaBean;
import org.apz.curso.bean.MediaGroup;
import org.apz.curso.bean.MediaItem;

@Path("media")
public class MediaResource {

    @Context
    private ServletContext context;
    private static final Logger logger = Logger.getLogger("org.apz.curso.rest.MediaResource");
    private FileMediaBean fmm;

    @PostConstruct
    private void init() {
        String realPath = context.getRealPath("fxmedia");
        fmm = new FileMediaBean(realPath);
        logger.info("metodo postConstruct");
        fmm.loadData();
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public MediaList getMedia() {

        MediaList mediaList = new MediaList();
        List<MediaGroup> groups = fmm.getGroups();
        for (MediaGroup group : groups) {
            for (MediaItem item : group.getItems()) {
                mediaList.mediaId.add(item.getId());
            }
        }
        return mediaList;
    }
    
}
