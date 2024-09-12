/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package jdbc;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

public class JDBC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String user = "root";
        String pass = "";
        String url = "jdbc:mysql://localhost:3306/jdbcpuntos";
        //Estructura URL: jdbc:mysql://<ipServidorBD>/<nombreBD>
        try {
            Connection con = DriverManager.getConnection(url, user, pass);
            Punto p1 = new Punto(5, 6);
            Punto p2 = new Punto(15, 21);
            //CRUD
            //1. Create
            String sql = "INSERT INTO puntos (x, y) VALUES (" + p1.getX() + "," + p1.getY() + ")";
            System.out.println("SQL Insert: " + sql);
            //INSERT INTO puntos (x, y) VALUES (5, 6)
            Statement sentencia = con.createStatement();
            //int filas = sentencia.executeUpdate(sql);
            //System.out.println("Número de filas insertadas: " + filas);

            //2. Read
            sql = "SELECT * FROM puntos";
            ResultSet rs = sentencia.executeQuery(sql);
            while (rs.next()) {
                System.out.println("Punto: " + rs.getInt("idpuntos")
                        + " - (" + rs.getInt("x")
                        + ", " + rs.getInt("y") + ")");
            }

            //3. Update
            sql = "UPDATE puntos SET x = 10, y = 10 WHERE idpuntos > 0";
            int filas = sentencia.executeUpdate(sql);
            System.out.println("Número de filas actualizadas: " + filas);

            //4. Delete
            sql = "DELETE FROM puntos WHERE idpuntos LIKE 2";
            filas = sentencia.executeUpdate(sql);
            System.out.println("Número de filas eliminadas: " + filas);

            //Sentencias parametrizadas:
            sql = "SELECT * FROM puntos WHERE x = ? AND y = ?";
            PreparedStatement sentenciaPrep = con.prepareStatement(sql);
            sentenciaPrep.setInt(1, 11);
            sentenciaPrep.setInt(2, 10);
            ResultSet resultados = sentenciaPrep.executeQuery();
            while (resultados.next()) {
                System.out.println("-->" + resultados.getInt("x")
                        + "," + resultados.getInt("y"));
            }
            
            sql = "INSERT INTO puntos (x, y) VALUES (?, ?)";
            sentenciaPrep = con.prepareStatement(sql);
            sentenciaPrep.setInt(1, 5);
            sentenciaPrep.setInt(2, 5);
            sentenciaPrep.executeUpdate();

            con.close();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            ex.printStackTrace();
        }
    }

}
