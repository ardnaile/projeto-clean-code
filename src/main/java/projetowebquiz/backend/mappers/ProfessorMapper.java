package projetowebquiz.backend.mappers;

import org.springframework.stereotype.Component;
import projetowebquiz.backend.dtos.ProfessorDto;
import projetowebquiz.backend.models.Professor;

@Component
public class ProfessorMapper {

  public Professor toEntity(ProfessorDto professorDto) {
    Professor objeto =
        new Professor(professorDto.usuarioProfessor(), professorDto.chaveProfessor());
    return objeto;
  }
}
