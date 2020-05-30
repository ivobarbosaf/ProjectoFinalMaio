package Frontend;

import javax.swing.JOptionPane;
import Backend.outras.Serializacao;
import Backend.entidades.Administrador;
import Backend.outras.Sistema;

/**
 *
 * @author
 * Bruno Ferreira (bruno@dsi.uminho.pt)
 */
public class JanelaPrincipal extends javax.swing.JFrame {
    private Sistema sistema;
    private Serializacao bd;
    
    public JanelaPrincipal(Sistema sistema, Serializacao bd) {
        initComponents();
        this.sistema = sistema;
        this.bd = bd;
        this.setExtendedState(JanelaPrincipal.MAXIMIZED_BOTH);//Força a maximização da janela    
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);//O processo de fecho da janela será controlado pelo programa
        mnuAdministrador.setVisible(sistema.getUtilizadorLigado() instanceof Administrador);//Apenas mostra o menu de administração se o utilizador for um administrador
        /**
         * Para que o menu deixe de ficar disponivel para o administradaor
         * mnuUtilizador.setVisible(!mnuAdministrador.isVisible());//Apenas mostra o menu de utilizador se o de administração estiver oculto  
         * 
         */
    }      
    
    private void guardarAlteracoes() {
        bd.guardar(sistema);
    }
    
    private void alterarPassword() {        
        JanelaDadosUtilizador psw = new JanelaDadosUtilizador(sistema, sistema.getUtilizadorLigado(), null);
        psw.setVisible(true);
    }
    
    private void listarUtilizadores() {
        ListagemUtilizadores listagem = new ListagemUtilizadores(sistema);
        listagem.setVisible(true);        
    }
    
    private void listarRegistoAcessos() {
        JanelaRegistoAcessos acessos = new JanelaRegistoAcessos(sistema);
        acessos.setVisible(true);
    }
    
    private void terminar() {        
        if (JOptionPane.showConfirmDialog(null, 
                "Deseja realmente terminar o programa?", 
                "Terminar", 
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            guardarAlteracoes();
            sistema.terminar();
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem3 = new javax.swing.JMenuItem();
        mnuPrincipal = new javax.swing.JMenuBar();
        mnuGeral = new javax.swing.JMenu();
        mniGuardar = new javax.swing.JMenuItem();
        mniAlterarPassword = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        mniTerminar = new javax.swing.JMenuItem();
        mnuAdministrador = new javax.swing.JMenu();
        mniRegistoAcessos = new javax.swing.JMenuItem();
        mnuListarUtilizadores = new javax.swing.JMenuItem();
        mnuUtilizador = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();

        jMenuItem3.setText("jMenuItem3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("O meu programa");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        mnuGeral.setText("Geral");

        mniGuardar.setText("Guardar dados");
        mniGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniGuardarActionPerformed(evt);
            }
        });
        mnuGeral.add(mniGuardar);

        mniAlterarPassword.setText("Alteração de dados de utilizador");
        mniAlterarPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniAlterarPasswordActionPerformed(evt);
            }
        });
        mnuGeral.add(mniAlterarPassword);
        mnuGeral.add(jSeparator1);

        mniTerminar.setText("Terminar");
        mniTerminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniTerminarActionPerformed(evt);
            }
        });
        mnuGeral.add(mniTerminar);

        mnuPrincipal.add(mnuGeral);

        mnuAdministrador.setText("Administrador");
        mnuAdministrador.setToolTipText("");

        mniRegistoAcessos.setText("Registo de Acessos");
        mniRegistoAcessos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniRegistoAcessosActionPerformed(evt);
            }
        });
        mnuAdministrador.add(mniRegistoAcessos);

        mnuListarUtilizadores.setText("Listagem Utilizadores");
        mnuListarUtilizadores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuListarUtilizadoresActionPerformed(evt);
            }
        });
        mnuAdministrador.add(mnuListarUtilizadores);

        mnuPrincipal.add(mnuAdministrador);

        mnuUtilizador.setText("Utilizador");

        jMenuItem2.setText("Opção especifica Utilizador");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        mnuUtilizador.add(jMenuItem2);

        mnuPrincipal.add(mnuUtilizador);

        setJMenuBar(mnuPrincipal);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 279, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mniTerminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniTerminarActionPerformed
        terminar();
    }//GEN-LAST:event_mniTerminarActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        terminar();
    }//GEN-LAST:event_formWindowClosing

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        JOptionPane.showMessageDialog(this, "Operação especifica do Utilizador");
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void mniAlterarPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniAlterarPasswordActionPerformed
        alterarPassword();
    }//GEN-LAST:event_mniAlterarPasswordActionPerformed

    private void mnuListarUtilizadoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuListarUtilizadoresActionPerformed
        listarUtilizadores();
    }//GEN-LAST:event_mnuListarUtilizadoresActionPerformed

    private void mniGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniGuardarActionPerformed
        guardarAlteracoes();
        JOptionPane.showMessageDialog(this, "Alterações guardadas.");
    }//GEN-LAST:event_mniGuardarActionPerformed

    private void mniRegistoAcessosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniRegistoAcessosActionPerformed
        listarRegistoAcessos();
    }//GEN-LAST:event_mniRegistoAcessosActionPerformed
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JMenuItem mniAlterarPassword;
    private javax.swing.JMenuItem mniGuardar;
    private javax.swing.JMenuItem mniRegistoAcessos;
    private javax.swing.JMenuItem mniTerminar;
    private javax.swing.JMenu mnuAdministrador;
    private javax.swing.JMenu mnuGeral;
    private javax.swing.JMenuItem mnuListarUtilizadores;
    private javax.swing.JMenuBar mnuPrincipal;
    private javax.swing.JMenu mnuUtilizador;
    // End of variables declaration//GEN-END:variables
}
