package projetowebquiz.backend.mappers;

import org.springframework.stereotype.Component;
import projetowebquiz.backend.dtos.ProfessorDto;
import projetowebquiz.backend.models.Professor;

@Component
public class ProfessorMapper implements UsuarioMapper<Professor, ProfessorDto> {

  @Override
  public Professor toEntity(ProfessorDto professorDto) {
    return new Professor(professorDto.usuario(), professorDto.senha());
  }
}
