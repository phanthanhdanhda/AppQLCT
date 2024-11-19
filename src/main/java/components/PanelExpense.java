package components;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import models.Expense;
import services.ExpenseService;

public class PanelExpense extends javax.swing.JPanel {

    private ExpenseService expenseService;
    private Long selectedExpenseId;

    public PanelExpense() {
        initComponents();
        this.expenseService = new ExpenseService();
        loadExpensesToTable();
        // Tạo DefaultTableModel tùy chỉnh để không cho phép chỉnh sửa
        DefaultTableModel model = new DefaultTableModel(new Object[][]{}, new String[]{"ID", "Occuring Date", "Money", "Description"}) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;  // Không cho phép chỉnh sửa bất kỳ ô nào
            }
        };
        // Thiết lập selection listener cho bảng
        tblExpenses.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent event) {
                int selectedRow = tblExpenses.getSelectedRow();
                if (selectedRow >= 0) {
                    try {
                        // Lấy ID từ cột đầu tiên và gán cho selectedExpenseId
                        selectedExpenseId = (Long) tblExpenses.getValueAt(selectedRow, 0);

                        // Lấy và chuyển đổi ngày từ cột thứ hai
                        String occurringDateStr = (String) tblExpenses.getValueAt(selectedRow, 1);
                        try {
                            // Chuyển đổi chuỗi thành java.util.Date
                            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                            Date date = dateFormat.parse(occurringDateStr);
                            dtpDate.setDate(date);  // Đặt giá trị cho JDateChooser
                        } catch (ParseException e) {
                            e.printStackTrace();
                            JOptionPane.showMessageDialog(null, "Định dạng ngày không hợp lệ!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                        }

                        // Lấy tiền và mô tả từ các cột tương ứng
                        txtMoney.setText(tblExpenses.getValueAt(selectedRow, 2).toString());
                        txtDescription.setText(tblExpenses.getValueAt(selectedRow, 4).toString());

                    } catch (ClassCastException | NullPointerException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Error loading data: " + ex.getMessage());
                    }
                }
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlExpense = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtMoney = new javax.swing.JTextField();
        dtpDate = new com.toedter.calendar.JDateChooser();
        btnAdd = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescription = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblExpenses = new javax.swing.JTable();
        btnDelete = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(760, 315));

        pnlExpense.setPreferredSize(new java.awt.Dimension(760, 315));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel2.setText("Money");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel3.setText("Date");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel4.setText("Description");

        dtpDate.setDateFormatString("yyyy-MM-dd");

        btnAdd.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        txtDescription.setColumns(20);
        txtDescription.setRows(5);
        jScrollPane1.setViewportView(txtDescription);

        tblExpenses.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tblExpenses.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Date Occured", "Money", "Created Date", "Description"
            }
        ));
        tblExpenses.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblExpenses.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(tblExpenses);

        btnDelete.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnUpdate.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlExpenseLayout = new javax.swing.GroupLayout(pnlExpense);
        pnlExpense.setLayout(pnlExpenseLayout);
        pnlExpenseLayout.setHorizontalGroup(
            pnlExpenseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlExpenseLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlExpenseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlExpenseLayout.createSequentialGroup()
                        .addGroup(pnlExpenseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(12, 12, 12)
                        .addGroup(pnlExpenseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(dtpDate, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                            .addComponent(txtMoney)))
                    .addGroup(pnlExpenseLayout.createSequentialGroup()
                        .addComponent(btnAdd)
                        .addGap(18, 18, 18)
                        .addComponent(btnDelete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnUpdate))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 473, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlExpenseLayout.setVerticalGroup(
            pnlExpenseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlExpenseLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(pnlExpenseLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(pnlExpenseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(dtpDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlExpenseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtMoney, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlExpenseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnDelete)
                    .addComponent(btnUpdate))
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(pnlExpense, javax.swing.GroupLayout.PREFERRED_SIZE, 766, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlExpense, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        // Lấy dữ liệu từ các trường
        Date selectedDate = dtpDate.getDate();
        if (selectedDate == null) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn ngày hợp lệ!", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return;
        }

        LocalDate date = selectedDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        String moneyText = txtMoney.getText();
        String description = txtDescription.getText();

        // Kiểm tra ràng buộc trước khi thêm vào database
        if (moneyText.isEmpty() || description.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin!", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Chuyển đổi money sang double
        double money;
        try {
            money = Double.parseDouble(moneyText);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Số tiền không hợp lệ!", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Lưu vào cơ sở dữ liệu thông qua ExpenseService
        expenseService.addExpense(money, description, date);  // Gọi đến service để lưu đối tượng

        // Reset các trường văn bản
        txtMoney.setText("");
        txtDescription.setText("");
        dtpDate.setDate(null); // Đặt lại ngày
        loadExpensesToTable();
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        if (selectedExpenseId != null) {
            // Gọi service hoặc EntityManager để xóa expense dựa trên ID
            expenseService.deleteExpenseById(selectedExpenseId);

            // Cập nhật lại bảng sau khi xóa
            loadExpensesToTable();
            JOptionPane.showMessageDialog(this, "Expense deleted successfully!");
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        if (selectedExpenseId != null) {
            double money = Double.parseDouble(txtMoney.getText());
            String description = txtDescription.getText();

            // Chuyển đổi sang LocalDate từ JDateChooser
            LocalDate occurringDate = dtpDate.getDate().toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDate();

            // Gọi service để cập nhật Expense với LocalDate
            expenseService.updateExpense(selectedExpenseId, money, description, occurringDate);

            // Cập nhật bảng sau khi sửa
            loadExpensesToTable();
            JOptionPane.showMessageDialog(this, "Expense updated successfully!");
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void loadExpensesToTable() {
        List<Expense> expenses = expenseService.getAllExpenses(); // Lấy danh sách Expense từ database
        DefaultTableModel model = (DefaultTableModel) tblExpenses.getModel();
        model.setRowCount(0); // Xóa các hàng cũ trong bảng

        // Định dạng LocalDateTime thành chuỗi
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        for (Expense expense : expenses) {
            Object[] rowData = {
                expense.getId(), // ID của Expense
                expense.getOccurringDate() != null ? expense.getOccurringDate().format(formatter) : "", // Kiểm tra null
                expense.getMoney(),
                expense.getCreatedDate().format(formatter),
                expense.getDescription()
            };
            model.addRow(rowData);
        }

        // Đặt lại các trường nhập liệu
        txtMoney.setText("");
        txtDescription.setText("");
        dtpDate.setDate(null);
        selectedExpenseId = null;
    }
//    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {                                       
//        // TODO add your handling code here:
//        // Lấy dữ liệu từ các trường
//        Date selectedDate = dtpDate.getDate();
//        if (selectedDate == null) {
//            JOptionPane.showMessageDialog(this, "Vui lòng chọn ngày hợp lệ!", "Thông báo", JOptionPane.WARNING_MESSAGE);
//            return;
//        }
//
//        LocalDateTime date = selectedDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
//        String moneyText = txtMoney.getText();
//        String description = txtDescription.getText();
//
//        // Kiểm tra ràng buộc trước khi thêm vào database
//        if (moneyText.isEmpty() || description.isEmpty()) {
//            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin!", "Thông báo", JOptionPane.WARNING_MESSAGE);
//            return;
//        }
//
//        // Chuyển đổi money sang double
//        double money;
//        try {
//            money = Double.parseDouble(moneyText);
//        } catch (NumberFormatException e) {
//            JOptionPane.showMessageDialog(this, "Số tiền không hợp lệ!", "Thông báo", JOptionPane.WARNING_MESSAGE);
//            return;
//        }
//
//        // Lưu vào cơ sở dữ liệu thông qua ExpenseService
//        expenseService.addExpense(money, description, date);  // Gọi đến service để lưu đối tượng
//
//        // Reset các trường văn bản
//        txtMoney.setText("");
//        txtDescription.setText("");
//        dtpDate.setDate(null); // Đặt lại ngày
//    }
//    private void updateTable() {
//        DefaultTableModel model = (DefaultTableModel) tblExpenditure.getModel();
//        model.setRowCount(0); // Xóa dữ liệu hiện tại
//
//        for (int i = 0; i < listExpenses.size(); i++) {
//            Expense exp = listExpenses.get(i);
//            model.addRow(new Object[]{
//                i + 1, exp.getOccurringDate(), exp.getMoney(), exp.getCreatedDate(), exp.getDescription()
//            });
//        }
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnUpdate;
    private com.toedter.calendar.JDateChooser dtpDate;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel pnlExpense;
    private javax.swing.JTable tblExpenses;
    private javax.swing.JTextArea txtDescription;
    private javax.swing.JTextField txtMoney;
    // End of variables declaration//GEN-END:variables
}
