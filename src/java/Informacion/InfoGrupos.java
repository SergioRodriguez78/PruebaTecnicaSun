/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Informacion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

/**
 *
 * @author Sergio Rodriguez
 */
public class InfoGrupos {

    private static List<String> nombre = new ArrayList<>();
    private static List<String> dane = new ArrayList<>();
    private static List<String> numGrupo = new ArrayList<>();

    public InfoGrupos() {
    }

    public static List<String> getNombre() {
        return nombre;
    }

    public static void setNombre(List<String> nombre) {
        InfoGrupos.nombre = nombre;
    }

    public static List<String> getDane() {
        return dane;
    }

    public static void setDane(List<String> dane) {
        InfoGrupos.dane = dane;
    }

    public static List<String> getNumGrupo() {
        return numGrupo;
    }

    public static void setNumGrupo(List<String> numGrupo) {
        InfoGrupos.numGrupo = numGrupo;
    }

    public void setdatos(String daneSede) {

        try {
            nombre.clear();
            dane.clear();
            numGrupo.clear();
            //Establecer url y conexion
            URL url = new URL("https://www.php.engenius.com.co/DatabaseIE.php");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            //Variable de mensaje post
            StringBuilder postData = new StringBuilder();

            //Mensaje post
            postData.append("User=etraining&Password=explorandoando2020%&option=grupos&CodSede=");
            postData.append(daneSede);
            //Conversion a byte y definir el metodo de envio
            byte[] postByte = postData.toString().getBytes("UTF-8");
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setDoOutput(true);
            //Envio de mensaje
            conn.getOutputStream().write(postByte);
            //Recepcion de respuesta 

            StringBuilder informacion = new StringBuilder();
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"))) {
                String linea;
                while ((linea = reader.readLine()) != null) {

                    informacion.append(linea);
                }
                //Convertir respuesta en json array para manejo de datos
                JSONTokener respuestass = new JSONTokener(informacion.toString());
                JSONObject res = (JSONObject) respuestass.nextValue();
                JSONArray municipios = res.getJSONArray("data");
                //Traer por objetos y asi subdividir municipios y danes en listas para uso
                List<JSONObject> partes = new ArrayList<>();
                for (int i = 0; i < municipios.length(); i++) {
                    partes.add(municipios.getJSONObject(i));
                }
                for (JSONObject a : partes) {
                    nombre.add(a.getString("nombre"));
                    dane.add(a.getString("id"));
                    numGrupo.add(a.getString("numGrupo"));

                }

            }

        } catch (IOException e) {

        }
    }
}
