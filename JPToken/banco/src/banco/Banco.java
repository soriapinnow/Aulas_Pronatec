/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;
import java.sql.*;

/**
 *
 * @author jeanp
 */
public class Banco {
    public static void main(String args[]) {
       
       final String url = "jdbc:postgresql://localhost:5432/postgres";
       final String usuario = "postgres";
       final String senha = "1198";
       final String driverBanco = "org.postgresql.Driver";
       final String instrucao_insert = "INSERT INTO aluno (matricula, nome, turno, pass) VALUES(?, ?, ?, ?)";
       
       
    try{
    Connection conexao = DriverManager.getConnection(url, usuario, senha);
    
    PreparedStatement preparedStatement = conexao.prepareStatement(instrucao_insert);
    preparedStatement.setString(1,"0003");
    preparedStatement.setString(2,"Osvaldo");
    preparedStatement.setInt(3,2);
    preparedStatement.setString(4, "123456");
    
    preparedStatement.executeUpdate();
    
    System.out.println("Inclusão realizada com sucesso!");

    }catch(Exception exception){
        exception.printStackTrace();
    }
    }
}


