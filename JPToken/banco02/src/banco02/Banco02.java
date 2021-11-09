/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco02;
import java.sql.*;
/**
 *
 * @author jeanp
 */
public class Banco02 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
          final String url = "jdbc:postgresql://localhost:5432/postgres";
       final String usuario = "postgres";
       final String senha = "1198";
       final String driverBanco = "org.postgresql.Driver";
       final String instrucaoSelect = "SELECT * FROM aluno";
       
       
    try{
    Connection conexao = DriverManager.getConnection(url, usuario, senha);
    
    PreparedStatement preparedStatement = conexao.prepareStatement(instrucaoSelect);
   
    ResultSet rs = preparedStatement.executeQuery();
    
    while(rs.next()){
        String matricula = rs.getString("matricula");
        String nome = rs.getString("nome");
        int turno = rs.getInt("turno");
        String pass = rs.getString("pass");
        System.out.println("Matrícula: "+ matricula+" Nome: "+nome+" Turno: "+turno+" Senha: "+pass);
    }
    System.out.println("Consulta realizada com sucesso!");

    }catch(Exception exception){
        exception.printStackTrace();
    }
    }
}

    
    

