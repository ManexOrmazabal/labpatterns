package observer;

import domain.Covid19Pacient;
import domain.Symptom;
import factory.SymptomFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PacientSymptomGUI {
    private Covid19Pacient pacient;
    private JComboBox<Symptom> symptomComboBox;
    private JTextField weightField;
    private JButton addButton;
    private JButton removeButton;

    public PacientSymptomGUI(Covid19Pacient pacient) {
        this.pacient = pacient;
        initializeUI();
    }

    private void initializeUI() {
        JFrame frame = new JFrame("Sintomas del Paciente");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new FlowLayout());

        // JComboBox para seleccionar síntomas
        symptomComboBox = new JComboBox<>(SymptomFactory.getAllSymptoms());
        frame.add(symptomComboBox);

        // JTextField para ingresar el peso
        weightField = new JTextField(5); // 5 columnas
        frame.add(weightField);
        
        // Botón para añadir síntoma
        addButton = new JButton("Añadir Síntoma");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String selectedSymptom = ((Symptom) symptomComboBox.getSelectedItem()).getName();
                    int weight = Integer.parseInt(weightField.getText());
                    pacient.addSymptomByName(selectedSymptom, weight);
                    JOptionPane.showMessageDialog(frame, "Síntoma añadido.");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Por favor, introduce un peso válido.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        frame.add(addButton);

        // Botón para eliminar síntoma
        removeButton = new JButton("Eliminar Síntoma");
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedSymptom = ((Symptom) symptomComboBox.getSelectedItem()).getName();
                pacient.removeSymptomByName(selectedSymptom);
                JOptionPane.showMessageDialog(frame, "Síntoma eliminado.");
            }
        });
        frame.add(removeButton);

        frame.setVisible(true);
    }
}
	



