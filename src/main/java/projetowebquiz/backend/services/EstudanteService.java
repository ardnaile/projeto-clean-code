package projetowebquiz.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projetowebquiz.backend.dtos.EstudanteDto;
import projetowebquiz.backend.mappers.EstudanteMapper;
import projetowebquiz.backend.models.Estudante;
import projetowebquiz.backend.repositories.EstudanteRepository;
import projetowebquiz.backend.repositories.TurmaRepository;

@Service
public class EstudanteService extends UsuarioService<Estudante, EstudanteDto>{
  public EstudanteService(EstudanteRepository repository, EstudanteMapper mapper){
    super(repository, mapper);
  }
}
