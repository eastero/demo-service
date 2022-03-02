package com.ty.demoservice.hospital.web;

import com.ty.demoservice.hospital.common.resp.ObjectResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/demo")
@Slf4j
public class DemoController {

    @GetMapping("/test")
    public ObjectResponse<String> demo() {
        return new ObjectResponse<>("ceshi");
    }

}
