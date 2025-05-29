package projetowebquiz.backend.mappers;

import org.springframework.stereotype.Component;
import projetowebquiz.backend.dtos.EstudanteDto;
import projetowebquiz.backend.models.Estudante;

@Component
public class EstudanteMapper implements UsuarioMapper<Estudante, EstudanteDto> {

  @Override
  public Estudante toEntity(EstudanteDto estudanteDto) {
    return new Estudante()
            .comUsuario(estudanteDto.usuario())
            .comSenha(estudanteDto.senha())
            .comTurma(estudanteDto.turma());
  }
}