package projetowebquiz.backend.repositories;

import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import projetowebquiz.backend.models.Professor;

public interface ProfessorRepository extends MongoRepository<Professor, String> {

  @Query("{ 'usuarioProfessor': ?0 }")
  Optional<Professor> findByUsuario(String usuarioProfessor);

  @Query("{ 'chaveProfessor': ?0 }")
  Optional<Professor> findByChave(String chaveProfessor);

  @Query("{ 'usuarioProfessor': ?0, 'chaveProfessor': ?1 }")
  Optional<Professor> findByUsuarioAndChaveProfessor(
      String usuarioProfessor, String chaveProfessor);
}
