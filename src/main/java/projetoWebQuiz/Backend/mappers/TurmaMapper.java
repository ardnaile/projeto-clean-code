package projetoWebQuiz.Backend.mappers;

import org.springframework.stereotype.Component;
import projetoWebQuiz.Backend.dtos.TurmaDto;
import projetoWebQuiz.Backend.models.Turma;

@Component
public class TurmaMapper {

  public Turma toEntity(TurmaDto turmaDto) {
    Turma objeto = new Turma(turmaDto.nome_turma(), turmaDto.id_professor());
    return objeto;
  }
}
