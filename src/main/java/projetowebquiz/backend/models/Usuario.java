package projetowebquiz.backend.models;

import org.springframework.data.mongodb.core.mapping.MongoId;

public abstract class Usuario <T extends Usuario<T>> {
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

  public T comUsuario(String usuario){
    this.usuario = usuario;
    return (T) this;
  }

  public T comSenha(String senha){
    this.senha = senha;
    return (T) this;
  }

}
