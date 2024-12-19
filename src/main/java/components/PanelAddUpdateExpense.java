package components;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import services.ExpenseService;

public class PanelAddUpdateExpense extends javax.swing.JPanel {

    private JDialog parentDialog;
    private Object[] expenseData;
    private TableModel tableModel;
    private ExpenseService expenseService;
    private Long selectedExpenseId = Long.valueOf(-1);

    public PanelAddUpdateExpense(String title, JDialog _parentDialog, Object[] _expenseData, TableModel _tableModel) throws ParseException {
        initComponents();
        this.expenseService = new ExpenseService();
        this.parentDialog = _parentDialog;
        lbLabel.setText(title);
        this.setVisible(true);
        expenseData = _expenseData;
        // Nếu có dữ liệu truyền vào (edit), điền dữ liệu vào các trường
        if (expenseData != null) {
            selectedExpenseId = Long.valueOf((String) expenseData[0]);
            txtAmount.setText((String) expenseData[2]);
            txtDescription.setText((String) expenseData[1]);
            // Định dạng ngày theo kiểu yyyy-MM-dd
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            // Chuyển đổi chuỗi thành đối tượng Date
            Date date = dateFormat.parse((String) expenseData[3]);
            // Đặt giá trị vào JDateChooser
            dtpDate.setDate(date);
            cbCategory.setSelectedItem((String) expenseData[4]);
        }
    }

    public JButton getBtnConfirm() {
        return btnConfirm;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lbLabel = new javax.swing.JLabel();
        txtAmount = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtDescription = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btnConfirm = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        cbCategory = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        dtpDate = new com.toedter.calendar.JDateChooser();

        jLabel1.setText("jLabel1");

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel2.setText("Số tiền");

        lbLabel.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lbLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbLabel.setText("Label");

        txtAmount.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel3.setText("Mô tả");

        txtDescription.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel4.setText("Thể  loại");

        btnConfirm.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        btnConfirm.setText("Xác nhận");
        btnConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmActionPerformed(evt);
            }
        });

        btnCancel.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        btnCancel.setText("Huỷ");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        cbCategory.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel5.setText("Ngày thực hiện");

        dtpDate.setDateFormatString("yyyy-MM-dd");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 173, Short.MAX_VALUE)
                        .addComponent(btnConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtDescription)
                            .addComponent(txtAmount)
                            .addComponent(cbCategory, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dtpDate, javax.swing.GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dtpDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancel)
                    .addComponent(btnConfirm))
                .addGap(10, 10, 10))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
        parentDialog.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmActionPerformed
        // TODO add your handling code here:
        Date selectedDate = dtpDate.getDate();
        if (selectedDate == null) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn ngày hợp lệ!", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return;
        }
        LocalDate date = selectedDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        String description = txtDescription.getText();
        String amount = txtAmount.getText();
        String category = (String) cbCategory.getSelectedItem();

        if (description.isEmpty() || amount.isEmpty()) {
            JOptionPane.showMessageDialog(parentDialog, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Kiểm tra ràng buộc trước khi thêm vào database
        if (amount.isEmpty() || description.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin!", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Chuyển đổi money sang double
        double money;
        try {
            money = Double.parseDouble(amount);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Số tiền không hợp lệ!", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Kiểm tra xem có đang cập nhật hay thêm mới
        if (selectedExpenseId == -1) {
            // Thêm mới
            expenseService.addExpense(money, description, date);
            JOptionPane.showMessageDialog(this, "Thêm thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        } else {
            // Cập nhật
            expenseService.updateExpense(selectedExpenseId, money, description, date);
            JOptionPane.showMessageDialog(this, "Cập nhật thành công!!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        }
        parentDialog.dispose();
    }//GEN-LAST:event_btnConfirmActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnConfirm;
    private javax.swing.JComboBox<String> cbCategory;
    private com.toedter.calendar.JDateChooser dtpDate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel lbLabel;
    private javax.swing.JTextField txtAmount;
    private javax.swing.JTextField txtDescription;
    // End of variables declaration//GEN-END:variables
}
