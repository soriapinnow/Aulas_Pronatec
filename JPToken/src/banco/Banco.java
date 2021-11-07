package banco;
import java.util.HashMap;
import aluno.Aluno;

/**
 *
 * @author jeanp
 */
public class Banco {
    private HashMap dados;
    
    public Banco(){
        dados = new HashMap();
        
    }
    
    public void incluir(Aluno aluno){
        dados.put(aluno.getMat(),aluno);
        
    }
    public void excluir(Aluno aluno){
        dados.remove(aluno.getMat());
    }
    public void alterar(Aluno aluno){
       dados.put(aluno.getMat(),aluno);
    }
    public Aluno consultar(Aluno aluno){
        return (Aluno)dados.get(aluno.getMat());
    }
}