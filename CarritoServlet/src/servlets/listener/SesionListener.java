package servlets.listener;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Se añade una unidad al contador de usuarios activos al crear una sesion. Se resta una unidad al destruir la sesion
 */
@WebListener
public class SesionListener implements HttpSessionListener {

    /**
     * Default constructor. 
     */
    public SesionListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent se)  { 
         ServletContext context=se.getSession().getServletContext();
         int activos=(Integer)context.getAttribute("activos");
         activos++;
         context.setAttribute("activos", activos);
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent se)  { 
    	ServletContext context=se.getSession().getServletContext();
        int activos=(Integer)context.getAttribute("activos");
        activos--;
        context.setAttribute("activos", activos);
    }
	
}
