package com.lahuriuts.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "absen")
public class Absen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @Column( name = "firstName")
    private String firstName;


    @Column( name = "lastName")
    private String lastName;


    @Column(name ="email", unique = true)
    private String email;


    @Column(name ="phone_number", unique = true)
    private String phoneNumber;

    @NotNull(message = "masukan NIM")
    @Column(name ="nim")
    private String nim;



}
