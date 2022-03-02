package com.ty.demoservice.test;

import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Data
@Table(name = "test_entity")
@EntityListeners(AuditingEntityListener.class)
public class TestEntity {
    @Id
    @Column(columnDefinition = "int(11) comment '主键' ")
    String id;

    @Column(columnDefinition = "int(16) comment '实体编号' ")
    int code;

    @Column(columnDefinition = "varchar(255) comment '实体名称' ")
    String name;

    @Column(columnDefinition = "varchar(255) comment '实体说明' ")
    String memo;

}
