package com.spring.zerotohero.base.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity(name = "customer")
@Data
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String email;
    private String psw;
    private String nickName;
    @OneToOne(mappedBy = "customer")
    private Registry registry;
}
