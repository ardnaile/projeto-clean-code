package projetowebquiz.backend.repositories;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import projetowebquiz.backend.models.QuestaoQuatro;

public interface QuestaoQuatroRepository extends MongoRepository<QuestaoQuatro, String> {

  @Query("{ 'id_categoria': ?0 }")
  List<QuestaoQuatro> findByIdCategoria(int id_categoria);
}
