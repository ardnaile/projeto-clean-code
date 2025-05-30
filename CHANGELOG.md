﻿# 📋 Changelog

> Nota: A atualização automática do changelog via GitHub Actions foi desativada. As entradas estão sendo atualizadas manualmente.

## 📦 [Unreleased]

### ✨ Features
* Adição de pasta com arquivos JSON para banco de dados.

* Adição dos arquivos do projeto original.


### 🧹 Refactors

Geral
* Renomeia parâmetros, coleções e métodos para camelCase.

* Renomeia pacotes e atualiza nomes de pacotes.

* Remove comentários de controllers, DTOs, mappers, models e repositórios.

* Aplica herança nas classes Questao e Usuario:
  
  * Cria uma superclasse Usuario para abstrair professores e estudantes.
    
  * Cria uma superclasse Usuario para abstrair professores e estudantes.

* Aplica spotless para padronização do código.

Controllers
* Remove lançamentos de exceções.

* Remove dependências diretas de repositórios.

* Adiciona endpoints comuns (/professor, /turma, /questao).

* Renomeia endpoints em TurmaController, QuestaoController, EstudanteController e ProfessorController.

Services e Repositórios
* Refatora QuestaoService, TurmaRepository, ProfessorRepository, EstudanteRepository, QuestaoQuatroRepository, QuestaoDuasRepository para usar nomes coerentes.

DTOs e Models
* Padroniza nomes de atributos em TurmaDto, ProfessorDto, LoginEstudanteDto, EstudanteDto, Estudante, Turma, Professor, QuestaoDuas, QuestaoQuatro.

Mappers
* Renomeia métodos toDto em QuestaoMapper e QuestaoQuatroMapper.

### 🐛 Fixes
* Corrige endpoints duplicados nos controllers.

* Corrige classes relacionadas a Turma, Questao, Usuario.

### 🛠️ Chores
* Adiciona plugins: Checkstyle, Spotless PMD e SpotBugs.

* Atualiza arquivo changelog.yml.

* Atualiza workflows do changelog.

* Atualiza changelog automaticamente (via GitHub Actions).

### 🧪 Tests
* Criados testes unitários para a classe UsuarioService usando JUnit 5 e Mockito.
  
* Testes cobrem cenários de cadastro, validação e exibição de usuários:
  
  * Cadastro salva usuário quando não existe.
    
  * Cadastro lança exceção ao tentar salvar usuário já existente.
    
  * Exibição retorna lista correta de usuários.
    
  * Validação retorna ID do usuário para login válido.
    
  * Validação lança exceção para login inválido.

* Implementação de mocks para UsuarioRepository e UsuarioMapper.

* Classe concreta de serviço UsuarioServiceImpl criada para facilitar testes genéricos.

* Definidos mocks simples para DTO (UsuarioDto) e entidade (Usuario) com herança correta da classe genérica base.

### 📄 Docs
* Atualiza README.md.

* Atualiza CHANGELOG.md.
