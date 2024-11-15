package views;

import components.PanelExpense;
import components.PanelReceipt;
import components.PanelSaving;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

public class MainFrame extends javax.swing.JFrame {

    public MainFrame() {
        initComponents();
        //String username = UserSession.getInstance().getUsername();
        //setTitle("Welcome, " + username);
        setLocationRelativeTo(null);
        setSize(800, 500);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator6 = new javax.swing.JSeparator();
        tbMain = new javax.swing.JToolBar();
        btnAddExp = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        btnAddRec = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        jButton1 = new javax.swing.JButton();
        jSeparator7 = new javax.swing.JToolBar.Separator();
        btnLock = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JToolBar.Separator();
        btnCloseTab = new javax.swing.JButton();
        tpMain = new javax.swing.JTabbedPane();
        pnlHome = new javax.swing.JPanel();
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
        setPreferredSize(new java.awt.Dimension(760, 450));
        setSize(new java.awt.Dimension(760, 400));

        tbMain.setBackground(new java.awt.Color(255, 255, 255));
        tbMain.setRollover(true);

        btnAddExp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add_create_new_32.png"))); // NOI18N
        btnAddExp.setText("Add Expense");
        btnAddExp.setFocusable(false);
        btnAddExp.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAddExp.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAddExp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddExpActionPerformed(evt);
            }
        });
        tbMain.add(btnAddExp);
        tbMain.add(jSeparator1);

        btnAddRec.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add_create_new_32.png"))); // NOI18N
        btnAddRec.setText("Add Receipt");
        btnAddRec.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAddRec.setPreferredSize(new java.awt.Dimension(90, 62));
        btnAddRec.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAddRec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddRecActionPerformed(evt);
            }
        });
        tbMain.add(btnAddRec);
        tbMain.add(jSeparator2);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add_create_new_32.png"))); // NOI18N
        jButton1.setText("Add Saving");
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        tbMain.add(jButton1);
        tbMain.add(jSeparator7);

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
        btnCloseTab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseTabActionPerformed(evt);
            }
        });
        tbMain.add(btnCloseTab);

        tpMain.setBackground(new java.awt.Color(255, 255, 255));

        pnlHome.setPreferredSize(new java.awt.Dimension(760, 315));

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
        mitExpenditures.setText("Expeneses");
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
                .addComponent(tpMain))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddExpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddExpActionPerformed
        // TODO add your handling code here:
        JScrollPane scrp = new JScrollPane(new PanelExpense());
        tpMain.add("Add Expense", scrp);
        tpMain.revalidate(); // Cập nhật lại bố cục để hiển thị tab mới
        tpMain.repaint(); // Vẽ lại để đảm bảo giao diện đã được cập nhật
    }//GEN-LAST:event_btnAddExpActionPerformed

    private void btnAddRecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddRecActionPerformed
        // TODO add your handling code here:
        JScrollPane scrp = new JScrollPane(new PanelReceipt());
        tpMain.add("Add Receipt", scrp);
        tpMain.revalidate(); // Cập nhật lại bố cục để hiển thị tab mới
        tpMain.repaint(); // Vẽ lại để đảm bảo giao diện đã được cập nhật
    }//GEN-LAST:event_btnAddRecActionPerformed

    private void btnCloseTabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseTabActionPerformed
        // TODO add your handling code here:
        // Lấy chỉ số của tab đang được chọn
        int selectedIndex = tpMain.getSelectedIndex();

        // Nếu có tab đang được chọn
        if (selectedIndex != -1) {
            // Đóng (hoặc loại bỏ) tab hiện tại
            tpMain.remove(selectedIndex);
        } else {
            // Thông báo nếu không có tab nào được chọn
            JOptionPane.showMessageDialog(this, "No tab selected to close!");
        }
    }//GEN-LAST:event_btnCloseTabActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        JScrollPane scrp = new JScrollPane(new PanelSaving());
        tpMain.add("Add Saving", scrp);
        tpMain.revalidate(); // Cập nhật lại bố cục để hiển thị tab mới
        tpMain.repaint(); // Vẽ lại để đảm bảo giao diện đã được cập nhật
    }//GEN-LAST:event_jButton1ActionPerformed

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
    private javax.swing.JButton btnLock;
    private javax.swing.JButton jButton1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JToolBar.Separator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JToolBar.Separator jSeparator7;
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
    private javax.swing.JPanel pnlHome;
    private javax.swing.JToolBar tbMain;
    private javax.swing.JTabbedPane tpMain;
    // End of variables declaration//GEN-END:variables
}
