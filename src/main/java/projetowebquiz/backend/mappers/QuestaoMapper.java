package projetowebquiz.backend.mappers;

import org.springframework.stereotype.Component;
import projetowebquiz.backend.dtos.QuestaoDuasDto;
import projetowebquiz.backend.dtos.QuestaoQuatroDto;
import projetowebquiz.backend.models.QuestaoDuas;
import projetowebquiz.backend.models.QuestaoQuatro;

@Component
public class QuestaoMapper {
  public QuestaoDuasDto toDto(QuestaoDuas questaoDuas) {
    return new QuestaoDuasDto(
        questaoDuas.getEnunciado(), questaoDuas.getResposta(), questaoDuas.getDica());
  }

  public QuestaoQuatroDto toDto(QuestaoQuatro questaoQuatro) {
    return new QuestaoQuatroDto(
        questaoQuatro.getEnunciado(),
        questaoQuatro.getResposta(),
        questaoQuatro.getDica(),
        questaoQuatro.getOpcao2(),
        questaoQuatro.getOpcao3(),
        questaoQuatro.getOpcao4());
  }
}
