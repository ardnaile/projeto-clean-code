package projetowebquiz.backend.mappers;

import org.springframework.stereotype.Component;
import projetowebquiz.backend.dtos.EstudanteDto;
import projetowebquiz.backend.models.Estudante;

@Component
public class EstudanteMapper {

  public Estudante toEntity(EstudanteDto estudanteDto) {
    Estudante objeto =
        new Estudante(
            estudanteDto.turma(), estudanteDto.usuarioEstudante(), estudanteDto.chaveEstudante());
    return objeto;
  }
}
