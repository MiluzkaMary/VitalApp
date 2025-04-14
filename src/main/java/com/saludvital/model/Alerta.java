package com.saludvital.model;

    import jakarta.persistence.*;
    import lombok.*;

    import java.time.LocalDateTime;

    @Entity
    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Setter
    @ToString
    @EqualsAndHashCode(onlyExplicitlyIncluded = true)
    public class Alerta {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @EqualsAndHashCode.Include
        private int id;

        private String mensaje;
        private String tipoAlerta;
        private LocalDateTime fechaHora;

        @ManyToOne
        private Doctor doctor;

        @ManyToOne
        private Paciente paciente;
    }