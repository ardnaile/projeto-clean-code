package projetowebquiz.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projetowebquiz.backend.dtos.EstudanteDto;
import projetowebquiz.backend.models.Estudante;
import projetowebquiz.backend.services.EstudanteService;

@RestController
@RequestMapping("estudantes")
public class EstudanteController {
  @Autowired EstudanteService estudanteService;

  @PostMapping
  public ResponseEntity<String> cadastrarEstudante(@RequestBody EstudanteDto dto) {
    String id = estudanteService.cadastrar(dto);
    return ResponseEntity.status(HttpStatus.CREATED).body(id);
  }

  @GetMapping
  public ResponseEntity<List<Estudante>> exibirEstudantes() {
    List<Estudante> lista = estudanteService.exibir();
    return ResponseEntity.ok(lista);
  }

  @PostMapping("/validar")
  public ResponseEntity<String> validarEstudante(@RequestBody EstudanteDto dto) {
    String id = estudanteService.validar(dto);
    return ResponseEntity.ok(id);
  }
}
