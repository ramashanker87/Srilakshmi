package com.srilakshmi.app.service;

import com.srilakshmi.app.model.Patient;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class PatientService {
    Map<String, Patient> patients = new HashMap<String, Patient>();

    public Patient createPatient(Patient patient) {
        patients.put(patient.getId(),patient);
        return patient;
    }

    public Patient updatePatient(String id, String newHospitalName) {
        Patient patient1= patients.get(id);
        patient1.setHospitalName(newHospitalName);
        return patient1;
    }

    public void deletePatient(String id) {
        patients.remove(id);
    }

    public Patient readPatientByName(String name) {
        Patient result=patients.get(name);
        return result;
    }
    public Map<String,Patient> readAllPatient() {
        return patients;
    }
}
