//package com.example.finartz_project.model;
//
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.*;
//import java.util.Date;
//import java.util.UUID;
//
//
//@Entity
//public class ConfirmationToken {
//
//    private static final java.util.UUID UUID = ;
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name="token_id")
//    private long tokenid;
//
//    @Column(name="confirmation_token")
//    private String confirmationToken;
//
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date createdDate;
//
//    @OneToOne(targetEntity = Person.class, fetch = FetchType.EAGER)
//    @JoinColumn(nullable = false, name = "general_id")
//    private Person person;
//
//    public ConfirmationToken(Person person) {
//        this.person = person;
//        createdDate = new Date();
//        confirmationToken = UUID.randomUUID().toString();
//    }
//
//
//}