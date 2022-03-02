package com.ty.demoservice.hospital.service.dto;

import com.ty.demoservice.hospital.persistence.domain.Hospital;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HospitalDTO {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 机构代码
     */
    private Integer customerCode;

    /**
     * 机构名称
     */
    private String customerName;

    /**
     * 机构地址
     */
    private String addr;

    /**
     * 状态
     */
    private Integer state;

    /**
     * 机构图片
     */
    private String imageUrl;

    /**
     * 省
     */
    private String province;

    /**
     * 市
     */
    private String city;

    /**
     * 电话
     */
    private String phone;

    /**
     * 医院等级
     */
    private String hospitalGrade;

    /**
     * 简介
     */
    private String introduction;
    /**
     * 已开通服务
     */
    private Integer productAlready;
    /**
     * 未开通服务
     */
    private Integer productTodo;

    public HospitalDTO(Hospital hospital) {
        if (hospital != null) {
            BeanUtils.copyProperties(hospital, this);
        }
    }

}
