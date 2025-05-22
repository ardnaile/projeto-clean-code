package projetoWebQuiz.Backend.mappers;

import org.springframework.stereotype.Component;
import projetoWebQuiz.Backend.dtos.ProfessorDto;
import projetoWebQuiz.Backend.models.Professor;

@Component
public class ProfessorMapper {

  public Professor toEntity(ProfessorDto professorDto) {
    Professor objeto =
        new Professor(professorDto.usuario_professor(), professorDto.chave_professor());
    return objeto;
  }
}
