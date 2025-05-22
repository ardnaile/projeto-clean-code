package projetoWebQuiz.Backend.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "questoes_duas")
public class QuestaoDuas {
  @Id private String idQuestaoDuas;

  private String enunciado;
  private int resposta;
  private String dica;
  private int idCategoria;

  public QuestaoDuas(String idQuestaoDuas, String enunciado, int resposta, String dica, int idCategoria) {
    this.idQuestaoDuas = idQuestaoDuas;
    this.enunciado = enunciado;
    this.resposta = resposta;
    this.dica = dica;
    this.idCategoria = idCategoria;
  }

  public String getIdQuestaoDuas() {
    return idQuestaoDuas;
  }

  public void setIdQuestaoDuas(String idQuestaoDuas) {
    this.idQuestaoDuas = idQuestaoDuas;
  }

  public String getEnunciado() {
    return enunciado;
  }

  public void setEnunciado(String enunciado) {
    this.enunciado = enunciado;
  }

  public int getResposta() {
    return resposta;
  }

  public void setResposta(int resposta) {
    this.resposta = resposta;
  }

  public String getDica() {
    return dica;
  }

  public void setDica(String dica) {
    this.dica = dica;
  }

  public int getIdCategoria() {
    return idCategoria;
  }

  public void setIdCategoria(int idCategoria) {
    this.idCategoria = idCategoria;
  }
}
