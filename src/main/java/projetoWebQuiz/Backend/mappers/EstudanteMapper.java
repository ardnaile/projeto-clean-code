package projetoWebQuiz.Backend.mappers;

import org.springframework.stereotype.Component;
import projetoWebQuiz.Backend.dtos.EstudanteDto;
import projetoWebQuiz.Backend.models.Estudante;

@Component
public class EstudanteMapper {

  public Estudante toEntity(EstudanteDto estudanteDto) {
    Estudante objeto =
        new Estudante(
            estudanteDto.turma(), estudanteDto.usuario_estudante(), estudanteDto.chave_estudante());
    return objeto;
  }
}
