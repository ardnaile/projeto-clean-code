package projetoWebQuiz.Backend.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projetoWebQuiz.Backend.models.Estudante;
import projetoWebQuiz.Backend.models.Turma;
import projetoWebQuiz.Backend.repositories.EstudanteRepository;
import projetoWebQuiz.Backend.repositories.TurmaRepository;

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
