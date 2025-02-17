package com.srilakshmi.app.controller;

import com.srilakshmi.app.module.Owner;
import com.srilakshmi.app.module.Registration;
import com.srilakshmi.app.module.Vehicle;
import com.srilakshmi.app.service.VehicleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class VehicleRegistration {

    @Autowired
    private VehicleService vehicleService;
    private final Logger logger = LoggerFactory.getLogger(VehicleRegistration.class);

//    private final VehicleService vehicleService;
//
//    public VehicleRegistration(VehicleService vehicleService) {
//        this.vehicleService = vehicleService;
//    }

    @PostMapping("/register/vehicle")
    public String register(@RequestBody Registration registration) {
        logger.info("Registeration request received");
        return vehicleService.saveVehicle(registration.getVehicle(), registration.getowner());
    }

    @DeleteMapping("deregister/vehicle")
    public String deRegister(@RequestParam String vehicleNumber) {
        logger.info("De-registeration request received");
        return vehicleService.deleteVehicle(vehicleNumber);
    }

    @GetMapping("/get/all-vehicles")
    public List<Registration> getAllVehicles() {
        logger.info("Get all vehicles request received");
        return vehicleService.getAllVehicles();
    }
}

