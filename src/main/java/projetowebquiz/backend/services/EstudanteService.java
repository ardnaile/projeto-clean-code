package projetowebquiz.backend.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projetowebquiz.backend.models.Estudante;
import projetowebquiz.backend.repositories.EstudanteRepository;

@Service
public class EstudanteService {
  @Autowired EstudanteRepository estudanteRepository;

  // Create
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
