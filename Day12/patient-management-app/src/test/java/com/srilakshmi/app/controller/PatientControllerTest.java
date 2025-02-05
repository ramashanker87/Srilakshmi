package com.srilakshmi.app.controller;

import com.srilakshmi.app.controller.PatientController;
import com.srilakshmi.app.model.Patient;
import com.srilakshmi.app.service.PatientService;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PatientControllerTest {
    @InjectMocks
    PatientController patientController;
    @Mock
    PatientService patientService;

    @Test
    public void testGetAllPatients() {
        Map<String, Patient> patientMap = new HashMap<>();
        Patient patient1 = new Patient("1","Pat1","ABC","Male",25);
        Patient patient2 = new Patient("2","Pat2","DEF","Female",26);
        Patient patient3 = new Patient("3","Pat3","GHI","Male",27);
        patientMap.put(patient1.getId(), patient1);
        patientMap.put(patient2.getId(), patient2);
        patientMap.put(patient3.getId(), patient3);
        when(patientService.readAllPatient()).thenReturn(patientMap);
        Map<String, Patient> patientResultMap=patientController.getAllPatients();
        assert patientResultMap!=null;
        assert patientResultMap.size()==3;
        assert patientResultMap.get(patient1.getId())==patient1;
        assert patientResultMap.get(patient2.getId())==patient2;
        assert patientResultMap.get(patient3.getId())==patient3;
    }

    @Test
    public void testCreatePatients() {
        Patient patient1 = new Patient("1","Pat1","ABC","Male",25);
        when(patientService.createPatient(patient1)).thenReturn(patient1);
        Patient resultPatient=patientController.createPatient(patient1);
        assert resultPatient!=null;
        assert resultPatient.getId()==patient1.getId();
        assert resultPatient.getName().equals("Pat1");
        assert resultPatient.gethospitalName().equals("ABC");
        assert resultPatient.getAge()==25;
    }
    @Test
    public void testUpdateEmployees() {
        Patient patient1 = new Patient("1","Pat1","ABC","Male",25);
        Patient patient2 = new Patient("2","Pat2","DEF","Female",26);
        when(patientService.updatePatient(anyString(),anyString())).thenReturn(patient2);
        Patient resultPatient=patientController.updatePatient(patient1.gethospitalName(),"JKL");
        assert resultPatient!=null;
        assert resultPatient.getId()==patient2.getId();
        assert resultPatient.getName().equals("Pat2");
        assert resultPatient.gethospitalName()=="JKL";
    }
    @Test
    public void testDeletePatients() {
        doNothing().when(patientService).deletePatient(anyString());
        patientController.deletePatient("1");
        verify( patientService, atLeast(1)).deletePatient(anyString());
    }
    @Test
    public void testGetPatientByName() {
        patientController.getAllPatientByName();
    }

}
