package main;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import session.UserSession;

public class MainFrame extends javax.swing.JFrame {

    public MainFrame() {
        initComponents();
        String username = UserSession.getInstance().getUsername();
        setTitle("Welcome, " + username);
        setLocationRelativeTo(null);
    }
    private ArrayList<ChiTieu> listChiTieu = new ArrayList<>();

    public class ChiTieu {

        private String tenChiTieu;
        private String soTien;
        private String thoiGian;
        private String noiDung;

        public ChiTieu(String tenChiTieu, String soTien, String thoiGian, String noiDung) {
            this.tenChiTieu = tenChiTieu;
            this.soTien = soTien;
            this.thoiGian = thoiGian;
            this.noiDung = noiDung;
        }

        public String getTenChiTieu() {
            return tenChiTieu;
        }

        public String getSoTien() {
            return soTien;
        }

        public String getThoiGian() {
            return thoiGian;
        }

        public String getNoiDung() {
            return noiDung;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tbMain = new javax.swing.JToolBar();
        btnAddExp = new javax.swing.JButton();
        btnListExp = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        btnAddRec = new javax.swing.JButton();
        btnListRec = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        btnLock = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JToolBar.Separator();
        btnCloseTab = new javax.swing.JButton();
        tpMain = new javax.swing.JTabbedPane();
        pnlHome = new javax.swing.JPanel();
        pnlRec = new javax.swing.JPanel();
        pnlExp = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtmoney = new javax.swing.JTextField();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        btntao = new javax.swing.JButton();
        btnxoa = new javax.swing.JButton();
        btncapnhat = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtnoidung = new javax.swing.JTextArea();
        txttenchitieu = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        mnbMain = new javax.swing.JMenuBar();
        menuAccount = new javax.swing.JMenu();
        mitLogin = new javax.swing.JMenuItem();
        mitRegister = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        mitSettings = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        mitExit = new javax.swing.JMenuItem();
        menuManage = new javax.swing.JMenu();
        mitExpenditures = new javax.swing.JMenuItem();
        mitReceipts = new javax.swing.JMenuItem();
        mitSavings = new javax.swing.JMenuItem();
        menuHelp = new javax.swing.JMenu();
        mitContent = new javax.swing.JMenuItem();
        mitAboutUs = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tbMain.setRollover(true);

        btnAddExp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add_create_new_32.png"))); // NOI18N
        btnAddExp.setText("Add Expenditure");
        btnAddExp.setFocusable(false);
        btnAddExp.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAddExp.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        tbMain.add(btnAddExp);

        btnListExp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/list_32.png"))); // NOI18N
        btnListExp.setText("List Expenditures");
        btnListExp.setFocusable(false);
        btnListExp.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnListExp.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        tbMain.add(btnListExp);
        tbMain.add(jSeparator1);

        btnAddRec.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add_create_new_32.png"))); // NOI18N
        btnAddRec.setText("Add Receipt");
        btnAddRec.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAddRec.setPreferredSize(new java.awt.Dimension(90, 62));
        btnAddRec.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        tbMain.add(btnAddRec);

        btnListRec.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/list_32.png"))); // NOI18N
        btnListRec.setText("List Receipts");
        btnListRec.setFocusable(false);
        btnListRec.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnListRec.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        tbMain.add(btnListRec);
        tbMain.add(jSeparator2);

        btnLock.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/lock_security_close_protection_32.png"))); // NOI18N
        btnLock.setText("Lock");
        btnLock.setFocusable(false);
        btnLock.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnLock.setMinimumSize(new java.awt.Dimension(60, 62));
        btnLock.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        tbMain.add(btnLock);
        tbMain.add(jSeparator5);

        btnCloseTab.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/exit_logout_sign out_32.png"))); // NOI18N
        btnCloseTab.setText("Close Tab");
        btnCloseTab.setFocusable(false);
        btnCloseTab.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCloseTab.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        tbMain.add(btnCloseTab);

        javax.swing.GroupLayout pnlHomeLayout = new javax.swing.GroupLayout(pnlHome);
        pnlHome.setLayout(pnlHomeLayout);
        pnlHomeLayout.setHorizontalGroup(
            pnlHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 758, Short.MAX_VALUE)
        );
        pnlHomeLayout.setVerticalGroup(
            pnlHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 311, Short.MAX_VALUE)
        );

