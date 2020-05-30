package Frontend;

import Backend.Exceptions.DadosEmBranco;
import Backend.Exceptions.DadosInvalidos;
import Backend.entidades.Hospital;
import Backend.listas.ListaHospitais;
import Backend.listas.ListaUtilizadores;
import Backend.outras.Sistema;
import java.util.Iterator;
import java.util.stream.Stream;


public class Teste {

    public static void main(String[] args) throws DadosEmBranco, DadosInvalidos {
        
        
        
        Sistema sistema = new Sistema();
       
        
        Hospital h1 = new Hospital(1, "A", "Fafe", "email1.com", "1", "estado1");
        Hospital h2 = new Hospital(2, "B", "Porto", "email2.com", "2", "estado2");
        Hospital h3 = new Hospital(3, "C", "Lisboa", "email3.com", "3", "estado3");
        Hospital h4 = new Hospital(4, "D", "Braga", "email4.com", "3", "estado3");
        
        ListaHospitais l1 = new ListaHospitais();
        l1.adicionar(h1);
        l1.adicionar(h2);
        l1.adicionar(h3);
        l1.adicionar(h4);
        
        //Código Para listar
        
        //usando o Iterator
        System.out.println("\nIterator:");
        Iterator<Hospital> it = l1.listaHospitais.iterator();
        while (it.hasNext()) {
        System.out.println(it.next());
        }
        
        //usando Stream
        
        System.out.println("\nStream:");
        Stream<Hospital> stream = l1.listaHospitais.stream();
        stream.forEach(System.out::println);
        
        
        //filtar elementos
        System.out.println("Filtrar um Hospital");
        l1.listaHospitais.stream()
                .filter(localidade -> localidade.getMorada().equalsIgnoreCase("fafe"))
                .map(localidade -> "Resultados da procura: " +localidade.getNome()+"!")
                .forEach(System.out::println);
        
        
        
        
        
        
        
    
    }
}
