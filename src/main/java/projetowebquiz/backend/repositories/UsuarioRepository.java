package projetowebquiz.backend.repositories;

import java.util.Optional;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import projetowebquiz.backend.models.Usuario;

@NoRepositoryBean
public interface UsuarioRepository<T extends Usuario> extends MongoRepository<T, String> {
  @Query("{ 'usuario': ?0 }")
  Optional<T> findByUsuario(String usuario);

  @Query("{ 'usuario': ?0, 'senha': ?1 }")
  Optional<T> findByLogin(String usuario, String senha);

}
