
package Frontend;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import Backend.outras.RegistoAcesso;
import Backend.outras.Sistema;

/**
 *
 * @author
 * Bruno Ferreira (bruno@dsi.uminho.pt)
 */
public class JanelaRegistoAcessos extends javax.swing.JFrame {
    private final Sistema sistema;

    public JanelaRegistoAcessos(Sistema sistema) {
        initComponents();
        this.sistema = sistema;        
        tabAcessos.setModel(criarModeloTabela());
    }  
    
    private AbstractTableModel criarModeloTabela() {   
        String[] nomeColunas = {"Username", "Data/Hora"};
        //Cria uma copia da lista de entradas, para nao alterarmos a lista original
        List<RegistoAcesso> registos = new ArrayList<>(sistema.getListaEntradas());
        //Um Comparator permite-nos comparar dois objectos
        registos.sort(new Comparator<RegistoAcesso>(){
           
            @Override
            public int compare(RegistoAcesso o1, RegistoAcesso o2) {
            /*
                Este metodo compara dois objectos do mesmo tipo, serve para o metodo sort saber como ordenar a lista
                O retorno deste metodo é:
                    0  -> se consideramos que os objectos sao iguais,
                    -1 -> se consideramos que o primeiro objecto/argumento é menor que o segundo
                    1 -> se consideramos que o segundo objecto/argumento é maior que o primeiro               

                Como queremos ordenar os registos pela data decrescente do acesso, vamos comparar as datas de 
              cada registo de acesso.
                
                Porque a classe LocalDateTime já tem um método que permite comparar dois LocalDateTime (compareTo),
             vamos utilizar esse método, contudo como queremos ordenar os registos de forma descendente vamos
             inverter a ordem dos parametros que passamos 

            */                
                return o2.getData().compareTo(o1.getData());
            }            
        });

        return new AbstractTableModel() {     
            @Override
            public String getColumnName(int column) {
                return nomeColunas[column];
            }
           
            @Override
            public int getRowCount() {                
                return registos.size();
            }

            @Override
            public int getColumnCount() {                
                return nomeColunas.length;
            }

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                switch (columnIndex) {
                    case 0: 
                        return registos.get(rowIndex).getUtilizador().getUsername();
                    case 1:
                        return registos.get(rowIndex).getData();
                    default:
                        return "";
                }                              
            }            
        };
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        tabAcessos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registo de Acessos");

        tabAcessos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tabAcessos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 615, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabAcessos;
    // End of variables declaration//GEN-END:variables
}
