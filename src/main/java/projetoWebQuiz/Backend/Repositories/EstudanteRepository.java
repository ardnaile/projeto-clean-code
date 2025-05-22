package projetoWebQuiz.Backend.Repositories;

import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import projetoWebQuiz.Backend.Models.Estudante;

public interface EstudanteRepository extends MongoRepository<Estudante, String> {

  @Query("{ 'turma': ?0 }")
  List<Estudante> findByNomeTurma(String turma);

  @Query("{ 'chave_estudante': ?0}")
  Optional<Estudante> findByChaveEstudante(String chave_estudante);
}
