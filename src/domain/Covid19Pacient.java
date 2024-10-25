package domain;

import factory.SymptomFactory;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Covid19Pacient {
    private String name;
    private int age;
    private Map<Symptom, Integer> symptoms = new HashMap<>();

    public Covid19Pacient(String name, int years) {
        this.name = name;
        this.age = years;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getWeight(Symptom s) {
        return symptoms.get(s);
    }

    public Set<Symptom> getSymptoms() {
        return symptoms.keySet();
    }

    public Symptom getSymptomByName(String symptomName) {
        for (Symptom s : symptoms.keySet()) {
            if (s != null && s.getName().equals(symptomName)) return s;
        }
        return null;
    }

    public void addSymptom(Symptom c, Integer w) {
        symptoms.put(c, w);
    }

    public Symptom addSymptomByName(String symptomName, Integer w) {
        Symptom s = getSymptomByName(symptomName);
        if (s == null) {
            s = SymptomFactory.createSymptom(symptomName);  // Usamos la fábrica
            if (s != null) symptoms.put(s, w);
        }
        return s;
    }

    public Symptom removeSymptomByName(String symptomName) {
        Symptom s = getSymptomByName(symptomName);
        if (s != null) symptoms.remove(s);
        return s;
    }

    public Iterator<Symptom> iterator() {
        return symptoms.keySet().iterator();
    }

    public double covidImpact() {
        double afection = 0;
        double increment = 0;
        double impact = 0;

        // Calcular afección
        for (Symptom c : symptoms.keySet()) {
            if (c != null)
                afection += c.getSeverityIndex() * symptoms.get(c);
        }
        afection = afection / symptoms.size();

        // Calcular incremento
        if (getAge() > 65) increment = afection * 0.5;

        // Calcular impacto
        impact = afection + increment;
        return impact;
    }
}


