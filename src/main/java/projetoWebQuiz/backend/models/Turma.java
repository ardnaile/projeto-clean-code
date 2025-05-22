package projetoWebQuiz.Backend.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "turmas")
public class Turma {

  @Id private String idTurma;
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
