
package usos;

import javax.swing.table.DefaultTableCellRenderer;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JTable;


public class EstadoCitaCellRenderer extends DefaultTableCellRenderer {
@Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        
        String estado = (String) value; // Supongamos que el valor es el estado de la cita
        
        // Configura el color de texto según el estado
        try{
            if (estado.equals("Vencida") || estado.equals("Cancelada")) {
            cell.setForeground(Color.RED);
        } else if (estado.equals("En curso")) {
            cell.setForeground(Color.BLUE);
        } else if (estado.equals("Aplicada")) {
            cell.setForeground(Color.GREEN);
        } else {
            cell.setForeground(table.getForeground());
        }
        
        Font font = cell.getFont();
        font = font.deriveFont(Font.BOLD | Font.ITALIC);
        cell.setFont(font);

        return cell;
        }catch(Exception e){
        return cell;
        }
    }
}
