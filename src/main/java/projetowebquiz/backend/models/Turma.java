package projetowebquiz.backend.models;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document(collection = "turmas")
public class Turma {

  @MongoId private String idTurma;
  private String nomeTurma;
  private String idProfessor;

  public Turma(String nomeTurma, String idProfessor) {
    this.nomeTurma = nomeTurma;
    this.idProfessor = idProfessor;
  }

  public String getIdTurma() {
    return idTurma;
  }

  public void setIdTurma(String idTurma) {
    this.idTurma = idTurma;
  }

  public String getNomeTurma() {
    return nomeTurma;
  }

  public void setNomeTurma(String nomeTurma) {
    this.nomeTurma = nomeTurma;
  }

  public String getIdProfessor() {
    return idProfessor;
  }

  public void setIdProfessor(String idProfessor) {
    this.idProfessor = idProfessor;
  }
}
