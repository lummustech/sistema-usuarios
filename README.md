Projeto de estudo para praticar Programação Orientada a Objetos em Java. A estrutura base do projeto já existe — cada aluno deve **complementar** o que já está criado, seguindo as regras de negócio e a sequência de desenvolvimento descritas abaixo.

## Regras de negócio

O sistema deve permitir, tudo **em memória** (sem persistência em banco de dados ou arquivo — os dados existem apenas durante a execução do programa):

1. Criar usuário
2. Listar usuários cadastrados
3. Filtrar usuários maiores de idade
4. Buscar usuário através do CPF

### Atributos do usuário

- `nome`
- `idade`
- `cpf`

O tipo de cada atributo fica a critério de quem for implementar a classe `Usuario`.

## Estrutura atual do projeto

```
src/main/java/org/sistema/
├── Main.java                  # ponto de entrada, com comentários indicando onde cada regra deve ser acionada
├── model/Usuario.java         # classe vazia — a ser modelada
└── services/UsuarioService.java  # classe vazia — a ser implementada
```

## Organização do trabalho

O desenvolvimento foi dividido em 4 tasks, uma por branch/aluno: `feature/DEV-001`, `feature/DEV-002`, `feature/DEV-003` e `feature/DEV-004`. **As tasks têm dependência entre si** — não é possível implementar uma etapa sem que a anterior já esteja concluída e mesclada na `main`, então sigam a ordem abaixo.

### Passo 1 — `feature/DEV-001`: Modelagem da classe `Usuario`

Não depende de nenhuma outra etapa. É a base de tudo o que vem depois.

- Definir os atributos `nome`, `idade` e `cpf` (privados), escolhendo o tipo de cada um.
- Criar um construtor que receba e inicialize os três atributos.
- Criar os métodos acessores (getters e setters) para cada atributo.
- Não implementar nenhuma lógica de negócio aqui — `Usuario` é só o modelo de dados.

### Passo 2 — `feature/DEV-002`: Cadastro de usuário

Depende do **Passo 1** já estar mesclado na `main` (precisa da classe `Usuario` pronta).

- Em `UsuarioService`, criar uma estrutura interna para armazenar os usuários em memória (ex.: uma lista).
- Implementar o método responsável por cadastrar um novo usuário, adicionando-o a essa estrutura.
- Em `Main.java`, no bloco `//CRIAR USUARIO`, instanciar o `UsuarioService`, criar alguns objetos `Usuario` e cadastrá-los através do método criado.

### Passo 3 — `feature/DEV-003`: Listagem e filtro de maiores de idade

Depende dos **Passos 1 e 2** já estarem mesclados na `main` (precisa do modelo `Usuario` e da estrutura de armazenamento criada no `UsuarioService`).

- Implementar em `UsuarioService` o método que lista todos os usuários cadastrados.
- Implementar em `UsuarioService` o método que filtra e retorna apenas os usuários maiores de idade (idade >= 18).
- Em `Main.java`, usar esses métodos nos blocos `//LISTAR USUARIOS CADASTRADOS` e `//FILTRAR POR USUARIOS MAIORES DE IDADE`, exibindo o resultado no console.

### Passo 4 — `feature/DEV-004`: Busca por CPF

Depende dos **Passos 1 e 2** já estarem mesclados na `main` (mesma dependência do Passo 3 — pode ser desenvolvido em paralelo ao Passo 3).

- Implementar em `UsuarioService` o método que busca um usuário pelo CPF na estrutura em memória.
- Tratar o caso de o CPF não ser encontrado.
- Em `Main.java`, usar esse método no bloco `//BUSCAR POR USUARIO ATRAVES DO CPF`, exibindo o resultado no console.

## Fluxo de trabalho recomendado

1. Cada aluno desenvolve sua parte na branch correspondente à sua task.
2. Ao concluir, abrir um Pull Request para a `main`.
3. Antes de começar sua task, garantir que a branch das tasks anteriores (das quais a sua depende) já foi mesclada na `main`, e atualizar a sua branch a partir da `main`.
4. Como não há testes automatizados ainda, validem manualmente rodando o `Main.java` e observando a saída no console.

## Boas práticas

- Mantenham os atributos de `Usuario` privados, expondo-os apenas pelos métodos acessores (encapsulamento).
- Sigam as convenções de nomenclatura do Java (camelCase para métodos e atributos, PascalCase para classes).
