package com.alura.forohub.model;
import jakarta.persistence.*;

@Entity
public class Perfil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;

    // Getters y setters
}
