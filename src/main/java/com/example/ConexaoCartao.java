package com.example;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConexaoCartao {
    private Connection conn;
    private PreparedStatement pstmt;
    private  ResultSet rs;

    public boolean conectar(){
        try {
            //informando qual driver de conexão será utilizado pelo DriveManager
            Class.forName("org.postgresql.Driver");
            // Criando a conexão com o BD
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:8000/postgres", "POSTGRES", "admin");
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

    public boolean inserir(String tabela, Object dados){

        try {
            conectar();
            // Instanciando o objeto preparedStatment (pstmt)

            StringBuilder query = new StringBuilder();
            query.append("INSERT INTO ");
            query.append(tabela);
            query.append("(");
            Field[] campos = dados.getClass().getDeclaredFields();
            for (int i = 0; i < campos.length; i++){
                query.append(campos[i].getName());
                if (i < campos.length - 1) {
                    query.append(", ");
                }
            }
            query.append(") VALUES(");
            for (int i = 0; i<campos.length; i++){
                try {
                    campos[i].setAccessible(true);
                    Object valores = campos[i].get(dados);
                    if (valores instanceof String){
                        query.append("'");
                        query.append(valores);
                        query.append("'");
                    }else {
                        query.append(valores);
                    }
                }catch (IllegalAccessException e){

                }
                if (i < campos.length -1){
                    query.append(",");
                }
            }
            query.append(")");
            pstmt = conn.prepareStatement(query.toString());
            pstmt.execute();
            desconectar();
            return true;
        }catch (SQLException e ){
            e.printStackTrace();
        }
        return false;
    }

    public ResultSet buscar(){
        try {
            conectar();
            pstmt = conn.prepareStatement("SELECT * FROM bserv.cartao ORDER BY cardnum");
            rs = pstmt.executeQuery();
            return rs;
        }catch (SQLException e){
            return  null;
        }finally {
            desconectar();
        }

    }

    public boolean remover(int cardnum){
        try {
            conectar();
            String remover = "DELETE FROM bserv.cartao WHERE cardnum = ?";
            pstmt = conn.prepareStatement(remover);
            pstmt.setInt(1,cardnum);
            pstmt.execute();
            desconectar();
            return true;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    public boolean removerCliente(String clienteid){
        try {
            conectar();
            String remover = "DELETE FROM bserv.cartao WHERE clienteid = ?";
            pstmt = conn.prepareStatement(remover);
            pstmt.setString(1,clienteid);
            pstmt.execute();
            desconectar();
            return true;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    public boolean alterarLimite(int cardnum, int limite){
        try {
            conectar();
            pstmt = conn.prepareStatement("UPDATE bserv.cartao SET limite = ? WHERE cardnum = ?");
            pstmt.setInt(1, limite);
            pstmt.setInt(2, cardnum);
            pstmt.execute();
            desconectar();
            return true;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

}