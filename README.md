# Sistema de Usuários

Projeto de estudo para praticar Programação Orientada a Objetos em Java. A estrutura base do projeto já existe — cada integrante deve **complementar** o que já está criado, seguindo as regras de negócio e a sequência de desenvolvimento descritas abaixo.

Repositório: https://github.com/lummustech/sistema-usuarios.git

## Regras de negócio

O sistema terá 3 etapas e deve funcionar tudo **em memória** (sem persistência em banco de dados ou arquivo — os dados existem apenas durante a execução do programa):

1. Modelar a classe `Usuario` com os atributos `nome`, `idade` e `cpf`
2. Cadastrar um usuário
3. Listar os usuários cadastrados, com filtro de maiores de idade

### Atributos do usuário

- `nome`
- `idade`
- `cpf`

O tipo de cada atributo fica a critério de quem for implementar a classe `Usuario`.

## Estrutura atual do projeto

```
src/main/java/org/sistema/
├── Main.java                     # ponto de entrada, com comentários indicando onde cada regra deve ser acionada
├── model/Usuario.java            # package onde deve ficar a classe Usuario
└── services/UsuarioService.java  # classe que deve conter a regra de negócio
```

## Divisão das tarefas

Cada pessoa fica responsável por **uma tarefa**, desenvolvida na sua própria branch:

| Responsável | Branch            | Tarefa                                        |
|-------------|-------------------|-----------------------------------------------|
| Chris       | `feature/DEV-001` | Modelagem da classe `Usuario`                 |
| André       | `feature/DEV-002` | Cadastro de usuário                           |
| David       | `feature/DEV-003` | Listagem e filtro de maiores de idade         |

**As tarefas têm dependência entre si** — a etapa seguinte precisa da anterior já mesclada na `main`. Siga a ordem: DEV-001 → DEV-002 → DEV-003. Antes de começar, confirme que as tarefas anteriores já foram mescladas na `main` e atualize sua branch (veja [Atualizando sua branch](#atualizando-sua-branch-com-a-main)).

### Tarefa 1 — `feature/DEV-001`: Modelagem da classe `Usuario` (Chris)

Não depende de nenhuma outra etapa. É a base de tudo o que vem depois.

- Definir os atributos `nome`, `idade` e `cpf` (privados), escolhendo o tipo de cada um.
- Criar um construtor que receba e inicialize os três atributos.
- Criar os métodos acessores (getters e setters) para cada atributo.
- Não implementar nenhuma lógica de negócio aqui — `Usuario` é só o modelo de dados.
- Instanciar um usuário na classe `Main`.

### Tarefa 2 — `feature/DEV-002`: Cadastro de usuário (André)

Depende da **Tarefa 1** já estar mesclada na `main` (precisa da classe `Usuario` pronta).

- Criar a classe `UsuarioService` no seu devido package, criar uma estrutura interna para armazenar os usuários em memória (ex.: uma lista).
- Chamar essa classe de serviço na main para fazer o devido cadastro dos usuários já criados na main
- Usar uma ferramenta de laço para exibir os nomes dos usuários cadastrados.

### Tarefa 3 — `feature/DEV-003`: Listagem e filtro de maiores de idade (David)

Depende das **Tarefas 1 e 2** já estarem mescladas na `main` (precisa do modelo `Usuario` e da estrutura de armazenamento criada no `UsuarioService`).

- Implementar em `UsuarioService` o método que filtra e retorna apenas os usuários maiores de idade (idade >= 18).
- Em `Main.java`, usar o método `//FILTRAR POR USUARIOS MAIORES DE IDADE`, exibindo o resultado no console com o nome do usuário maior de idade.

## Git e GitHub

### O que você precisa

- Uma conta no [GitHub](https://github.com) e acesso ao repositório (peça ao Gustavo para adicionar você como colaborador, se necessário).
- [Git](https://git-scm.com/downloads) instalado. Confira com:

  ```bash
  git --version
  ```

- JDK e uma IDE (ex.: IntelliJ IDEA) para rodar o projeto.
- Configurar seu nome e e-mail no Git (apenas na primeira vez):

  ```bash
  git config --global user.name "Seu Nome"
  git config --global user.email "seu-email@exemplo.com"
  ```

### 1. Clonar o projeto

```bash
git clone https://github.com/lummustech/sistema-usuarios.git
cd sistema-usuarios
```

### 2. Acessar a branch da sua tarefa

As branches já existem no repositório. Para listar e entrar na sua:

```bash
git fetch origin
git branch -a                      # lista todas as branches
git checkout feature/DEV-00X       # troque X pelo número da sua tarefa
```

Exemplos:

```bash
git checkout feature/DEV-001       # Chris
git checkout feature/DEV-002       # André
git checkout feature/DEV-003       # David
```

Confirme que está na branch certa:

```bash
git branch --show-current
```

### 3. Desenvolver, commitar e enviar

Depois de implementar a sua tarefa, valide manualmente rodando o `Main.java` e observando a saída no console. Em seguida:

```bash
git status                                   # veja o que foi alterado
git add .                                    # adiciona as alterações
git commit -m "DEV-00X: descrição curta do que foi feito"
git push origin feature/DEV-00X              # envia a branch para o GitHub
```

### Atualizando sua branch com a `main`

Se a tarefa da qual você depende foi mesclada na `main`, traga essas mudanças para a sua branch **antes** de começar:

```bash
git checkout feature/DEV-00X
git pull origin main
```

Se houver conflitos, resolva-os na IDE, depois faça `git add .` e `git commit`.

### 4. Abrir o Pull Request para a `main` (pelo GitHub)

O PR é aberto direto no site do GitHub, sem linha de comando:

1. Acesse https://github.com/lummustech/sistema-usuarios.
2. Após o `git push`, o GitHub mostra um banner amarelo *"feature/DEV-00X had recent pushes"* com o botão **Compare & pull request**. Clique nele.
   - Se o banner não aparecer: abra a aba **Pull requests** → **New pull request**.
3. Confira os campos de branch:
   - **base:** `main`
   - **compare:** `feature/DEV-00X` (a sua branch)
4. Preencha o **título** (ex.: `DEV-002: Cadastro de usuário`) e uma **descrição** curta do que foi implementado.
5. Clique em **Create pull request**.
6. Avise o Gustavo para revisar. Após a aprovação, o PR será mesclado (**Merge pull request**) na `main`.

## Fluxo de trabalho resumido

1. Clonar o projeto (uma única vez).
2. Mudar para a branch da sua tarefa.
3. Garantir que as tarefas anteriores já estão na `main` e atualizar sua branch.
4. Implementar a tarefa e validar rodando o `Main.java`.
5. `git add`, `git commit` e `git push` na sua branch.
6. Abrir o Pull Request para a `main` no GitHub.

## Boas práticas

- Mantenha os atributos de `Usuario` privados, expondo-os apenas pelos métodos acessores (encapsulamento).
- Siga as convenções de nomenclatura do Java (camelCase para métodos e atributos, PascalCase para classes).
- Trabalhe somente na sua branch; nunca faça push direto na `main`.
- Faça commits pequenos, com mensagens que descrevam o que mudou.
