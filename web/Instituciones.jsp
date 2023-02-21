

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
                    <th>Revisar</th> <th>Intitucion</th><th>Dane</th>
                </tr>
            </thead>
            <tbody>
              <form action="SvInstituciones" method="POST">
                <%   
                    InfoInstituciones a= new InfoInstituciones();
                    HttpSession misesion = request.getSession();
                    String s=String.valueOf(misesion.getAttribute("valorMunicipio"));
                  a.setdatos(s);
                   List<String> instituciones= a.getInstituciones();
                   List<String> dane= a.getDane();
                   
                       misesion.setAttribute("daneIns",dane);
                    
                           for(int i=0; i<instituciones.size();i++)
                           {  String m= instituciones.get(i);
                              String d= dane.get(i);
                           
                %>
                <tr>
            <div >
                <td><input type="submit" name="valor" value="<%=i%>"></td > <td ><%=m%></td><td><%=d%></td>

            </div>
        </tr>
        <% }%>
              </form>
    </tbody>
</table>

</body>
</html>

