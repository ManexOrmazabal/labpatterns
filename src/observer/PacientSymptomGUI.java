package observer;

import domain.Covid19Pacient;
import domain.Symptom;
import factory.SymptomFactory;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PacientSymptomGUI extends JFrame {
    private JPanel contentPane;
    private JTextField weightField;
    private JComboBox<Symptom> symptomComboBox;
    private JButton addButton;
    private JButton removeButton;
    private JLabel errorLabel;
    private JLabel lblPacient;
    private JLabel labelPacient;

    public PacientSymptomGUI(Covid19Pacient pacient) {
        // Configuración de la ventana principal
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(200, 100, 450, 300);
        
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Etiqueta "Select Symptom"
        JLabel lblSelectSymptom = new JLabel("Select Symptom");
        lblSelectSymptom.setBounds(32, 68, 100, 16);
        contentPane.add(lblSelectSymptom);

        // JComboBox para seleccionar síntomas
        symptomComboBox = new JComboBox<>(SymptomFactory.getAllSymptoms());
        symptomComboBox.setBounds(195, 57, 192, 27);
        contentPane.add(symptomComboBox);

        // Etiqueta "Symptom weight"
        JLabel lblSymptomWeight = new JLabel("Symptom weight");
        lblSymptomWeight.setBounds(32, 96, 125, 16);
        contentPane.add(lblSymptomWeight);

        // Campo de texto para el peso del síntoma
        weightField = new JTextField();
        weightField.setBounds(195, 91, 130, 25);
        contentPane.add(weightField);
        weightField.setColumns(10);
        

        // Botón "Add Symptom"
        addButton = new JButton("Add Symptom");
        addButton.setBounds(88, 202, 117, 29);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                errorLabel.setText(" ");
                try {
                    int weight = Integer.parseInt(weightField.getText());
                    if (weight >= 1 && weight <= 3) {
                        Symptom selectedSymptom = (Symptom) symptomComboBox.getSelectedItem();
                        pacient.addSymptomByName(selectedSymptom.getName(), weight);
                        JOptionPane.showMessageDialog(contentPane, "Síntoma añadido.");
                    } else {
                        errorLabel.setText("ERROR, Weight between [1..3]");
                    }
                } catch (NumberFormatException ex) {
                    errorLabel.setText("Por favor, introduce un peso válido.");
                }
            }
        });
        contentPane.add(addButton);

        // Botón "Remove Symptom"
        removeButton = new JButton("Remove Symptom");
        removeButton.setBounds(255, 202, 147, 29);
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                errorLabel.setText(" ");
                Symptom selectedSymptom = (Symptom) symptomComboBox.getSelectedItem();
                pacient.removeSymptomByName(selectedSymptom.getName());
                JOptionPane.showMessageDialog(contentPane, "Síntoma eliminado.");
            }
        });
        contentPane.add(removeButton);

        // Etiqueta de error
        errorLabel = new JLabel("");
        errorLabel.setBounds(117, 146, 238, 16);
        contentPane.add(errorLabel);

        // Etiqueta "Pacient"
        lblPacient = new JLabel("Pacient:");
        lblPacient.setBounds(210, 17, 61, 16);
        contentPane.add(lblPacient);

        // Etiqueta para el nombre del paciente
        labelPacient = new JLabel(pacient.getName());
        labelPacient.setFont(new Font("Lucida Grande", Font.BOLD, 13));
        labelPacient.setBounds(271, 17, 131, 16);
        contentPane.add(labelPacient);

        this.setVisible(true);
    }
}

	



