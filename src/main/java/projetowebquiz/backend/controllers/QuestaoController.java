package projetowebquiz.backend.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import projetowebquiz.backend.dtos.QuestaoDuasDto;
import projetowebquiz.backend.dtos.QuestaoQuatroDto;
import projetowebquiz.backend.models.Questao;
import projetowebquiz.backend.models.QuestaoDuas;
import projetowebquiz.backend.repositories.QuestaoDuasRepository;
import projetowebquiz.backend.services.QuestaoService;

@RestController
@RequestMapping("/questoes")
public class QuestaoController {
  @Autowired QuestaoService questaoService;

  @GetMapping("/quatro/{idCategoria}")
  public ResponseEntity<QuestaoQuatroDto> selecionarQuestaoQuatro(@PathVariable int idCategoria) {
    QuestaoQuatroDto questao = questaoService.selecionarQuestaoQuatro(idCategoria);
    return ResponseEntity.ok(questao);
  }

  @GetMapping("/duas/{idCategoria}")
  public ResponseEntity<QuestaoDuasDto> selecionarQuestaoDuas(@PathVariable int idCategoria) {
    QuestaoDuasDto questao = questaoService.selecionarQuestaoDuas(idCategoria);
    return ResponseEntity.ok(questao);
  }

  @GetMapping("/aleatoria/{idCategoria}")
  public ResponseEntity<Object> selecionarQuestaoAleatoria(@PathVariable int idCategoria) {
    Object questao = questaoService.selecionarQuestaoAleatoria(idCategoria);
    return ResponseEntity.ok(questao);
  }

  @GetMapping
  public ResponseEntity<List<Questao<?>>> listarTodasQuestoes() {
    List<Questao<?>> lista = questaoService.listarTodasQuestoes();
    return ResponseEntity.ok(lista);
  }
}
