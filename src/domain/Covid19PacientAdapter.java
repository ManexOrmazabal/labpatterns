package domain;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

import adapter.InvertedIterator;

public class Covid19PacientAdapter implements InvertedIterator {
    private Covid19Pacient pacient;
    private List<Symptom> symptoms;
    private int currentIndex; // Índice del síntoma actual

    public Covid19PacientAdapter(Covid19Pacient pacient) {
        this.pacient = pacient;
        this.symptoms = new ArrayList<>(pacient.getSymptoms()); // Obtener los síntomas
        this.currentIndex = symptoms.size(); // Inicializar en el último elemento
    }

    @Override
    public Object previous() {
        if (hasPrevious()) {
            currentIndex--; // Moverse al anterior
            return symptoms.get(currentIndex); // Devolver el síntoma
        }
        return null;
    }

    @Override
    public boolean hasPrevious() {
        return currentIndex > 0; // Comprobar si hay un anterior
    }

    @Override
    public void goLast() {
        currentIndex = symptoms.size(); // Mover el índice al último elemento
    }
}


