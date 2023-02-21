<%-- 
    Document   : index
    Created on : 21/02/2023, 9:08:35 a. m.
    Author     : Sergio Rodriguez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="Informacion.*" %>
<%@page import="java.util.List" %>


<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Dando estilo a tablas</title>
        <link href="CSS.css" rel="stylesheet" type="text/css"/>

    </head>
    <body>


        <table>
            <thead>
                <tr>
                    <th>Revisar</th> <th>Sedes</th><th>Dane</th>
                </tr>
            </thead>
            <tbody>
            <form action="SvSedes" method="POST">
                <%   
                    InfoSedes a= new InfoSedes();
                    HttpSession misesion = request.getSession();
                    String s=String.valueOf(misesion.getAttribute("valorInst"));
                  a.setdatos(s);
                   List<String> sedes= a.getSedes();
                   List<String> dane= a.getDane();
                   
                      misesion.setAttribute("daneSedes",dane);
                      
                           for(int i=0; i<sedes.size();i++)
                           {  String m= sedes.get(i);
                              String d= dane.get(i);
                           
                %>
            
                <tr>
                   <div >
                       <td>  <input type="submit" name="valor" value="<%=i%>"> <td >   <%=m%>  </td><td><%=d%></td>
                    
                    </div>
                </tr>
                <% } %>
                </form>
            </tbody>
        </table>

    </body>
</html>


