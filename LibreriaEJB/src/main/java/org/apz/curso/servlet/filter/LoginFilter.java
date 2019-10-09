package org.apz.curso.servlet.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Intercepting Filter + info: http://www.juntadeandalucia.es/servicios/madeja/contenido/recurso/113
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
		String path=((HttpServletRequest)request).getServletPath();
		if (path.equals("/")||path.equals("/login") ) {
			chain.doFilter(request, response);
		}
		HttpSession sesion=((HttpServletRequest)request).getSession();
		if(sesion.getAttribute("usuario")!=null) {
			chain.doFilter(request, response);
		} else {
			request.getRequestDispatcher("login").forward(request, response);
			//((HttpServletResponse)response).sendRedirect("login");
		}
		
		//chain.doFilter(request, response);
	}	

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}

