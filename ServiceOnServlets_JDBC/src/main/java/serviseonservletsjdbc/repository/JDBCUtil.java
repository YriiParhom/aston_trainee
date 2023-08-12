package serviseonservletsjdbc.repository;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtil {


    public Connection getConnection() {

        Connection connection = null;

        try {

            Class.forName(getProperty().getProperty("driver"));
            connection = DriverManager.getConnection((getProperty().getProperty("url")),
                    getProperty().getProperty("username"), getProperty().getProperty("password"));

        } catch (ClassNotFoundException | SQLException e) {

            System.out.println("CONNECTION ERROR!");
        }

        return connection;
    }

    private Properties getProperty() {

        Properties properties = new Properties();


        try (FileInputStream fileInputStream = new FileInputStream(
                "D:\\JavaProjects\\AstonTrainee\\ServiceOnServlets_JDBC\\src\\main\\resources\\application.properties")) {

            properties.load(fileInputStream);

        } catch (IOException e) {
            System.out.println("There is no property file");
        }

        return properties;
    }
}
