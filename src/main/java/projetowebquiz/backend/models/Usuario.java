package projetowebquiz.backend.models;

import org.springframework.data.mongodb.core.mapping.MongoId;

public abstract class Usuario {
  @MongoId String id;
  String usuario;
  String senha;

  public String getId() {
    return id;
  }

  public String getUsuario() {
    return usuario;
  }

  public String getSenha() {
    return senha;
  }
}
