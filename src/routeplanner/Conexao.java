/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package routeplanner;

/**
 *
 * @author Murilo Costa
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    public static Connection conectar() {

        try {

            String url = "jdbc:mysql://localhost:3306/routeplanner";
            String usuario = "root";
            String senha = "admin@1234";

            Connection conn = DriverManager.getConnection(url, usuario, senha);

            return conn;

        } catch (SQLException e) {

            System.out.println("Erro: " + e.getMessage());

            return null;
        }
    }
}