package projetowebquiz.backend.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;
import projetowebquiz.backend.dtos.EstudanteDto;
import projetowebquiz.backend.mappers.EstudanteMapper;
import projetowebquiz.backend.models.Estudante;
import projetowebquiz.backend.models.Turma;
import projetowebquiz.backend.repositories.EstudanteRepository;
import projetowebquiz.backend.repositories.TurmaRepository;

@Service
public class EstudanteService {
  @Autowired EstudanteRepository estudanteRepository;
  @Autowired EstudanteMapper estudanteMapper;
  @Autowired TurmaRepository turmaRepository;

  public String cadastroEstudante(EstudanteDto estudanteDto){
    Estudante estudante = estudanteMapper.toEntity(estudanteDto);
    Turma turma = turmaRepository.findByNomeTurma(estudante.getTurma());

    if (turma == null) {
      throw new NoSuchElementException("Turma não encontrada");
    }

    Estudante novoEstudante = salvarEstudante(estudante);
    return novoEstudante.getId().toString();
  }

  public Estudante salvarEstudante(Estudante estudante) {
    return estudanteRepository.save(estudante);
  }

  // Read
  public List<Estudante> verTodosEstudantes() {
    return estudanteRepository.findAll();
  }

  public Optional<Estudante> buscarEstudantePorId(String id) {
    return estudanteRepository.findById(id);
  }

  public String validarEstudante(String chave) {
    Optional<Estudante> estudante = estudanteRepository.findByChaveEstudante(chave);
    if (estudante.isPresent()) {
      return String.valueOf(estudante.get().getId());
    } else {
      throw new NoSuchElementException("Estudante não encontrado com a chave fornecida.");
    }
  }
}
