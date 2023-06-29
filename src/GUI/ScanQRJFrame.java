package GUI;

import DAO.TaiKhoanDAO;
import Helper.Auth;
import Helper.MsgBox;
import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import Helper.XImage;
import Model.TaiKhoan;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import javax.swing.JFrame;
import org.apache.log4j.BasicConfigurator;

public class ScanQRJFrame extends javax.swing.JFrame implements Runnable, ThreadFactory {

    TaiKhoanDAO daotk = new TaiKhoanDAO();
    private WebcamPanel panel = null;
    private Webcam webcam = null;

//    private static final long serialVersionUID = 6441489157408381878L;
    private Executor executor = Executors.newSingleThreadExecutor(this);

    public ScanQRJFrame() {
        initComponents();
        init();
        initWebcam();
//        BasicConfigurator.configure();
        this.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);

                System.exit(0);
                webcam.close();
                new DangNhap().setVisible(true);
            }

        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        result_field = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        result_field.setBorder(null);
        jPanel1.add(result_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, 470, 20));

        jSeparator1.setForeground(new java.awt.Color(126, 167, 206));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, 470, 10));

        jLabel1.setForeground(new java.awt.Color(105, 105, 105));
        jLabel1.setText("Resultado");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, -1, -1));

        jPanel2.setBackground(new java.awt.Color(250, 250, 250));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(230, 230, 230)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 470, 300));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 490, 410));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ScanQRJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new ScanQRJFrame().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField result_field;
    // End of variables declaration//GEN-END:variables

    private void init() {
//        setIconImage(XImage.getAppIcon());
        setLocationRelativeTo(null);
    }

    /**
     * Run webcam -> Show webcam on JFrame
     */
    private void initWebcam() {
        try {
            Dimension size = WebcamResolution.QVGA.getSize();
            webcam = Webcam.getWebcams().get(0); //0 is default webcam
            webcam.setViewSize(size);

            panel = new WebcamPanel(webcam);
            panel.setPreferredSize(size);
            panel.setFPSDisplayed(true);

            jPanel2.add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 470, 300));

            executor.execute(this);
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    @Override
    public void run() {
        try {
            do {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                }

                Result result = null;
                BufferedImage image = null;

                if (webcam.isOpen()) {
                    if ((image = webcam.getImage()) == null) {
                        continue;
                    }
                }
                LuminanceSource source = new BufferedImageLuminanceSource(image);
                BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
                try {
                    result = new MultiFormatReader().decode(bitmap);
                } catch (NotFoundException e) {
//               e.printStackTrace();
                }

                if (result != null) {
                    String[] arr = result.getText().split(" ");

                    String userName = arr[0];
                    String pass = arr[1];
                    TaiKhoan tk = this.daotk.selectById(userName);
                    this.dispose();
                    if (tk != null) {
                        if (userName.equalsIgnoreCase(tk.getTenTK()) && pass.equalsIgnoreCase(tk.getMatKhau())) {
                            Auth.USER = tk;
                            if (Auth.USER.getVaiTro().equalsIgnoreCase("Khách Hàng")) {
                                MsgBox.alert(this, "Đăng Nhập Thành Công");
                                TrangchuKH tck = new TrangchuKH();
                                this.dispose();
                                tck.setVisible(true);
                            } else if (Auth.USER.getVaiTro().equalsIgnoreCase("Nhân Viên")) {
                                MsgBox.alert(this, "Đăng Nhập Thành Công");
                                trangChu tc = new trangChu();
                                this.dispose();
                                tc.setVisible(true);
                            }
                        }
                        webcam.close();

                    }
                }
            } while (true);
        } catch (Exception e) {
        }

    }

    @Override
    public Thread newThread(Runnable r
    ) {

        Thread t = new Thread(r, "My Thread");
        t.setDaemon(true);
        return t;
    }

}
