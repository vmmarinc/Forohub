package com.alura.forohub.dto;

import java.time.LocalDateTime;

public class TopicoResponseDTO {

    private Long id;
    private String titulo;
    private String mensaje;
    private LocalDateTime fechaDeCreacion;
    private String status;
    private String autorNombre;
    private String cursoNombre;

    // Getters y setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public LocalDateTime getFechaDeCreacion() {
        return fechaDeCreacion;
    }

    public void setFechaDeCreacion(LocalDateTime fechaDeCreacion) {
        this.fechaDeCreacion = fechaDeCreacion;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAutorNombre() {
        return autorNombre;
    }

    public void setAutorNombre(String autorNombre) {
        this.autorNombre = autorNombre;
    }

    public String getCursoNombre() {
        return cursoNombre;
    }

    public void setCursoNombre(String cursoNombre) {
        this.cursoNombre = cursoNombre;
    }
}


//package com.alura.forohub.dto;
//
//import com.alura.forohub.model.Topico;
//import java.time.LocalDateTime;
//
//public class TopicoResponseDTO {
//
//    private Long id;
//    private String titulo;
//    private String mensaje;
//    private LocalDateTime fechaCreacion;
//    private String status;
//    private String autorNombre;
//    private String cursoNombre;
//
//    // Getters y Setters
//
//    public static TopicoResponseDTO fromEntity(Topico topico) {
//        TopicoResponseDTO dto = new TopicoResponseDTO();
//        dto.setId(topico.getId());
//        dto.setTitulo(topico.getTitulo());
//        dto.setMensaje(topico.getMensaje());
//        dto.setFechaCreacion(topico.getFechaCreacion());
//        dto.setStatus(topico.getStatus());
//        dto.setAutorNombre(topico.getAutor().getNombre());
//        dto.setCursoNombre(topico.getCurso().getNombre());
//        return dto;
//    }
//
//    private void setCursoNombre(String nombre) {
//    }
//
//    private void setAutorNombre(String nombre) {
//    }
//
//    private void setStatus(String status) {
//    }
//
//    private void setFechaCreacion(Object fechaCreacion) {
//    }
//
//    private void setMensaje(String mensaje) {
//    }
//
//    private void setTitulo(String titulo) {
//    }
//
//    private void setId(Long id) {
//    }
//}
