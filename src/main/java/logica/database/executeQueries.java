package logica.database;

import java.sql.Connection;

import logica.DbConnection;

public class executeQueries {
   
     public String login(String usuario, String contra) {
        String query = "SELECT * FROM usuarios WHERE nombre_usuario = '" + usuario + "' AND contra_usuario = '" + contra + "'";
        try {
            Connection con = new DbConnection().getConnection();
            java.sql.Statement stmt = con.createStatement();
            java.sql.ResultSet rs = stmt.executeQuery(query);
            if (rs.next()) {
                return rs.getString("tipo_usuario");
            } else {
                throw new Exception("Usuario o contraseña incorrectos");
            }

        } catch (Exception e) {
            return "Error al obtener el usuario y la contraseña: " + e.getMessage();
        }finally{
            //con.close();
        }

    }

}
