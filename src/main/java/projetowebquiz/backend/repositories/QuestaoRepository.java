package projetowebquiz.backend.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import projetowebquiz.backend.models.Questao;
import java.util.List;

@NoRepositoryBean
public interface QuestaoRepository<T extends Questao<R>, R> extends MongoRepository<T, ObjectId> {
    @Query("{ 'idCategoria': ?0 }")
    List<T> findByIdCategoria(int idCategoria);
}
