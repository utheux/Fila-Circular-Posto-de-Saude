import java.util.Random;

public class Main {
    public static void main(String[] args) {
        FilaDeAtendimento fila = new FilaDeAtendimento();
        Random random = new Random();
        int idCounter = 1;

        for (int i = 0; i < 100; i++) {
            int idade = random.nextInt(80);
            boolean gestante = random.nextBoolean();
            boolean lactante = random.nextBoolean();
            boolean necessidadeEspecial = random.nextBoolean();
            String sexo = random.nextBoolean() ? "Feminino" : "Masculino";
            fila.adicionarPessoa(new Pessoa(idCounter++, sexo, idade, gestante, lactante, necessidadeEspecial));
        }


        fila.processarAtendimento();
    }
}
