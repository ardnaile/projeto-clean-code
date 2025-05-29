package projetowebquiz.backend.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import projetowebquiz.backend.models.Professor;
import projetowebquiz.backend.models.Usuario;

import java.util.Optional;

public interface UsuarioRepository<T extends Usuario> extends MongoRepository<T, String> {
    @Query("{ 'usuario': ?0 }")
    Optional<T> findByUsuario(String usuario);

    @Query("{ 'senha': ?0}")
    Optional<T> findBySenha(String senha);

    @Query("{ 'usuario': ?0, 'senha': ?1 }")
    Optional<T> findByLogin(String usuario, String senha);
}
