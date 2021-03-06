/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VIEW;

import DAO.DAOKhoahoc;
import DAO.DAOThongke;
import Model.KhoaHoc;
import Model.Nhanvien;
import javax.swing.JInternalFrame;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author dell
 */
public class ThongkeGUI extends JInternalFrame {

    DefaultTableModel modeltable = new DefaultTableModel();
    DAOThongke tkdao = new DAOThongke();
    DAO.DAOKhoahoc khdao = new DAOKhoahoc();
    static Nhanvien nhanvien = null;
    static int indextatb = 0;

    /**
     * Creates new form ThongkeGUI
     */
    public ThongkeGUI() {
        initComponents();
        setcbo();
        loadtbNH();
        loadtbbangdiem();
        loadtbdiemCD();
        loadtbDThu();
        settab();
    }
    
    public static void getNV(Nhanvien x){
        nhanvien = x;
    }
    
    public static void getindextab(int index){
        indextatb = index;
    }
    
    void settab(){
        if (nhanvien.getChucvu()!=1) {
            tab.removeTabAt(3);
        }
        tab.setSelectedIndex(indextatb);
    }
    

    void setcbo() {
        tkdao = new DAOThongke();
        for (KhoaHoc x : khdao.getlistKh()) {
            cboKH.addItem("Khóa học " + x.getIdKh() + "(" + x.getNgayKG() + ")");
        }
        for (int x : tkdao.selectYear()) {
            cbonam.addItem(" " + x);
        }
    }

    private void loadtbbangdiem() {
        modeltable = (DefaultTableModel) tbBangdiem.getModel();
        modeltable.setRowCount(0);
        int idkh = khdao.getlistKh().get(cboKH.getSelectedIndex()).getIdKh();
        for (Object[] x : tkdao.getBangdiem(idkh)) {
            modeltable.addRow(x);
        }
    }

    private void loadtbNH() {
        modeltable = (DefaultTableModel) tbNguoihoc.getModel();
        modeltable.setRowCount(0);
        for (Object[] x : tkdao.getTKNguoihoc()) {
            modeltable.addRow(x);
        }
    }

    private void loadtbdiemCD() {
        modeltable = (DefaultTableModel) tbDiemcd.getModel();
        modeltable.setRowCount(0);
        for (Object[] x : tkdao.getTKdiemCD()) {
            modeltable.addRow(x);
        }
    }

    private void loadtbDThu() {
        modeltable = (DefaultTableModel) tbdoanthu.getModel();
        modeltable.setRowCount(0);
        String year = cbonam.getSelectedItem().toString();
        for (Object[] x : tkdao.getTKdoanhthu(year)) {
            modeltable.addRow(x);
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

        tab = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        cboKH = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbBangdiem = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbNguoihoc = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbDiemcd = new javax.swing.JTable();
        pnds = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbdoanthu = new javax.swing.JTable();
        cbonam = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tab.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        cboKH.setMaximumRowCount(100);
        cboKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboKHActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Khóa học :");

        tbBangdiem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã người học", "Họ tên", "Điểm", "Xếp loại"
            }
        ));
        jScrollPane1.setViewportView(tbBangdiem);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel2)
                .addGap(52, 52, 52)
                .addComponent(cboKH, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE)
                .addContainerGap())
        );

        tab.addTab("BẢNG ĐIỂM", jPanel1);

        tbNguoihoc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Năm", "Số người học", "Đăng kí sớm nhất", "Đăng kí muộn nhất"
            }
        ));
        jScrollPane2.setViewportView(tbNguoihoc);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 369, Short.MAX_VALUE)
        );

        tab.addTab("NGƯỜI HỌC", jPanel2);

        tbDiemcd.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Chuyên đề", "Số lượng học viên", "Điểm TN", "Điểm CN", "Điểm TB"
            }
        ));
        jScrollPane3.setViewportView(tbDiemcd);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 640, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 369, Short.MAX_VALUE)
        );

        tab.addTab("ĐIỂM CHUYÊN ĐỀ", jPanel3);

        tbdoanthu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Chuyên đề", "Số KH", "Số HV", "Doanh thu", "Thấp nhất", "Cao nhẩt", "TB"
            }
        ));
        jScrollPane4.setViewportView(tbdoanthu);

        cbonam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbonamActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Nam :");

        javax.swing.GroupLayout pndsLayout = new javax.swing.GroupLayout(pnds);
        pnds.setLayout(pndsLayout);
        pndsLayout.setHorizontalGroup(
            pndsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pndsLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel3)
                .addGap(52, 52, 52)
                .addComponent(cbonam, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pndsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4)
                .addContainerGap())
        );
        pndsLayout.setVerticalGroup(
            pndsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pndsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pndsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbonam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE)
                .addContainerGap())
        );

        tab.addTab("DOANH THU", pnds);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setText("TỔNG HỢP THỐNG KÊ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tab, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 11, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(tab, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cboKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboKHActionPerformed
        loadtbbangdiem();
    }//GEN-LAST:event_cboKHActionPerformed

    private void cbonamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbonamActionPerformed
        // TODO add your handling code here:
        loadtbDThu();
    }//GEN-LAST:event_cbonamActionPerformed

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
            java.util.logging.Logger.getLogger(ThongkeGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ThongkeGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ThongkeGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThongkeGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ThongkeGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cboKH;
    private javax.swing.JComboBox<String> cbonam;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JPanel pnds;
    private javax.swing.JTabbedPane tab;
    private javax.swing.JTable tbBangdiem;
    private javax.swing.JTable tbDiemcd;
    private javax.swing.JTable tbNguoihoc;
    private javax.swing.JTable tbdoanthu;
    // End of variables declaration//GEN-END:variables
}
