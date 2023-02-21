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
                    <th>Revisar</th> <th>Municipio</th><th>Dane</th>
                </tr>
            </thead>
            <tbody>
            <form action="SvMunicipios" method="POST">
                <%   
                    InfoMunicipios a= new InfoMunicipios();
                  a.setdatos();
                   List<String> municipios= a.getMunicipioss();
                   List<String> dane= a.getDane();
                   
                       HttpSession misesion = request.getSession();
                       misesion.setAttribute("daneMun",dane);
                    
                           for(int i=0; i<municipios.size();i++)
                           {  String m= municipios.get(i);
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



