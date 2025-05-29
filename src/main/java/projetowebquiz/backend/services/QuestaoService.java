package projetowebquiz.backend.services;

import java.util.*;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projetowebquiz.backend.dtos.QuestaoDuasDto;
import projetowebquiz.backend.dtos.QuestaoQuatroDto;
import projetowebquiz.backend.mappers.QuestaoMapper;
import projetowebquiz.backend.models.Questao;
import projetowebquiz.backend.models.QuestaoDuas;
import projetowebquiz.backend.models.QuestaoQuatro;
import projetowebquiz.backend.repositories.QuestaoDuasRepository;
import projetowebquiz.backend.repositories.QuestaoQuatroRepository;

@Service
public class QuestaoService {

  @Autowired private QuestaoQuatroRepository questaoQuatroRepository;
  @Autowired private QuestaoDuasRepository questaoDuasRepository;
  @Autowired private QuestaoMapper questaoMapper;

  private final Random random = new Random();

  public QuestaoQuatroDto selecionarQuestaoQuatro(int idCategoria) {
    List<QuestaoQuatro> listaQuestoes = questaoQuatroRepository.findByIdCategoria(idCategoria);

    if (listaQuestoes == null || listaQuestoes.isEmpty()) {
      throw new NoSuchElementException(
          "Nenhuma questão encontrada para a categoria " + idCategoria);
    }

    Collections.shuffle(listaQuestoes);

    QuestaoQuatro questao = listaQuestoes.get(0);
    questao.setOpcao2(listaQuestoes.get(1).getResposta());
    questao.setOpcao3(listaQuestoes.get(2).getResposta());
    questao.setOpcao4(listaQuestoes.get(3).getResposta());

    return questaoMapper.toDto(questao);
  }

  public QuestaoDuasDto selecionarQuestaoDuas(int idCategoria) {
    List<QuestaoDuas> listaQuestoes = questaoDuasRepository.findByIdCategoria(idCategoria);

    if (listaQuestoes == null || listaQuestoes.isEmpty()) {
      throw new NoSuchElementException(
          "Nenhuma questão encontrada para a categoria " + idCategoria);
    }

    Collections.shuffle(listaQuestoes);

    return questaoMapper.toDto(listaQuestoes.get(0));
  }

  public Object selecionarQuestaoAleatoria(int idCategoria) {
    if (random.nextBoolean()) {
      return selecionarQuestaoQuatro(idCategoria);
    } else {
      return selecionarQuestaoDuas(idCategoria);
    }
  }

  public List<Questao<?>> listarTodasQuestoes() {
    List<QuestaoDuas> questoesDuas = questaoDuasRepository.findAll();
    List<QuestaoQuatro> questoesQuatro = questaoQuatroRepository.findAll();

    List<Questao<?>> todasQuestoes = new ArrayList<>();
    todasQuestoes.addAll(questoesDuas);
    todasQuestoes.addAll(questoesQuatro);

    return todasQuestoes;
  }
}
