package com.saludvital.model;

    import jakarta.persistence.*;
    import lombok.*;

    import java.util.List;

@Entity
    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Setter
    @ToString
    @EqualsAndHashCode(onlyExplicitlyIncluded = true)
    public class Especialidad {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @EqualsAndHashCode.Include
        private int id;

        private String nombre;
        private String descripcion;

        @OneToMany(mappedBy = "especialidad", cascade = CascadeType.ALL, orphanRemoval = true)
        private List<Doctor> doctores;
    }