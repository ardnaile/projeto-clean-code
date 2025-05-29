package projetowebquiz.backend.models;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "professores")
public class Professor extends Usuario {

  public Professor() {}

  public Professor(String usuario, String senha) {
    this.usuario = usuario;
    this.senha = senha;
  }
}
