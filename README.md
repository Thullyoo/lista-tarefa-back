# Lista de Tarefas - Back-End

Este projeto é a **API Back-End** de uma aplicação de **gerenciamento de tarefas**. Ele foi desenvolvido utilizando **Java** e **Spring Boot** para fornecer os endpoints necessários para manipular tarefas, incluindo **criação, edição, exclusão e listagem** de tarefas.

## Funcionalidades

- **Criar Tarefa**: Permite ao usuário criar uma nova tarefa.
- **Listar Tarefas**: Recupera todas as tarefas cadastradas no sistema.
- **Editar Tarefa**: Permite editar o nome, custo e data de uma tarefa existente.
- **Excluir Tarefa**: Permite excluir uma tarefa do sistema.
  
## Tecnologias Utilizadas

- **Java**: Linguagem de programação principal do projeto.
- **Spring Boot**: Framework para desenvolvimento de aplicações Java baseadas em microservices.
- **Spring Data JPA**: Para manipulação do banco de dados de forma mais eficiente.
- **MySql**: Banco de dados.
- **Maven**: Gerenciador de dependências e build tool.
  
## Instalação

É necessário ter o MySql instalado.

Siga os passos abaixo para rodar o back-end localmente:

1. **Clone o repositório**:
   ```bash
   git clone https://github.com/thullyoo/lista-tarefa-back.git
2. **Navegue até o diretório do projeto:
    ```bash
    cd lista-tarefa-back
3.  **Instale as dependências:
    ```bash
    mvn install
4.  **Configure as seguintes variáveis no application.properties:
     ```bash
    spring.datasource.url=jdbc:
    spring.datasource.username=
    spring.datasource.password=

6.  **Inicie o servidor:
   ```bash  
   mvn spring-boot:run

  
