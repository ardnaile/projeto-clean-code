package projetowebquiz.backend.repositories;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import projetowebquiz.backend.models.Turma;

public interface TurmaRepository extends MongoRepository<Turma, String> {
  @Query("{ 'nomeTurma': ?0 }")
  Turma findByNomeTurma(String nomeTurma);

  @Query("{ 'idProfessor': ?0 }")
  List<Turma> findByProfessor(String idProfessor);
}
