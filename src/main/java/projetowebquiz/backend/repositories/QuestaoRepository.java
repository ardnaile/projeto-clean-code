package projetowebquiz.backend.repositories;

import java.util.List;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import projetowebquiz.backend.models.Questao;

@NoRepositoryBean
public interface QuestaoRepository<T extends Questao<R>, R> extends MongoRepository<T, ObjectId> {
  @Query("{ 'id_categoria': ?0 }")
  List<T> findByIdCategoria(int idCategoria);
}
