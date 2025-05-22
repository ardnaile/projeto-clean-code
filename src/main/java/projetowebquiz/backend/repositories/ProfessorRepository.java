package projetowebquiz.backend.repositories;

import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import projetowebquiz.backend.models.Professor;

public interface ProfessorRepository extends MongoRepository<Professor, String> {
  // aqui podemos adicionar os métodos de consulta (query)

  @Query("{ 'usuarioProfessor': ?0 }")
  Optional<Professor> findByUsuario(String usuario_professor);

  @Query("{ 'chaveProfessor': ?0 }")
  Optional<Professor> findByChave(String chave_professor);

  @Query("{ 'usuarioProfessor': ?0, 'chaveProfessor': ?1 }")
  Optional<Professor> findByUsuarioAndChaveProfessor(
      String usuarioProfessor, String chaveProfessor);
}
