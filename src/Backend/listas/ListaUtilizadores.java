package Backend.listas;

import Backend.entidades.Utilizador;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author ivoba
 */
public class ListaUtilizadores implements Serializable {
    
    
    /**
     * Atributos de classe
     */
    private final Map<String, Utilizador> ListaUtilizadores;
    
    /**
     * Método Construtores
     * 
     */
    public ListaUtilizadores() {
        ListaUtilizadores = new TreeMap<>(String.CASE_INSENSITIVE_ORDER); 
    }
    
    /**
     * Método Modificadores e Selectores
     * 
     */
    public TreeMap<String, Utilizador> getListaUtilizadores() {
        return (TreeMap<String, Utilizador>) ListaUtilizadores;
    }
    
    /**
     * @author
     * Bruno Ferreira (bruno@dsi.uminho.pt)
     * 
     */
    public class UtilizadorNaoExistenteException extends Exception {
        public UtilizadorNaoExistenteException() { }
        public UtilizadorNaoExistenteException(String message) {
            super(message);
        }        
    }
    
    public class UtilizadorDuplicadoException extends Exception {
        public UtilizadorDuplicadoException() { }
        public UtilizadorDuplicadoException(String message) {
            super(message);
        }        
    }
    
    /**
     * Método para adicionar utilizadores
     * 
     */
    public void adicionar(Utilizador utilizador) throws UtilizadorDuplicadoException { 
        if (utilizador==null) {
             throw new NullPointerException("A parâmetro 'utilizador' não pode ser um valor nulo");
        }
        if (existe(utilizador.getUsername())) {
            throw new UtilizadorDuplicadoException(String.format("O utilizador '%s' já existe na coleção", utilizador.getUsername()));
        }else{
        ListaUtilizadores.put(utilizador.getUsername(), utilizador);
        }
    }
    
     /**
     *Método para verificar se existe um username
     */
    public boolean existe(String username) {
        return ListaUtilizadores.containsKey(username);
    }
    
    /**
     * Método para procurar um utilizador por username
     */        
            
    public Utilizador procurarUtilizador(String username) throws UtilizadorNaoExistenteException {
        if (ListaUtilizadores.containsKey(username)){
            return ListaUtilizadores.get(username);
        }else{
            throw new UtilizadorNaoExistenteException("O utilizador '%s' já existe na lista");
        }
    }
    /**
     *Método que retorna o tamanho da lista de utilizadores
     */ 
    
    public int size() {
        return ListaUtilizadores.size();
    }
    
    /**
     *Método que retorna os valores da lista pelo seus valores
     */ 
    public ArrayList<Utilizador> todos() {
        return new ArrayList<>(ListaUtilizadores.values());
    }
    
}
