# 🚀 Projeto intermediário de Clean Code

O trabalho consise em refatorar um projeto já desenvolvido anteriormente na graduação, aplicando princípios de Clean Code.

## 📚 Sobre o projeto escolhido

O código escolhido para refatoração foi o back-end do projeto [Aprende No Game](https://github.com/ardnaile/projeto-integrador-web), um sistema web de quiz para crianças. Ele foi desenvolvido em Java com o framework Spring, estruturado como uma API RESTful. Os arquivos do projeto antes da refatoração estão na branch `original`.


## ⚙️ Instalação e execução

### Pré requisitos

- Java JDK 17 ou superior
- Maven 3.6 ou superior
- MongoDB em execução

### Clonar o repositório

```bash
git clone https://github.com/ardnaile/projeto-clean-code
cd projeto-clean-code
```

### Banco de dados MongoDB

Para rodar o projeto, é necessário um banco de dados MongoDB: 

1. Crie um cluster gratuito (M0) no MongoDB Atlas seguindo o cadastro e configuração básica;
2. Instale o MongoDB Compass;
3. Com o Compass, use sua string de conexão para conectar ao cluster criado, crie um banco de dados e importe os arquivos JSON que estão na pasta [arquivos-json-banco](https://github.com/ardnaile/projeto-clean-code/tree/25aa35e9576acced58721d2aff0ca2042bbc53f4/arquivos-json-banco).

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

## 🐞 Principais problemas detectados

Alguns dos Code Smells detectados foram:

- Nomes pouco descritivos, inconsistentes ou enganosos
- Violação do princípio de Single Responsibility
- Código duplicado ou repetitivo
- Comentários desnecessários
- Endpoint sem prefixo comum no controller
- Dependência direta de repositórios no controller
- Verbos HTTP mal utilizados ou inconsistentes
- Retornos genéricos e mensagens pobres
- Manipulação de exceção genérica catch `(Exception e)`
- Falta de consistência nos nomes de endpoints
- Não segue os princípios de REST adequadamente
- Falta de valiação nos dados de entrada ⚠
- Falta de autenticação/autorização de rotas ⚠

⚠ Atualmente, o projeto está configurado para rodar somente em ambiente local (localhost). Para uma versão de produção, é importante implementar autenticação e autorização mais robustas para garantir a proteção dos dados e o controle de acesso.

---

## 🛠️ Estratégia de refatoração

A estratégia de refatoração envolveu a adoção de boas práticas como o uso de linters e testes unitários para garantir a qualidade do código. 

Além disso, foi feita uma reestruturação na modelagem. Por exemplo: no código original os objetos Estudante e Professor têm alguns atributos e métodos parecidos, sendo substituídos por uma hierarquia com a superclasse Usuario.

Algumas dessas mudanças na modelagem do projeto também têm impacto no front-end, como na parte de registro e login de Estudante que anteriormente eram feitas utilizando uma chave aleatória gerada pelo sistema. Embora o front-end não esteja no escopo desta refatoração, esse ponto fica registrado para futuras atualizações.

### Checkstyle

O primeiro linter utilizado foi o Checkstyle, que gerou um relatório com sugestões de melhorias no estilo do código, como a substituição de nomes em snake_case por camelCase.

### PMD

O PMD foi utilizado de forma complementar ao Checkstyle para identificar más práticas como código duplicado, variáveis não utilizadas, etc.

### Spotless 

O Spotless foi o linter responsável por corrigir a indentação do código, quebras de linhas, etc.

### Spotbugs

Por fim, o SpotBugs foi utilizado para verificar possíveis bugs no código.

---

## 📜 ChangeLog
O arquivo [CHANGELOG.md](https://github.com/ardnaile/projeto-clean-code/blob/main/CHANGELOG.md) contém as mudanças que foram feitas no código original.

---

## 🧪 Testes implementados

Os [testes unitários](https://github.com/ardnaile/projeto-clean-code/blob/25f6389a3376dbe5320b81e801d07c86b2140929/src/test/java/projetowebquiz/backend/UsuarioServiceTest.java) foram implementados para classe UsuarioService.

* Testes escritos com JUnit 5 e Mockito para isolamento das dependências.
  
* Cenários abrangem casos positivos e negativos, validações de exceções e comportamento esperado dos métodos.
  
* A imagem abaixo mostra o relatório do JaCoCo comprovando 100% de cobertura da classe testada.
  
![image](https://github.com/user-attachments/assets/2ba942a8-c74b-491e-b0dc-b2b1bc5a3e58)

### Como rodar os testes
Para executar os testes unitários e gerar o relatório com o JaCoCo, rode o comando `./mvnw test jacoco:report` no terminal dentro da pasta do projeto.

---

## 🔄 Interfaces fluentes
Neste projeto, foi utilizado o padrão interfaces fluentes para facilitar a construção e configuração dos objetos com encadeamento de métodos.

**Como funciona:**

* As classes base são genéricas e definem métodos que retornam o próprio tipo genérico (T), permitindo que as subclasses retornem seu próprio tipo ao chamar esses métodos.

* Isso é feito usando uma técnica chamada Curiously Recurring Template Pattern (CRTP), onde a classe base recebe como parâmetro o tipo da subclasse.

* Com isso, é possível encadear chamadas de métodos, incluindo os da classe base e os específicos da classe concreta, de forma natural e segura.

**Exemplo:**
```
public abstract class Usuario<T extends Usuario<T>> {
    protected String usuario;

    @SuppressWarnings("unchecked")
    public T comUsuario(String usuario) {
        this.usuario = usuario;
        return (T) this;
    }
}

public class Estudante extends Usuario<Estudante> {
    private String turma;

    public Estudante comTurma(String turma) {
        this.turma = turma;
        return this;
    }
}
```
**Uso:**
```
Estudante e = new Estudante()
    .comUsuario("joao")
    .comTurma("A");
```
---


