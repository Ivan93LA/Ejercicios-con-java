/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.ResultSet;

/**
 *
 * @author IvanLeon
 */
public class InsertaPuntos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String user = "root";
        String pass = "";
        String url = "jdbc:mysql://localhost:3306/jdbcpuntos";

        Scanner sc = new Scanner(System.in);
        Scanner scInt = new Scanner(System.in);
        System.out.print("Introduce la coordenada x: ");
        int x = scInt.nextInt();
        System.out.print("Introduce la coordenada x: ");
        int y = scInt.nextInt();

        //Creo el objeto Punto
        Punto p = new Punto(x, y);

        try {
            //Lo guardo en la base de datos
            Connection con = DriverManager.getConnection(url, user, pass);
            String sql = "INSERT INTO puntos (x, y) VALUES (" + p.getX() + "," + p.getY() + ")";
            System.out.println("SQL Insert: " + sql);
            Statement sentencia = con.createStatement();
            sentencia.executeUpdate(sql);

            //Nuevo: ejemplo de posibilidada de inyección de código SQL
            System.out.print("Qué puntos con coordenada x quieres buscar: ");
            String coordy = sc.nextLine();
            sql = "SELECT * FROM puntos WHERE x = " + coordy;
            System.out.println("SQL Insert: " + sql);
            sentencia = con.createStatement();
            ResultSet rs = sentencia.executeQuery(sql);
            while (rs.next()) {
                System.out.println("Punto: " + rs.getInt("idpuntos")
                        + " - (" + rs.getInt("x")
                        + ", " + rs.getInt("y") + ")");
            }
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

}
