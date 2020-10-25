package com.eikholm.jpademo10.model;

import javax.persistence.*;

@Entity
@Table(name = "owners") // (name = "owners") er krævet.
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "first_name") //er IKKE krævet
    private String firstName;  // SKAL være i camel-case (firstName)

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
