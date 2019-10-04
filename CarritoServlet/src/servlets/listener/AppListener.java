package servlets.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Pasa cuando al inicio de la aplicacion
 *
 */
@WebListener
public class AppListener implements ServletContextListener {

    
    public void contextDestroyed(ServletContextEvent sce)  { 
    }

	public void contextInitialized(ServletContextEvent sce)  { 
		System.out.println("estoy en contextInitialized de la app");
        sce.getServletContext().setAttribute("activos", 0);
    }
	
}

