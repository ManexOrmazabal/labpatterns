package adapter2;

import javax.swing.table.AbstractTableModel;
import domain.Covid19Pacient;
import domain.Symptom;

public class Covid19PacientTableModelAdapter extends AbstractTableModel {
    protected Covid19Pacient pacient;
    protected String[] columnNames = new String[] {"Symptom", "Weight"};

    public Covid19PacientTableModelAdapter(Covid19Pacient p) {
        this.pacient = p;
    }

    public int getColumnCount() {
        return columnNames.length; // Número de columnas
    }

    public String getColumnName(int i) {
        return columnNames[i]; // Nombres de columnas
    }

    public int getRowCount() {
        return pacient.getSymptoms().size(); // Número de síntomas
    }

    public Object getValueAt(int row, int col) {
        // Obtener el síntoma correspondiente
        Symptom symptom = (Symptom) pacient.getSymptoms().toArray()[row]; 
        if (col == 0) {
            return symptom.getName(); // Nombre del síntoma
        } else if (col == 1) {
            return pacient.getWeight(symptom); // Peso del síntoma
        }
        return null;
    }
}
