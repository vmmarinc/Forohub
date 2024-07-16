package com.alura.forohub.controller;

import com.alura.forohub.dto.TopicoResponseDTO;
import com.alura.forohub.model.Curso;
import com.alura.forohub.model.Topico;
import com.alura.forohub.dto.TopicoRequestDTO;
import com.alura.forohub.model.Usuario;
import com.alura.forohub.repository.CursoRepository;
import com.alura.forohub.repository.UsuarioRepository;
import com.alura.forohub.service.TopicoService;
import com.alura.forohub.repository.TopicoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;
import java.net.URI;


@RestController
@RequestMapping("/topicos")
public class TopicoController {
    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private TopicoService topicoService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CursoRepository cursoRepository;



    public ResponseEntity<Topico> registrar(@Valid @RequestBody TopicoRequestDTO topicoRequestDTO) {
        Usuario autor = usuarioRepository.findById(topicoRequestDTO.getAutorId())
                .orElseThrow(() -> new RuntimeException("Autor no encontrado"));
        Curso curso = cursoRepository.findById(topicoRequestDTO.getCursoId())
                .orElseThrow(() -> new RuntimeException("Curso no encontrado"));

        Topico topico = new Topico();
        topico.setTitulo(topicoRequestDTO.getTitulo());
        topico.setMensaje(topicoRequestDTO.getMensaje());
        topico.setStatus(topicoRequestDTO.getStatus());
        topico.setAutor(autor);
        topico.setCurso(curso);

        Topico topicoGuardado = topicoRepository.save(topico);
        return ResponseEntity.created(URI.create("/topicos/" + topicoGuardado.getId())).body(topicoGuardado);
    }


    @GetMapping
    public List<TopicoResponseDTO> listar() {
        List<Topico> topicos = topicoRepository.findAll();
        return topicos.stream().map(topico -> {
            TopicoResponseDTO dto = new TopicoResponseDTO();
            dto.setId(topico.getId());
            dto.setTitulo(topico.getTitulo());
            dto.setMensaje(topico.getMensaje());
            dto.setFechaDeCreacion(topico.getFechaDeCreacion());
            dto.setStatus(topico.getStatus());
            dto.setAutorNombre(topico.getAutor().getNombre());
            dto.setCursoNombre(topico.getCurso().getNombre());
            return dto;
        }).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TopicoResponseDTO> detalle(@PathVariable Long id) {
        Topico topico = topicoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tópico no encontrado"));

        TopicoResponseDTO dto = new TopicoResponseDTO();
        dto.setId(topico.getId());
        dto.setTitulo(topico.getTitulo());
        dto.setMensaje(topico.getMensaje());
        dto.setFechaDeCreacion(topico.getFechaDeCreacion());
        dto.setStatus(topico.getStatus());
        dto.setAutorNombre(topico.getAutor().getNombre());
        dto.setCursoNombre(topico.getCurso().getNombre());

        return ResponseEntity.ok(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Topico> actualizar(@PathVariable Long id, @Valid @RequestBody TopicoRequestDTO topicoRequestDTO) {
        Topico topicoExistente = topicoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tópico no encontrado"));

        Usuario autor = usuarioRepository.findById(topicoRequestDTO.getAutorId())
                .orElseThrow(() -> new RuntimeException("Autor no encontrado"));
        Curso curso = cursoRepository.findById(topicoRequestDTO.getCursoId())
                .orElseThrow(() -> new RuntimeException("Curso no encontrado"));

        topicoExistente.setTitulo(topicoRequestDTO.getTitulo());
        topicoExistente.setMensaje(topicoRequestDTO.getMensaje());
        topicoExistente.setStatus(topicoRequestDTO.getStatus());
        topicoExistente.setAutor(autor);
        topicoExistente.setCurso(curso);

        Topico topicoActualizado = topicoRepository.save(topicoExistente);
        return ResponseEntity.ok(topicoActualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        Topico topicoExistente = topicoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tópico no encontrado"));

        topicoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
