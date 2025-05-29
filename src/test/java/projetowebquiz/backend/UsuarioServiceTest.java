package projetowebquiz.backend;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import projetowebquiz.backend.mappers.UsuarioMapper;
import projetowebquiz.backend.repositories.UsuarioRepository;
import projetowebquiz.backend.services.UsuarioService;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UsuarioServiceTest {

    @Mock
    private UsuarioRepository<Usuario> repository;

    @Mock
    private UsuarioMapper<Usuario, UsuarioDto> mapper;

    @InjectMocks
    private UsuarioServiceImpl service;

    private UsuarioDto dto;
    private Usuario usuario;

    @BeforeEach
    public void setUp() {
        dto = new UsuarioDto("usuario", "senha");
        usuario = new Usuario("usuario", "senha");
        usuario.setId(String.valueOf(UUID.randomUUID()));
    }

    @Test
    public void cadastrar_DeveSalvarUsuario_QuandoNaoExiste() {
        when(mapper.toEntity(dto)).thenReturn(usuario);
        when(repository.findByUsuario("usuario")).thenReturn(Optional.empty());

        String id = service.cadastrar(dto);

        verify(repository).save(usuario);
        assertEquals(usuario.getId(), id);
    }

    @Test
    public void cadastrar_DeveLancarExcecao_QuandoUsuarioJaExiste() {
        when(mapper.toEntity(dto)).thenReturn(usuario);
        when(repository.findByUsuario("usuario")).thenReturn(Optional.of(usuario));

        assertThrows(IllegalArgumentException.class, () -> service.cadastrar(dto));
        verify(repository, never()).save(any());
    }

    @Test
    public void exibir_DeveRetornarListaDeUsuarios() {
        List<Usuario> lista = List.of(usuario);
        when(repository.findAll()).thenReturn(lista);

        List<Usuario> resultado = service.exibir();

        assertEquals(1, resultado.size());
        assertEquals(usuario, resultado.get(0));
    }

    @Test
    public void validar_DeveRetornarId_QuandoLoginValido() {
        when(mapper.toEntity(dto)).thenReturn(usuario);
        when(repository.findByLogin("usuario", "senha")).thenReturn(Optional.of(usuario));

        String id = service.validar(dto);

        assertEquals(usuario.getId(), id);
    }

    @Test
    public void validar_DeveLancarExcecao_QuandoLoginInvalido() {
        when(mapper.toEntity(dto)).thenReturn(usuario);
        when(repository.findByLogin("usuario", "senha")).thenReturn(Optional.empty());

        assertThrows(NoSuchElementException.class, () -> service.validar(dto));
    }

    // Classe concreta auxiliar para teste
    static class UsuarioServiceImpl extends UsuarioService<Usuario, UsuarioDto> {
        public UsuarioServiceImpl(UsuarioRepository<Usuario> repository, UsuarioMapper<Usuario, UsuarioDto> mapper) {
            super(repository, mapper);
        }
    }

    // Mocks simples para DTO e entidade
    static class UsuarioDto {
        private String usuario;
        private String senha;

        public UsuarioDto(String usuario, String senha) {
            this.usuario = usuario;
            this.senha = senha;
        }

        public String getUsuario() { return usuario; }
        public String getSenha() { return senha; }
    }

    static class Usuario extends projetowebquiz.backend.models.Usuario {
        private String id;
        private String usuario;
        private String senha;

        public Usuario(String usuario, String senha) {
            this.usuario = usuario;
            this.senha = senha;
        }

        public String getId() { return id; }
        public void setId(String id) { this.id = id; }
        public String getUsuario() { return usuario; }
        public String getSenha() { return senha; }
    }
}
