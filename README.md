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
| André  | `feature/DEV-004` | Validação de nome, idade e CPF no cadastro    |
| Chris   | `feature/DEV-005` | Impedir cadastro com CPF duplicado            |
| David   | `feature/DEV-006` | Impedir cadastro de menores de 5 anos         |
| David       | `feature/DEV-007` | Estrutura do cartão de transporte público     |
| André       | `feature/DEV-008` | Interface `ValidaCartao` e `CartaoEstudante`  |
| Chris       | `feature/DEV-009` | `CartaoInfantil`                              |

**As tarefas têm dependência entre si** — a etapa seguinte precisa da anterior já mesclada na `main`. Siga a ordem: DEV-001 → DEV-002 → DEV-003 → DEV-004 → DEV-005 → DEV-006 → DEV-007 → DEV-008 → DEV-009. Antes de começar, confirme que as tarefas anteriores já foram mescladas na `main` e atualize sua branch (veja [Atualizando sua branch](#atualizando-sua-branch-com-a-main)).

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

### Tarefa 4 — `feature/DEV-004`: Validação de nome, idade e CPF (André)

- No cadastro de usuário (`UsuarioService`), rejeitar o cadastro quando:
  - o `nome` for vazio;
  - a `idade` for negativa ou maior que 150;
  - o `cpf` não tiver exatamente 11 dígitos numéricos.
- O usuário rejeitado **não** deve ser adicionado à lista.
- Em `Main.java`, tentar cadastrar usuários inválidos e exibir no console o motivo da rejeição.

### Tarefa 5 — `feature/DEV-005`: Impedir CPF duplicado (Chris)

Depende da **Tarefa 4** já estar mesclada na `main`.

- No cadastro de usuário, impedir que dois usuários tenham o mesmo `cpf`.
- Ao tentar cadastrar um CPF já existente, o cadastro deve devolver uma mensagem informando que o CPF já existe.
- Em `Main.java`, tentar cadastrar um usuário com CPF repetido e exibir a mensagem no console.

### Tarefa 6 — `feature/DEV-006`: Impedir cadastro de menores de 5 anos (David)

Depende da **Tarefa 5** já estar mesclada na `main`.

- No cadastro de usuário, impedir o cadastro de usuários com menos de 5 anos de idade.
- Ao tentar cadastrar um usuário nessa condição, o cadastro deve devolver uma mensagem informando o motivo da rejeição.
- Em `Main.java`, tentar cadastrar um usuário com menos de 5 anos e exibir a mensagem no console.

### Tarefa 7 — `feature/DEV-007`: Estrutura do cartão de transporte público (David)

Depende da **Tarefa 6** já estar mesclada na `main`.

- Criar os enums `TipoCartao` (`ESTUDANTE`, `IDOSO`, `COMUM`, `INFANTIL`) e `TipoUsuario` (`IDOSO`, `ADULTO`, `ADOLESCENTE`, `CRIANCA`) no package `model`.
- Criar a classe `Cartao` no package `model` com os atributos privados: `id` (`Long`), `nomeCartao` (`String`), `numeroCartao` (`String`), `usuario` (`Usuario`) e `tipoCartao` (`TipoCartao`), com construtor e getters/setters.
- Atualizar `Usuario` adicionando:
  - o atributo `tipoUsuario` (`TipoUsuario`), definido a partir da idade (ex.: menos de 12 = `CRIANCA`, 12 a 17 = `ADOLESCENTE`, 18 a 59 = `ADULTO`, 60 ou mais = `IDOSO`), recalculado quando a idade mudar;
  - a lista de cartões (`List<Cartao>`), iniciada vazia — relação de **1 usuário para N cartões**;
  - um método `adicionarCartao(Cartao)` que adiciona o cartão à lista e define o usuário no cartão (mantendo os dois lados em sincronia).
- O usuário **não é obrigado** a ter cartão: ele pode ser cadastrado sem nenhum e criar o cartão depois.
- Criar `CartaoService` (package `services`) com o método `criarCartao(Usuario, Cartao)`, que gera o `id` do cartão (um contador em memória), vincula o cartão ao usuário e devolve uma mensagem de sucesso (mesmo padrão de retorno em `String` do `UsuarioService`).
- Em `Main.java`, criar cartões para alguns usuários já cadastrados (não necessariamente todos) e exibir o resultado no console.

### Tarefa 8 — `feature/DEV-008`: Interface `ValidaCartao` e `CartaoEstudante` (André)

Depende da **Tarefa 7** já estar mesclada na `main`.

- Criar, no package `services`, a interface `ValidaCartao` apenas com a assinatura `String validar(Usuario usuario)`. O retorno é `null` quando o usuário está apto e a mensagem de erro quando não está.
- Criar a classe de serviço `CartaoEstudante`, que implementa `ValidaCartao`. No método `validar`, aplicar as regras:
  - o usuário só pode ter **um cartão** do tipo `ESTUDANTE`;
  - o usuário deve ter **15 anos ou mais**;
  - o `tipoUsuario` deve ser `ADOLESCENTE`.
- Se passar nas três, o usuário está apto. Caso contrário, devolver uma mensagem especificando qual foi o problema.
- Em `CartaoService`, usar o validador correspondente ao tipo do cartão (sugestão: um `Map<TipoCartao, ValidaCartao>`) antes de criar o cartão — é aqui que o polimorfismo é utilizado. Tipos sem validador (`COMUM` e `IDOSO`) são aceitos direto.
- Em `Main.java`, testar a criação de cartão `ESTUDANTE` com um usuário apto e com usuários que quebrem cada regra, exibindo as mensagens no console.

### Tarefa 9 — `feature/DEV-009`: `CartaoInfantil` (Chris)

Depende da **Tarefa 8** já estar mesclada na `main` (precisa da interface `ValidaCartao` e do `CartaoService`).

- Criar a classe de serviço `CartaoInfantil` no package `services`, implementando `ValidaCartao`. No método `validar`, aplicar as regras:
  - o `tipoUsuario` deve ser `CRIANCA`;
  - a idade deve estar **entre 5 e 8 anos** (inclusive);
  - o usuário não pode ter mais de **um cartão** do tipo `INFANTIL`.
- Se passar nas três, o usuário está apto. Caso contrário, devolver uma mensagem especificando qual foi o problema.
- Registrar o `CartaoInfantil` no `CartaoService` para o tipo `INFANTIL`.
- Em `Main.java`, testar a criação de cartão `INFANTIL` com uma criança apta e com usuários que quebrem cada regra, exibindo as mensagens no console.

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
