package projetowebquiz.backend.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projetowebquiz.backend.models.Estudante;
import projetowebquiz.backend.models.Turma;
import projetowebquiz.backend.repositories.EstudanteRepository;
import projetowebquiz.backend.repositories.TurmaRepository;

@Service
public class TurmaService {
  @Autowired private TurmaRepository turmaRepository;
  @Autowired private EstudanteRepository estudanteRepository;

  // Create
  public Turma salvarTurma(Turma turma) {
    return turmaRepository.save(turma);
  }

  // Read
  public List<Turma> verTodasTurmas() {
    return turmaRepository.findAll();
  }

  // Ver alunos da turma

  public List<Estudante> verAlunosDaTurma(String nomeTurma) {
    return estudanteRepository.findByNomeTurma(nomeTurma);
  }
}
