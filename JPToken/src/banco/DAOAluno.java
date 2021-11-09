package banco;
import aluno.Aluno;
import java.sql.*;
/**
 *
 * @author jeanp
 */
public class DAOAluno {
    
    private final String url = "jdbc:postgresql://localhost:5432/postgres";
    private final String usuario = "postgres";
    private final String senha = "1198";
    private final String driverBanco = "org.posgtresql.Driver";
    
    public DAOAluno(){
        
    }
    
    public void incluir(Aluno aluno){
        final String instrucao_insert = "INSERT INTO aluno (matricula, nome, turno, pass) VALUES(?,?,?,?)";
        
        try{
            
          Connection conexao = DriverManager.getConnection(url, usuario, senha);
          
          PreparedStatement preparedStatement = conexao.prepareStatement(instrucao_insert);
          preparedStatement.setString(1, aluno.getMat());
          preparedStatement.setString(2, aluno.getNome());
          preparedStatement.setString(3, aluno.getTurno());
          preparedStatement.setString(4, aluno.getPass());

          preparedStatement.executeUpdate();
          
          System.out.println("Inclusão realizada com sucesso");
          
        }catch(Exception exception){
            exception.printStackTrace();
        }
        
    }
    public void excluir(Aluno aluno){

        final String instrucaoDelete = "DELETE FROM aluno WHERE matricula = ?";
        
        try{
          Connection conexao = DriverManager.getConnection(url, usuario, senha);
          
          PreparedStatement preparedStatement = conexao.prepareStatement(instrucaoDelete);
          preparedStatement.setString(1, aluno.getMat());

          preparedStatement.executeUpdate();
          
          System.out.println("Exclusão realizada com sucesso");
          
        }catch(Exception exception){
            exception.printStackTrace();
        }
        
        
    }
    public void alterar(Aluno aluno){

        final String instrucaoUpdate = "UPDATE aluno SET nome=?, turno=?, pass=? WHERE matricula=?";
        
        try{
          Connection conexao = DriverManager.getConnection(url, usuario, senha);
          
          
          PreparedStatement preparedStatement = conexao.prepareStatement(instrucaoUpdate);
          preparedStatement.setString(1, aluno.getMat());
          preparedStatement.setString(2, aluno.getNome());
          preparedStatement.setString(3, aluno.getTurno());
          preparedStatement.setString(4, aluno.getPass());
 
          preparedStatement.executeUpdate();
          
          System.out.println("Atualização realizada com sucesso");
          
        }catch(Exception exception){
            exception.printStackTrace();
        }
    }
    
    public Aluno consultar(Aluno aluno){

        final String instrucaoSelect = "SELECT * FROM aluno WHERE matricula = ?";
        
        Aluno aux = null;
        
        try{
            
          Connection conexao = DriverManager.getConnection(url, usuario, senha);
          
          PreparedStatement preparedStatement = conexao.prepareStatement(instrucaoSelect);
          preparedStatement.setString(1, aluno.getMat());
          
          ResultSet rs = preparedStatement.executeQuery();
          
          aux = new Aluno();
          
          while(rs.next()){
              aux.setMat(rs.getString("matricula"));
              aux.setNome(rs.getString("nome"));
              aux.setTurno(rs.getString("turno"));
              aux.setPass(rs.getString("pass"));
          }          
          System.out.println("Consulta realizada com sucesso");
          
          
          
        }catch(Exception exception){
            exception.printStackTrace();
        }
        return aux;
    }
    public Aluno logar(Aluno aluno){

        final String instrucaoSelect = "SELECT * FROM aluno WHERE matricula = ?";
        
        Aluno aux = null;
        
        try{
            
          Connection conexao = DriverManager.getConnection(url, usuario, senha);
          
          PreparedStatement preparedStatement = conexao.prepareStatement(instrucaoSelect);
          preparedStatement.setString(1, aluno.getMat());
          
          ResultSet rs = preparedStatement.executeQuery();
          
          aux = new Aluno();
          
          while(rs.next()){
          aux.setPass(rs.getString("pass"));
                  
          System.out.println("Login");
          
          }
          
          
        }catch(Exception exception){
            exception.printStackTrace();
        }
        return aux;
    }
}
    
