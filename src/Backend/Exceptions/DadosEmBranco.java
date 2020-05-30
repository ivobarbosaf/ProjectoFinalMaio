
package Backend.Exceptions;

    public class DadosEmBranco extends Exception {
    public DadosEmBranco() {
        super("Tem dados em branco.");
    }
    
    public DadosEmBranco(String msg) {
        super(msg);
    }
}
