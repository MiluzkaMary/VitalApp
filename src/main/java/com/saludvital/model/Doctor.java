package com.saludvital.model;

    import jakarta.persistence.*;
    import lombok.*;

    @Entity
    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Setter
    @ToString
    @EqualsAndHashCode(onlyExplicitlyIncluded = true)
    public class Doctor {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @EqualsAndHashCode.Include
        private int id;

        private String nombre;
        private String correo;
        private String telefono;

        @ManyToOne
        private Especialidad especialidad;
    }