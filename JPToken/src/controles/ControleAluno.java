/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controles;
import java.util.ArrayList;
import banco.DAOAluno;
import aluno.Aluno;

/**
 *
 * @author Oswaldo Peres
 */
public class ControleAluno {
    
    private DAOAluno dao;
    private Aluno aluno;
    
    public ControleAluno(){
        
        dao = new DAOAluno();
    }
    
    
    public void incluir(String matricula, String nome, String turno, String pass){
        aluno = new Aluno();
        
        aluno.setMat(matricula);
        aluno.setNome(nome);
        aluno.setTurno(turno);
        aluno.setPass(pass);
        
        dao.incluir(aluno);
        
        
    }
    
    public void excluir(String matricula){
        aluno = new Aluno();
        
        aluno.setMat(matricula);

        dao.excluir(aluno); 
    }
        
    public void alterar(String matricula, String nome, String turno, String pass){
        aluno = new Aluno();
        
        aluno.setMat(matricula);
        aluno.setNome(nome);
        aluno.setTurno(turno);
        aluno.setPass(pass);
        
        dao.alterar(aluno);
          
    }
    
    public ArrayList<String> consultar(String matricula){
        aluno = new Aluno();
        ArrayList<String> dadosAluno = new ArrayList<>();
        
        aluno.setMat(matricula);

        aluno = dao.consultar(aluno); 
        
        dadosAluno.add(aluno.getMat());
        dadosAluno.add(aluno.getNome());
        dadosAluno.add(aluno.getTurno());
        dadosAluno.add(aluno.getPass());
        
        
        return dadosAluno;
    }
    public ArrayList<String> logar(String matricula){
        aluno = new Aluno();
        ArrayList<String> dadosAluno = new ArrayList<>();       
        aluno.setMat(matricula);
        
        aluno = dao.logar(aluno); 
        
        
        dadosAluno.add(aluno.getPass());
        
        
        return dadosAluno;
    }
    
}
