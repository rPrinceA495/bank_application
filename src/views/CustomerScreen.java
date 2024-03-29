/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import model.Account;
import model.JDBC;

/**
 *
 * @author Acer
 */
public class CustomerScreen extends javax.swing.JFrame {
    
    // Active Customer
    private static Account activeAccount = null;
    
    
    JPanel panel = null;

        
    
    static Account getActiveAccount() {
        return CustomerScreen.activeAccount;
    }
    
    static void setActiveAccount(Account acc) {
        CustomerScreen.activeAccount = acc;
    }
    
    private JDBC jdbc;

    /**
     * Creates new form CustomerScreen
     */
    public CustomerScreen() {
        initComponents();
        
        accNumField.addKeyListener(new KeyAdapter() {
         public void keyPressed(KeyEvent ke) {
            String value = accNumField.getText();
            int l = value.length();
            continueBtn.setEnabled(true);
            if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') {
               accNumField.setEditable(true);
               label.setText("");
            } else {
               accNumField.setEditable(true);
               label.setText("* Enter  only  numeric  digits (0-9) !");
               continueBtn.setEnabled(false);
            }
         }
      });
       
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        accNumField = new javax.swing.JTextField();
        continueBtn = new javax.swing.JButton();
        label = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("<<");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Elephant", 1, 24)); // NOI18N
        jLabel1.setText("PULA BANKING ATM");

        jLabel2.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        jLabel2.setText("Please enter your Account Number to continue:");

        jLabel3.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
        jLabel3.setText("Account Number:");

        accNumField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accNumFieldActionPerformed(evt);
            }
        });

        continueBtn.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        continueBtn.setText("Continue >>");
        continueBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                continueBtnActionPerformed(evt);
            }
        });

        label.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        label.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(159, 159, 159)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 105, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(continueBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3)
                                .addComponent(jLabel2)
                                .addComponent(accNumField, javax.swing.GroupLayout.PREFERRED_SIZE, 511, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(113, 113, 113))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(251, 251, 251)
                .addComponent(label)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel1)))
                .addGap(58, 58, 58)
                .addComponent(jLabel2)
                .addGap(34, 34, 34)
                .addComponent(label)
                .addGap(33, 33, 33)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(accNumField, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(continueBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(140, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        LandingScreen ls = new LandingScreen();
        ls.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void accNumFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accNumFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_accNumFieldActionPerformed

    private void continueBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_continueBtnActionPerformed

        String accountNumber = "";
        
        if(accNumField.getText().equals("")) {
            label.setText("* Enter  Account Number !");
        }else {
            accountNumber = accNumField.getText();
        }
        
        if(!accNumField.getText().equals("")) {
            jdbc = new JDBC();
        
        int accNum = Integer.parseInt(accountNumber);
        
        CustomerScreen.setActiveAccount(jdbc.fetchAccount(accNum));
        
        jdbc = null;
        
        if(activeAccount != null){
            String atmPin = activeAccount.getHolder().getAtmPin();
            
            if(atmPin.equals("1234")) {
                JPasswordField field1 = new JPasswordField("");
                JPanel panel = new JPanel(new GridLayout(0, 1));
                panel.add(new JLabel("New PIN:"));
                panel.add(field1);
                int result = JOptionPane.showConfirmDialog(null, panel, "Set ATM PIN",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
                if (result == JOptionPane.OK_OPTION) {
                       // Update PIN
                       jdbc = new JDBC();
                       jdbc.updateATMPin(activeAccount.getHolder().getCustomerId(), field1.getText());
                       // Success message
                       JOptionPane.showMessageDialog(null, "ATM PIN succesfully changed for user: " + activeAccount.getHolder().getfName() + " " + activeAccount.getHolder().getlName());
                       ATM atm = new ATM();
                       atm.setVisible(true);
                       this.setVisible(false);
                } 
            }else {
                JPasswordField field1 = new JPasswordField("");
                JPanel panel = new JPanel(new GridLayout(0, 1));
                panel.add(new JLabel("ATM PIN:"));
                panel.add(field1);
                int result = JOptionPane.showConfirmDialog(null, panel, "Enter your ATM PIN",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
                if (result == JOptionPane.OK_OPTION) {
                       // Validate PIN
                       jdbc = new JDBC();
                       int success = jdbc.validatePIN(activeAccount.getHolder().getCustomerId(), field1.getText());
                       if(success > 0) {
                           // Success message
                           JOptionPane.showMessageDialog(null, "PIN Correct ! Welcome user: " + activeAccount.getHolder().getfName() + " " + activeAccount.getHolder().getlName());
                           ATM atm = new ATM();
                           atm.setVisible(true);
                           this.setVisible(false);
                       }else {
                           JOptionPane.showMessageDialog(null, "Incorrect PIN. Please try again.");
                       }
                       
                }
            }
        }
        }
    }//GEN-LAST:event_continueBtnActionPerformed

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
            java.util.logging.Logger.getLogger(CustomerScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CustomerScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CustomerScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CustomerScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CustomerScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField accNumField;
    private javax.swing.JButton continueBtn;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel label;
    // End of variables declaration//GEN-END:variables
}
