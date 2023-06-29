/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import DAO.KhachHangDAO;
import DAO.TaiKhoanDAO;
import Helper.Auth;
import Helper.MsgBox;
import Model.KhachHang;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.Reader;
import com.google.zxing.Result;

import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import javax.imageio.ImageIO;
import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;

/**
 *
 * @author vutai
 */
public class thongtinkh extends javax.swing.JPanel {

    KhachHangDAO khd = new KhachHangDAO();
    KhachHangDAO dao = new KhachHangDAO();
    int row = -1;
    TaiKhoanDAO d = new TaiKhoanDAO();

    public thongtinkh() {
        initComponents();
        txtMakh.setEditable(false);
        txtTentaikhoan.setEditable(false);
        duaLen();
    }

    public void duaLen() {
        KhachHang kh = khd.selecttkkhbyid(Auth.USER.getTenTK());
        kh = dao.select(kh.getMaKH());
        txtMakh.setText(String.valueOf(kh.getMaKH()));
        txtHoten.setText(kh.getTenKH());
        txtTentaikhoan.setText(kh.getTenTK());
        txtSoDienthoai.setText(kh.getSoDienThoai());
        txtEmail.setText(kh.getEmail());
        String gt = kh.isGioiTinh() ? "Nữ" : "Nam";
        if (gt.equalsIgnoreCase("Nam")) {
            rdonam.setSelected(true);
        } else {
            rdoNu.setSelected(true);
        }
        tatDiachi.setText(kh.getDiaChi());
    }

    private KhachHang getModelkh() {
        KhachHang model = new KhachHang();
        model.setMaKH(Integer.valueOf(txtMakh.getText()));
        model.setTenKH(txtHoten.getText());
        //model.setTenTK(txtTentaikhoan.getText());
        model.setGioiTinh(rdonam.isSelected());
        model.setGioiTinh(rdoNu.isSelected());
        model.setSoDienThoai(txtSoDienthoai.getText());
        model.setEmail(txtEmail.getText());
        model.setDiaChi(tatDiachi.getText());
        return model;
    }

    private void update() {
        KhachHang modelkh = getModelkh();
        try {
            dao.update1(modelkh);
            duaLen();
            MsgBox.alert(this, "Cập Nhật Nhân Viên Thành Công!");
        } catch (Exception e) {
            MsgBox.alert(this, "Cập Nhật Nhân Viên Thất Bại!");
            System.out.println(e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel7 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtTentaikhoan = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tatDiachi = new javax.swing.JTextArea();
        rdoNu = new javax.swing.JRadioButton();
        rdonam = new javax.swing.JRadioButton();
        btnCapnhap = new javax.swing.JButton();
        txtMakh = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        txtHoten = new javax.swing.JTextField();
        txtSoDienthoai = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        nen = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel7.setText("Mã KH");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 70, 25));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel11.setText("Họ và tên");
        add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 70, 25));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel13.setText("Giới tính");
        add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, 70, 30));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel14.setText("Tên tài khoản");
        add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 110, -1));

        txtTentaikhoan.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        txtTentaikhoan.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        add(txtTentaikhoan, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 100, 200, 25));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel15.setText("Email");
        add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 60, 70, 25));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel16.setText("Số ĐT");
        add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 20, 70, 25));

        tatDiachi.setColumns(20);
        tatDiachi.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        tatDiachi.setRows(5);
        jScrollPane3.setViewportView(tatDiachi);

        add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 190, 320, -1));

        rdoNu.setBackground(new java.awt.Color(204, 204, 204));
        buttonGroup1.add(rdoNu);
        rdoNu.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        rdoNu.setText("Nữ");
        rdoNu.setFocusPainted(false);
        rdoNu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoNuActionPerformed(evt);
            }
        });
        add(rdoNu, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 140, -1, -1));

        rdonam.setBackground(new java.awt.Color(204, 204, 204));
        buttonGroup1.add(rdonam);
        rdonam.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        rdonam.setText("Nam");
        rdonam.setFocusPainted(false);
        rdonam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdonamActionPerformed(evt);
            }
        });
        add(rdonam, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 140, -1, -1));

        btnCapnhap.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnCapnhap.setText("Cập Nhập");
        btnCapnhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapnhapActionPerformed(evt);
            }
        });
        add(btnCapnhap, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 220, 110, 30));

        txtMakh.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        txtMakh.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtMakh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMakhActionPerformed(evt);
            }
        });
        add(txtMakh, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, 200, 25));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel18.setText("Địa chỉ");
        add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, 90, 30));

        txtEmail.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        txtEmail.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 60, 200, 25));

        txtHoten.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        txtHoten.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        add(txtHoten, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 60, 200, 25));

        txtSoDienthoai.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        txtSoDienthoai.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        add(txtSoDienthoai, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 20, 200, 25));

        jButton1.setText("Tạo Mã QR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 270, 110, -1));

        nen.setBackground(new java.awt.Color(204, 204, 204));
        nen.setOpaque(true);
        add(nen, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 440));
    }// </editor-fold>//GEN-END:initComponents

    private void rdoNuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoNuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdoNuActionPerformed

    private void rdonamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdonamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdonamActionPerformed

    private void btnCapnhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapnhapActionPerformed
        update();
    }//GEN-LAST:event_btnCapnhapActionPerformed

    private void txtMakhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMakhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMakhActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // MAke Qr code
        String tentk = Auth.USER.getTenTK();
        String mk = Auth.USER.getMatKhau();
        try {

            ByteArrayOutputStream out = QRCode.from(tentk + " " + mk)
                    .to(ImageType.PNG).stream();

            String f_name = txtHoten.getText() + " QR code";
            String Path_name = "D:\\QR_code\\";

            FileOutputStream fout = new FileOutputStream(new File(Path_name + (f_name + ".PNG")));
            fout.write(out.toByteArray());
            fout.flush();
            MsgBox.alert(this, "Tạo QR code thành công");

        } catch (Exception e) {
            System.out.println(e);
        }


    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCapnhap;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel nen;
    private javax.swing.JRadioButton rdoNu;
    private javax.swing.JRadioButton rdonam;
    private javax.swing.JTextArea tatDiachi;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtHoten;
    private javax.swing.JTextField txtMakh;
    private javax.swing.JTextField txtSoDienthoai;
    private javax.swing.JTextField txtTentaikhoan;
    // End of variables declaration//GEN-END:variables
}
