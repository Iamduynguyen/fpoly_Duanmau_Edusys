/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VIEW;

import DAO.DAOchuyende;
import Model.ChuyenDe;
import Model.Nhanvien;
import java.awt.HeadlessException;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author dell
 */
public class ChuyendeGUI extends JInternalFrame{

    DefaultTableModel tbmodel = new DefaultTableModel();
    int _index = 0;
    static Nhanvien _nhanvienlog = new Nhanvien();

    /**
     * Creates new form ChuyendeGUI
     */
    public ChuyendeGUI() {
        initComponents();
        tbmodel = (DefaultTableModel) tbchuyende.getModel();
        loadtb();
        settext();
        btnthem.setEnabled(false);
        setform();
        settext();
    }
    private String tenHinhAnh = "";
    private Path pathForm = null;
    private File dst = null;

    private void evtChonHinhAnh() throws HeadlessException {
        try {
            JFileChooser chooser = new JFileChooser();
            if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                File srcFile = chooser.getSelectedFile();
                while (true) {
                    int Random = (int) (Math.random() * 100);
                    tenHinhAnh = txtma.getText() + Random + srcFile.getName();
                    dst = new File("logos", tenHinhAnh);
                    if (!dst.exists()) {
                        break;
                    }
                }
                if (!dst.getParentFile().exists()) {
                    dst.getParentFile().mkdirs();
                }
                pathForm = Paths.get(srcFile.getAbsolutePath());
                ImageIcon imageIcon = new ImageIcon(pathForm.toString()); // load the image to a imageIcon
                Image image = imageIcon.getImage(); // transform it
                Image newimg = image.getScaledInstance(140, 174, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
                imageIcon = new ImageIcon(newimg);  // transform it back
                lbllogo.setIcon(imageIcon);
            }
        } catch (HeadlessException e) {
        }
    }

    private void loadtb() {
        tbmodel.setRowCount(0);
        DAOchuyende.lstchuyende().forEach(x -> {
            tbmodel.addRow(new Object[]{x.getIdCD(), x.getNameCD(), x.getThoiluongCD(), x.getHocphiCD(),
                x.getHinh()});
        });
    }

    private void refresh() {
        txthocphi.setText("");
        txtma.setText("");
        txtmota.setText("");
        txtname.setText("");
        txtthoiluong.setText("");
        lbllogo.revalidate();
        lbllogo.setText("Click here");
        lbllogo.setIcon(null);
    }

    public static void getNV(Nhanvien x) {
        _nhanvienlog = x;
    }

    private void setform() {
        if (btnthem.isEnabled() == false) {
            btnsua.setEnabled(false);
            btnxoa.setEnabled(false);
            btnthem.setEnabled(true);
            refresh();
        } else {
            btnsua.setEnabled(true);
            btnxoa.setEnabled(true);
            if (_nhanvienlog.getChucvu() == 0) {
                btnxoa.setEnabled(false);
            }
            btnthem.setEnabled(false);
        }
    }

    private void settext() {
        ChuyenDe x = new ChuyenDe();
        x = DAOchuyende.lstchuyende().get(_index);
        txtma.setText(x.getIdCD());
        txtname.setText(x.getNameCD());
        txthocphi.setText(x.getHocphiCD() + "");
        txtthoiluong.setText(x.getThoiluongCD() + "");
        txtmota.setText(x.getMotaCD());
        File file = new File("logos", x.getHinh());
        if (!file.exists()) {
            lbllogo.setText("no image");
            lbllogo.setIcon(null);
            return;
        }
        Path part = Paths.get(file.getAbsolutePath());
        ImageIcon icon = new ImageIcon(part.toString());
        Image image = icon.getImage(); // transform it 
        Image newimg = image.getScaledInstance(140, 174, java.awt.Image.SCALE_SMOOTH);
        icon = new ImageIcon(newimg);  // transform it back
        lbllogo.setIcon(icon);
    }

