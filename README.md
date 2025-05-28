# Projeto intermediário de Clean Code

 O trabalho consise em refatorar um projeto já desenvolvido anteriormente na graduação, aplicando princípios de Clean Code.

## Sobre o projeto escolhido

O código escolhido para refatoração foi o back-end do projeto [Aprende No Game](https://github.com/ardnaile/projeto-integrador-web), um sistema web de quiz para crianças. Ele foi desenvolvido em Java com o framework Spring, estruturado como uma API RESTful.

---

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

### Criar o banco de dados

Para rodar o projeto, é necessário um banco de dados MongoDB: 

1. Crie um cluster gratuito (M0) no MongoDB Atlas seguindo o cadastro e configuração básica (salve a string de conexão);
2. Instale o MongoDB Compass (interface gráfica para gerenciar seu banco);
3. Com o Compass, conecte ao cluster criado, crie um banco de dados e importe os arquivos JSON que estão na pasta [arquivos-json-banco](https://github.com/ardnaile/projeto-clean-code/tree/25aa35e9576acced58721d2aff0ca2042bbc53f4/arquivos-json-banco).

Isso vai preparar o ambiente de dados para o funcionamento do projeto!

### Configurar a conexão do back-end com o banco de dados

Edite o arquivo `src/main/resources/application.properties` e insira a string de conexão. Ela deve se parecer com esta:
```
spring.data.mongodb.uri=mongodb+srv://<usuario>:<senha>@<cluster>.mongodb.net/<nome_do_banco>
```

### Executar via Intellij IDEA
- Abra o IntelliJ e clique em *File > Open*, selecionando a pasta `projeto-clean-code`.
- Localize a classe `BackEndApplication`.
- Clique com o botão direito sobre ela e selecione Run 'BackEndApplication'.

---

## Principais problemas detectados

Alguns dos Code Smells detectados foram:

- Nomes pouco descritivos, inconsistentes ou enganosos
- Violação do princípio de Single Responsibility
- Código duplicado ou repetitivo
- Comentários desnecessários ✅
- Tipagem genérica
- Endpoint sem prefixo comum no controller ✅
- Dependência direta de repositórios no controller
- Verbos HTTP mal utilizados ou inconsistentes ✅
- Retornos genéricos e mensagens pobres
- Manipulação de exceção genérica catch `(Exception e)`
- Falta de consistência nos nomes de endpoints ✅
- Não segue os princípios de REST adequadamente
- Falta de valiação nos dados de entrada
- Falta de autenticação/autorização de rotas

---

## Estratégia de refatoração

A estratégia de refatoração envolve a adoção de boas práticas como o uso de linters e testes unitários para garantir a qualidade do código. 

Além disso, será feita uma reestruturação na modelagem. Por exemplo: no código original os objetos Estudante e Professor tem alguns atributos e métodos parecidos, o que poderia facilmente ser substituído por uma hierarquia com a superclasse Usuario. 

Algumas dessas mudanças impactarão também em como os dados serão guardados no banco, exigindo a adaptação dos documentos armazenados para refletir as atualizações que seguirão de forma mais coerente o paradigma de orientação a objetos.

### Checkstyle

O primeiro linter utilizado foi o Checkstyle, que gerou um relatório com sugestões de melhorias no estilo do código, como a substituição de nomes em snake_case por camelCase.

### PMD

O PMD foi utilizado de forma complementar ao Checkstyle para identificar más práticas como código duplicado, variáveis não utilizadas, etc.

### Spotless 

O Spotless foi o linter responsável por corrigir a indentação do código, quebras de linhas, etc.

### Spotbugs

Por fim, o SpotBugs foi utilizado para verificar possíveis bugs no código.

---

## ChangeLog
O arquivo [CHANGELOG.md](https://github.com/ardnaile/projeto-clean-code/blob/main/CHANGELOG.md) contém as mudanças que foram feitas no código original.

---

## Testes implementados
Mais informações conforme andamento do projeto!

---

## Interfaces fluentes
O padrão de interfaces fluentes é útil em projetos que seguem Clean Code pois permite encadear chamadas de métodos em linguagem natural, o que facilita a criação de objetos complexos. Neste projeto, foram identificadas algumas possibilidades para o uso de interfaces fluentes. Uma delas é o EstudanteDTO, que a princípio era estruturado assim:
```
public class EstudanteDto {
    private String nome;
    private String email;

    // Getters e setters
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}

```
Com interfaces fluentes:
```
public class EstudanteDto {
    private String nome;
    private String email;

    public EstudanteDto comNome(String nome) {
        this.nome = nome;
        return this;
    }

    public EstudanteDto comEmail(String email) {
        this.email = email;
        return this;
    }

    public String getNome() { return nome; }
    public String getEmail() { return email; }
}

```
Uso:
```
EstudanteDto estudante = new EstudanteDto()
    .comNome("Ana")
    .comEmail("ana@email.com");
```

---


