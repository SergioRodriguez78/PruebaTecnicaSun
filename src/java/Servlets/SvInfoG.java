/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author Sergio Rodriguez
 */
@WebServlet(name = "SvInfoG", urlPatterns = {"/SvInfoG"})
public class SvInfoG extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        //Obtener valor seleccionado
        String indexGrupo = String.valueOf(request.getParameter("valor"));
        //Obtener datos y realizar busqueda
        HttpSession misesion = request.getSession();
        List<String> valorGrupo = (List<String>) misesion.getAttribute("daneGrupo");
        int index = Integer.parseInt(indexGrupo);
        misesion.setAttribute("valorGrupo", valorGrupo.get(index));
        response.sendRedirect("InfoGrupo.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
