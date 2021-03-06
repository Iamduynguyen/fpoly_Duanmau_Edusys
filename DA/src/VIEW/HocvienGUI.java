/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VIEW;

import DAO.DAOHocvien;
import DAO.DAOKhoahoc;
import DAO.DAONguoihoc;
import DAO.DAOchuyende;
import Model.ChuyenDe;
import Model.Hocvien;
import Model.KhoaHoc;
import Model.Nguoihoc;
import SEVICE.SVHOCVIEN;
import java.util.List;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author dell
 */
public class HocvienGUI extends JInternalFrame {

    DAOchuyende cddao = new DAOchuyende();
    DAO.DAOKhoahoc khdao = new DAOKhoahoc();
    DAO.DAONguoihoc nhdao = new DAONguoihoc();
    DAOHocvien hvdao = new DAOHocvien();
    DefaultTableModel tbmModel = new DefaultTableModel();
    String macd = cddao.lstchuyende().get(0).getIdCD();
    SVHOCVIEN svhv = new SVHOCVIEN();

    /**
     * Creates new form HocvienGUI
     */
    public HocvienGUI() {
        initComponents();
        loadtbnh();
        setcbbcd();
        loadtbhv();
    }

    private void setcbbcd() {
        for (ChuyenDe x : cddao.lstchuyende()) {
            cbbcd.addItem(x.getNameCD());
        }
    }

    private void setcbbkh(String macd) {
        cbbkh.removeAllItems();
        for (KhoaHoc x : khdao.getlistKhbyid(macd)) {
            cbbkh.addItem("khoa hoc: " + x.getIdKh() + " (" + x.getNgayKG() + ")");
        }
    }

    private void loadtbhv() {
        try {
            tbmModel = (DefaultTableModel) tbhocvien.getModel();
            tbmModel.setRowCount(0);
            int i = 1;
            int makh = khdao.getlistKhbyid(macd).get(cbbkh.getSelectedIndex()).getIdKh();
            List<Hocvien> lst = hvdao.lsthocvienbymakh(makh);
            for (Hocvien x : lst) {
                tbmModel.addRow(new Object[]{i++, x.getMahv(), x.getManh(), x.getHvt(), x.getDiem()});
            }
        } catch (Exception e) {
        }
    }

