package swing;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class Table extends JTable {

    public Table() {
        // Cấu hình hiển thị bảng
        setShowHorizontalLines(true);
        setGridColor(new Color(230, 230, 230));
        setRowHeight(40);

        // Mô hình bảng cơ bản
        DefaultTableModel model = new DefaultTableModel(
                new Object[][]{}, // Dữ liệu ban đầu rỗng
                new Object[]{"ID", "STT", "Description", "Amount", "Date"} // Cột ID thực tế không hiển thị
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Không cho phép chỉnh sửa dữ liệu
            }
        };

        // Gán mô hình cho bảng
        setModel(model);

        // Cấu hình tiêu đề cột
        getTableHeader().setReorderingAllowed(false);
        getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                TableHeader header = new TableHeader(value + "");
                header.setHorizontalAlignment(JLabel.CENTER);
                header.setOpaque(true);
                header.setBackground(new Color(230, 230, 230));
                header.setForeground(Color.BLACK);
                return header;
            }
        });

        // Cấu hình renderer cho tất cả các ô
        setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                component.setBackground(Color.WHITE);
                setBorder(noFocusBorder);
                if (isSelected) {
                    component.setForeground(Color.WHITE); // Màu chữ khi chọn
                    component.setBackground(new Color(0, 204, 204)); // Màu nền khi chọn
                } else {
                    component.setForeground(new Color(102, 102, 102)); // Màu chữ bình thường
                }
                return component;
            }
        });
    }

    // Ẩn cột ID
    public void hideColumn(int columnIndex) {
        getColumnModel().removeColumn(getColumnModel().getColumn(columnIndex));
    }

    // Phương thức để thêm dòng vào
    public void addRow(Object[] row) {
        DefaultTableModel model = (DefaultTableModel) getModel();
        model.addRow(row);
    }
}
