/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author IvanLeon
 */
public class PuntoDAO {
    private static Connection conectar() {
        String user = "root";
        String pass = "";
        String url = "jdbc:mysql://localhost:3306/jdbcpuntos";
        Connection con = null;
        try {
            con = DriverManager.getConnection(url, user, pass);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return con;
    }

    public static int create(Punto p) {
        //SQL parametrizado:
        String sql = "INSERT INTO puntos (x, y) VALUES (?, ?)";
        Connection con = conectar();
        try {
            PreparedStatement sentencia = con.prepareStatement(sql);
            sentencia.setInt(1, p.getX());
            sentencia.setInt(2, p.getY());
            return sentencia.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    public static Punto read(int id) {
        String sql = "SELECT * FROM puntos WHERE idpuntos = ?";
        Connection con = conectar();
        try {
            PreparedStatement sentencia = con.prepareStatement(sql);
            sentencia.setInt(1, id);
            ResultSet rs = sentencia.executeQuery();
            if (rs.next()) {
                int x = rs.getInt("x");
                int y = rs.getInt("y");
                return new Punto(x, y);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static int update(int id, Punto p) {
        String sql = "UPDATE puntos SET x = ?, y = ? WHERE idpuntos = ?";
        Connection con = conectar();
        try {
            PreparedStatement sentencia = con.prepareStatement(sql);
            sentencia.setInt(1, p.getX());
            sentencia.setInt(2, p.getY());
            sentencia.setInt(3, id);
            return sentencia.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    public static int delete(int id) {
        String sql = "DELETE FROM puntos WHERE idpuntos = ?";
        Connection con = conectar();
        try {
            PreparedStatement sentencia = con.prepareStatement(sql);
            sentencia.setInt(1, id);
            return sentencia.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    public static ArrayList<Punto> readAll() {
        ArrayList<Punto> puntos = new ArrayList();
        String sql = "SELECT * FROM puntos";
        Connection con = conectar();
        try {
            Statement sentencia = con.createStatement();
            ResultSet rs = sentencia.executeQuery(sql);
            while (rs.next()) {
                int x = rs.getInt("x");
                int y = rs.getInt("y");
                puntos.add(new Punto(x, y));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return puntos;
    }
}
