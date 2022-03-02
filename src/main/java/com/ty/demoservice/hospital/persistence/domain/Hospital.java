package com.ty.demoservice.hospital.persistence.domain;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author wangpeng
 * @date 2022/2/26 14:11
 */
@Entity
@Data
@Table(name = "basic_khxx")
@EntityListeners(AuditingEntityListener.class)
public class Hospital {
    @Id
    @Column(columnDefinition = "int(11) comment '主键' ")
    private Integer id;

    @Column(columnDefinition = "int(4) comment '医院代码' ")
    private Integer customerCode;

    @Column(columnDefinition = "varchar(255) comment '医院名称' ")
    private String customerName;

    @Column(columnDefinition = "varchar(255) comment '医院别名' ")
    private String alias;

    @Column(columnDefinition = "int(4) comment '省份代码' ")
    private Integer provinceId;

    @Column(columnDefinition = "varchar(255) comment '省份名称' ")
    private String province;

    @Column(columnDefinition = "varchar(255) comment '城市代码' ")
    private String cityId;

    @Column(columnDefinition = "varchar(255) comment '城市名称' ")
    private String city;

    @Column(columnDefinition = "varchar(255) comment '类型名称' ")
    private String customerType;

    @Column(columnDefinition = "varchar(255) comment '类型代码' ")
    private String customerTypeId;

    @Column(columnDefinition = "varchar(255) comment '等级名称' ")
    private String hospitalGrade;

    @Column(columnDefinition = "varchar(255) comment '等级代码' ")
    private String hospitalGradeId;

    @Column(columnDefinition = "int(4) comment '状态' ")
    private Integer state;

    @Column(columnDefinition = "int(11) comment '客户分类代码' ")
    private Integer customerCategoryId;

    @Column(columnDefinition = "varchar(255) comment '客户分类名称' ")
    private String customerCategory;

    @Column(columnDefinition = "varchar(255) comment '地址' ")
    private String addr;

    @Column(columnDefinition = "varchar(255) comment '简介' ")
    private String introduction;

    @Column(columnDefinition = "varchar(16) comment '电话' ")
    private String phone;

    @Column(columnDefinition = "int(10) comment '已开通服务' ")
    private Integer productAlready;

    @Column(columnDefinition = "int(10) comment '待开通服务' ")
    private Integer productTodo;

    @Column(columnDefinition = "varchar(255) comment '医院图片' ")
    private String imageUrl;
}
