package org.apz.curso.servlet;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Date;

import javax.activation.MimetypesFileTypeMap;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apz.curso.bean.FileMediaBean;
import org.apz.curso.bean.MediaItem;
import org.apz.curso.bean.UploadData;
import org.apz.curso.media.MediaManager;

@WebServlet(name = "UploadServlet", urlPatterns = {"/UploadServlet"})
@MultipartConfig(location = "/tmp")
public class UploadServlet extends HttpServlet {

	private static final long serialVersionUID = -477475212020894009L;

	/**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UploadServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UploadServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        ServletContext context = getServletContext();
        String realPath = context.getRealPath("fxmedia");
        FileMediaBean fmm = new FileMediaBean(realPath);
        MediaManager mm = fmm.getMediaManager();
        response.setContentType("text/html;charset=UTF-8");
       // PrintWriter out = response.getWriter();
       // out.println("<html><head><title>Upload Results</title></head><body>");
        String address = "/WEB-INF/error.jsp";
        // Determine if this in fact a multipart/form-data post
        Collection<Part> parts = request.getParts();
        if (parts.isEmpty()) {
           // out.println("<h2>Not a multipart/form-data request</h2>");
           request.setAttribute("error", "Not a multipart/form-data request");
        } else {
            // Write the files to the location directory
            for (Part part : parts) {
                String name = part.getSubmittedFileName();
                try {
                    String contentType = new MimetypesFileTypeMap().getContentType(name);
                    if (contentType.startsWith("image") || contentType.startsWith("video")) {
                        int periodIndex = name.lastIndexOf(".");
                        String fileExtension = name.substring(periodIndex);
                        String title = name.substring(0, periodIndex);
                        MediaItem item = new MediaItem(title, name, new Date());
//                        out.println("<br/>ID:" + name);
//                        out.println("<br/>Title:" + title);
//                        out.println("<br/>Extension:" + fileExtension);
//                        mm.createMediaItem(item, part.getInputStream());
                        UploadData data = new UploadData(name, title, fileExtension);
                        request.setAttribute("uploadData", data);
                        address = "/WEB-INF/uploadData.jsp";

                    } else {
                        //out.println("<h2>" + contentType + " not supported</h2>");
                        request.setAttribute("error", contentType + " not supported");
                    }
                    part.delete();
                } catch (IOException fe) {
                   // out.println("<br/>Exception writing file: " + name + " : " + fe);
                   request.setAttribute("error", "Exception writing file: " + name + " : " + fe);
                }
            }
        }
        //out.println("<br/><a href='" + getServletContext().getContextPath() + "/MediaController'>Home</a>");
        //out.println("</body></html>");
         RequestDispatcher dispatcher = request.getRequestDispatcher(address);
        dispatcher.forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
