package projetowebquiz.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projetowebquiz.backend.dtos.ProfessorDto;
import projetowebquiz.backend.models.Professor;
import projetowebquiz.backend.models.Turma;
import projetowebquiz.backend.services.ProfessorService;

@RestController
@RequestMapping("/professores")
public class ProfessorController {
  @Autowired ProfessorService professorService;

  @PostMapping
  public ResponseEntity<String> cadastrarProfessor(@RequestBody ProfessorDto dto) {
    String id = professorService.cadastrar(dto);
    return ResponseEntity.status(HttpStatus.CREATED).body(id);
  }

  @GetMapping
  public ResponseEntity<List<Professor>> exibirProfessores() {
    List<Professor> lista = professorService.exibir();
    return ResponseEntity.ok(lista);
  }

  @PostMapping("/validar")
  public ResponseEntity<String> validarProfessor(@RequestBody ProfessorDto dto) {
    String id = professorService.validar(dto);
    return ResponseEntity.ok(id);
  }

  @GetMapping("/{id}/turmas")
  public ResponseEntity<List<Turma>> buscarTurmas(@PathVariable String id) {
    List<Turma> lista = professorService.buscarTurmasPorProfessor(id);
    return ResponseEntity.ok(lista);
  }

  @GetMapping("/{id}/nome")
  public ResponseEntity<String> buscarNomeProfessor(@PathVariable String id) {
    String nome = professorService.buscarNomeProfessor(id);
    return ResponseEntity.ok(nome);
  }
}
