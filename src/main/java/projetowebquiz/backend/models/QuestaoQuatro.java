package projetowebquiz.backend.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "questoesQuatro")
public class QuestaoQuatro {
  @Id private String idQuestaoQuatro;

  private String enunciado;
  private String resposta;
  private String dica;
  private int idCategoria;

  public String getId() {
    return idQuestaoQuatro;
  }

  public void setId(String idQuestaoQuatro) {
    this.idQuestaoQuatro = idQuestaoQuatro;
  }

  public String getEnunciado() {
    return enunciado;
  }

  public void setEnunciado(String enunciado) {
    this.enunciado = enunciado;
  }

  public String getResposta() {
    return resposta;
  }

  public void setResposta(String resposta) {
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
