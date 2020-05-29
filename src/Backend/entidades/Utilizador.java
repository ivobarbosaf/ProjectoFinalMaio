package Backend.entidades;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author ivoba
 */
public class Utilizador implements Serializable {
    
    /**
     * Atributos de classe
     */
    private String username;
    private String password;
    private String nomeCompleto;
    
    /**
     * Método Construtores
     * 
     */
    public Utilizador() {
    }    
    
    public Utilizador(String username, String password, String nome) {
        this.username = username;
        this.password = password;
        this.nomeCompleto = nome;
    }
    
    /**
     * Métodos Modificadores e Selectores
     */
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nome) {
        this.nomeCompleto = nome;
    }
    
    /**
     * Método hashcode
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.username);
        return hash;
    }
    
    /**
     * Método equals
     */
    @Override
    public boolean equals(Object objeto) {
        if (objeto instanceof Utilizador) {
            Utilizador outroUtilizador = (Utilizador) objeto;
            boolean outroUser = outroUtilizador.username.equalsIgnoreCase(this.username); //podemos acrescentar outras condições de verificação
            return outroUser; //caso hajam mais verificações colocar aqui com &&
        }else{
            return false;
        }
    }
    
    /**
     * Método equals
     */
    @Override
    public String toString() {
        return "[Utilizador: "+ username +", " + nomeCompleto +']';
    }
    
    
}
