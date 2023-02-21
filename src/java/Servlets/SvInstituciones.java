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
@WebServlet(name = "SvInstituciones", urlPatterns = {"/SvInstituciones"})
public class SvInstituciones extends HttpServlet {

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
        String indexIns = String.valueOf(request.getParameter("valor"));
        //Obtener datos y realizar busqueda
        HttpSession misesion = request.getSession();
        List<String> valorIns = (List<String>) misesion.getAttribute("daneIns");
        int index = Integer.parseInt(indexIns);
        misesion.setAttribute("valorInst", valorIns.get(index));
        response.sendRedirect("Sedes.jsp");

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
