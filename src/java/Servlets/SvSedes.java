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
@WebServlet(name = "SvSedes", urlPatterns = {"/SvSedes"})
public class SvSedes extends HttpServlet {

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
        String indexSedes = String.valueOf(request.getParameter("valor"));
        //Obtener datos y realizar busqueda
        HttpSession misesion = request.getSession();
        List<String> valorSedes = (List<String>) misesion.getAttribute("daneSedes");
        int index = Integer.parseInt(indexSedes);
        misesion.setAttribute("valorSedes", valorSedes.get(index));
        response.sendRedirect("Grupos.jsp");

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
