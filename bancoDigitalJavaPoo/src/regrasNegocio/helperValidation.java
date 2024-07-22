package regrasNegocio;

import domain.Conta;

import java.util.List;

public class helperValidation {

    public static boolean verificarPossibildidadeCadastro(Conta conta) {
        if(!verificarDadosCliente(conta)) {
            System.out.println("Não foi possível cadastrar a conta!");
            return false;
        }

        return true;
    }

    public static boolean verificarDadosCliente(Conta conta) {
        if(conta == null) {
            System.out.println("Conta não foi preenchida.");

            return false;
        }

        if(conta.getPessoa().getNome().isEmpty()) {
            System.out.println("Nome não foi preenchido.");

            return false;
        }

        if(conta.getPessoa().getCpf().isEmpty()) {
            System.out.println("CPF não foi preenchido.");

            return false;
        }

        if(conta.getPessoa().getGenero().isEmpty()) {
            System.out.println("Gênero não foi preenchido.");

            return false;
        }

        if(conta.getPessoa().getDataNascimento() == null) {
            System.out.println("Data de Nascimento não foi preenchida.");

            return false;
        }

        if(conta.getNumero().isEmpty()) {
            System.out.println("Nº da Conta não foi preenchido.");

            return false;
        }

        return true;
    }

    public static boolean verificarPossibilidadeTransacaoBancaria(Conta conta, double valor) {
        if(valor <= conta.getSaldo()) {
            return true;
        }else{
            System.out.println("Não foi possível realizar a operação, verifique o valor informado!");

            return false;
        }
    }

    public static boolean verificarPossibilidadeDeposito(double valor) {
        if(valor > 0) {
            return true;
        } else {
            System.out.println("Não foi possível realizar o depósito, verifique o valor informado!");

            return false;
        }
    }

    public static boolean verificarPossibilidadeCartao(Conta conta) {
        if(conta.getSaldo() > 50) {
            return true;
        }else {
            System.out.println("Não é possível solicitar um cartão! Verifique o seu tempo de conta.");

            return false;
        }
    }

    public static boolean verificarExistenciaConta (List<Conta> contas, String cpf) {
        if(!contas.isEmpty()) {
            for (Conta conta : contas) {
                if(conta.getPessoa().getCpf().equals(cpf)) {
                    return true;
                }
            }
        }

        System.out.println("O CPF não foi encontrado");

        return false;
    }
}
