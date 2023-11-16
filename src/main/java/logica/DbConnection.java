package logica;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbConnection {

    static Connection con = null;

    public DbConnection() {
        try {
            Properties properties = new Properties();
            FileInputStream input = new FileInputStream(".env");
            properties.load(input);

            String url = properties.getProperty("DB_URL");
            String user = properties.getProperty("DB_USER");
            String password = properties.getProperty("DB_PASSWORD");
            String useSSL = properties.getProperty("USE_SSL");
            String requireSSL = properties.getProperty("REQUIRE_SSL");
            String certPath = properties.getProperty("CERT_PATH");

            // Configurar las propiedades
            properties.setProperty("user", user);
            properties.setProperty("password", password);
            properties.setProperty("useSSL", useSSL);
            properties.setProperty("requireSSL", requireSSL);
            properties.setProperty("serverSslCert", certPath);

            // Establecer la conexión
            con = DriverManager.getConnection(url, properties);

            if (con != null) {
                System.out.println("Conexión a la base de datos Recetas listo...");
            }

            input.close();
        } catch (IOException | SQLException e) {
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
        }
    }

    public Connection getConnection() {
        return con;
    }
}
