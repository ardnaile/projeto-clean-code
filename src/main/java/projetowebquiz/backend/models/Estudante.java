package projetowebquiz.backend.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import projetowebquiz.backend.interfaces.Usuario;

@Document(collection = "estudantes")
public class Estudante implements Usuario {
  private ObjectId idEstudante;
  private String usuarioEstudante;
  private String senhaEstudante;
  private String turma;

  public Estudante(String usuarioEstudante, String senhaEstudante, String turma) {
      this.usuarioEstudante = usuarioEstudante;
      this.senhaEstudante = senhaEstudante;
      this.turma = turma;
  }

  @Override
  public ObjectId getId(){
    return idEstudante;
  }

  @Override
  public String getUsuario(){
    return usuarioEstudante;
  }

  @Override
  public String getSenha(){
    return senhaEstudante;
  }

  public String getTurma() {
    return turma;
  }

  public void setTurma(String turma) {
    this.turma = turma;
  }
}
