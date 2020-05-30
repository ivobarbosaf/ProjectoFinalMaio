
package Backend.Exceptions;


public class DadosNaoEncontrados extends Exception {

    public DadosNaoEncontrados() {
        super("Dados nao econtrados!");
    }

    public DadosNaoEncontrados(String msg) {
        super(msg);
    }
    
}
