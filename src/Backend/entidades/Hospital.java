package Backend.entidades;

import Backend.Exceptions.DadosInvalidos;
import Backend.Exceptions.DadosEmBranco;
import Backend.outras.Sistema;
import java.io.Serializable;

public class Hospital extends Sistema implements Serializable{
    
    /**
     * Atribustos da Classe
     * 
     */
    private int codigoHospital;
    private String nomeHospital;
    private String localidadeHospital;
    
    
    
    //tem um conjunto de enfermarias
    
    //tem um conjunto de equipamentos
    
    //estão internados vários doentes 
    
    //tem um conjunto de profissionais de saúde (médicos e enfermeiros) ue asseguram os serviços nas  enfermarias.

    private String email;
    private String contacto;
    private String estado;

    
 //   public ListaStock listaStock;
    
    public Hospital(int codigoHospital, String nomeHospital, String localidadeHospital, String email, String contacto, String estado) throws DadosEmBranco, DadosInvalidos {
        this.codigoHospital = codigoHospital;
        setNome(nomeHospital);
        setMorada(localidadeHospital);
        setEmail(email);
        setContacto(contacto);   
        setEstado(estado);
    
      //  this.listaStock = new ListaStock();
        
    }

    public Hospital() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void setId(int id) {
        this.codigoHospital = codigoHospital;
    }
        
        public int getId() {
            return codigoHospital;
        }
        
	public String getNome(){
	    return nomeHospital;
	}
	
	public String getContacto(){
		return contacto;
	}
	
	public String getMorada(){
		return localidadeHospital;
	}
        
        public String getEmail(){
            return email;
        }
        
     
        
    
        public String getEstado(){
            return estado;
        }
    

        
  //     public ListaStock getListaStocks(){
    //        return this.listaStock;
      //  }
        
        public void setEstado(String estado) {
            this.estado = estado;
        }
        
     
        
        public void setContacto(String novoContacto) throws DadosEmBranco, DadosInvalidos {
            if (novoContacto.isEmpty()) {
                throw new DadosEmBranco();
            } else {
            this.contacto = novoContacto;
            }
        }
        
    
        
	public void setNome(String nomeHospital) throws DadosEmBranco, DadosInvalidos {
        if (nomeHospital.isEmpty()) {
            throw new DadosEmBranco();
        } else {
            this.nomeHospital = nomeHospital;
        }
    }
	
	public void setMorada(String address) throws DadosEmBranco{
		if(address.isEmpty()){
                    throw new DadosEmBranco();
                }
                else{
                    this.localidadeHospital = address;
                }
	}
        
        public void setEmail(String email) throws DadosEmBranco {
        if (email.isEmpty()) {
            throw new DadosEmBranco();
        } else {
            this.email = email;
        }
    }

    @Override
    public String toString() {
        return "Hospital[" + "codigoHospital=" + codigoHospital + ", nomeHospital=" + nomeHospital + ", localidadeHospital=" + localidadeHospital + ", email=" + email + ", contacto=" + contacto + ", estado=" + estado + ']';
    }
        
       
}
