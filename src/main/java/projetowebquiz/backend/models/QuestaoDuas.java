package projetowebquiz.backend.models;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "questoesDuas")
public class QuestaoDuas extends Questao<Integer>{
}
