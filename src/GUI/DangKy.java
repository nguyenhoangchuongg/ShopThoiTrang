package GUI;

import Model.KhachHang;
import Model.TaiKhoan;
import DAO.KhachHangDAO;
import DAO.TaiKhoanDAO;
import Helper.MsgBox;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public class DangKy extends javax.swing.JFrame {

    ArrayList<KhachHang> kh = new ArrayList<>();
    KhachHangDAO khh = new KhachHangDAO();
    TaiKhoanDAO tk = new TaiKhoanDAO();
    String emailPattern = "\\w+@\\w+[.]\\w+([.]\\w+)?";

    public DangKy() {
        initComponents();
        setLocationRelativeTo(null);
    }

    private KhachHang getModel01() {
        KhachHang model = new KhachHang();

        List<KhachHang> MaKH = khh.selectAll();
        int max = 0;
        for (int i = 0; i < MaKH.size(); i++) {
            if (MaKH.get(i).getMaKH() > max) {
                max = MaKH.get(i).getMaKH();
            }
        }

        int Ma = max + 1;
        model.setMaKH(Ma);
        model.setTenKH(txtHoten.getText());
        model.setTenTK(txtTentaikhoan.getText());
        model.setSoDienThoai(txtSdt.getText());
        model.setDiaChi(tatDiachi.getText());
        model.setGioiTinh(rdoNam.isSelected());
        model.setGioiTinh(rdoNu.isSelected());
        model.setEmail(txtEmail.getText());
        return model;
    }

    private TaiKhoan getModel02() {
        TaiKhoan m = new TaiKhoan();
        String vaitro = "Khách Hàng";
        m.setTenTK(txtTentaikhoan.getText());
        m.setMatKhau(txtMatkhau.getText());
        m.setVaiTro(vaitro);
        return m;
    }

    public void insertt() {
        KhachHang model = getModel01();
        TaiKhoan m = getModel02();

        try {
            tk.insert(m);
            khh.insert(model);
            this.dispose();
            DangNhap dn = new DangNhap();
            dn.setVisible(true);
            MsgBox.alert(this, "Đăng ký thành công!");
        } catch (Exception e) {
            MsgBox.alert(this, "Đăng ký  thất bại!");
            System.out.println(e);
        }
    }

    public KhachHang timTheoTK(String TenTK) {
        List<KhachHang> TenTKK = khh.selectAll();

        for (KhachHang khachHang : TenTKK) {
            if (khachHang.getTenTK().equalsIgnoreCase(TenTK)) {
                return khachHang;
            }
        }
        return null;
    }

    public boolean valiDate() {
        if (txtHoten.getText().equals("") || txtEmail.getText().equals("") || txtSdt.getText().equals("")
                || tatDiachi.getText().equals("") || txtTentaikhoan.getText().equals("") || txtMatkhau.getText().equals("")
                || txtNhaplaimatkhau.getText().equals("")) {
            MsgBox.alert(this, "Không để trống Form!");
            return false;
        }
        Matcher matcher = Pattern.compile(emailPattern).matcher(txtEmail.getText());
        if (!matcher.matches()) {               // khi nhập email sai định dạng
            MsgBox.alert(this, "Email sai định dạng!");
            return false;
        }
        try {
            Integer.parseInt(txtSdt.getText()); //Khi nhập sdt bằng chử
        } catch (NumberFormatException e) {
             MsgBox.alert(rootPane, "Nhập sai định dạng số DT!");
            return false;
        }
        if (buttonGroup1.getSelection() == null) {
            MsgBox.alert(rootPane, "Chọn giới tính!");
            return false;
        }
        if (timTheoTK(txtTentaikhoan.getText()) != null) {
            MsgBox.alert(rootPane, "Tên tài khoản đẵ tồn tại!");
            return false;
        }
        if (!txtMatkhau.getText().equals(txtNhaplaimatkhau.getText())) {
             MsgBox.alert(rootPane, "Xem lại mật khẩu!");
            return false;
        }

        return true;
    }
//
//    public boolean checkEmail() {
//        XacNhanMail xn = new XacNhanMail(txtEmail.getText());
//        xn.setVisible(true);
////        xn.setLocationRelativeTo(null);
////        xn.setTitle("Xác Nhận Email");
//
//        return true;
//    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        name = new javax.swing.JLabel();
        txtHoten = new com.da1.CustomControl.TextField11();
        txtSdt = new com.da1.CustomControl.TextField11();
        txtEmail = new com.da1.CustomControl.TextField11();
        rdoNam = new javax.swing.JRadioButton();
        rdoNu = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tatDiachi = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        btnDangKy = new javax.swing.JButton();
        btnHuy = new javax.swing.JButton();
        txtTentaikhoan = new com.da1.CustomControl.TextField11();
        txtMatkhau = new com.da1.CustomControl.PasswordField1();
        txtNhaplaimatkhau = new com.da1.CustomControl.PasswordField1();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        name.setBackground(new java.awt.Color(204, 204, 204));
        name.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        name.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        name.setText("Đăng Ký Tài Khoản");
        getContentPane().add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 0, 290, 50));

        txtHoten.setBackground(new java.awt.Color(204, 204, 204));
        txtHoten.setLabelText("Họ và tên");
        txtHoten.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHotenActionPerformed(evt);
            }
        });
        getContentPane().add(txtHoten, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 200, 44));

        txtSdt.setBackground(new java.awt.Color(204, 204, 204));
        txtSdt.setLabelText("Số điện thoại");
        txtSdt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSdtActionPerformed(evt);
            }
        });
        getContentPane().add(txtSdt, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 200, 44));

        txtEmail.setBackground(new java.awt.Color(204, 204, 204));
        txtEmail.setLabelText("Email");
        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });
        getContentPane().add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 200, 44));

        rdoNam.setBackground(new java.awt.Color(204, 204, 204));
        buttonGroup1.add(rdoNam);
        rdoNam.setText("Nam");
        getContentPane().add(rdoNam, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 240, -1, -1));

        rdoNu.setBackground(new java.awt.Color(204, 204, 204));
        buttonGroup1.add(rdoNu);
        rdoNu.setText("Nữ");
        getContentPane().add(rdoNu, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 240, -1, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Địa chỉ");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 60, 30));

        tatDiachi.setBackground(new java.awt.Color(204, 204, 204));
        tatDiachi.setColumns(20);
        tatDiachi.setRows(5);
        jScrollPane1.setViewportView(tatDiachi);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 270, 270, 100));

        jLabel2.setText("Giới tính");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 60, 20));

        btnDangKy.setBackground(new java.awt.Color(255, 255, 255));
        btnDangKy.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnDangKy.setText("Đăng ký");
        btnDangKy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangKyActionPerformed(evt);
            }
        });
        getContentPane().add(btnDangKy, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 280, 100, 30));

        btnHuy.setBackground(new java.awt.Color(255, 255, 255));
        btnHuy.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnHuy.setText("Hủy");
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });
        getContentPane().add(btnHuy, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 320, 100, 30));

        txtTentaikhoan.setBackground(new java.awt.Color(204, 204, 204));
        txtTentaikhoan.setLabelText("Tên tài khoản");
        txtTentaikhoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTentaikhoanActionPerformed(evt);
            }
        });
        getContentPane().add(txtTentaikhoan, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 60, 200, 44));

        txtMatkhau.setBackground(new java.awt.Color(204, 204, 204));
        txtMatkhau.setLabelText("Mật khẩu");
        getContentPane().add(txtMatkhau, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 120, 200, -1));

        txtNhaplaimatkhau.setBackground(new java.awt.Color(204, 204, 204));
        txtNhaplaimatkhau.setLabelText("Nhập lại mật khẩu");
        getContentPane().add(txtNhaplaimatkhau, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 180, 200, -1));

        jLabel3.setBackground(new java.awt.Color(204, 204, 204));
        jLabel3.setOpaque(true);
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 560, 380));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtHotenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHotenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHotenActionPerformed

    private void txtSdtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSdtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSdtActionPerformed

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_txtEmailActionPerformed

    private void btnDangKyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangKyActionPerformed

        if (valiDate()) {
            insertt();
        }

    }//GEN-LAST:event_btnDangKyActionPerformed

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        DangNhap dn = new DangNhap();
        this.dispose();
        dn.setVisible(true);
    }//GEN-LAST:event_btnHuyActionPerformed

    private void txtTentaikhoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTentaikhoanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTentaikhoanActionPerformed

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
            java.util.logging.Logger.getLogger(DangKy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DangKy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DangKy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DangKy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DangKy().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDangKy;
    private javax.swing.JButton btnHuy;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel name;
    private javax.swing.JRadioButton rdoNam;
    private javax.swing.JRadioButton rdoNu;
    private javax.swing.JTextArea tatDiachi;
    private com.da1.CustomControl.TextField11 txtEmail;
    private com.da1.CustomControl.TextField11 txtHoten;
    private com.da1.CustomControl.PasswordField1 txtMatkhau;
    private com.da1.CustomControl.PasswordField1 txtNhaplaimatkhau;
    private com.da1.CustomControl.TextField11 txtSdt;
    private com.da1.CustomControl.TextField11 txtTentaikhoan;
    // End of variables declaration//GEN-END:variables
}
