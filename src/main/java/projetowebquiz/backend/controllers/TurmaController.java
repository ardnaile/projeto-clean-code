package projetowebquiz.backend.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projetowebquiz.backend.dtos.TurmaDto;
import projetowebquiz.backend.mappers.TurmaMapper;
import projetowebquiz.backend.models.Estudante;
import projetowebquiz.backend.models.Turma;
import projetowebquiz.backend.services.TurmaService;

@RestController
@RequestMapping("/turma")
public class TurmaController {
  @Autowired TurmaMapper turmaMapper;
  @Autowired TurmaService turmaService;

  @PostMapping
  public ResponseEntity<String> criarTurma(@RequestBody TurmaDto turmaDto) {
    String id = turmaService.criarTurma(turmaDto);
    return ResponseEntity.ok("Turma cadastrada com sucesso. ID: " + id);
  }

  @GetMapping
  public ResponseEntity<List<Turma>> verTodasTurmas() {
    List<Turma> lista = turmaService.verTodasTurmas();
    return ResponseEntity.ok(lista);
  }

  @GetMapping("/{nomeTurma}/alunos")
  public ResponseEntity<List<Estudante>> verAlunosDaTurma(@PathVariable String nomeTurma) {
    List<Estudante> lista = turmaService.verAlunosDaTurma(nomeTurma);
    return ResponseEntity.ok(lista);
  }
}
