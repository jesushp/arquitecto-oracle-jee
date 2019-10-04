package org.apz.curso.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apz.curso.dao.ContactoDao;
import org.apz.curso.model.Contacto;


@WebServlet("/contactos")
public class ContactosAction extends HttpServlet {
	
	private static final long serialVersionUID = -8124276041766036590L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ContactoDao contactoDao =new ContactoDao();
		
		List<Contacto> contactos=contactoDao.recuperarContactos();
		if(contactos.size()>0) {
			request.setAttribute("resultado",1);
			request.setAttribute("contactos",contactos);
		} else {
			request.setAttribute("resultado",0);
		}
	}
}
