package projetowebquiz.backend.services;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projetowebquiz.backend.dtos.QuestaoDuasDto;
import projetowebquiz.backend.dtos.QuestaoQuatroDto;
import projetowebquiz.backend.mappers.QuestaoDuasMapper;
import projetowebquiz.backend.mappers.QuestaoQuatroMapper;
import projetowebquiz.backend.models.QuestaoDuas;
import projetowebquiz.backend.models.QuestaoQuatro;
import projetowebquiz.backend.repositories.QuestaoDuasRepository;
import projetowebquiz.backend.repositories.QuestaoQuatroRepository;

@Service
public class QuestaoService {

  @Autowired private QuestaoQuatroRepository questaoQuatroRepository;

  @Autowired private QuestaoQuatroMapper questaoQuatroMapper;

  @Autowired private QuestaoDuasRepository questaoDuasRepository;

  @Autowired private QuestaoDuasMapper questaoDuasMapper;

  private final Random random = new Random();

  public QuestaoQuatroDto pegarQuestaoQuatro(int idCategoria) {
    // Pegando uma lista com todas as questões do banco e embaralhando
    List<QuestaoQuatro> questoesQuatro = questaoQuatroRepository.findByIdCategoria(idCategoria);
    Collections.shuffle(questoesQuatro);

    // Pegando a primeira da lista e transformando em dto
    QuestaoQuatroDto questaoQuatroDto = questaoQuatroMapper.toDto(questoesQuatro.get(0));

    // Setando os valores das outras opções (opções erradas)
    questaoQuatroDto.setOpcao2(questoesQuatro.get(1).getResposta());
    questaoQuatroDto.setOpcao3(questoesQuatro.get(2).getResposta());
    questaoQuatroDto.setOpcao4(questoesQuatro.get(3).getResposta());

    // retornando o json com todas as infos necessárias
    return questaoQuatroDto;
  }

  public QuestaoDuasDto pegarQuestaoDuas(int idCategoria) {
    List<QuestaoDuas> questoesDuas = questaoDuasRepository.findByIdCategoria(idCategoria);
    Collections.shuffle(questoesDuas);

    QuestaoDuasDto questaoDuasDto = questaoDuasMapper.toDto(questoesDuas.get(0));
    return questaoDuasDto;
  }

  public Object pegarQuestaoAleatoria(int idCategoria) {
    if (random.nextBoolean()) {
      return pegarQuestaoQuatro(idCategoria);
    } else {
      return pegarQuestaoDuas(idCategoria);
    }
  }
}
