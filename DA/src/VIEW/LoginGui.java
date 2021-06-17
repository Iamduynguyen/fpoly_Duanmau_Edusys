/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VIEW;

import DAO.DAOLogin;
import Model.Nhanvien;
import SEVICE.SVNhanvien;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author dell
 */
public class LoginGui extends javax.swing.JFrame {

    DAO.DAOLogin log = new DAOLogin();

    /**
     * Creates new form Login
     */
    public LoginGui() {
        initComponents();
        setLocationRelativeTo(this);
        lbllogo.setIcon(new ImageIcon("img/aaaaaaaa.png"));
    }
    
    public static Nhanvien getnhanvien(Nhanvien x){
        return x;
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_log = new javax.swing.JPanel();
        txt_us = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_pw = new javax.swing.JPasswordField();
        btnend = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lbllogo = new javax.swing.JLabel();
        btnlogin = new javax.swing.JButton();
        jTextField4 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_log.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        btn_log.add(txt_us, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 100, 160, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Mật khẩu :");
        btn_log.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 160, -1, 20));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Tên tài khoản :");
        btn_log.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 110, -1, 20));
        btn_log.add(txt_pw, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 150, 160, 30));

        btnend.setBackground(new java.awt.Color(255, 0, 51));
        btnend.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnend.setText("Kết thúc");
        btnend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnendActionPerformed(evt);
            }
        });
        btn_log.add(btnend, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 210, 120, 30));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setText("ĐĂNG NHẬP");
        btn_log.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, 181, 55));
        btn_log.add(lbllogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 84, 125, 156));

        btnlogin.setBackground(new java.awt.Color(0, 0, 255));
        btnlogin.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnlogin.setText("Đăng nhập");
        btnlogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnloginActionPerformed(evt);
            }
        });
        btnlogin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnloginKeyPressed(evt);
            }
        });
        btn_log.add(btnlogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 210, 120, 30));

        getContentPane().add(btn_log, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 480, 290));
        getContentPane().add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 100, 160, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnendActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnendActionPerformed

    private void btnloginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnloginActionPerformed
        String user = txt_us.getText();
        String pw = txt_pw.getText();
        for (Nhanvien x : log.lstLog()) {
            if (x.getId().equals(user) && x.getMatkhau().equals(pw)) {
                MainGui.getNv(x);
                JOptionPane.showMessageDialog(this, "Chào "+ x.getName());
                new MainGui().setVisible(true);
                this.dispose();
                return;
            }
        }
        JOptionPane.showMessageDialog(this, "Đăng nhập thất bại");
    }//GEN-LAST:event_btnloginActionPerformed

    private void btnloginKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnloginKeyPressed
        
    }//GEN-LAST:event_btnloginKeyPressed

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
            java.util.logging.Logger.getLogger(LoginGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginGui().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btn_log;
    private javax.swing.JButton btnend;
    private javax.swing.JButton btnlogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JLabel lbllogo;
    private javax.swing.JPasswordField txt_pw;
    private javax.swing.JTextField txt_us;
    // End of variables declaration//GEN-END:variables
}
