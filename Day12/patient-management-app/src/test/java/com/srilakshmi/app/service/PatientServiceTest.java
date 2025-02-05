package com.srilakshmi.app.service;

import com.srilakshmi.app.model.Patient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Map;

@RunWith(MockitoJUnitRunner.class)
public class PatientServiceTest {
    @InjectMocks
    PatientService patientService;

    @Test
    public void testCreatePatient() {
        Patient patient = new Patient("1","Pat1","ABC","Male",25);
        Patient expectedPatient=patientService.createPatient(patient);
        assert expectedPatient != null;
        assert expectedPatient.getId()== patient.getId();
        assert expectedPatient.getName()== patient.getName();
        assert expectedPatient.getAge()== patient.getAge();
        assert expectedPatient.gethospitalName()== patient.gethospitalName();
    }

    @Test
    public void testUpdatePatient() {
        Patient patient1 = new Patient("1","Pat1","ABC","Male",25);
        Patient expectedPatient=patientService.createPatient(patient1);
        Patient resultPatient=patientService.updatePatient(patient1.gethospitalName(),"JKL");
        assert resultPatient != null;
        assert resultPatient.getId()== patient1.getId();
        assert resultPatient.getName()== patient1.getName();
        assert resultPatient.getAge()== patient1.getAge();
        assert resultPatient.gethospitalName()== "JKL";
    }

    @Test
    public void testDeletePatient() {
        Patient patient1 = new Patient("1","Pat1","ABC","Male",25);
        Patient expectedPatient=patientService.createPatient(patient1);
        patientService.deletePatient(patient1.getName());
        Patient expectedResult=patientService.readPatientByName(patient1.getName());
        assert expectedResult== null;

    }
    @Test
    public void testReadPatientsBYName() {
        Patient patient1 = new Patient("1","Pat1","ABC","Male",25);
        Patient actualPatient=patientService.createPatient(patient1);
        Patient expectedResult=patientService.readPatientByName(patient1.getId());
        assert expectedResult != null;
        assert expectedResult.getId()== actualPatient.getId();
        assert expectedResult.getName()== actualPatient.getName();
        assert expectedResult.getAge()== actualPatient.getAge();
    }
    @Test
    public void testReadAllPatients() {
        Patient patient1 = new Patient("1","Pat1","ABC","Male",25);
        Patient patient2 = new Patient("2","Pat2","DEF","Female",26);
        Patient patient3 = new Patient("3","Pat3","GHI","Male",27);
        patientService.createPatient(patient1);
        patientService.createPatient(patient2);
        patientService.createPatient(patient3);
        Map<String,Patient> resultPatients= patientService.readAllPatient();
        assert resultPatients.size()==3;
        assert resultPatients.containsKey(patient1.getId());
        assert resultPatients.containsKey(patient2.getId());
        assert resultPatients.containsKey(patient3.getId());
    }
}
