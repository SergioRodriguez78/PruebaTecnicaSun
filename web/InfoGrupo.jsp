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
                    <th>Nombre</th> <th>ID</th><th># Grupo</th><th>sede</th><th>municipio</th><th>Institucion</th>
                </tr>
            </thead>
            <tbody>
            <form action="" method="POST">
                <%   
                    InfoDetalladaG a= new InfoDetalladaG();
                    HttpSession misesion = request.getSession();
                    String s=String.valueOf(misesion.getAttribute("valorGrupo"));
                    
                  a.setdatos(s);
                  
                   List<String> nombre= a.getNombre();
                   List<String> dane= a.getDane();
                    List<String> numGrupos= a.getNumGrupo();
                    List<String> sede= a.getSede();
                    List<String> mun= a.getMunicipio();
                    List<String> inst= a.getInstitucion();
                   
                      
                           for(int i=0; i<nombre.size();i++)
                           {  String m= nombre.get(i);
                              String d= dane.get(i);
                              String t= numGrupos.get(i);
                              String x=sede.get(i);
                              String h= mun.get(i);
                              String y=inst.get(i);
                              
                           
                %>
            
                <tr>
                   <div >
                       <td> <%=m%>   <td >  <%=d%>  </td><td><%=t%></td> <td><%=x%></td><td><%=h%></td><td><%=y%></td>
                    
                    </div>
                </tr>
                <% } %>
                </form>
            </tbody>
        </table>

    </body>
</html>


