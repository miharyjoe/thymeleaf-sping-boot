package com.gradle.prog4.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;


@Entity(name = "Employee")
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;

    @Column(nullable = false)
    private String firstname;

    @Column(nullable = false)
    private String lastname;

    private LocalDate birthDate;

    @Column(unique = true, nullable = false)
    private String matricule;

    @Column(nullable = true)
    @Lob
    private String image;
/*
    public String getMatricule() {
        return "EMPL" + matricule;
    }
    public void setMatricule(String matricule) {
        // Remove the "EMPL" prefix from the matricule value
        this.matricule = matricule.substring(4);
    }

 */
}
