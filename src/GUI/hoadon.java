/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import DAO.HoaDonXuatDAO;
import Helper.MsgBox;
import Model.HoaDonXuat;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ADMIN
 */
public class hoadon extends javax.swing.JPanel {

    /**
     * Creates new form hoadon
     */
    int index = -1;
    int row = -1;
    int row1 = -1;

    public hoadon() {
        initComponents();
        filltotable();
    }
    HoaDonXuatDAO dao = new HoaDonXuatDAO();

    void filltotable() {
        DefaultTableModel model = (DefaultTableModel) tblhoadon.getModel();
        model.setRowCount(0);
        try {
            List<HoaDonXuat> list = dao.selectAlltt();
            for (HoaDonXuat hdx : list) {
                Object[] row = {hdx.getMaHDX(), hdx.getMaKH(), hdx.getNgayBan(), hdx.getTinhTrang(), hdx.isCheck()};
                model.addRow(row);
            }
        } catch (Exception e) {
            MsgBox.alert(this, "Lỗi truy vấn dữ liệu!");
            System.out.println(e);
        }
    }

    void dissibale() {

        try {
            String hdx = (String) tblhoadon.getValueAt(row, 0);
            if (index == -1) {

                btnchapnhan.setEnabled(false);
            } else {
                btnchapnhan.setEnabled(true);
            }
        } catch (Exception e) {
        }
    }

    void delete() {
        if (MsgBox.confirm(this, "Bạn muốn xóa hóa đơn được chọn?")) {
            for (int row : tblhoadon.getSelectedRows()) {
                String mahv = (String) tblhoadon.getValueAt(row, 0);
                System.out.println(row);
            }
            this.filltotable();
        }
    }

    void delete1() {
        int in = tblhoadon.getRowCount();
        boolean a = false;
        List<HoaDonXuat> hd = dao.selectAll();
        boolean b = false;
        for (int row : tblhoadon.getSelectedRows()) {
            b = (boolean) tblhoadon.getValueAt(row, 4);
        }
        if (chkcheck.isSelected()) {
            b = true;
        }
        if (b == false) {
            MsgBox.alert(this, "Bạn chưa chọn hóa đơn để xóa");
        } else {
            for (int i = 0; i < hd.size()-1; i++) {
                hd.get(i).setCheck((boolean) tblhoadon.getValueAt(i, 4));
                if (hd.get(i).isCheck()) {
                    int mahv = (Integer) tblhoadon.getValueAt(i, 0);
                    dao.delete(mahv);
                }
            }

            MsgBox.alert(this, "Bạn đã xóa hóa đơn thành công");
        }
        chkcheck.setSelected(false);
        this.filltotable();
    }

    void update1() {
        int in = tblhoadon.getRowCount();
        boolean a = false;
        List<HoaDonXuat> hd = dao.selectAll();
        boolean b = false;
        for (int row : tblhoadon.getSelectedRows()) {
            b = (boolean) tblhoadon.getValueAt(row, 4);
            System.out.println(b);
        }
        if (chkcheck.isSelected()) {
            b = true;
        }
        if (b == false) {
            MsgBox.alert(this, "Bạn chưa chọn hóa đơn để cập nhật");
        } else {
            for (int i = 0; i < hd.size()-1; i++) {
                hd.get(i).setCheck((boolean) tblhoadon.getValueAt(i, 4));
                if (hd.get(i).isCheck()) {
                    int mahv = (Integer) tblhoadon.getValueAt(i, 0);
                    dao.updatehd(mahv);

                }

            }
            MsgBox.alert(this, "Bạn đã cập nhật hóa đơn thành công");
        }
        chkcheck.setSelected(false);
        this.filltotable();
    }

    void update() {

        try {
            int hdx = (Integer) tblhoadon.getValueAt(row, 0);
            boolean a = (boolean) tblhoadon.getValueAt(row, 4);
            if (index == 0 && a == true) {
                dao.updatehd(hdx);
                MsgBox.alert(this, "Cập nhật thành công!");
            } else {
                MsgBox.alert(this, "Hóa đơn đã thanh toán!");
            }
        } catch (Exception e) {
        }

        this.filltotable();
    }

