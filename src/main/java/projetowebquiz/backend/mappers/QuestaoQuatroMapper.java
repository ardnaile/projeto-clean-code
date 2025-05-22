package projetowebquiz.backend.mappers;

import org.springframework.stereotype.Component;
import projetowebquiz.backend.dtos.QuestaoQuatroDto;
import projetowebquiz.backend.models.QuestaoQuatro;

@Component
public class QuestaoQuatroMapper {

  // quando inicializa o dto por meio da conversão, as opcoes são nulas

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
