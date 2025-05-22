package projetoWebQuiz.Backend.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "professores")
public class Professor {
  @Id private String idProfessor;

  private String usuarioProfessor;
  private String chaveProfessor;

  public Professor(String usuarioProfessor, String chaveProfessor) {
    this.usuarioProfessor = usuarioProfessor;
    this.chaveProfessor = chaveProfessor;
  }

  public String getIdProfessor() {
    return idProfessor;
  }

  public void setIdProfessor(String idProfessor) {
    this.idProfessor = idProfessor;
  }

  public String getUsuarioProfessor() {
    return usuarioProfessor;
  }

  public void setUsuarioProfessor(String usuarioProfessor) {
    this.usuarioProfessor = usuarioProfessor;
  }

  public String getChaveProfessor() {
    return chaveProfessor;
  }

  public void setChaveProfessor(String chaveProfessor) {
    this.chaveProfessor = chaveProfessor;
  }
}
