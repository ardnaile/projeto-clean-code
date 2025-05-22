package projetoWebQuiz.Backend.services;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projetoWebQuiz.Backend.models.Professor;
import projetoWebQuiz.Backend.models.Turma;
import projetoWebQuiz.Backend.repositories.ProfessorRepository;
import projetoWebQuiz.Backend.repositories.TurmaRepository;

@Service
public class ProfessorService {
  @Autowired private ProfessorRepository professorRepository;
  @Autowired private TurmaRepository turmaRepository;

  // Create
  public Professor salvarProfessor(Professor professor) throws Exception {
    Optional<Professor> existente =
        professorRepository.findByUsuario(professor.getUsuario_professor());
    if (existente.isPresent()) {
      throw new Exception("Usuário já existe.");
    }
    return professorRepository.save(professor);
  }

  // Read
  public List<Professor> verTodosProfessores() {
    return professorRepository.findAll();
  }

  public Professor buscarProfessorPorId(String id) {
    return professorRepository
        .findById(id)
        .orElseThrow(() -> new RuntimeException("Professor não encontrado"));
  }

  // Buscar turmas relacionadas a esse professor

  public List<Turma> buscarTurmasPorProfessor(String idProfessor) {
    return turmaRepository.findByProfessor(idProfessor);
  }

  public List buscaNomeProfessor(String idProfessor) {
    Professor professor =
        professorRepository
            .findById(idProfessor)
            .orElseThrow(() -> new RuntimeException("Professor não encontrado"));
    if (professor != null) {
      return Collections.singletonList(professor.getUsuario_professor());
    } else {
      return null;
    }
  }

  public String validarProfessor(String usuario, String chave) {
    Optional<Professor> professor =
        professorRepository.findByUsuarioAndChaveProfessor(usuario, chave);
    if (professor.isPresent()) {
      return String.valueOf(professor.get().getId_professor());
    } else {
      throw new NoSuchElementException("Professor não encontrado.");
    }
  }
}
