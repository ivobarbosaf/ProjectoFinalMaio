
package Backend.Exceptions;


public class DadosJaExistentes extends Exception{
    
    public DadosJaExistentes() {
        super("Dados ja existentes!");
    }
    
    public DadosJaExistentes(String msg) {
        super(msg);
    }
}
