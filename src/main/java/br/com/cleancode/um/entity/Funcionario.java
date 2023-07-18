package main.java.br.com.cleancode.um.entity;

    /*
        Create by @Eleison Jr
     */


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Funcionario {

    private String          nome;
    private List<String> telefones;
    private String          endereco;
    private BigDecimal salario;
    private String          setor;
    private String          cargo;

    public static class Cargo {
        private Integer id;
        private String  descricao;
    }

    public static class Setor {
        private Integer id;
        private String  descricao;
    }

    public class FuncionarioTerceirizado {
        private String          nome;
        private List<String>    telefones;
        private String          endereco;
        private BigDecimal      salario;
        private String          setor;
        private String          cargo;
    }


    public static void reajusteSalario(Funcionario funcionarioTeste, BigDecimal valorReajuste) {
        if(funcionarioTeste instanceof Funcionario) {
            funcionarioTeste.salario = funcionarioTeste.salario.add(valorReajuste);
            System.out.println("O novo valor do salário do funcionário é de R$ "+ funcionarioTeste.salario);
        }
        else{
            System.out.println("Funcionario terceirizado não pode ter reajuste!");
        }
    }


    public static void main(String[] args) {
        try {

            Funcionario funcionario = new Funcionario();
            List<String> telefones = new ArrayList<String>();
            Cargo cargo = new Cargo();
            Setor setor = new Setor();
            setor.descricao = "DESENVOLVIMENTO";
            cargo.descricao = "JÚNIOR";
            telefones.add("6199999999");
            funcionario.nome = "João";
            funcionario.telefones = telefones;
            funcionario.cargo = cargo.descricao;
            funcionario.setor = setor.descricao;
            funcionario.endereco = "Rua da Lagosta";
            funcionario.salario = new BigDecimal(1000.00);
            funcionario.reajusteSalario(funcionario,new BigDecimal(300.00));

        }catch (RuntimeException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