        tpMain.addTab("Home", pnlHome);

        javax.swing.GroupLayout pnlRecLayout = new javax.swing.GroupLayout(pnlRec);
        pnlRec.setLayout(pnlRecLayout);
        pnlRecLayout.setHorizontalGroup(
            pnlRecLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 758, Short.MAX_VALUE)
        );
        pnlRecLayout.setVerticalGroup(
            pnlRecLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 311, Short.MAX_VALUE)
        );

        tpMain.addTab("Receipts", pnlRec);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel2.setText("Số tiền");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel3.setText("Thời gian");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel4.setText("Description");

        txtmoney.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtmoneyActionPerformed(evt);
            }
        });

        btntao.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btntao.setText("Tạo");
        btntao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntaoActionPerformed(evt);
            }
        });

        btnxoa.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btnxoa.setText("Xóa");
        btnxoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnxoaActionPerformed(evt);
            }
        });

        btncapnhat.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btncapnhat.setText("Cập nhật");
        btncapnhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncapnhatActionPerformed(evt);
            }
        });

        jTable1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Tên chi tiêu", "Số tiền", "Thời gian", "Nội dung"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        txtnoidung.setColumns(20);
        txtnoidung.setRows(5);
        jScrollPane1.setViewportView(txtnoidung);

        txttenchitieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttenchitieuActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel5.setText("Tên chi tiêu");

        javax.swing.GroupLayout pnlExpLayout = new javax.swing.GroupLayout(pnlExp);
        pnlExp.setLayout(pnlExpLayout);
        pnlExpLayout.setHorizontalGroup(
            pnlExpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlExpLayout.createSequentialGroup()
                .addGroup(pnlExpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlExpLayout.createSequentialGroup()
                        .addGroup(pnlExpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlExpLayout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(btntao)
                                .addGap(18, 18, 18)
                                .addComponent(btnxoa)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btncapnhat))
                            .addGroup(pnlExpLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnlExpLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnlExpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlExpLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane1))
                            .addGroup(pnlExpLayout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtmoney))
                            .addGroup(pnlExpLayout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(pnlExpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txttenchitieu, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 423, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlExpLayout.setVerticalGroup(
            pnlExpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlExpLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlExpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlExpLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(pnlExpLayout.createSequentialGroup()
                        .addGap(0, 25, Short.MAX_VALUE)
                        .addGroup(pnlExpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txttenchitieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlExpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlExpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtmoney, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlExpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlExpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btntao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnxoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btncapnhat))
                        .addGap(16, 16, 16))))
        );

        tpMain.addTab("Expenditures", pnlExp);

        menuAccount.setText("Account");

        mitLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/login_signin_20.png"))); // NOI18N
        mitLogin.setText("Login");
        menuAccount.add(mitLogin);

        mitRegister.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/signup_register_20.png"))); // NOI18N
        mitRegister.setText("Register");
        menuAccount.add(mitRegister);
        menuAccount.add(jSeparator4);

        mitSettings.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/settings_20.png"))); // NOI18N
        mitSettings.setText("Settings");
        menuAccount.add(mitSettings);
        menuAccount.add(jSeparator3);

        mitExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/exit_logout_signout_20.png"))); // NOI18N
        mitExit.setText("Exit");
        menuAccount.add(mitExit);

        mnbMain.add(menuAccount);

        menuManage.setText("Manage");

        mitExpenditures.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/expenditure_20.png"))); // NOI18N
        mitExpenditures.setText("Expenditures");
        menuManage.add(mitExpenditures);

        mitReceipts.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/receipt_20.png"))); // NOI18N
        mitReceipts.setText("Receipts");
        menuManage.add(mitReceipts);

        mitSavings.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/saving_20.png"))); // NOI18N
        mitSavings.setText("Savings");
        menuManage.add(mitSavings);

        mnbMain.add(menuManage);

        menuHelp.setText("Help");

        mitContent.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/help_20.png"))); // NOI18N
        mitContent.setText("Content");
        menuHelp.add(mitContent);

        mitAboutUs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/info_20.png"))); // NOI18N
        mitAboutUs.setText("About us");
        menuHelp.add(mitAboutUs);

        mnbMain.add(menuHelp);

        setJMenuBar(mnbMain);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tbMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(tpMain)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(tbMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tpMain, javax.swing.GroupLayout.DEFAULT_SIZE, 346, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtmoneyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtmoneyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtmoneyActionPerformed

    private void btntaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntaoActionPerformed
        // TODO add your handling code here:
        String tenChiTieu = txttenchitieu.getText();
        String soTien = txtmoney.getText();
        String thoiGian = ((JTextField) jDateChooser1.getDateEditor().getUiComponent()).getText();
        String noiDung = txtnoidung.getText();

        // Kiểm tra ràng buộc trước khi thêm vào database
        if (tenChiTieu.isEmpty() || soTien.isEmpty() || thoiGian == null || noiDung.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin!", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return;
        }
        // Chuẩn bị câu lệnh SQL để thêm vào database
        //String query = "INSERT INTO ChiTieu (tenChiTieu, soTien, thoiGian, noiDung) VALUES (?, ?, ?, ?)";

        ChiTieu chiTieu = new ChiTieu(tenChiTieu, soTien, thoiGian, noiDung);
        listChiTieu.add(chiTieu);
        updateTable();

        // Reset các trường văn bản
        txtmoney.setText("");
        txtnoidung.setText("");
        jDateChooser1.setDate(null); // Đặt lại ngày
    }//GEN-LAST:event_btntaoActionPerformed

    private void btnxoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnxoaActionPerformed
        // TODO add your handling code here:

        int selectedRow = jTable1.getSelectedRow();
        if (selectedRow != -1) {
            listChiTieu.remove(selectedRow);
            updateTable();
        }
    }//GEN-LAST:event_btnxoaActionPerformed

    private void updateTable() {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0); // Xóa dữ liệu hiện tại

        for (int i = 0; i < listChiTieu.size(); i++) {
            ChiTieu chiTieu = listChiTieu.get(i);
            model.addRow(new Object[]{
                i + 1, chiTieu.getTenChiTieu(), chiTieu.getSoTien(), chiTieu.getThoiGian(), chiTieu.getNoiDung()
            });
        }
    }
    private void btncapnhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncapnhatActionPerformed
        // TODO add your handling code here:
        int selectedRow = jTable1.getSelectedRow();
        if (selectedRow != -1) {
            String tenChiTieu = txttenchitieu.getText(); // Lấy tên chi tiêu
            String soTien = txtmoney.getText();
            String thoiGian = ((JTextField) jDateChooser1.getDateEditor().getUiComponent()).getText();
            String noiDung = txtnoidung.getText();

            ChiTieu updatedChiTieu = new ChiTieu(tenChiTieu, soTien, thoiGian, noiDung);
            listChiTieu.set(selectedRow, updatedChiTieu);
            updateTable();
        }
    }//GEN-LAST:event_btncapnhatActionPerformed

    private void txttenchitieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttenchitieuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttenchitieuActionPerformed

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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddExp;
    private javax.swing.JButton btnAddRec;
    private javax.swing.JButton btnCloseTab;
    private javax.swing.JButton btnListExp;
    private javax.swing.JButton btnListRec;
    private javax.swing.JButton btnLock;
    private javax.swing.JButton btncapnhat;
    private javax.swing.JButton btntao;
    private javax.swing.JButton btnxoa;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JToolBar.Separator jSeparator5;
    private javax.swing.JTable jTable1;
    private javax.swing.JMenu menuAccount;
    private javax.swing.JMenu menuHelp;
    private javax.swing.JMenu menuManage;
    private javax.swing.JMenuItem mitAboutUs;
    private javax.swing.JMenuItem mitContent;
    private javax.swing.JMenuItem mitExit;
    private javax.swing.JMenuItem mitExpenditures;
    private javax.swing.JMenuItem mitLogin;
    private javax.swing.JMenuItem mitReceipts;
    private javax.swing.JMenuItem mitRegister;
    private javax.swing.JMenuItem mitSavings;
    private javax.swing.JMenuItem mitSettings;
    private javax.swing.JMenuBar mnbMain;
    private javax.swing.JPanel pnlExp;
    private javax.swing.JPanel pnlHome;
    private javax.swing.JPanel pnlRec;
    private javax.swing.JToolBar tbMain;
    private javax.swing.JTabbedPane tpMain;
    private javax.swing.JTextField txtmoney;
    private javax.swing.JTextArea txtnoidung;
    private javax.swing.JTextField txttenchitieu;
    // End of variables declaration//GEN-END:variables
}
