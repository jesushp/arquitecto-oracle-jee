package org.apz.curso.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apz.curso.bean.FileMediaBean;
import org.apz.curso.bean.MediaItem;
import org.apz.curso.media.Constants;
import org.apz.curso.media.MediaQualifier;

/**
 *
 * @author oracle
 */
@WebServlet(name = "MediaController", urlPatterns = {"/MediaController"})
public class MediaController extends HttpServlet implements Constants {

    /**
	 * 
	 */
	private static final long serialVersionUID = -8548193381038054255L;

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
        //response.setContentType("text/html;charset=UTF-8");
        ServletContext context = getServletContext();
        String realPath = context.getRealPath("fxmedia");
        FileMediaBean fmm = new FileMediaBean(realPath);
         MediaQualifier mq;
         HttpSession session = request.getSession();
        // If this is a new session, initialize it
        if (session.isNew()) {
            mq = fmm.getQualifier();
            session.setAttribute("qualifierBean", mq);
        }
        mq = (MediaQualifier) session.getAttribute("qualifierBean");
        // In the case where the session was invalidated
        if (mq == null) {
            System.out.println("Got null");
            mq = fmm.getQualifier();
            session.setAttribute("qualifierBean", mq);
        }
//        fmm.loadData();
//        request.setAttribute("fileBean", fmm);
//        RequestDispatcher dispatcher = request.getfmm.loadRequestDispatcher("/WEB-INF/manager.jsp");
    String action = request.getParameter("action");
        if (action == null) {
            action = "manager";
        }
        String address;
        switch (action) {
            case "manager":
                // Load the current data
                fmm.loadData(mq);
                request.setAttribute("fileBean", fmm);
                address = "/WEB-INF/manager.jsp";
                break;
            case "item":
                String itemId = request.getParameter("itemId");
                MediaItem item = fmm.getMediaItem(itemId);
                request.setAttribute("itemBean", item);
                address = "/WEB-INF/media.jsp";
                break;
                case "settings":
                address = "/WEB-INF/settings.jsp";
                break;
           case "newSettings":
                String type = request.getParameter("type");
                String sortOrder = request.getParameter("sortOrder");
                if (type != null) {
                    switch (type) {
                        case "images":
                            mq.setTypes(MediaType.IMAGE);
                            break;
                        case "videos":
                            mq.setTypes(MediaType.MP4_VIDEO, MediaType.OGV_VIDEO);
                            break;
                        default:
                            mq.setTypes(MediaType.IMAGE, MediaType.MP4_VIDEO, MediaType.OGV_VIDEO);
                    }
                }
                if (sortOrder != null) {
                    mq.setSortOrder(MediaOrder.valueOf(sortOrder));
                }
                fmm.loadData(mq);
                request.setAttribute("fileBean", fmm);
                address = "/WEB-INF/manager.jsp";
                break;
            default:
                request.setAttribute("error", "Unknown action!");
                address = "WEB-INF/error.jsp";
                break;
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher(address);
        dispatcher.forward(request, response);
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
        processRequest(request, response);
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
