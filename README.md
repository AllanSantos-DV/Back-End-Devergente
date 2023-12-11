# Devergente, conectando mentes diferentes

## Descrição

Este projeto é uma aplicação web desenvolvida em Java 17, utilizando IntelliJ IDEA e Docker. O projeto é um Maven.

## Pré-requisitos

Antes de começar, certifique-se de ter o seguinte software instalado em sua máquina:

- [Java 17](https://www.oracle.com/java/technologies/downloads/)
- [IntelliJ IDEA](https://www.jetbrains.com/pt-br/idea/download/)
- [Docker](https://www.docker.com/products/docker-desktop/)

Se você não tiver esses softwares instalados, o projeto não funcionará adequadamente.

## Instalação

Para instalar o projeto, siga estas etapas:

1. Clone o repositório para a sua máquina local.
2. Abra o projeto usando o IntelliJ IDEA.
3. Execute o método main na classe DeVerGenteApplication.
#### opções vias docker:
1. Localize o arquivo [compose.yaml](../compose.yaml) e descomente todas as linhas comentadas.
2. Na pasta raiz do projeto digite o seguinte comando
```
docker compose up
```
3. A opção acima podera ser usada com a opção ```-d``` para poder liberar o console.

exemplo: ``` docker compose up -d ```

4. As portas estão definidas no arquivo:

```
Back-- 8080:8080
Banco-- 5432:5432
```

Lembre-se de que o Docker deve estar instalado e funcionando, pois o banco de dados será criado no Docker.

## Uso

O servidor abrirá no localhost:8080 por padrão. Você pode usar um programa como o Postman ou Insomnia para testar os endpoints.

O projeto não está completo e pode apresentar instabilidades. Foi ajustado um front-end para rodar com base na aplicação. Você pode acessar o projeto [aqui](https://github.com/AllanSantos-DV/Front-End-Devergente).

## Funções

### Usando o front-end:

- Criar usuário.
- Logar usuário criado.
- Acesso ao feed de notícias.

### Usando Insomnia ou Postman:

- Criar usuário.
- Logar usuário criado.
- Criar postagem.
- Buscar todas as postagens.

## Aviso

O projeto ainda está em desenvolvimento.

# ate o momento foi realizado no Back-End.
elaboração das classes modelos : 
User, UserDTO, Profissional, Neurodivergente, Familiar, Empregador, Comentario, Curriculum, Curtida, Endereco, Postagem, Vaga.

elaboração dos repositorios:
UsersRepository, UsersDTORepository, ComentarioRepository, CurriculumRepository, CurtidasRepository, EnderecosRepository, PostagensRepository, VagasRepository

elaboração dos services:
PostagensServices, UserServices.

elaboração dos controllers:
UserController, PostagemController, LoginController.

elaboração do enuns:
EnunsUsers, EnunsProfissional, EnunsNeuro, EnunsFamiliar.

uso do BCryptPasswordEncoder para salvar a senha do usuario de forma segura.
uso do JwT para geração do token.
token gerado tem duração de 1 hora caso usuario esteja ativo, ao restar menos de 5 minutos e gerado um refreshtoken por mais uma hora.

# A ser desenvolvido.
Api para criar e ler comentarios.
Api para armazenar e deletar curtidas.
Api para editar e remover usuario.
Api para chegar se o emial e valido.


# Ajuste no Front-End.

Atualização das chaves das interfaces para manter o mesmo padrão.
familiar, neurodivergente e profissional.

função login:
função reescrita para atender os parametros do projeto.
guardar o token gerado em caso de login com sucesso.
instanciamento do enviroments correto para apontar a rota de login.
o sistema usa BCryptPasswordEncoder e o front estava lendo e comparando a senha como String.
ajuste no tratamento do erro.

função carregasMaisPostagens:
implementação do token na requisição para autenticar o usuario.
correção dos parametros e rota para api.

Rota /perfil:
Post - Corpo da requisição do Json com chaves diferentes para cada tipo de usuario.
validação se o usuario ja existe no banco de dados.
import da classe UsuarioService correto.

postagens:
Get - função que sinboliza os lazyload da aplicação com erro. função criada sem parametro e instancia da função com 2 parametros.
função atualizada

Ajuste a serem feitos:
implementação da validação da seção do usuario via token.
função de salvar postagem usando um unico endpoint.
função de sair do usuario atual.
função de editar usuario em um unico endpoint.
função de alterar perfil em um unico endpoint.
função para validar email.


## Contribuição

Contribuições são bem-vindas! Para contribuir, por favor:

1. Faça um fork do projeto.
2. Crie uma nova branch para suas alterações.
3. Faça commit de suas alterações.
4. Faça push para a sua branch.
5. Abra um Pull Request.

