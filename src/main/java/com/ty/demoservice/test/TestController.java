package com.ty.demoservice.test;

import com.ty.demoservice.hospital.service.HospitalService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hospital")
@Slf4j
public class TestController {
    @Autowired
    private HospitalService hospitalService;



}
