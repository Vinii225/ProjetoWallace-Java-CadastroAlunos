import java.util.Scanner;

// HUMBERTO NASCIMENTO
// Classe Disciplina: representa cada disciplina do aluno como um nó em uma lista encadeada
class Disciplina {
    String nome;        // Nome da disciplina
    Disciplina proxima; // Referência para a próxima disciplina na lista

    public Disciplina(String nome) {
        this.nome = nome;   // Inicia o nome da disciplina
        this.proxima = null; // Inicialmente, não há próxima disciplina
    }
}

// Classe Aluno: representa um aluno com RGM, nome e uma lista encadeada de disciplinas
class Aluno {
    int rgm;                      // RGM do aluno (identificador único)
    String nome;                  // Nome do aluno
    Disciplina primeiraDisciplina; // Referência para a primeira disciplina cadastrada

    public Aluno(int rgm, String nome) {
        this.rgm = rgm;               // Inicializa o RGM
        this.nome = nome;             // Inicializa o nome
        this.primeiraDisciplina = null; // Sem disciplina cadastrada inicialmente
    }

    // Adiciona uma disciplina à lista (inserção no início da lista encadeada)
    public void adicionarDisciplina(String nomeDisciplina) {
        Disciplina nova = new Disciplina(nomeDisciplina);
        nova.proxima = primeiraDisciplina; // A nova disciplina aponta para a antiga primeira
        primeiraDisciplina = nova;         // Atualiza a referência para a nova primeira disciplina
    }

    // VICTOR GABRIEL 
    // Exibe todas as disciplinas cadastradas para o aluno
    public void mostrarDisciplinas() {
        if (primeiraDisciplina == null) {
            System.out.println("   - Nenhuma disciplina cadastrada.");
        } else {
            Disciplina atual = primeiraDisciplina;
            while (atual != null) { // Percorre a lista enquanto houver disciplinas
                System.out.println("   - " + atual.nome); // Exibe o nome da disciplina
                atual = atual.proxima; // Avança para a próxima disciplina
            }
        }
    }
}


// Classe Principal: gerencia o cadastro de alunos e operações associadas
public class TrabalhoWallace {
    static final int MAX_ALUNOS = 60;            // Tamanho fixo em 60 alunos (lista sequencial)
    static Aluno[] alunos = new Aluno[MAX_ALUNOS]; // Array para armazenar os alunos
    static int totalAlunos = 0;                  // Contador de alunos cadastrados

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcao;

        // Loop principal do menu
        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Incluir aluno");
            System.out.println("2. Mostrar todos os alunos");
            System.out.println("3. Buscar aluno por RGM");
            System.out.println("4. Remover aluno por RGM");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine(); // Limpa o buffer

            // Executa a opção escolhida
            switch (opcao) {
                case 1 -> incluirAluno(sc);    // Cadastra um novo aluno (com disciplinas)
                case 2 -> mostrarAlunos();       // Exibe todos os alunos e suas disciplinas
                case 3 -> buscarAluno(sc);       // Procura um aluno pelo RGM
                case 4 -> removerAluno(sc);      // Remove um aluno pelo RGM
                case 5 -> System.out.println("Encerrando...");
                default -> System.out.println("Opção inválida!");
            }
        } while (opcao != 5);

        sc.close(); // Fecha o Scanner
    }

    // Método para incluir aluno (com inserção ordenada por RGM)
    public static void incluirAluno(Scanner sc) {
        if (totalAlunos >= MAX_ALUNOS) {
            System.out.println("Limite de alunos atingido!");
            return;
        }

        System.out.print("Digite o RGM do aluno: ");
        int rgm = sc.nextInt();
        sc.nextLine(); // Limpa o buffer
        System.out.print("Digite o nome do aluno: ");
        String nome = sc.nextLine();

        Aluno novoAluno = new Aluno(rgm, nome);

        
        // HUMBERTO NASCIMENTO
        // Cadastro interativo de disciplinas:
        // Pergunta "Mais disciplina?" e, se o usuário responder "s", solicita o nome da disciplina.
        while (true) {
            System.out.print("Mais disciplina? (s/n): ");
            String resposta = sc.nextLine();
            if (!resposta.equalsIgnoreCase("s")) break;

            System.out.print("Digite o nome da disciplina: ");
            String nomeDisciplina = sc.nextLine();
            novoAluno.adicionarDisciplina(nomeDisciplina);
        }
        
        // Inserção ordenada pelo RGM:
        // Encontra a posição correta para manter o array ordenado
        int pos = 0;
        while (pos < totalAlunos && alunos[pos].rgm < rgm) {
            pos++;
        }
        // Desloca os elementos para a direita para abrir espaço na posição encontrada
        for (int i = totalAlunos; i > pos; i--) {
            alunos[i] = alunos[i - 1];
        }
        alunos[pos] = novoAluno;
        totalAlunos++;

        System.out.println("Aluno adicionado com sucesso!");
    }


    // VINICIUS ARES
    // Método para exibir todos os alunos e suas disciplinas
    public static void mostrarAlunos() {
        if (totalAlunos == 0) {
            System.out.println("Nenhum aluno cadastrado.");
            return;
        }

        System.out.println("Lista de alunos:");
        for (int i = 0; i < totalAlunos; i++) {
            Aluno aluno = alunos[i];
            System.out.println("RGM: " + aluno.rgm + ", Nome: " + aluno.nome);
            System.out.println("Disciplinas:");
            aluno.mostrarDisciplinas();
        }
    }

    // Método para buscar um aluno pelo RGM e exibir seus dados
    public static void buscarAluno(Scanner sc) {
        System.out.print("Digite o RGM do aluno a ser buscado: ");
        int rgm = sc.nextInt();

        for (int i = 0; i < totalAlunos; i++) {
            if (alunos[i].rgm == rgm) {
                Aluno aluno = alunos[i];
                System.out.println("Aluno encontrado: RGM: " + aluno.rgm + ", Nome: " + aluno.nome);
                System.out.println("Disciplinas:");
                aluno.mostrarDisciplinas();
                return;
            }
        }

        System.out.println("Aluno não encontrado.");
    }

    // Método para remover um aluno pelo RGM
    public static void removerAluno(Scanner sc) {
        System.out.print("Digite o RGM do aluno a ser removido: ");
        int rgm = sc.nextInt();

        for (int i = 0; i < totalAlunos; i++) {
            if (alunos[i].rgm == rgm) {
                // Desloca os elementos para a esquerda para sobrescrever o aluno removido
                for (int j = i; j < totalAlunos - 1; j++) {
                    alunos[j] = alunos[j + 1];
                }
                alunos[--totalAlunos] = null; // Remove a última posição e decrementa o contador
                System.out.println("Aluno removido com sucesso!");
                return;
            }
        }

        System.out.println("Aluno não encontrado.");
    }
}