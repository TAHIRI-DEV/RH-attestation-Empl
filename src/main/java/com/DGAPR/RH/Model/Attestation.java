package com.DGAPR.RH.Model;
import jakarta.persistence.*;
import java.util.Date;
import org.springframework.data.annotation.Id;



@Entity
public class Attestation {

    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    @jakarta.persistence.Id
    @Id

        private Long id;
        private String Travail, Salaire;
        private Date dateCreation;
        private String statut; // Générée, En attente, Validée

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void setDateCreation(Date date) {
        this.dateCreation = date;
    }

    public void setStatut(String generee) {
        this.statut = generee;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setDate(Date date) {

    }

    // Getters & Setters
    }




