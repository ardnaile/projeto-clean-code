package projetowebquiz.backend.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "estudantes")
public class Estudante {
  @Id private String idEstudante;
  private String usuarioEstudante;
  private String chaveEstudante;
  private int qtdAcertos;
  private String turma;

  // builder pro dto!!
  public Estudante(String turma, String usuarioEstudante, String chaveEstudante) {
    this.usuarioEstudante = usuarioEstudante;
    this.chaveEstudante = chaveEstudante;
    this.turma = turma;
  }

  public String getIdEstudante() {
    return idEstudante;
  }

  public void setIdEstudante(String idEstudante) {
    this.idEstudante = idEstudante;
  }

  public String getUsuarioEstudante() {
    return usuarioEstudante;
  }

  public void setUsuarioEstudante(String usuarioEstudante) {
    this.usuarioEstudante = usuarioEstudante;
  }

  public String getChaveEstudante() {
    return chaveEstudante;
  }

  public String getTurma() {
    return turma;
  }

  public void setTurma(String turma) {
    this.turma = turma;
  }

  public void setChaveEstudante(String chaveEstudante) {
    this.chaveEstudante = chaveEstudante;
  }

  public int getQtdAcertos() {
    return qtdAcertos;
  }

  public void setQtdAcertos(int qtdAcertos) {
    this.qtdAcertos = qtdAcertos;
  }
}
