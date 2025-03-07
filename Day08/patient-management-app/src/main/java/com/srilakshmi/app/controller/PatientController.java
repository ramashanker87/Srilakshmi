package com.srilakshmi.app.controller;

import com.srilakshmi.app.model.Patient;
import com.srilakshmi.app.service.PatientService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/patient")
public class PatientController {
    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/patient/age/all")
    public Map<String, Patient> getAllPatients() {
        return patientService.readAllPatient();
    }

    @GetMapping("/get/patient")
    public void getAllPatientByName() {
    }

    @PostMapping("/save/patient")
    public Patient createPatient(@RequestBody Patient patient) {
        return patientService.createPatient(patient);
    }

    @PutMapping("/update/patient")
    public Patient updatePatient(@RequestParam("id") String id,@RequestParam("hospitalName") String hospitalName) {
        return patientService.updatePatient(id,hospitalName);
    }

    @DeleteMapping("/delete/patient")
    public void deletePatient(@RequestParam("id") String id) {
        patientService.deletePatient(id);
    }
}

