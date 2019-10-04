package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbc.ProductoDAO;
import model.Producto;

@WebServlet("/carrito")
public class CarritoServlet extends HttpServlet {
	
	private static final long serialVersionUID = -5654107612329614225L;
	
	private String VIEW = "carrito.jsp";
	
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd;
		try {
			//HttpSession sesion = request.getSession();
			//List<Producto> productos = Optional.ofNullable((List)sesion.getAttribute("productos")).orElse(new ArrayList<>());
			
			ProductoDAO productoDAO = new ProductoDAO();
			List<Producto> productos = productoDAO.getProductos();
			request.setAttribute("productos", productos);
			
			rd = request.getRequestDispatcher(VIEW);
			rd.forward(request, response);
			//response.sendRedirect("carrito");
		
		} catch (Exception e) {
			System.err.println(e.getMessage());
			request.getRequestDispatcher("Error").forward(request, response);
			
		}
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//RequestDispatcher rd;
		try {
			ProductoDAO productoDAO = new ProductoDAO();
			String nombre=request.getParameter("nombre");
			int unidades= Integer.valueOf(request.getParameter("unidades"));
			int precio= Integer.valueOf(request.getParameter("precio"));
			productoDAO.insertProducto(new Producto(nombre, unidades, precio));	
			doGet(request, response);
			//rd = request.getRequestDispatcher(VIEW);
			//response.sendRedirect("carrito");
			
		} catch (Exception e) {
			request.getRequestDispatcher("Error").forward(request, response);

		}
		
		
	}
	
	

}
