package com.ty.demoservice.hospital.web;

import com.ty.demoservice.hospital.common.resp.ObjectResponse;
import com.ty.demoservice.hospital.common.resp.PageResponse;
import com.ty.demoservice.hospital.persistence.domain.Hospital;
import com.ty.demoservice.hospital.service.HospitalService;
import com.ty.demoservice.hospital.service.dto.HospitalDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 首页-医院信息
 *
 * @author wangpeng
 * 2022-02-26 20:32:15
 */
@RestController
@RequestMapping("/hospital")
@Slf4j
public class HospitalController {
    @Autowired
    private HospitalService hospitalService;

    /**
     * 查询医院列表
     *
     * @param customerCode
     * @param customerName
     * @param city
     * @param province
     * @param hospitalGrade
     * @param page
     * @param size
     * @return
     */
    @GetMapping("/list")
    public PageResponse<HospitalDTO> queryPage(
            @RequestParam(name = "customer_code", required = false) Integer customerCode,
            @RequestParam(name = "customer_name", required = false) String customerName,
            @RequestParam(name = "city", required = false) String city,
            @RequestParam(name = "province", required = false) String province,
            @RequestParam(name = "hospital_grade", required = false) String hospitalGrade,
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "20") int size
    ) {
        Page<Hospital> hospitals = hospitalService.queryPage(customerCode, customerName, city, province, hospitalGrade, page, size);
        List<HospitalDTO> list = hospitals.getContent().stream().map(l -> {
            HospitalDTO dto = new HospitalDTO();
            BeanUtils.copyProperties(l, dto);
            return dto;
        }).collect(Collectors.toList());
        return new PageResponse<HospitalDTO>(list, hospitals.getTotalElements(), page, size);
    }

    /**
     * 查询医院详情
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/{id}")
    public ObjectResponse<HospitalDTO> getById(@PathVariable Integer id) {
        HospitalDTO hospitalDTO = hospitalService.getById(id);
        String sa = "   ";
        return new ObjectResponse(hospitalDTO);

    }

}
