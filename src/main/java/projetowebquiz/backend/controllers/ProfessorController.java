package projetowebquiz.backend.controllers;

import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projetowebquiz.backend.dtos.ProfessorDto;
import projetowebquiz.backend.mappers.ProfessorMapper;
import projetowebquiz.backend.models.Professor;
import projetowebquiz.backend.models.Turma;
import projetowebquiz.backend.repositories.ProfessorRepository;
import projetowebquiz.backend.services.ProfessorService;

@RestController
public class ProfessorController {

  @Autowired private ProfessorRepository professorRepository;

  @Autowired private ProfessorMapper professorMapper;

  @Autowired private ProfessorService professorService;

  @PostMapping("/cadastroProfessor")
  public ResponseEntity<String> cadastrarProfessor(@RequestBody ProfessorDto professorDto) {
    try {
      Professor professor = professorMapper.toEntity(professorDto);
      Professor novoProfessor = professorService.salvarProfessor(professor);

      return ResponseEntity.ok(
          "Professor cadastrado com sucesso. ID: " + novoProfessor.getIdProfessor());
    } catch (Exception e) {
      if (e.getMessage().equals("Usuário já existe.")) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
            .body("Erro ao cadastrar professor: usuário já existe");
      }
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
          .body("Erro ao cadastrar professor: " + e.getMessage());
    }
  }

  @GetMapping("/verTodosProfessores")
  public ResponseEntity<List<Professor>> verTodosProfessores() {
    List<Professor> lista = professorService.verTodosProfessores();
    return ResponseEntity.ok(lista);
  }

  @GetMapping("/minhasTurmas/{idProfessor}")
  public ResponseEntity<List<Turma>> minhasTurmas(@PathVariable String idProfessor) {
    List<Turma> lista = professorService.buscarTurmasPorProfessor(idProfessor);
    return ResponseEntity.ok(lista);
  }

  @GetMapping("/buscaNomeProfessor/{idProfessor}")
  public ResponseEntity<List<Professor>> buscaNomeProfessor(@PathVariable String id_professor) {
    List nomeProfessor = professorService.buscaNomeProfessor(id_professor);
    if (nomeProfessor != null) {
      return ResponseEntity.ok(nomeProfessor);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @PostMapping("/validarProfessor")
  public ResponseEntity<String> validarProfessor(@RequestBody ProfessorDto professorDto) {
    try {
      String professorId =
          professorService.validarProfessor(
              professorDto.usuarioProfessor(), professorDto.chaveProfessor());
      return ResponseEntity.ok(professorId);
    } catch (NoSuchElementException e) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
          .body("Erro interno no servidor.");
    }
  }
}
