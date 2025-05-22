package projetowebquiz.backend.mappers;

import org.springframework.stereotype.Component;
import projetowebquiz.backend.dtos.TurmaDto;
import projetowebquiz.backend.models.Turma;

@Component
public class TurmaMapper {

  public Turma toEntity(TurmaDto turmaDto) {
    Turma objeto = new Turma(turmaDto.nomeTurma(), turmaDto.idProfessor());
    return objeto;
  }
}
