package observer;

import domain.Covid19Pacient;
import observer.PacientObserverGUI;
import observer.PacientSymptomGUI;

import java.util.Observable;

public class Main {
    public static void main(String[] args) {
        // Crear dos pacientes
        Covid19Pacient pacient1 = new Covid19Pacient("Aitor", 35);
        Covid19Pacient pacient2 = new Covid19Pacient("Marta", 28);

        // Crear interfaces de observador para cada paciente
        PacientObserverGUI observer1 = new PacientObserverGUI(pacient1);
        PacientObserverGUI observer2 = new PacientObserverGUI(pacient2);

        // Crear interfaces para actualizar síntomas
        PacientSymptomGUI symptomGUI1 = new PacientSymptomGUI(pacient1);
        PacientSymptomGUI symptomGUI2 = new PacientSymptomGUI(pacient2);
        
        PacientThermometerGUI thermometerGUI1 = new PacientThermometerGUI(pacient1);
        PacientThermometerGUI thermometerGUI2 = new PacientThermometerGUI(pacient2);
        
        SemaphorGUI semaphorGUI1 = new SemaphorGUI(pacient1);
        SemaphorGUI semaphorGUI2 = new SemaphorGUI(pacient2);
        
    }
}
	
