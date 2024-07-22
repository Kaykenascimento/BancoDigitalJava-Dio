package main;

import domain.Conta;
import domain.Genero;
import regrasNegocio.helperTransaction;
import regrasNegocio.helperValidation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TimeZone;

public class Main {
    public static void main(String[] args) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));

        helperTransaction transacaoHelper = new helperTransaction();

        List<Conta> contas = new ArrayList<Conta>();

        String opcao = "";

        boolean sair = false;

        try (Scanner teclado = new Scanner(System.in)) {
            System.out.println("*------------------------------------------------------------*");
            System.out.println("|Bem vindo ao JavaBank!                                        |");
            System.out.println("*------------------------------------------------------------*");
            do {
                System.out.println("*------------------------------------------------------------*");
                System.out.println("|0 - Sair                                                    |");
                System.out.println("|1 - Criar Conta                                             |");
                System.out.println("|2 - Listar Todas as Contas                                  |");
                System.out.println("|3 - Exibir Dados Bancários pelo CPF                         |");
                System.out.println("|4 - Visualizar Saldo Pelo CPF                               |");
                System.out.println("|5 - Solicitar Cartão de Crédito                             |");
                System.out.println("|6 - Sacar                                                   |");
                System.out.println("|7 - Depositar                                               |");
                System.out.println("|8 - Transferir                                              |");
                System.out.println("*------------------------------------------------------------*");

                System.out.print("Informe a opção: ");
                opcao = teclado.nextLine();

                switch (opcao) {
                    case "0":
                        System.out.println("*------------------------------------------------------------*");
                        System.out.println("|ENCERRADANDO APLICAÇÃO...                                   |");
                        System.out.println("*------------------------------------------------------------*");
                        sair = true;

                        break;
                    case "1":
                        System.out.println("-> CRIAR CONTA");

                        Conta c1 = new Conta();
                        System.out.print("Informe o nome da pessoa: ");
                        c1.getPessoa().setNome(teclado.nextLine());

                        System.out.print("Informe o CPF da pessoa: ");
                        c1.getPessoa().setCpf(teclado.nextLine());

                        System.out.print("Informe o genêro da pessoa (Masculino ou Feminino): ");
                        c1.getPessoa().setGenero(Genero.modificarStringToGenero(teclado.nextLine()));

                        System.out.print("Informe a data de nascimento da pessoa: ");
                        String dataNascimento = teclado.nextLine();

                        if (!dataNascimento.isEmpty()) {
                            c1.getPessoa().setDataNascimento(simpleDateFormat.parse(dataNascimento));
                        }

                        if (helperValidation.verificarPossibildidadeCadastro(c1)) {
                            contas.add(c1);

                            System.out.println("Conta criada com sucesso!");
                        }

                        break;
                    case "2":
                        System.out.println("-> LISTAR CONTAS");

                        if (!contas.isEmpty()) {
                            for (Conta conta : contas) {
                                System.out.println("Número:" + conta.getNumero() + "Agência: " + conta.getCodigo());
                            }
                        }

                        break;
                    case "3":
                        System.out.println("-> DADOS BANCÁRIOS");

                        System.out.print("Informe o CPF da pessoa: ");
                        String cpfDados = teclado.nextLine();

                        if (helperValidation.verificarExistenciaConta(contas, cpfDados)) {
                            for (Conta conta : contas) {
                                if (conta.getPessoa().getCpf().equals(cpfDados)) {
                                    transacaoHelper.exibirDadosBancarios(conta);
                                }
                            }
                        }

                        break;
                    case "4":
                        System.out.println("-> SALDO");

                        System.out.print("Informe o CPF da pessoa: ");
                        String cpfSaldo = teclado.nextLine();

                        if (helperValidation.verificarExistenciaConta(contas, cpfSaldo)) {
                            for (Conta conta : contas) {
                                if (conta.getPessoa().getCpf().equals(cpfSaldo)) {
                                    System.out.println("O saldo é de: " + conta.getSaldo());
                                }
                            }
                        }
                        break;
                    case "5":
                        System.out.println("-> SOLICITAR CARTÃO");

                        System.out.print("Informe o CPF da pessoa: ");
                        String cpfCartao = teclado.nextLine();

                        if (helperValidation.verificarExistenciaConta(contas, cpfCartao)) {
                            for (Conta conta : contas) {
                                if (conta.getPessoa().getCpf().equals(cpfCartao)) {
                                    helperTransaction.solicitarCartaoCredito(conta);
                                }
                            }
                        }

                        break;
                    case "6":
                        System.out.println("-> SAQUE");

                        System.out.print("Informe o CPF da pessoa: ");
                        String cpfSacar = teclado.nextLine();

                        if (helperValidation.verificarExistenciaConta(contas, cpfSacar)) {
                            String valor;

                            System.out.print("Informe o valor do saque: ");
                            valor = teclado.nextLine();

                            for (Conta conta : contas) {
                                if (conta.getPessoa().getCpf().equals(cpfSacar)) {
                                    helperTransaction.sacarDinheiro(conta, Double.parseDouble(valor));
                                }
                            }
                        }

                        break;
                    case "7":
                        System.out.println("-> DEPÓSITO");

                        System.out.print("Informe o CPF da pessoa: ");
                        String cpfDeposito = teclado.nextLine();

                        if (helperValidation.verificarExistenciaConta(contas, cpfDeposito)) {
                            String valor;

                            System.out.print("Informe o valor do depósito: ");
                            valor = teclado.nextLine();

                            for (Conta conta : contas) {
                                if (conta.getPessoa().getCpf().equals(cpfDeposito)) {
                                    helperTransaction.depositarDinheiro(conta, Double.parseDouble(valor));
                                }
                            }
                        }

                        break;
                    case "8":
                        System.out.println("-> TRANSFERÊNCIA");

                        System.out.print("Informe o CPF do depositante: ");
                        String cpfDepositante = teclado.nextLine();

                        System.out.print("Informe o CPF do recebedor: ");
                        String cpfRecebedor = teclado.nextLine();

                        if (helperValidation.verificarExistenciaConta(contas, cpfDepositante)
                                && helperValidation.verificarExistenciaConta(contas, cpfRecebedor)) {
                            Conta contaDepositante = null, contaRecebedor = null;
                            String valor;

                            System.out.print("Informe o valor do depósito: ");
                            valor = teclado.nextLine();

                            for (Conta conta : contas) {
                                if (conta.getPessoa().getCpf().equals(cpfDepositante)) {
                                    contaDepositante = conta;
                                } else if (conta.getPessoa().getCpf().equals(cpfRecebedor)) {
                                    contaRecebedor = conta;
                                }
                            }

                            helperTransaction.transferirDinheiro(contaDepositante, contaRecebedor, Double.parseDouble(valor));
                        }

                        break;
                    default:
                        break;
                }
            } while (!sair);

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}