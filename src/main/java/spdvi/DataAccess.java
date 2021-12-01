package spdvi;

import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataAccess {
        ArrayList<User> lista = new ArrayList<>();

    private Connection  getConnection() throws SQLException{
    
    Connection connection = null;
    Properties properties = new Properties();
        try {
            
            properties.load(DataAccess.class.getClassLoader().getResourceAsStream("aplications.properties"));
            connection = DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("user"), properties.getProperty("password"));
            
        } 
        catch (IOException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return connection;
    }
    
    public ArrayList<User> getUser(){
        try (Connection connection = getConnection()){
            PreparedStatement selectStatement = connection.prepareStatement(
                "SELECT * FROM dbo.[User]" 
            );
        ResultSet resultSet = selectStatement.executeQuery();
        while(resultSet.next()){
            User user = new User(
            resultSet.getString("firstName"),
            resultSet.getString("lastName"),
            LocalDate.parse(resultSet.getString("birthDate")),
            resultSet.getString("gender"),
            resultSet.getBoolean("isAlive"),
            null
            );
            user.setId(resultSet.getInt("id"));
            lista.add(user);
        }
        }        
        catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
}