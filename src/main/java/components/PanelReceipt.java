package components;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.ParseException;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import models.Receipt;
import services.ReceiptService;
import swing.ScrollBar;

public class PanelReceipt extends javax.swing.JPanel {

    private DefaultTableModel tableModel;
    private ReceiptService receiptService;
    private Long selectedReceiptId = Long.valueOf(-1);
    private int selectedRow = -1;
    
    public PanelReceipt() {
        initComponents();
        DisableButton();
        this.receiptService = new ReceiptService();
        tableModel = (DefaultTableModel) table.getModel();
        // Loại bỏ cột ID khỏi JTable hiển thị
        TableColumnModel columnModel = table.getColumnModel();
        columnModel.removeColumn(columnModel.getColumn(0)); // Cột 0 là cột ID thật
        spTable.setVerticalScrollBar(new ScrollBar());
        spTable.getVerticalScrollBar().setBackground(Color.WHITE);
        spTable.getViewport().setBackground(Color.WHITE);
        JPanel p = new JPanel();
        p.setBackground(Color.WHITE);
        spTable.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);
        // Vô hiệu hóa chức năng chỉnh sửa ô trong bảng
        table.setDefaultEditor(Object.class, null); // Không cho phép chỉnh sửa
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);  // Chỉ chọn 1 dòng

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() >= 1 && table.getSelectedRow() != -1) {
                    selectedRow = table.getSelectedRow();
                }
            }
        });
        // Lắng nghe sự kiện chọn dòng
        table.getSelectionModel().addListSelectionListener(e -> {
            selectedRow = table.getSelectedRow();
            if (selectedRow >= 0) {
                // Nếu có dòng được chọn, kích hoạt nút Update và Delete
                btnUpdate.setEnabled(true);  // Kích hoạt nút Update
                btnUpdate.setBackground(new Color(255, 255, 0));
                btnDelete.setEnabled(true);  // Kích hoạt nút Delete
                btnDelete.setBackground(new Color(255, 0, 0));
                // Lấy ID thật từ model
                int modelRow = table.convertRowIndexToModel(selectedRow); // Chuyển index từ view sang model
                selectedReceiptId = (Long) tableModel.getValueAt(modelRow, 0);
                EnableButton();
            } else {
                DisableButton();
            }
        });

        loadReceiptsToTable();  // Tải dữ liệu vào bảng
    }
    
    public void ShowDialog(String title, Object[] input) throws ParseException {
        JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(this); // 'this' là JPanel hiện tại
        parentFrame.setEnabled(false);

        JDialog dialog = new JDialog(parentFrame, title, true); // Tạo dialog modal
        dialog.setUndecorated(true);
        dialog.setSize(400, 350);
        dialog.setLocationRelativeTo(parentFrame);

        // Phân biệt chế độ Add và Update dựa trên title
        Object[] dialogInput = null;
        if (input != null && "Update Receipt".equalsIgnoreCase(title)) {
            dialogInput = input; // Sử dụng dữ liệu đầu vào cho chế độ Update
        }

        dialog.add(new PanelAddUpdateReceipt(title, dialog, dialogInput, tableModel), BorderLayout.CENTER);

        dialog.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                // Hành động thực hiện sau khi JDialog đóng
                loadReceiptsToTable();
                parentFrame.setVisible(true);
                parentFrame.setEnabled(true);
                selectedReceiptId = Long.valueOf(-1);
            }
        });

        dialog.setVisible(true);
    }

    public void loadReceiptsToTable() {
        // Xóa dữ liệu cũ trong table model
        tableModel.setRowCount(0);

        // Lấy danh sách receipts từ cơ sở dữ liệu
        List<Receipt> receipts = receiptService.getAllReceipts();

        // Duyệt qua danh sách và thêm vào table model
        int stt = 1; // Bắt đầu từ 1
        for (Receipt receipt : receipts) {
            tableModel.addRow(new Object[]{
                receipt.getId(), // Cột ID thật (không hiển thị)
                stt++, // Hiển thị STT
                receipt.getDescription(),
                receipt.getMoney(),
                receipt.getOccurringDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")),
                "Food"
            });
        }
    }

    public void DisableButton() {
        btnUpdate.setBackground(Color.lightGray);
        btnDelete.setBackground(Color.lightGray);
        btnUpdate.setEnabled(false);
        btnDelete.setEnabled(false);
    }

    public void EnableButton() {
        btnUpdate.setEnabled(true);
        btnDelete.setEnabled(true);
        btnUpdate.setBackground(new Color(255, 255, 0));
        btnDelete.setBackground(new Color(255, 0, 0));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnDelete = new swing.Button();
        btnUpdate = new swing.Button();
        panelBorder1 = new swing.PanelBorder();
        spTable = new javax.swing.JScrollPane();
        table = new swing.Table();
        button2 = new swing.Button();
        button1 = new swing.Button();
        lbLabel = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        btnDelete.setBackground(new java.awt.Color(204, 204, 204));
        btnDelete.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnDelete.setText("Delete");
        btnDelete.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnUpdate.setBackground(new java.awt.Color(204, 204, 204));
        btnUpdate.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnUpdate.setText("Update");
        btnUpdate.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));
        panelBorder1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        spTable.setBackground(new java.awt.Color(255, 255, 255));
        spTable.setBorder(null);
        spTable.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        spTable.setOpaque(false);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "No.", "Description", "Amount", "Date", "Category"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        spTable.setViewportView(table);

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(spTable)
                .addContainerGap())
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(spTable, javax.swing.GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE)
                .addGap(10, 10, 10))
        );

        button2.setBackground(new java.awt.Color(0, 204, 255));
        button2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        button2.setText("Report");
        button2.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N

        button1.setBackground(new java.awt.Color(51, 153, 255));
        button1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        button1.setText("Add");
        button1.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });

        lbLabel.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        lbLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbLabel.setText("Personal Receipt Manager");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 728, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(40, 40, 40)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(170, 170, 170))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGap(40, 40, 40))))
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(lbLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 545, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(25, 25, 25)
                    .addComponent(lbLabel)
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(25, 25, 25)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        if (selectedReceiptId <= -1) {
            JOptionPane.showMessageDialog(this, "No row selected. Please select a row to update.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Lấy dữ liệu từ dòng được chọn
        Long id = selectedReceiptId; // Lấy ID thật từ cột ẩn
        String description = (String) table.getValueAt(table.getSelectedRow(), 1);
        String amount = table.getValueAt(selectedRow, 2).toString(); // Truyền thẳng Double
        String date = (String) table.getValueAt(table.getSelectedRow(), 3);
        String category = (String) table.getValueAt(table.getSelectedRow(), 4);

        Object[] input = new Object[]{id.toString(), description, amount, date, category};

        try {
            // Hiển thị dialog để cập nhật thông tin
            ShowDialog("Update Receipt", input);
        } catch (ParseException ex) {
            Logger.getLogger(PanelReceipt.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        // Kiểm tra nếu không có dòng nào được chọn
        if (selectedReceiptId <= -1) {
            JOptionPane.showMessageDialog(this, "No row selected. Please select a row to delete.", "Warning", JOptionPane.WARNING_MESSAGE);
            return; // Thoát khỏi phương thức nếu không có dòng được chọn
        }

        // Xác nhận xóa
        int response = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this receipt?", "Confirm Delete", JOptionPane.YES_NO_OPTION);
        if (response == JOptionPane.YES_OPTION) {
            // Xóa receipt từ cơ sở dữ liệu
            if (selectedReceiptId != -1) {
                receiptService.deleteReceiptById(selectedReceiptId);
                JOptionPane.showMessageDialog(this, "Xoá thành công", "Notification", JOptionPane.INFORMATION_MESSAGE);
                // Cập nhật lại bảng
                loadReceiptsToTable();

                // Reset trạng thái các nút Update và delete
                DisableButton();
                selectedReceiptId = Long.valueOf(0);
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            ShowDialog("Add New Receipt", null);
        } catch (ParseException ex) {
            Logger.getLogger(PanelReceipt.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_button1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.Button btnDelete;
    private swing.Button btnUpdate;
    private swing.Button button1;
    private swing.Button button2;
    private javax.swing.JLabel lbLabel;
    private swing.PanelBorder panelBorder1;
    private javax.swing.JScrollPane spTable;
    private swing.Table table;
    // End of variables declaration//GEN-END:variables
}
