package projetowebquiz.backend.mappers;

import org.springframework.stereotype.Component;
import projetowebquiz.backend.dtos.QuestaoDuasDto;
import projetowebquiz.backend.models.QuestaoDuas;

@Component
public class QuestaoDuasMapper {

  public QuestaoDuasDto toDto(QuestaoDuas questaoDuas) {
    return new QuestaoDuasDto(
        questaoDuas.getEnunciado(), questaoDuas.getResposta(), questaoDuas.getDica());
  }
}
