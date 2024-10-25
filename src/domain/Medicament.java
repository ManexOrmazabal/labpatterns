package domain;

import factory.SymptomFactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Medicament {
    private String name;
    private List<Symptom> symptoms = new ArrayList<>();

    public Medicament(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Symptom addSymptomByName(String symptomName) {
        Symptom existingSymptom = getSymptomByName(symptomName);
        if (existingSymptom == null) {
            Symptom newSymptom = SymptomFactory.createSymptom(symptomName);
            if (newSymptom != null) {
                symptoms.add(newSymptom);
                return newSymptom;
            }
        }
        return existingSymptom;
    }

    public void removeSymptom(Symptom s) {
        symptoms.remove(s);
    }

    public Iterator<Symptom> getSymptoms() {
        return symptoms.iterator();
    }

    public Symptom getSymptomByName(String symptomName) {
        for (Symptom symptom : symptoms) {
            if (symptom != null && symptom.getName().equals(symptomName)) {
                return symptom;
            }
        }
        return null;
    }

    public Symptom removeSymptomByName(String symptomName) {
        Symptom symptom = getSymptomByName(symptomName);
        if (symptom != null) {
            removeSymptom(symptom);
        }
        return symptom;
    }
}

