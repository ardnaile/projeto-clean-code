package projetoWebQuiz.Backend.mappers;

import org.springframework.stereotype.Component;
import projetoWebQuiz.Backend.dtos.QuestaoDuasDto;
import projetoWebQuiz.Backend.dtos.QuestaoQuatroDto;
import projetoWebQuiz.Backend.models.QuestaoDuas;
import projetoWebQuiz.Backend.models.QuestaoQuatro;

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
        null,
        null,
        null);
  }
}
