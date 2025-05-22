package projetoWebQuiz.Backend.mappers;

import org.springframework.stereotype.Component;
import projetoWebQuiz.Backend.dtos.QuestaoDuasDto;
import projetoWebQuiz.Backend.models.QuestaoDuas;

@Component
public class QuestaoDuasMapper {

  public QuestaoDuasDto toDto(QuestaoDuas questaoDuas) {
    return new QuestaoDuasDto(
        questaoDuas.getEnunciado(), questaoDuas.getResposta(), questaoDuas.getDica());
  }
}
