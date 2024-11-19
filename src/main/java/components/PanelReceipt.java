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
import models.Receipt;
import services.ReceiptService;

public class PanelReceipt extends javax.swing.JPanel {

    private ReceiptService receiptService;
    private Long selectedReceiptId;

    public PanelReceipt() {
        initComponents();
        this.receiptService = new ReceiptService();
        loadReceiptsToTable();
        // Tạo DefaultTableModel tùy chỉnh để không cho phép chỉnh sửa
        DefaultTableModel model = new DefaultTableModel(new Object[][]{}, new String[]{"ID", "Occuring Date", "Money", "Description"}) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;  // Không cho phép chỉnh sửa bất kỳ ô nào
            }
        };
        // Thiết lập selection listener cho bảng
        tblReceipts.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent event) {
                int selectedRow = tblReceipts.getSelectedRow();
                if (selectedRow >= 0) {
                    try {
                        // Lấy ID từ cột đầu tiên và gán cho selectedReceiptId
                        selectedReceiptId = (Long) tblReceipts.getValueAt(selectedRow, 0);

                        // Lấy và chuyển đổi ngày từ cột thứ hai
                        String occurringDateStr = (String) tblReceipts.getValueAt(selectedRow, 1);
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
                        txtMoney.setText(tblReceipts.getValueAt(selectedRow, 2).toString());
                        txtDescription.setText(tblReceipts.getValueAt(selectedRow, 4).toString());

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

        panelReceipt = new javax.swing.JPanel();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblReceipts = new javax.swing.JTable();
        dtpDate = new com.toedter.calendar.JDateChooser();
        txtMoney = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescription = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(760, 315));

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        tblReceipts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Date Occured", "Money", "Date Created", "Description"
            }
        ));
        tblReceipts.setColumnSelectionAllowed(true);
        tblReceipts.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblReceipts.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(tblReceipts);
        tblReceipts.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        txtDescription.setColumns(20);
        txtDescription.setRows(5);
        jScrollPane1.setViewportView(txtDescription);

        jLabel3.setText("Description");

        jLabel2.setText("Date");

        jLabel1.setText("Money");

        javax.swing.GroupLayout panelReceiptLayout = new javax.swing.GroupLayout(panelReceipt);
        panelReceipt.setLayout(panelReceiptLayout);
        panelReceiptLayout.setHorizontalGroup(
            panelReceiptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 760, Short.MAX_VALUE)
            .addGroup(panelReceiptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelReceiptLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(panelReceiptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
                        .addGroup(panelReceiptLayout.createSequentialGroup()
                            .addGroup(panelReceiptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3)
                                .addGroup(panelReceiptLayout.createSequentialGroup()
                                    .addComponent(btnAdd)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnDelete)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnUpdate)))
                            .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(panelReceiptLayout.createSequentialGroup()
                            .addGroup(panelReceiptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel1))
                            .addGap(18, 18, 18)
                            .addGroup(panelReceiptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtMoney)
                                .addComponent(dtpDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );
        panelReceiptLayout.setVerticalGroup(
            panelReceiptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 315, Short.MAX_VALUE)
            .addGroup(panelReceiptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelReceiptLayout.createSequentialGroup()
                    .addGap(3, 3, 3)
                    .addGroup(panelReceiptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelReceiptLayout.createSequentialGroup()
                            .addGap(12, 12, 12)
                            .addGroup(panelReceiptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(dtpDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(panelReceiptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addComponent(txtMoney, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                            .addGap(18, 18, 18)
                            .addGroup(panelReceiptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnAdd)
                                .addComponent(btnDelete)
                                .addComponent(btnUpdate))
                            .addGap(16, 16, 16))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGap(3, 3, 3)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelReceipt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelReceipt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

        // Lưu vào cơ sở dữ liệu thông qua ReceiptService
        receiptService.addReceipt(money, description, date);  // Gọi đến service để lưu đối tượng

        // Reset các trường văn bản
        txtMoney.setText("");
        txtDescription.setText("");
        dtpDate.setDate(null); // Đặt lại ngày
        loadReceiptsToTable();
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        if (selectedReceiptId != null) {
            // Gọi service hoặc EntityManager để xóa receipt dựa trên ID
            receiptService.deleteReceiptById(selectedReceiptId);

            // Cập nhật lại bảng sau khi xóa
            loadReceiptsToTable();
            JOptionPane.showMessageDialog(this, "Receipt deleted successfully!");
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        if (selectedReceiptId != null) {
            double money = Double.parseDouble(txtMoney.getText());
            String description = txtDescription.getText();

            // Chuyển đổi sang LocalDate từ JDateChooser
            LocalDate occurringDate = dtpDate.getDate().toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDate();

            // Gọi service để cập nhật Receipt với LocalDate
            receiptService.updateReceipt(selectedReceiptId, money, description, occurringDate);

            // Cập nhật bảng sau khi sửa
            loadReceiptsToTable();
            JOptionPane.showMessageDialog(this, "Receipt updated successfully!");
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void loadReceiptsToTable() {
        List<Receipt> receipts = receiptService.getAllReceipts(); // Lấy danh sách Receipt từ database
        DefaultTableModel model = (DefaultTableModel) tblReceipts.getModel();
        model.setRowCount(0); // Xóa các hàng cũ trong bảng

        // Định dạng LocalDateTime thành chuỗi
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        
        for (Receipt receipt : receipts) {
            Object[] rowData = {
                receipt.getId(), // ID của Receipt
                receipt.getOccurringDate() != null ? receipt.getOccurringDate().format(formatter) : "", // Kiểm tra null,
                receipt.getMoney(),
                receipt.getCreatedDate().format(formatter),
                receipt.getDescription()
            };
            model.addRow(rowData);
        }
        // Đặt lại các trường nhập liệu
        txtMoney.setText("");
        txtDescription.setText("");
        dtpDate.setDate(null);
        selectedReceiptId = null;
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
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel panelReceipt;
    private javax.swing.JTable tblReceipts;
    private javax.swing.JTextArea txtDescription;
    private javax.swing.JTextField txtMoney;
    // End of variables declaration//GEN-END:variables
}
