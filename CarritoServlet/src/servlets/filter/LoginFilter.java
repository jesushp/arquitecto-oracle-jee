package servlets.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class FiltroLogin
 */
@WebFilter("/*")
public class LoginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LoginFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {		
		//recuperamos la dirección original solicitada y si quiere autenticarse
		//le dejamos pasar
		/* TODO 
		String path=((HttpServletRequest)request).getServletPath();
		if(path.equals("/")||path.equals("/autenticar")|| path.equals("/cerrar") || path.equals("/login")) {
			chain.doFilter(request, response);
		}
		//comprobamos la existencia del atributo de sesión "persona"
		//si no existe, le mandamos a Inicio
		HttpSession sesion=((HttpServletRequest)request).getSession();
		if(sesion.getAttribute("persona")!=null) {
			System.out.println("persona existe");
			chain.doFilter(request, response);
		}else {
			((HttpServletResponse)response).sendRedirect("login");
			//request.getRequestDispatcher("login").forward(request, response);
		}*/
		
		chain.doFilter(request, response);
	}	

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