    private String checkCD(ChuyenDe x) {
        if (x.getIdCD().isBlank()) {
            return "Mời nhập lại mã chuyên đề";
        }
        if (Help.Checkloi.checkmaCD(x.getIdCD(), DAOchuyende.lstchuyende()) > -1) {
            return "Mã chuyên đề đã tồn tại";
        }
        if (x.getNameCD().isBlank()) {
            return "Mời nhập lại tên chuyên đề";
        }
        if (x.getThoiluongCD() <= 0) {
            return "Mời nhập lại thời lượng";
        }
        if (x.getHocphiCD() < 0) {
            return "Mời nhập lại học phí";
        }
        return "ok";
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
        jLabel1 = new javax.swing.JLabel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtma = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtname = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtthoiluong = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txthocphi = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        btnlast = new javax.swing.JButton();
        btnthem = new javax.swing.JButton();
        btnsua = new javax.swing.JButton();
        btnxoa = new javax.swing.JButton();
        btnmoi = new javax.swing.JButton();
        btnfist = new javax.swing.JButton();
        btnprev = new javax.swing.JButton();
        btnnext = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtmota = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        lbllogo = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbchuyende = new javax.swing.JTable();

        setClosable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(0, 0, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setText("Quản lý chuyên đề");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));
        jPanel1.add(jTabbedPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jTabbedPane3.setForeground(new java.awt.Color(255, 0, 102));
        jTabbedPane3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Mã chuyên đề");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 10, -1, -1));
        jPanel2.add(txtma, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 30, 350, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Tên chuyên đề");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 60, -1, -1));
        jPanel2.add(txtname, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 80, 350, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Thời lượng");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 110, -1, -1));
        jPanel2.add(txtthoiluong, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 130, 350, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Hình logo");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));
        jPanel2.add(txthocphi, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 180, 350, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Học phí:");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 160, -1, -1));

        btnlast.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnlast.setText(">|");
        btnlast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlastActionPerformed(evt);
            }
        });
        jPanel2.add(btnlast, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 330, -1, -1));

        btnthem.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnthem.setText("Thêm");
        btnthem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthemActionPerformed(evt);
            }
        });
        jPanel2.add(btnthem, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, -1, -1));

        btnsua.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnsua.setText("Sửa");
        btnsua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsuaActionPerformed(evt);
            }
        });
        jPanel2.add(btnsua, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 330, -1, -1));

        btnxoa.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnxoa.setText("Xóa");
        btnxoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnxoaActionPerformed(evt);
            }
        });
        jPanel2.add(btnxoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 330, -1, -1));

        btnmoi.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnmoi.setText("Mới");
        btnmoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmoiActionPerformed(evt);
            }
        });
        jPanel2.add(btnmoi, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 330, -1, -1));

        btnfist.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnfist.setText("|<");
        btnfist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnfistActionPerformed(evt);
            }
        });
        jPanel2.add(btnfist, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 330, -1, -1));

        btnprev.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnprev.setText("<<");
        btnprev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnprevActionPerformed(evt);
            }
        });
        jPanel2.add(btnprev, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 330, -1, -1));

        btnnext.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnnext.setText(">>");
        btnnext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnextActionPerformed(evt);
            }
        });
        jPanel2.add(btnnext, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 330, -1, -1));

        txtmota.setColumns(20);
        txtmota.setRows(5);
        jScrollPane5.setViewportView(txtmota);

        jPanel2.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, 500, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Mô tả chuyên đề:");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, -1, -1));

        lbllogo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbllogo.setText("       Click here");
        lbllogo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbllogoMouseClicked(evt);
            }
        });
        jPanel2.add(lbllogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 140, 170));

        jTabbedPane3.addTab("CẬP NHẬT", jPanel2);

        tbchuyende.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã chuyên đề", "Tên chuyên đề", "Thời lượng", "Học phí", "Hình"
            }
        ));
        jScrollPane4.setViewportView(tbchuyende);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 575, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane3.addTab("DANH SÁCH", jPanel7);

        getContentPane().add(jTabbedPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 580, 400));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnlastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlastActionPerformed
        _index = DAOchuyende.lstchuyende().size() - 1;
        settext();
    }//GEN-LAST:event_btnlastActionPerformed

    private void btnthemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthemActionPerformed
        ChuyenDe chuyenDe = new ChuyenDe();
        chuyenDe.setIdCD(txtma.getText());
        chuyenDe.setNameCD(txtname.getText());
        try {
            chuyenDe.setHocphiCD(Double.parseDouble(txthocphi.getText()));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(rootPane, "Học phí mời nhập số");
            return;
        }
        try {
            chuyenDe.setThoiluongCD(Integer.parseInt(txtthoiluong.getText()));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(rootPane, "Thời lượng mời nhập số");
            return;
        }

        chuyenDe.setMotaCD(txtmota.getText());
        chuyenDe.setHinh(tenHinhAnh);
        String tb = checkCD(chuyenDe);
        if (tb.equals("ok")) {
            try {
                Path patchTo = Paths.get(dst.getAbsolutePath());
                Files.copy(pathForm, patchTo, StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException ex) {
                Logger.getLogger(ChuyendeGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            DAOchuyende.insertCD(chuyenDe);
            loadtb();
            JOptionPane.showMessageDialog(rootPane, "Đã thêm");
        } else {
            JOptionPane.showMessageDialog(rootPane, tb);
        }
        refresh();
    }//GEN-LAST:event_btnthemActionPerformed

    private void btnsuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsuaActionPerformed
        ChuyenDe chuyenDe = new ChuyenDe();
        chuyenDe.setIdCD(txtma.getText());
        chuyenDe.setNameCD(txtname.getText());
        if (chuyenDe.getNameCD().isBlank()) {
            JOptionPane.showMessageDialog(rootPane, "Mời nhập lại tên chuyên đề");
            return;
        }
        try {
            chuyenDe.setHocphiCD(Double.parseDouble(txthocphi.getText()));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(rootPane, "Học phí mời nhập số");
            return;
        }
        try {
            chuyenDe.setThoiluongCD(Integer.parseInt(txtthoiluong.getText()));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(rootPane, "Thời lượng mời nhập số");
            return;
        }

        chuyenDe.setMotaCD(txtmota.getText());
        String tb = checkCD(chuyenDe);
        if (dst != null) {
            chuyenDe.setHinh(tenHinhAnh);
            try {
                Path patchTo = Paths.get(dst.getAbsolutePath());
                Files.copy(pathForm, patchTo, StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException ex) {

            }
        }
        if (DAOchuyende.updatecd(chuyenDe)) {
            loadtb();
            JOptionPane.showMessageDialog(rootPane, "Đã sửa");
        }
    }//GEN-LAST:event_btnsuaActionPerformed

    private void btnxoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnxoaActionPerformed
        if (JOptionPane.showConfirmDialog(rootPane, "Chắc chắn xóa không", "Thông báo",
                JOptionPane.YES_OPTION) == JOptionPane.YES_OPTION) {
            List<ChuyenDe> lst = DAOchuyende.lstchuyende();
            ChuyenDe x = lst.get(_index);
            if (DAOchuyende.xoaCD(x)) {
                if (lst.size() - _index == 1) {
                    _index--;
                }
                settext();
                loadtb();
                File file = new File("logos", x.getHinh());
                file.delete();
            }
        }
    }//GEN-LAST:event_btnxoaActionPerformed

    private void btnmoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmoiActionPerformed
        setform();
    }//GEN-LAST:event_btnmoiActionPerformed

    private void btnfistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnfistActionPerformed
        _index = 0;
        settext();
    }//GEN-LAST:event_btnfistActionPerformed

    private void btnprevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnprevActionPerformed

        if (_index > 0) {
            _index--;
            settext();
        }
    }//GEN-LAST:event_btnprevActionPerformed

    private void btnnextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnextActionPerformed
        if (_index < (DAOchuyende.lstchuyende().size()) - 1) {
            _index++;
            settext();
        }
    }//GEN-LAST:event_btnnextActionPerformed

    private void lbllogoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbllogoMouseClicked
        try {
            evtChonHinhAnh();
        } catch (HeadlessException e) {
            System.out.println("loi cc gi " + e);
        }
    }//GEN-LAST:event_lbllogoMouseClicked

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChuyendeGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new ChuyendeGUI().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnfist;
    private javax.swing.JButton btnlast;
    private javax.swing.JButton btnmoi;
    private javax.swing.JButton btnnext;
    private javax.swing.JButton btnprev;
    private javax.swing.JButton btnsua;
    private javax.swing.JButton btnthem;
    private javax.swing.JButton btnxoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JLabel lbllogo;
    private javax.swing.JTable tbchuyende;
    private javax.swing.JTextField txthocphi;
    private javax.swing.JTextField txtma;
    private javax.swing.JTextArea txtmota;
    private javax.swing.JTextField txtname;
    private javax.swing.JTextField txtthoiluong;
    // End of variables declaration//GEN-END:variables
}
