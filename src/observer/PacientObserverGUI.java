package observer;

import javax.swing.*;

import domain.Covid19Pacient;
import domain.Symptom;

import java.awt.*;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;

public class PacientObserverGUI extends JFrame implements Observer {
    private JLabel symptomLabel; // Asegúrate de que este campo esté presente

    public PacientObserverGUI(Observable obs) {
        setTitle("Patient Symptoms");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        symptomLabel = new JLabel("No symptoms yet");
        add(symptomLabel, BorderLayout.CENTER);
        setVisible(true);
        obs.addObserver(this); // Suscribir este objeto al Observable
    }

    @Override
    public void update(Observable o, Object arg) {
        Covid19Pacient p = (Covid19Pacient) o; // Casting
        String s = "<html> Pacient: <b>" + p.getName() + "</b> <br>";
        s += "Covid impact: <b>" + p.covidImpact() + "</b><br><br>";
        s += " _____________________ <br> Symptoms: <br>";

        Iterator<Symptom> i = p.getSymptoms().iterator();
        while (i.hasNext()) {
            Symptom p2 = i.next();
            s += " - " + p2.toString() + ", " + p.getWeight(p2) + "<br>";
        }
        s += "</html>";
        symptomLabel.setText(s); // Actualiza la etiqueta
    }
}
