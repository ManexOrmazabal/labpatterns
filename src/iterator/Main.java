package iterator;

import java.util.Iterator;

import domain.Covid19PacientAdapter;
import domain.Covid19Pacient;
import domain.Symptom;
import adapter.Sorting;
import domain.SeverityIndexComparator;
import domain.SymptomNameComparator;

public class Main {
    public static void main(String[] args) {
        // Crear un objeto Covid19Pacient con 5 síntomas
        Covid19Pacient pacient = new Covid19Pacient("Ane", 29);
        pacient.addSymptom(new Symptom("Cefalea", 3, 1), 2);
        pacient.addSymptom(new Symptom("Tos seca", 2, 2), 1);
        pacient.addSymptom(new Symptom("Fiebre", 5, 3), 3);
        pacient.addSymptom(new Symptom("Dificultad para respirar", 4, 4), 2);
        pacient.addSymptom(new Symptom("Fatiga", 1, 5), 2);

        // Crear el adaptador
        Covid19PacientAdapter adapter = new Covid19PacientAdapter(pacient);

        // Ordenar por nombre de síntoma
        System.out.println("Sintomas ordenados por nombre:");
        
        Iterator<Symptom> sortedByName = Sorting.sortedIterator(adapter, new SymptomNameComparator());
        
        while (sortedByName.hasNext()) {
            System.out.println(sortedByName.next());
        }

        // Ordenar por índice de severidad
        System.out.println("\nSintomas ordenados por índice de severidad:");
        Iterator<Symptom> sortedBySeverity = Sorting.sortedIterator(adapter, new SeverityIndexComparator());
        while (sortedBySeverity.hasNext()) {
            System.out.println(sortedBySeverity.next());
        }
    }
}



