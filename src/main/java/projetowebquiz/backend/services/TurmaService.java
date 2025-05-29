package projetowebquiz.backend.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import projetowebquiz.backend.dtos.TurmaDto;
import projetowebquiz.backend.mappers.TurmaMapper;
import projetowebquiz.backend.models.Estudante;
import projetowebquiz.backend.models.Turma;
import projetowebquiz.backend.repositories.EstudanteRepository;
import projetowebquiz.backend.repositories.TurmaRepository;

@Service
public class TurmaService {
  @Autowired private TurmaRepository turmaRepository;
  @Autowired private TurmaMapper turmaMapper;
  @Autowired private EstudanteRepository estudanteRepository;

  public String criarTurma(TurmaDto turmaDto){
    Turma turma = turmaMapper.toEntity(turmaDto);
    turmaRepository.save(turma);
    return turma.getIdTurma().toString();
  }

  public List<Turma> verTodasTurmas() {
    return turmaRepository.findAll();
  }

  public List<Estudante> verAlunosDaTurma(String nomeTurma) {
    return estudanteRepository.findByNomeTurma(nomeTurma);
  }
}
