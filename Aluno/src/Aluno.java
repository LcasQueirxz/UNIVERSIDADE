public class Aluno {
    
    private String nome;
    private String ra;  // Registro Academico
    private double[] notas;  // armazenar as notas
    private double frequencia;  // Percentual de frequencia (presencial)
    private boolean ead;  // Indica se a disciplina e online/ead

    // construtor para disciplinas presenciais
    public Aluno(String nome, String ra, double[] notas, double frequencia) {
        this.nome = nome;
        this.ra = ra;
        this.notas = notas;
        this.frequencia = frequencia;
        this.ead = false;  // presencial por padrao
    }
    
    // construtor para disciplinas ead (sem presenca)
    public Aluno(String nome, String ra, double[] notas) {
        this.nome = nome;
        this.ra = ra;
        this.notas = notas;
        this.ead = true;  // ead
    }

    public Double calcularMediaFinal() {
        int quantidadeNotas = notas.length;
        double mediaFinal = 0.0;
        if (quantidadeNotas == 2) {
            // Media aritmetica para 2 notas
            mediaFinal = (notas[0] + notas[1]) / 2;
        } else if (quantidadeNotas == 3) {
            mediaFinal = (notas[0] * 1 + notas[1] * 2 + notas[2] * 4) / 7;
        } else if (quantidadeNotas == 4) {
            // Calculo com pesos para 4 notas
            mediaFinal = (notas[0] * 0.15) + (notas[1] * 0.30) + (notas[2] * 0.10) + (notas[3] * 0.45);
        }
        return mediaFinal;
    }

    // Metodo para verificar se o aluno foi aprovado ou reprovado
    public String verificarSituacao() {
        double mediaFinal = calcularMediaFinal();
        if (ead) {
            // Para EAD, apenas a nota e considerada
            if (mediaFinal >= 5) {
                return "Aprovado";
            } else {
                return "Reprovado";
            }
        } else {
            // Para disciplinas presenciais, considera a nota e a frequencia
            if (mediaFinal >= 5) {
                return "Aprovado";
            } else {
                return "Reprovado";
            }				
        }
    }

    // Metodo para imprimir os dados do aluno
    public void imprimirDados() {
        System.out.println("Nome: " + nome);
        System.out.println("RA: " + ra);
        System.out.println("Nota Final: " + calcularMediaFinal());
        System.out.println("Situacao: " + verificarSituacao());
    }

    public static void main(String[] args) {
        // Teste com 2 notas (presencial)
        double[] notas1 = {7.0, 8.0};
        Aluno aluno1 = new Aluno("Joao Silva", "12345", notas1, 80);
        aluno1.imprimirDados();

        // Teste com 3 notas (EAD)
        double[] notas2 = {6.0, 7.0, 8.0};
        Aluno aluno2 = new Aluno("Maria Souza", "67890", notas2, 80);
        aluno2.imprimirDados();

        // Teste com 4 notas (presencial)
        double[] notas3 = {6.0, 7.0, 8.0, 9.0};
        Aluno aluno3 = new Aluno("Carlos Pirico", "11223", notas3, 60);
        aluno3.imprimirDados();
    }
}
