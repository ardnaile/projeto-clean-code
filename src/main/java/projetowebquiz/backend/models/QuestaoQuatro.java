package projetowebquiz.backend.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "questoesQuatro")
public class QuestaoQuatro extends Questao<String>{}
