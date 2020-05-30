package Backend.outras;

import Backend.entidades.Administrador;
import Backend.entidades.Utilizador;
import Backend.listas.ListaUtilizadores;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author
 * Bruno Ferreira (bruno@dsi.uminho.pt)
 */
public class Sistema implements Serializable{
    
    
    /**
     * Atributos de classe
     */
    private final ListaUtilizadores utilizadores;
    private final List<RegistoAcesso> listaEntradas;
    private Utilizador utilizadorLigado;
    
    /**
     * Métodos Construtores
     */
    public Sistema() {
        utilizadores = new ListaUtilizadores();   
        listaEntradas = new ArrayList<>();
    }  
    
    /**
     * Método Modificadores e Selectores
     * 
     */
    public Utilizador getUtilizadorLigado() {
        return utilizadorLigado;
    }
    //Não deve ser necessário
    public void setUtilizadorLigado(Utilizador utilizadorLigado) {
        this.utilizadorLigado = utilizadorLigado;
    }

    public ListaUtilizadores getListaUtilizadores() {
        return utilizadores;
    }

    public List<RegistoAcesso> getListaEntradas() {
        return listaEntradas;
    }
    
    /**
     * Método para efetuar o login
     */
    
      public boolean autenticarUtilizador(String username, String password) {        
        if (utilizadores.existe(username)) {
            try{
                Utilizador user = utilizadores.procurarUtilizador(username);                
                if (user.getPassword().equals(password)){
                    utilizadorLigado = user;
                    listaEntradas.add(new RegistoAcesso(user, LocalDateTime.now()));
                    return true;
                }                
            }catch (Exception e) {}                        
        }        
        return false;        
    }
    
    public void inicializar() throws ListaUtilizadores.UtilizadorDuplicadoException {
        utilizadores.adicionar(new Administrador("admin1", "admin1", "Aministrador"));
        utilizadores.adicionar(new Utilizador("user1", "1234", "Utilizador 1"));
        utilizadores.adicionar(new Utilizador("user2", "1234", "Utilizador 2"));        
    }
    
    public void terminar() {
        System.exit(0);
    }
    
}