    void checktong() {
        List<HoaDonXuat> hd = dao.selectAll();
        if (chkcheck.isSelected()) {
            for (int i = 0; i < hd.size()-1; i++) {
                hd.get(i).setCheck(true);
                if (hd.get(i).isCheck()) {
                    tblhoadon.setValueAt(true, i, 4);
                }
            }
        } else {

            for (int i = 0; i < hd.size()-1; i++) {
                hd.get(i).setCheck(false);
                if (!hd.get(i).isCheck()) {
                    tblhoadon.setValueAt(false, i, 4);
                }
            }

        }

    }

    void check() {
        int in = tblhoadon.getRowCount();
        int b = 0;
        boolean a = false;
        List<HoaDonXuat> hd = dao.selectAll();
        for (int i = 0; i < hd.size(); i++) {
            hd.get(i).setCheck((boolean) tblhoadon.getValueAt(i, 4));
            if (hd.get(i).isCheck()) {
                a = true;
                b++;
            } else {
                a = false;
            }
        }
        if (a == true && b == in) {
            chkcheck.setSelected(true);
        } else {
            chkcheck.setSelected(false);
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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblhoadon = new javax.swing.JTable();
        btnchapnhan = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        chkcheck = new javax.swing.JCheckBox();

        setBackground(new java.awt.Color(204, 204, 204));

        jTabbedPane1.setBackground(new java.awt.Color(204, 204, 204));
        jTabbedPane1.setForeground(new java.awt.Color(0, 51, 0));
        jTabbedPane1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setForeground(new java.awt.Color(204, 204, 204));

        jScrollPane1.setBackground(new java.awt.Color(204, 204, 204));

        tblhoadon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã Hóa Đơn Xuất", "Mã KH", "Ngày Bán", "Tình Trạng", "Chọn"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblhoadon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblhoadonMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblhoadonMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblhoadon);

        btnchapnhan.setText("Chấp Nhận");
        btnchapnhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnchapnhanActionPerformed(evt);
            }
        });

        jButton3.setText("Xóa");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        chkcheck.setText("Chọn tất cả");
        chkcheck.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                chkcheckStateChanged(evt);
            }
        });
        chkcheck.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                chkcheckMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                chkcheckMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 731, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton3)
                        .addGap(18, 18, 18)
                        .addComponent(btnchapnhan)
                        .addGap(28, 28, 28))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(chkcheck)
                .addGap(47, 47, 47))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(chkcheck)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnchapnhan)
                    .addComponent(jButton3))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Hóa đơn", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        delete1();

    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnchapnhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnchapnhanActionPerformed
        update1();

    }//GEN-LAST:event_btnchapnhanActionPerformed

    private void tblhoadonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblhoadonMousePressed

        row = tblhoadon.getSelectedRow();
        String mahv1 = (String) tblhoadon.getValueAt(row, 3);
        if (mahv1.equalsIgnoreCase("Chờ xác nhận")) {
            index = 0;
        } else {
            index = -1;
        }
        dissibale();
    }//GEN-LAST:event_tblhoadonMousePressed

    private void chkcheckStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_chkcheckStateChanged

    }//GEN-LAST:event_chkcheckStateChanged

    private void tblhoadonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblhoadonMouseClicked
        check();
    }//GEN-LAST:event_tblhoadonMouseClicked

    private void chkcheckMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chkcheckMousePressed

    }//GEN-LAST:event_chkcheckMousePressed

    private void chkcheckMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chkcheckMouseClicked
        checktong();
    }//GEN-LAST:event_chkcheckMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnchapnhan;
    private javax.swing.JCheckBox chkcheck;
    private javax.swing.JButton jButton3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tblhoadon;
    // End of variables declaration//GEN-END:variables

}
