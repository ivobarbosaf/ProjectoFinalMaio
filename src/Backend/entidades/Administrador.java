package Backend.entidades;

import java.io.Serializable;

/**
 *
 * @author ivoba
 */
public class Administrador extends Utilizador implements Serializable{
    
    /**
     *Métodos Construtores 
     */
     public Administrador() {
    }

    public Administrador(String username, String password, String nomeCompleto) {
        super(username, password, nomeCompleto);
    }
     
    /**
     *Método ToString 
     */
    @Override
    public String toString() {
        return "[Administrador: "+ getUsername()+", " + getNomeCompleto() +']';
    }
   
    
    
}
