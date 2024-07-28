package org.capslv.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity     // hibernate的 实体类
@Table(name = "tb_customer")   // 映射的表名
public class Customer {
    @Id     // 声明为主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)     // 主键生成策略
    @Column(name = "cust_id")
    private Long customerId;

    @Column(name = "cust_name")
    private String customerName;

    @Column(name = "cust_addr")
    private String customerAddress;
}
