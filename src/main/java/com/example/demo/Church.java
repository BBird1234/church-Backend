package com.example.demo;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "church")

public class Church {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    private String cname;

    private Gender cgender;

    private LocalDate cdob;

    private String email;

//    private String password;
//
//    public Boolean hasCash =false;

    @Column(columnDefinition = "TEXT")
    private String image;

}
