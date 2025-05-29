package projetowebquiz.backend.models;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.MongoId;

public abstract class Questao<T> {
  @MongoId private String id;
  private T resposta;
  private String enunciado;
  private String dica;
  private int idCategoria;

  public String getEnunciado() {
    return enunciado;
  }

  public T getResposta() {
    return resposta;
  }

  public String getDica() {
    return dica;
  }
}
