/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend.listas;

import Backend.Exceptions.DadosJaExistentes;
import Backend.Exceptions.DadosNaoEncontrados;
import Backend.entidades.Hospital;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;


public class ListaHospitais implements Serializable {
    
    public ArrayList<Hospital> listaHospitais;
    
    public ListaHospitais(){
        this.listaHospitais = new ArrayList<>();
    }
     
    public void registarHospital(Hospital u) {
        this.listaHospitais.add(u);
    }
    
    public Hospital buscarHospital(int p) {
        return listaHospitais.get(p);
    }
    
    public Hospital buscarHospital(String nome) {
        Hospital hospital = null;
        for (Hospital l : listaHospitais) {
            if (l.getNome()== nome) {
                hospital = l;
            }
        }
        return hospital;
    }
    
    
    public void removerHospital(Hospital p) {
        listaHospitais.remove(p);
    }
    
    public Hospital getHospitalId(String email) {
        Hospital hospital = null;
        for (Hospital l : listaHospitais) {
            if (l.getEmail() == email) {
                hospital = l;
            }
        }
        return hospital;
    }
    
    public Hospital getHospital(int id){
        Hospital hospital = null;
        for(Hospital l : listaHospitais){
            if(l.getId() == id){
                hospital = l;
            }
        }
        return hospital;
    }
     
    public boolean existeHospital(String Email) throws DadosJaExistentes {
        for (Hospital l : listaHospitais) {
            if ((l.getEmail().equals(Email))) {
                throw new DadosJaExistentes("Hospital já inserido.");
            }
        }
        return true;
    }
    
    public boolean verificaHospital(String Email){
        for (Hospital l : listaHospitais) {
            if ((l.getEmail().equals(Email))) {
                return true;
            }
        }
        return false;
    }

   public boolean validaHospital(String Email) {
        if (Email.isEmpty()) {
            return false;
        } else {
            for (Hospital f : this.listaHospitais) {
                if (f.getEmail().equals(Email)) {
                    return true;
                }
            }
            return false;
        }
    }
    

    
    public Hospital getHospital(String Email) throws DadosNaoEncontrados {
        for (Hospital l : this.listaHospitais) {
            if (l.getEmail().equals(Email)) {
                return l;
            }
        }
        throw new DadosNaoEncontrados("Hospitla inexistente");
    }
    
    
     
    public int size(){
        return listaHospitais.size();
    }
    
    
    /**
     * Métodos para adicionar
     */
    public void adicionar(Hospital hospital) { //IVO: trocava a assinatura deste método para: public void adicionar(Hospital hospital)
        if (hospital == null) {
            throw new RuntimeException("O hospital não existe!");
        }
        if (existe(hospital)) {
            throw new RuntimeException("O hospital " + hospital.getNome() + " já existe!");
        } else {
            listaHospitais.add(hospital);
        }
    }
    
    /**
     * Métodos de Procura
     */
   
     //pelo indice
    public Hospital procurarPeloIndice(int index) {
        if (index >= listaHospitais.size()) {
            throw new RuntimeException("Não existe nenhum Hospital com indice inserido!");
        }
        return listaHospitais.get(index);
    }
    //pelo nome
    public Hospital procurarPeloNome(String nomeHospital) {
         for (Iterator<Hospital> iterator = listaHospitais.iterator(); iterator.hasNext();) {
            Hospital hospital = iterator.next();
             if (hospital.getNome().equalsIgnoreCase(nomeHospital)) {
                 return hospital;
             }
        }
        return null;
    }
    //pelo email
    public Hospital procurarPeloEmail(String email) {
     for (Iterator<Hospital> iterator = listaHospitais.iterator(); iterator.hasNext();) {
            Hospital hospital = iterator.next();
             if (hospital.getEmail().equalsIgnoreCase(email)) {
                 return hospital;
             }
        }
        return null;
    }
    
    /**
     * Métodos verificação boolean
     */
    
    //por objecto
     public boolean existe(Hospital hospital) {
        return listaHospitais.contains(hospital);
    }
     
    //por email
    public boolean existePorEmail(String Email) throws DadosJaExistentes {
        for (Hospital hospital : listaHospitais) {
            if ((hospital.getEmail().equalsIgnoreCase(Email))) {
                return true;
            }
        }
        return false;
    } 
    
     /**
     * Método para remover
     */
    public void remover(Hospital hospital) {
        if (existe(hospital)) {
         listaHospitais.remove(hospital);   
        } else{
        throw new RuntimeException("O hospital " + hospital.getNome() + " não existe!");
        }
    }
    
    
    
     
    
     /**
     * Método para medir o tamanho da  lista
     */
    
 
    
    
}
