public class Pessoa {
    Integer id;
    String sexo;
    Integer idade;
    Boolean gestante;
    Boolean lactante;
    Boolean necessidadeEspecial;
    Integer prioridade;

    public Pessoa(Integer id, String sexo, Integer idade, Boolean gestante, Boolean lactante, Boolean necessidadeEspecial) {
        this.id = id;
        this.sexo = sexo;
        this.idade = idade;
        this.gestante = gestante;
        this.lactante = lactante;
        this.necessidadeEspecial = necessidadeEspecial;
        this.prioridade = calcularPrioridade();
    }

    public int calcularPrioridade(){
        if (gestante || lactante) return 3;
        if (necessidadeEspecial) return 2;
        if (idade >= 60) return 1;
        return 0;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "id=" + id +
                ", sexo='" + sexo + '\'' +
                ", idade=" + idade +
                ", gestante=" + gestante +
                ", lactante=" + lactante +
                ", necessidadeEspecial=" + necessidadeEspecial +
                ", prioridade=" + prioridade +
                '}';
    }
}
