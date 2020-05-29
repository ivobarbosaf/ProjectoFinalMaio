package Backend.outras;

import Backend.entidades.Utilizador;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 *
 * @author
 * Bruno Ferreira (bruno@dsi.uminho.pt)
 */
public class RegistoAcesso implements Serializable{
    
    
     /**
     * Atributos de classe
     */
    private Utilizador utilizador;
    private LocalDateTime data;
    
    
     /**
     * Métodos Construtores
     */
    public RegistoAcesso() { 
    }
    
    public RegistoAcesso(Utilizador utilizador, LocalDateTime data) {
        this.utilizador = utilizador;
        this.data = data;
    }
    
    /**
     * Métodos Construtores
     */
    public Utilizador getUtilizador() {
        return utilizador;
    }
    /**
     * Métodos Modificadores e Selectores
     */
    public void setUtilizador(Utilizador utilizador) {
        this.utilizador = utilizador;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }      
    
}
