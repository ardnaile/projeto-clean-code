package projetoWebQuiz.Backend.repositories;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import projetoWebQuiz.Backend.models.QuestaoDuas;

public interface QuestaoDuasRepository extends MongoRepository<QuestaoDuas, String> {

  @Query("{ 'id_categoria': ?0 }")
  List<QuestaoDuas> findByIdCategoria(int id_categoria);
}
