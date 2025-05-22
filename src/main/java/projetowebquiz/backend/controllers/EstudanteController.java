package projetowebquiz.backend.controllers;

import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projetowebquiz.backend.dtos.EstudanteDto;
import projetowebquiz.backend.mappers.EstudanteMapper;
import projetowebquiz.backend.models.Estudante;
import projetowebquiz.backend.repositories.TurmaRepository;
import projetowebquiz.backend.services.EstudanteService;

@RestController
@RequestMapping("estudantes")
public class EstudanteController {
  @Autowired EstudanteService estudanteService;

  @Autowired EstudanteMapper estudanteMapper;

  @Autowired TurmaRepository turmaRepository;

  @PostMapping
  public ResponseEntity<String> cadastroEstudante(@RequestBody EstudanteDto estudanteDto) {
    String id = estudanteService.cadastroEstudante(estudanteDto);
    return ResponseEntity.status(HttpStatus.CREATED).body(id);
  }

  @GetMapping
  public ResponseEntity<List<Estudante>> exibirEstudantes() {
    List<Estudante> lista = estudanteService.exibirEstudantes();
    return ResponseEntity.status(HttpStatus.OK).body(lista);
  }

  @PostMapping("/validar")
  public ResponseEntity<String> validarEstudante(@RequestParam String senha) {
    String estudanteId = estudanteService.validarEstudante(senha);
    return ResponseEntity.ok(estudanteId);
  }
}
