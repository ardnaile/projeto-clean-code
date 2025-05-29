package projetowebquiz.backend.models;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "questoesQuatro")
public class QuestaoQuatro extends Questao<String> {
  String opcao2;
  String opcao3;
  String opcao4;

  public String getOpcao2() {
    return opcao2;
  }

  public String getOpcao3() {
    return opcao3;
  }

  public String getOpcao4() {
    return opcao4;
  }

  public void setOpcao3(String opcao3) {
    this.opcao3 = opcao3;
  }

  public void setOpcao4(String opcao4) {
    this.opcao4 = opcao4;
  }

  public void setOpcao2(String opcao2) {
    this.opcao2 = opcao2;
  }
}
