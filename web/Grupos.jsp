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
                    <th>Revisar</th> <th>Grupos</th><th>Dane</th><th># grupo</th>
                </tr>
            </thead>
            <tbody>
            <form action="SvInfoG" method="POST">
                <%   
                    InfoGrupos a= new InfoGrupos();
                    HttpSession misesion = request.getSession();
                    String s=String.valueOf(misesion.getAttribute("valorSedes"));
                    
                  a.setdatos(s);
                  
                   List<String> grupos= a.getNombre();
                   List<String> dane= a.getDane();
                    List<String> numGrupos= a.getNumGrupo();
                   
                      misesion.setAttribute("daneGrupo",dane);
                      
                           for(int i=0; i<grupos.size();i++)
                           {  String m= grupos.get(i);
                              String d= dane.get(i);
                              String t= numGrupos.get(i);
                           
                %>
            
                <tr>
                   <div >
                       <td>  <input type="submit" name="valor" value="<%=i%>"> <td >   <%=m%>  </td><td><%=d%></td> <td><%=t%></td>
                    
                    </div>
                </tr>
                <% } %>
                </form>
            </tbody>
        </table>

    </body>
</html>


