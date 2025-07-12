package com.DGAPR.RH.Model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

    @Entity
    public class Employee {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String nom;
        private String prenom;
        private String poste;
        private String email;
        private Date dateEmbauche;

        // One-to-Many relationship with Attestation
        // The cascade type ALL means that all operations (persist, merge, remove, refresh, detach) will be cascaded to the attestations
        @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
        private List<Attestation> attestations = new ArrayList<>();
        public Long getId() {
            return id;
        }
        public void setId(Long id) {
            this.id = id;
        }
        public String getNom() {
            return nom;
        }
        public void setNom(String nom) {
            this.nom = nom;
        }
        public String getPrenom() {
            return prenom;
        }
        public void setPrenom(String prenom) {
            this.prenom = prenom;
        }
        public String getPoste() {
            return poste;
        }
        public void setPoste(String poste) {
            this.poste = poste;
        }
        public String getEmail() {
            return email;
        }
        public void setEmail(String email) {
            this.email = email;
        }
        public Date getDateEmbauche() {
            return dateEmbauche;
        }
        public void setDateEmbauche(Date dateEmbauche) {
            this.dateEmbauche = dateEmbauche;
        }
        public List<Attestation> getAttestations() {
            return attestations;
        }
        public void setAttestations(List<Attestation> attestations) {
            this.attestations = attestations;
        }
        public void addAttestation(Attestation attestation) {
            attestations.add(attestation);
            attestation.setEmployee(this); // Set the employee in the attestation
        }
        public void removeAttestation(Attestation attestation) {
            attestations.remove(attestation);
            attestation.setEmployee(null); // Remove the employee reference in the attestation
        }
        @Override
        public String toString() {
            return "Employee{" +
                    "id=" + id +
                    ", nom='" + nom + '\'' +
                    ", prenom='" + prenom + '\'' +
                    ", poste='" + poste + '\'' +
                    ", email='" + email + '\'' +
                    ", dateEmbauche=" + dateEmbauche +
                    '}';
        }




        // Getters & Setters
    }

