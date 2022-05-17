
package View;

import Controller.LoginController;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class Login extends javax.swing.JFrame {

    private final LoginController controller;
    public Login() {
        initComponents();
        controller = new LoginController(this);
        
    }

    @SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                jButtonLogin = new javax.swing.JButton();
                jTextSenha = new javax.swing.JTextField();
                jTextEmail = new javax.swing.JTextField();
                background = new javax.swing.JLabel();

                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
                getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

                jButtonLogin.setBackground(new java.awt.Color(240, 61, 7));
                jButtonLogin.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
                jButtonLogin.setForeground(new java.awt.Color(255, 255, 255));
                jButtonLogin.setText("ENTRAR");
                jButtonLogin.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jButtonLoginActionPerformed(evt);
                        }
                });
                getContentPane().add(jButtonLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 456, 240, 72));

                jTextSenha.setBackground(new java.awt.Color(255, 255, 255));
                jTextSenha.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
                jTextSenha.setText("senha");
                getContentPane().add(jTextSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(498, 335, 384, 72));

                jTextEmail.setBackground(new java.awt.Color(255, 255, 255));
                jTextEmail.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
                jTextEmail.setText("login");
                getContentPane().add(jTextEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(498, 215, 384, 72));

                background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/imgs/Login.jpeg"))); // NOI18N
                getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

                pack();
        }// </editor-fold>//GEN-END:initComponents

    private void jButtonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLoginActionPerformed
        try {
            this.controller.validar();
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButtonLoginActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JLabel background;
        private javax.swing.JButton jButtonLogin;
        private javax.swing.JTextField jTextEmail;
        private javax.swing.JTextField jTextSenha;
        // End of variables declaration//GEN-END:variables

public void msg(String message) {
        JOptionPane.showMessageDialog(null, message);
    }

    public JTextField getjTextEmail() {
        return jTextEmail;
    }

    public void setjTextEmail(JTextField jTextEmail) {
        this.jTextEmail = jTextEmail;
    }

    public JTextField getjTextSenha() {
        return jTextSenha;
    }

    public void setjTextSenha(JTextField jTextSenha) {
        this.jTextSenha = jTextSenha;
    }

  

}
