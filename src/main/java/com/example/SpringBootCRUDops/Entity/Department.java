package com.example.SpringBootCRUDops.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
//we used lombok dependency and annotations like Data,NoargConstructor,AllargsConstructor
//so need to create getters and setters and constructors
public class Department {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long did;
    private String dname;
    private String daddress;
    private String dcode;

}