    private void loadtbnh() {
        tbmModel = (DefaultTableModel) tbnguoihoc.getModel();
        List<Nguoihoc> lst = nhdao.lstNguoihocs();
        tbmModel.setRowCount(0);
        for (Nguoihoc x : lst) {
            tbmModel.addRow(new Object[]{x.getId(), x.getName(), x.getGioitinh(), x.getSdt(), x.getEmail()});
        }
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
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        cbbcd = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        cbbkh = new javax.swing.JComboBox<>();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbhocvien = new javax.swing.JTable();
        btnrefresh = new javax.swing.JButton();
        btnxoa = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbnguoihoc = new javax.swing.JTable();
        btnthem = new javax.swing.JButton();

        setClosable(true);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Chuy??n ?????");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Kh??a h???c:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 30, -1, -1));

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        cbbcd.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbcdItemStateChanged(evt);
            }
        });
        cbbcd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbcdActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbbcd, 0, 266, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cbbcd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 290, 50));

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        cbbkh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbkhActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbbkh, 0, 266, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(cbbkh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 60, -1, -1));

        tbhocvien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "M?? h???c vi??n", "M?? ng?????i h???c", "H??? v?? t??n", "??i???m"
            }
        ));
        jScrollPane1.setViewportView(tbhocvien);

        btnrefresh.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnrefresh.setText("C???p nh???t ??i???m");
        btnrefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnrefreshActionPerformed(evt);
            }
        });

        btnxoa.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnxoa.setText("X??a kh???i kh??a h???c");
        btnxoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnxoaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 595, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnrefresh)
                .addContainerGap())
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                    .addContainerGap(283, Short.MAX_VALUE)
                    .addComponent(btnxoa)
                    .addGap(167, 167, 167)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnrefresh)
                .addContainerGap())
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                    .addContainerGap(272, Short.MAX_VALUE)
                    .addComponent(btnxoa)
                    .addContainerGap()))
        );

        jTabbedPane1.addTab("H???C VI??N", jPanel4);

        tbnguoihoc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "M?? ng?????i h???c", "H??? v?? t??n", "Gi???i t??nh", "Sdt", "Email"
            }
        ));
        jScrollPane2.setViewportView(tbnguoihoc);

        btnthem.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnthem.setText("Th??m v??o kh??a h???c");
        btnthem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 595, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnthem)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnthem)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("NG?????I H???C", jPanel5);

        jPanel1.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 600, 330));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 650, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnthemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthemActionPerformed
        if (macd == null) {
            JOptionPane.showMessageDialog(rootPane, "moi ban chon khoa hoc theo chuyen de");
        } else {
            KhoaHoc kh = khdao.getlistKhbyid(macd).get(cbbkh.getSelectedIndex());
            for (int row : tbnguoihoc.getSelectedRows()) {
                Hocvien hv = new Hocvien();
                hv.setMakh(kh.getIdKh());
                hv.setDiem(0);
                hv.setManh((String) tbnguoihoc.getValueAt(row, 0));
                hvdao.inserthv(hv);
            }
            loadtbhv();
        }
    }//GEN-LAST:event_btnthemActionPerformed

    private void cbbcdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbcdActionPerformed

    }//GEN-LAST:event_cbbcdActionPerformed

    private void cbbcdItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbcdItemStateChanged
        try {
            macd = cddao.lstchuyende().get(cbbcd.getSelectedIndex()).getIdCD();
            setcbbkh(macd);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "loi");
            e.printStackTrace();
        }
    }//GEN-LAST:event_cbbcdItemStateChanged

    private void btnxoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnxoaActionPerformed
        try {
            int mahv = (int) tbhocvien.getValueAt(tbhocvien.getSelectedRow(), 1);
            hvdao.deletehv(mahv);
            loadtbhv();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "moi ban chon hoc vien");
        }
    }//GEN-LAST:event_btnxoaActionPerformed

    private void btnrefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnrefreshActionPerformed
        int count = 0;
        boolean loi = false;
        for (int i = 0; i < tbhocvien.getRowCount(); i++) {
            int mahv = Integer.parseInt(tbhocvien.getValueAt(i, 1).toString());
            Hocvien hocvien = svhv.getHocvienbyid(mahv);
            if (hocvien != null) {
                try {
                    float diem = Float.parseFloat(tbhocvien.getValueAt(i, 4).toString());
                    if (diem <= 0) {
                        JOptionPane.showMessageDialog(rootPane, "Moi nhap lai diem cua hoc vien " + hocvien.getHvt());
                    } else {
                        if (hocvien.getDiem() != diem) {
                            if (hvdao.updatediem(mahv, diem)) {
                                count++;
                            }
                        }
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(rootPane, "Moi nhap lai diem cua hoc vien " + hocvien.getHvt());
                }
//                System.out.println("ten "+hocvien.getHvt()+" diem "+hocvien.getDiem() +"diem kia "+diem);
            } else {
                loi = true;
            }
        }
        if (loi) {
            JOptionPane.showMessageDialog(rootPane, "Chua co hoc vien nao duoc cap nhat");
        }
        if (count > 0) {
            JOptionPane.showMessageDialog(rootPane, "Da update diem cua " + count + " hocvien");
        }
    }//GEN-LAST:event_btnrefreshActionPerformed

    private void cbbkhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbkhActionPerformed
        loadtbhv();
    }//GEN-LAST:event_cbbkhActionPerformed

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
            java.util.logging.Logger.getLogger(HocvienGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HocvienGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HocvienGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HocvienGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HocvienGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnrefresh;
    private javax.swing.JButton btnthem;
    private javax.swing.JButton btnxoa;
    private javax.swing.JComboBox<String> cbbcd;
    private javax.swing.JComboBox<String> cbbkh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tbhocvien;
    private javax.swing.JTable tbnguoihoc;
    // End of variables declaration//GEN-END:variables
}
