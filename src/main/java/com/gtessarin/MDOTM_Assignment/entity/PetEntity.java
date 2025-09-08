package com.gtessarin.MDOTM_Assignment.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*id (Long, auto-generated)
● name (String, required)
● species (String, e.g., "Dog", "Cat", "Rabbit", required)
● age (Integer, optional, must be greater than or equal to 0)
● ownerName (String, optional*/

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PetEntity {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    @Column
    private String species;

    @Column
    private Integer age;

    @Column
    private String ownerName;
}
