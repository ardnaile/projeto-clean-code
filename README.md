# Projeto intermediário de Clean Code

 O trabalho consise em refatorar um projeto já desenvolvido anteriormente na graduação, aplicando princípios de Clean Code.

## Sobre o projeto escolhido

O código escolhido para refatoração foi o back-end do projeto [Aprende No Game](https://github.com/ardnaile/projeto-integrador-web), um sistema web de quiz para crianças. Ele foi desenvolvido em Java com o framework Spring, estruturado como uma API RESTful.

## Instalação e execução

### Pré requisitos

- Java JDK 11 ou superior
- Maven 3.6 ou superior
- MongoDB em execução

### Clonar o repositório

```bash
git clone https://github.com/ardnaile/projeto-clean-code
cd projeto-clean-code
```

### Configurar a conexão com o banco de dados
Edite o arquivo `src/main/resources/application.properties` e atualize a string de conexão:
```
spring.data.mongodb.uri=mongodb+srv://<usuario>:<senha>@<cluster>.mongodb.net/<nome_do_banco>
```


### Executar via Intellij IDEA
- Abra o IntelliJ e clique em *File > Open*, selecionando a pasta `projeto-clean-code`.
- Localize a classe `BackEndApplication`.
- Clique com o botão direito sobre ela e selecione Run 'BackEndApplication'.


## Principais problemas detectados

## Estratégia de refatoração

## ChangeLog

## Testes implementados

## Interface fluente

