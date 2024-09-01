import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class FilaDeAtendimento {
    Deque<Pessoa> fila;
    Integer capacidade = 100;

    public FilaDeAtendimento() {
        this.fila = new ArrayDeque<>(capacidade);
    }

    public void adicionarPessoa(Pessoa pessoa) {
        fila.add(pessoa);
    }

    public void processarAtendimento() {
        LinkedList<Pessoa> filaNaoAtendida = new LinkedList<>();
        int totalAtendidos = 0;
        int[] atendimentosPorGrupo = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        for (int grupo = 0; grupo < 10; grupo++) {
            int atendimentos = atendimentosPorGrupo[grupo];
            for (int i = 0; i < atendimentos; i++) {
                Pessoa atendida = obterProximaPessoa();
                if (atendida != null) {
                    System.out.println("Atendida: " + atendida);
                    totalAtendidos++;
                } else {
                    break;
                }
            }
        }
        System.out.println("\nPessoas que não foram atendidas:");
        while (!fila.isEmpty()) {
            filaNaoAtendida.add(fila.poll());
        }

        for (Pessoa p : filaNaoAtendida) {
            System.out.println(p);
        }
    }

    private Pessoa obterProximaPessoa() {
        Pessoa proximaPessoa = null;
        for (Pessoa pessoa : fila) {
            if (proximaPessoa == null || pessoa.prioridade > proximaPessoa.prioridade) {
                proximaPessoa = pessoa;
            }
        }
        if (proximaPessoa != null) {
            fila.remove(proximaPessoa);
        }
        return proximaPessoa;
    }
}
