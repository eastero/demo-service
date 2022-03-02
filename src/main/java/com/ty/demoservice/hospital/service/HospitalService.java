package com.ty.demoservice.hospital.service;

import com.ty.demoservice.hospital.exception.BaseException;
import com.ty.demoservice.hospital.persistence.domain.Hospital;
import com.ty.demoservice.hospital.persistence.repository.HospitalRepository;
import com.ty.demoservice.hospital.service.dto.HospitalDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

@Service
public class HospitalService {

    @Autowired
    private HospitalRepository hospitalRepository;

    /**
     * 查询医院列表
     * @param
     * @param page
     * @param size
     * @return
     */
    public Page<Hospital> queryPage(Integer customerCode, String customerName, String city, String province, String hospitalGrade, int page, int size) {
        HospitalDTO hospital = new HospitalDTO();
        hospital.setCustomerCode(customerCode);
        hospital.setCustomerName(customerName);
        hospital.setCity(city);
        hospital.setProvince(province);
        hospital.setHospitalGrade(hospitalGrade);
        return queryPage(hospital, page, size);
    }

    private Page<Hospital> queryPage(HospitalDTO hospital, int page, int size) {
        Specification<Hospital> specification = (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicateList = new ArrayList<>();
            if (StringUtils.isNotEmpty(hospital.getCity())) {
                predicateList.add(criteriaBuilder.like(root.get("city").as(String.class), "%" + hospital.getCity() + "%"));
            }
            if (StringUtils.isNotEmpty(hospital.getProvince())) {
                predicateList.add(criteriaBuilder.like(root.get("province").as(String.class), "%" + hospital.getProvince() + "%"));
            }
            if (StringUtils.isNotEmpty(hospital.getCustomerName())) {
                predicateList.add(criteriaBuilder.like(root.get("customerName").as(String.class), "%" + hospital.getCustomerName() + "%"));
            }
            if (StringUtils.isNotEmpty(hospital.getHospitalGrade())) {
                predicateList.add(criteriaBuilder.like(root.get("hospitalGrade").as(String.class), "%" + hospital.getHospitalGrade() + "%"));
            }
            return criteriaBuilder.and(predicateList.toArray(new Predicate[predicateList.size()]));
        };
        PageRequest pageRequest = PageRequest.of(page - 1, size, Sort.by(Sort.Direction.ASC, "customerCode"));
        return hospitalRepository.findAll(specification, pageRequest);
    }

    /**
     * 医院详情
     * @param id 医院id
     * @return 医院信息
     */
    public HospitalDTO getById(Integer id) {
        Hospital hospital = hospitalRepository.findById(id).orElseThrow(() -> new BaseException("查询不到机构信息，机构id："+id));
        return new HospitalDTO(hospital);
    }
}
