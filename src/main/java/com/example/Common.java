package com.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Common {
    private Connection conn;
    private PreparedStatement pstmt;
    private  ResultSet rs;

    public boolean conectar(){
        try {

            //informando qual driver de conexão será utilizado pelo DriveManager
            Class.forName("org.postgresql.Driver");
            // Criando a conexão com o BD
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Pratica", "postgres", "1234");
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

    public  boolean operacao(String id, String tipo, Float valor){
        try {

            conectar();
            if (tipo.toLowerCase() == "deposito"){
                pstmt = conn.prepareStatement("UPDATE conta SET saldo = saldo + ? WHERE contaid = ?");
                pstmt.setFloat(1, valor);
                pstmt.setString(2, id);
                pstmt.execute();
            }
            if (tipo.toLowerCase() == "saque"){
                pstmt = conn.prepareStatement("UPDATE conta SET saldo = saldo - ? WHERE contaid = ?");
                pstmt.setFloat(1, valor);
                pstmt.setString(2, id);
                pstmt.execute();
            }
            desconectar();
            return true;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    public boolean transferencia(String envia, String recebe, Float valor){
        try {

            conectar();

            pstmt = conn.prepareStatement("UPDATE conta SET saldo = saldo - ? WHERE contaid = ?");
            pstmt.setFloat(1, valor);
            pstmt.setString(2, envia);
            pstmt.execute();
            desconectar();
            conectar();
            pstmt = conn.prepareStatement("UPDATE conta SET saldo = saldo + ? WHERE contaid = ?");
            pstmt.setFloat(1, valor);
            pstmt.setString(2, recebe);
            pstmt.execute();
            desconectar();

            return true;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
}