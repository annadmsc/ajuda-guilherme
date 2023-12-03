package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConexaoEmprestimo {

    private Connection conn;
    private PreparedStatement pstmt;
    private  ResultSet rs;

    public boolean conectar(){
        try {

            //informando qual driver de conexão será utilizado pelo DriveManager
            Class.forName("org.postgresql.Driver");
            // Criando a conexão com o BD
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:80000/postgres", "POSTGRES", "admin");
            return true;
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    public boolean desconectar(){
        try {
            if (conn!= null && !conn.isClosed()){
                conn.close();
                return true;
            }
        }catch (SQLException exception){
            exception.printStackTrace();
        }
        return false;
    }


    public ResultSet buscar(){
        try {
            conectar();
            pstmt = conn.prepareStatement("SELECT * FROM bserv.emprestimo ORDER BY emprestimoid");
            rs = pstmt.executeQuery();
            return rs;
        }catch (SQLException e){
            return  null;
        }finally {
            desconectar();
        }

    }

}