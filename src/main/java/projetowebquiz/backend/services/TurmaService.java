package projetowebquiz.backend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projetowebquiz.backend.dtos.TurmaDto;
import projetowebquiz.backend.mappers.TurmaMapper;
import projetowebquiz.backend.models.Estudante;
import projetowebquiz.backend.models.Professor;
import projetowebquiz.backend.models.Turma;
import projetowebquiz.backend.repositories.EstudanteRepository;
import projetowebquiz.backend.repositories.ProfessorRepository;
import projetowebquiz.backend.repositories.TurmaRepository;

@Service
public class TurmaService {
  @Autowired private TurmaRepository turmaRepository;
  @Autowired private TurmaMapper turmaMapper;
  @Autowired private EstudanteRepository estudanteRepository;
  @Autowired private ProfessorRepository professorRepository;

  public String criarTurma(TurmaDto turmaDto) {
    String idProfessor = turmaDto.idProfessor();
    Optional<Professor> professor = professorRepository.findById(idProfessor);

    if(professor.isPresent()){
      Turma turma = turmaMapper.toEntity(turmaDto);
      turmaRepository.save(turma);
      return turma.getIdTurma();
    } else {
      throw new IllegalArgumentException("Professor inválido ou não existente.");
    }
  }

  public List<Turma> verTodasTurmas() {
    return turmaRepository.findAll();
  }

  public List<Estudante> verAlunosDaTurma(String nomeTurma) {
    return estudanteRepository.findByTurma(nomeTurma);
  }
}
