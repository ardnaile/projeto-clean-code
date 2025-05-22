package projetowebquiz.backend.models;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import projetowebquiz.backend.interfaces.Usuario;

@Document(collection = "professores")
public class Professor implements Usuario {
  private ObjectId idProfessor;
  private final String usuarioProfessor;
  private final String senhaProfessor;

  public Professor(String usuarioProfessor, String senhaProfessor) {
    this.usuarioProfessor = usuarioProfessor;
    this.senhaProfessor = senhaProfessor;
  }

  @Override
  public ObjectId getId() {
    return idProfessor;
  }

  @Override
  public String getUsuario() {
    return usuarioProfessor;
  }

  @Override
  public String getSenha() {
    return senhaProfessor;
  }
}
