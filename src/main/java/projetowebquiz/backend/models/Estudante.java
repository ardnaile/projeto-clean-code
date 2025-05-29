package projetowebquiz.backend.models;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "estudantes")
public class Estudante extends Usuario<Estudante> {
  private String turma;

  public Estudante() {}

  public Estudante(String usuario, String senha, String turma) {
    this.usuario = usuario;
    this.senha = senha;
    this.turma = turma;
  }

  public String getTurma() {
    return turma;
  }

  public void setTurma(String turma) {
    this.turma = turma;
  }

  public Estudante comTurma(String turma){
    this.turma = turma;
    return this;
  }

}
