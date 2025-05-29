package projetowebquiz.backend.services;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projetowebquiz.backend.dtos.ProfessorDto;
import projetowebquiz.backend.mappers.ProfessorMapper;
import projetowebquiz.backend.models.Professor;
import projetowebquiz.backend.models.Turma;
import projetowebquiz.backend.repositories.ProfessorRepository;
import projetowebquiz.backend.repositories.TurmaRepository;

@Service
public class ProfessorService extends UsuarioService<Professor, ProfessorDto> {
  @Autowired private TurmaRepository turmaRepository;

  public ProfessorService(ProfessorRepository repository, ProfessorMapper mapper) {
    super(repository, mapper);
  }

  public List<Turma> buscarTurmasPorProfessor(String idProfessor) {
    return turmaRepository.findByProfessor(idProfessor);
  }

  public String buscarNomeProfessor(String idProfessor) {
    return repository
        .findById(idProfessor)
        .map(Professor::getUsuario)
        .orElseThrow(() -> new RuntimeException("Professor não encontrado"));
  }
}
