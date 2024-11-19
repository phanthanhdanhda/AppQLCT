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
import models.Saving;
import services.SavingService;

public class PanelSaving extends javax.swing.JPanel {

    private SavingService savingService;
    private Long selectedSavingId;
    
    public PanelSaving() {
        initComponents();
        this.savingService = new SavingService();
        loadSavingsToTable();
        // Tạo DefaultTableModel tùy chỉnh để không cho phép chỉnh sửa
        DefaultTableModel model = new DefaultTableModel(new Object[][]{}, new String[]{"ID", "Target Date", "Target Amount", "Current Amount"}) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;  // Không cho phép chỉnh sửa bất kỳ ô nào
            }
        };
        // Thiết lập selection listener cho bảng
        tblSavings.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent event) {
                int selectedRow = tblSavings.getSelectedRow();
                if (selectedRow >= 0) {
                    try {
                        // Lấy ID từ cột đầu tiên và gán cho selectedExpenseId
                        selectedSavingId = (Long) tblSavings.getValueAt(selectedRow, 0);

                        // Lấy và chuyển đổi ngày từ cột thứ hai
                        String occurringDateStr = (String) tblSavings.getValueAt(selectedRow, 1);
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
                        txtTargetAmount.setText(tblSavings.getValueAt(selectedRow, 2).toString());
                        txtCurrentAmount.setText(tblSavings.getValueAt(selectedRow, 3).toString());

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

        panelsave = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtTargetAmount = new javax.swing.JTextField();
        dtpDate = new com.toedter.calendar.JDateChooser();
        txtCurrentAmount = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSavings = new javax.swing.JTable();
        btnAdd = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();

        panelsave.setPreferredSize(new java.awt.Dimension(760, 315));

        jLabel1.setText("Target Date");

        jLabel2.setText("Target Amount");

        jLabel3.setText("Current Amount");

        tblSavings.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Target Date", "Target Amount", "Current Amount", "Created Date"
            }
        ));
        tblSavings.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblSavings.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(tblSavings);

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelsaveLayout = new javax.swing.GroupLayout(panelsave);
        panelsave.setLayout(panelsaveLayout);
        panelsaveLayout.setHorizontalGroup(
            panelsaveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelsaveLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelsaveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelsaveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel1)
                        .addComponent(dtpDate, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addComponent(jLabel3)
                        .addComponent(txtTargetAmount)
                        .addComponent(txtCurrentAmount))
                    .addGroup(panelsaveLayout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addGroup(panelsaveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnDelete)
                            .addComponent(btnAdd)
                            .addComponent(btnUpdate))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 482, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelsaveLayout.setVerticalGroup(
            panelsaveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelsaveLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelsaveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(panelsaveLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dtpDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTargetAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCurrentAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAdd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDelete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnUpdate)
                        .addGap(0, 24, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelsave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelsave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
        String targetAmountText = txtTargetAmount.getText();
        String currentAmountText = txtCurrentAmount.getText();
        // Kiểm tra ràng buộc trước khi thêm vào database
        if (targetAmountText.isEmpty() || currentAmountText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin!", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return;
        }
        // Chuyển đổi money sang double
        double targetAmount;
        try {
            targetAmount = Double.parseDouble(targetAmountText);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Số tiền không hợp lệ!", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return;
        }
        double currentAmount;
        try {
            currentAmount = Double.parseDouble(currentAmountText);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Số tiền không hợp lệ!", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return;
        }
        // Lưu vào cơ sở dữ liệu thông qua ExpenseService
        savingService.addSaving(targetAmount, currentAmount, date);  // Gọi đến service để lưu đối tượng
        // Reset các trường văn bản
        txtCurrentAmount.setText("");
        txtTargetAmount.setText("");
        dtpDate.setDate(null); // Đặt lại ngày
        loadSavingsToTable();
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        if (selectedSavingId != null) {
            // Gọi service hoặc EntityManager để xóa expense dựa trên ID
            savingService.deleteSavingById(selectedSavingId);

            // Cập nhật lại bảng sau khi xóa
            loadSavingsToTable();
            JOptionPane.showMessageDialog(this, "Saving deleted successfully!");
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        if (selectedSavingId != null) {
            double targetAmount = Double.parseDouble(txtTargetAmount.getText());
            double currentAmount = Double.parseDouble(txtCurrentAmount.getText());

            // Chuyển đổi sang LocalDate từ JDateChooser
            LocalDate date = dtpDate.getDate().toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDate();

            // Gọi service để cập nhật Expense với LocalDate
            savingService.updateSaving(selectedSavingId, targetAmount, currentAmount, date);

            // Cập nhật bảng sau khi sửa
            loadSavingsToTable();
            JOptionPane.showMessageDialog(this, "Saving updated successfully!");
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void loadSavingsToTable() {
        List<Saving> savings = savingService.getAllSavings(); // Lấy danh sách Expense từ database
        DefaultTableModel model = (DefaultTableModel) tblSavings.getModel();
        model.setRowCount(0); // Xóa các hàng cũ trong bảng

        // Định dạng LocalDateTime thành chuỗi
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        for (Saving saving : savings) {
            Object[] rowData = {
                saving.getId(), // ID của Expense
                saving.getTargetDate()!= null ? saving.getTargetDate().format(formatter) : "", // Kiểm tra null
                saving.getTargetAmount(),
                saving.getCurrentAmount(),
                saving.getCreatedDate().format(formatter)
            };
            model.addRow(rowData);
        }

        // Đặt lại các trường nhập liệu
        txtCurrentAmount.setText("");
        txtCurrentAmount.setText("");
        dtpDate.setDate(null);
        selectedSavingId = null;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnUpdate;
    private com.toedter.calendar.JDateChooser dtpDate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelsave;
    private javax.swing.JTable tblSavings;
    private javax.swing.JTextField txtCurrentAmount;
    private javax.swing.JTextField txtTargetAmount;
    // End of variables declaration//GEN-END:variables
}
