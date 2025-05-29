package projetowebquiz.backend.mappers;

import projetowebquiz.backend.models.Usuario;

public interface UsuarioMapper<T extends Usuario<T>, D> {
  T toEntity(D dto);
}
