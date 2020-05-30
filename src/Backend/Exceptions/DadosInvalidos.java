
package Backend.Exceptions;


public class DadosInvalidos extends Exception {
     public DadosInvalidos() {
        super("Dados invalidos.");
    }
     
    public DadosInvalidos(String msg) {
        super(msg);
    }
}
