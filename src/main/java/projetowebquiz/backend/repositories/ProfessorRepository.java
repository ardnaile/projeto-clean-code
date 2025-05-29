package projetowebquiz.backend.repositories;

import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import projetowebquiz.backend.models.Professor;

public interface ProfessorRepository extends UsuarioRepository<Professor> {
}
