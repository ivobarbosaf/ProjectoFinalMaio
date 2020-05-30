package Frontend;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import Backend.outras.Sistema;

/**
 *
 * @author
 * Bruno Ferreira (bruno@dsi.uminho.pt)
 */
public class JanelaLogin extends JDialog {    
    private Sistema sistema;
    
    public JanelaLogin(Sistema sistema) {
        initComponents();

        //Indica que a janela deve ser modal ou seja,
        //bloqueia a execução do programa até que a janela seja fechada
        this.setModal(true);           
        
        //Não permite o redimensionamento da janela
        this.setResizable(false);
        
        //Mostra a centralização da janela
        this.setLocationRelativeTo(null);
        
        //O processo de fecho da janela será controlado pelo programa
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);                                
        
        this.sistema = sistema;      
      
        txtUtilizador.requestFocus();
    }   
    
    private void autenticar() {                
        if (txtUtilizador.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Introduza p.f. o nome de utilizador!");            
            txtUtilizador.requestFocus();
            return;
        }
        
        if (txtPassword.getPassword().length == 0) {
            JOptionPane.showMessageDialog(this, "Introduza p.f. a sua password!");
            txtPassword.requestFocus();
            return;
        }                              
        
        if (!sistema.autenticarUtilizador(txtUtilizador.getText(), new String(txtPassword.getPassword()))){
            JOptionPane.showMessageDialog(this, "As credenciais introduzidas não correspondem a um utilizador válido.",
                     "Autenticação", JOptionPane.WARNING_MESSAGE);
            txtUtilizador.requestFocus();            
        }else{
            //Devolve o controlo da aplicação para o método main
            dispose();            
        }               
    }           
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtUtilizador = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        btnOk = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Autenticação");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Username:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 15, -1, -1));

        jLabel2.setText("Password:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        txtUtilizador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUtilizadorActionPerformed(evt);
            }
        });
        getContentPane().add(txtUtilizador, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 172, 26));
        getContentPane().add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 172, 27));

        btnOk.setText("Autenticar");
        btnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkActionPerformed(evt);
            }
        });
        getContentPane().add(btnOk, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, 100, 30));

        btnSair.setText("Terminar");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });
        getContentPane().add(btnSair, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 50, 100, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkActionPerformed
        autenticar();
    }//GEN-LAST:event_btnOkActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        sistema.terminar();
    }//GEN-LAST:event_btnSairActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        sistema.terminar();
    }//GEN-LAST:event_formWindowClosing

    private void txtUtilizadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUtilizadorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUtilizadorActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOk;
    private javax.swing.JButton btnSair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUtilizador;
    // End of variables declaration//GEN-END:variables
}
