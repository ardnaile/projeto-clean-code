package projetowebquiz.backend.repositories;

import java.util.List;
import org.springframework.data.mongodb.repository.Query;
import projetowebquiz.backend.models.Estudante;

public interface EstudanteRepository extends UsuarioRepository<Estudante> {

  @Query("{ 'turma': ?0 }")
  List<Estudante> findByNomeTurma(String turma);
}
