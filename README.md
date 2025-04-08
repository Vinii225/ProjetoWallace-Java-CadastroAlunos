# 🎓 MiniProjeto - Sistema de Cadastro de Alunos e Disciplinas, Proposto por Prof. Wallace Sartori
# 👨‍🎓 Alunos: Vinícius Ares Monteiro de Lima, Victor Gabriel de Melo, Humberto Nascimento, Alexandre Toscano.

Este é um projeto em Java que implementa um sistema de cadastro de alunos e suas respectivas disciplinas. O sistema utiliza conceitos de arrays e lista encadeada dinâmica para gerenciar os dados.

## ✨ Funcionalidades

- **➕ Incluir Aluno**: Permite cadastrar um novo aluno com RGM, nome e disciplinas associadas.
- **📋 Mostrar Todos os Alunos**: Exibe a lista de todos os alunos cadastrados e suas disciplinas.
- **🔍 Buscar Aluno por RGM**: Localiza um aluno específico pelo seu RGM e exibe suas informações.
- **🗑️ Remover Aluno por RGM**: Remove um aluno específico pelo seu RGM.
- **📜 Menu Interativo**: Interface de texto para navegar pelas funcionalidades.

## 🛠️ Estrutura do Projeto

### 📂 Classes e Métodos

#### 📘 Classe `Disciplina`
- **Atributos**:
  - `📄 String nome`: Nome da disciplina.
  - `🔗 Disciplina proxima`: Referência para a próxima disciplina na lista encadeada.
- **Construtor**:
  - `🛠️ Disciplina(String nome)`: Inicializa o nome da disciplina e define a próxima como `null`.

#### 📗 Classe `Aluno`
- **Atributos**:
  - `🆔 int rgm`: Identificador único do aluno.
  - `📛 String nome`: Nome do aluno.
  - `📚 Disciplina primeiraDisciplina`: Referência para a primeira disciplina cadastrada.
- **Construtor**:
  - `🛠️ Aluno(int rgm, String nome)`: Inicializa o RGM, nome e define a lista de disciplinas como vazia.
- **Métodos**:
  - `➕ void adicionarDisciplina(String nomeDisciplina)`: Adiciona uma nova disciplina à lista encadeada.
  - `📋 void mostrarDisciplinas()`: Exibe todas as disciplinas cadastradas para o aluno.

#### 📕 Classe `TrabalhoWallace` (Principal)
- **Atributos**:
  - `🔢 static final int MAX_ALUNOS`: Limite máximo de alunos (60).
  - `📂 static Aluno[] alunos`: Array para armazenar os alunos.
  - `📊 static int totalAlunos`: Contador de alunos cadastrados.
- **Métodos**:
  - `▶️ public static void main(String[] args)`: Método principal que gerencia o menu interativo.
  - `➕ public static void incluirAluno(Scanner sc)`: Adiciona um novo aluno ao sistema.
  - `📋 public static void mostrarAlunos()`: Exibe todos os alunos cadastrados e suas disciplinas.
  - `🔍 public static void buscarAluno(Scanner sc)`: Busca um aluno pelo RGM e exibe suas informações.
  - `🗑️ public static void removerAluno(Scanner sc)`: Remove um aluno pelo RGM.