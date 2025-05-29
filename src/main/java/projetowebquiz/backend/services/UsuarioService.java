package projetowebquiz.backend.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import projetowebquiz.backend.mappers.UsuarioMapper;
import projetowebquiz.backend.models.Usuario;
import projetowebquiz.backend.repositories.UsuarioRepository;

public abstract class UsuarioService<T extends Usuario<T>, D> {
  protected UsuarioRepository<T> repository;
  protected UsuarioMapper<T, D> mapper;

  public UsuarioService(UsuarioRepository<T> repository, UsuarioMapper<T, D> mapper) {
    this.repository = repository;
    this.mapper = mapper;
  }

  public String cadastrar(D dto) {
    T usuario = mapper.toEntity(dto);

    Optional<T> usuarioOptional = repository.findByUsuario(usuario.getUsuario()); // encontrar usuario pelo nome passado no dto
    if (usuarioOptional.isPresent()) {
      throw new IllegalArgumentException("Esse nome de usuário já existe.");
    }
    repository.save(usuario);
    return usuario.getId();
  }

  public List<T> exibir() {
    return repository.findAll();
  }

  public String validar(D dto) {
    T usuario = mapper.toEntity(dto);
    Optional<T> usuarioOptional = repository.findByLogin(usuario.getUsuario(), usuario.getSenha());

    if (usuarioOptional.isPresent()) {
      return String.valueOf(usuarioOptional.get().getId());
    } else {
      throw new NoSuchElementException("Usuário não encontrado");
    }
  }
}
