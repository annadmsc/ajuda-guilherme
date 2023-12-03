package com.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.sql.ClientInfoStatus;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;




public class Main {

    private static AgenciaDAO agenciaDAO = new AgenciaDAO();
    private static ClienteDAO clienteDAO = new ClienteDAO();
    private static ContaDAO contaDAO = new ContaDAO();
    private static Tipos_contaDAO tipos_conta = new Tipos_contaDAO();
    private static ConexaoOperacao operacao = new ConexaoOperacao();
    private static ConexaoCartao cartao = new ConexaoCartao();



    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        int opcao = 0;

        while(opcao != 9){
            Menu();
            try{
                opcao = scan.nextInt();
                int opcaoTabela;
                switch (opcao){
                    case 1:
                        opcaoTabela = 0;
                        Menu2();
                        try{
                            opcaoTabela = scan.nextInt();
                            switch (opcaoTabela){
                                case 1:
                                    System.out.println("Digite o ID do CLiente:");
                                    String idCliente1 = scan.next();
                                    scan.nextLine();
                                    System.out.println("Digite o nome do Cliente");
                                    String nome = scan.nextLine();
                                    System.out.println("Digite a cidade do Cliente:");
                                    String cidade = scan.nextLine();
                                    System.out.println("Digite o número de telefone do Cliente");
                                    String telefone = scan.next();
                                    scan.nextLine();
                                    System.out.println("Digite a profissao do cliente");
                                    String profissao = scan.nextLine();
                                    System.out.println("Digite a data de nascimento do Cliente (yyyy-MM-dd):");
                                    String dataNascimentoStr = scan.nextLine();
                                    Date datanascimento = null;
                                    try {
                                        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                                        datanascimento = format.parse(dataNascimentoStr);
                                    } catch (ParseException e) {
                                        System.out.println("Coloque em formato de data");
                                        break;
                                    }

                                    clienteDAO.inserir(idCliente1, nome, cidade, telefone, profissao, (java.sql.Date) datanascimento);
                                    break;
                                case 2:
                                   clienteDAO.retornarTodos();
                                    break;
                                case 3:
                                    System.out.println("Digite o Id que deseja alterar");
                                    String idCliente2 = scan.nextLine();
                                    System.out.println("Qual coluna voce deseja alterar?");
                                    String coluna = scan.nextLine();
                                    System.out.println("Que valor você quer substituir?");
                                    String valorStr = scan.nextLine();
                                    try{
                                        Date data = new Date(2022,01,01);
                                        try {
                                            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                                            data = format.parse(valorStr);
                                            clienteDAO.alterar(idCliente2, String.valueOf(data), coluna);
                                        } catch (ParseException e) {
                                            System.out.println("Coloque em formato de data");
                                            break;
                                        }
                                    } catch (Exception Error){
                                        continue;
                                    }
                                    clienteDAO.alterar(idCliente2, valorStr, coluna);
                                    break;
                                case 4:
                                    System.out.println("Qual coluna você deseja usar como parametro?");
                                    String colunaExluir = scan.nextLine();
                                    System.out.println("Que valor da coluna?");
                                    String valorColuna = scan.nextLine();
                                    clienteDAO.remover(colunaExluir, valorColuna);
                                    break;
                                default:
                                    System.out.println("Coloque um inteiro entre 1 e 4");
                            }
                        } catch (Exception Error){
                            System.out.println("Insira um valor númerico");
                        }
                        break;
                    case 2:
                        opcaoTabela = 0;
                        Menu2();
                        try{
                            opcaoTabela = scan.nextInt();
                            switch (opcaoTabela){
                                case 1:
                                    System.out.println("Digite o ID da Agencia:");
                                    String idAgencia1 = scan.nextLine();
                                    scan.nextLine();
                                    System.out.println("Digite o nome da Agencia");
                                    String nome = scan.nextLine();
                                    System.out.println("Digite a cidade da Agencia:");
                                    String cidade = scan.nextLine();
                                    agenciaDAO.inserir(idAgencia1, nome, cidade);
                                    break;
                                case 2:
                                    agenciaDAO.retornarTodos();
                                    break;
                                case 3:
                                    System.out.println("Digite o Id que deseja alterar");
                                    String idAgencia2 = scan.nextLine();
                                    System.out.println("Qual coluna voce deseja alterar?");
                                    String coluna = scan.nextLine();
                                    System.out.println("Que valor você quer substituir?");
                                    String valorStr = scan.nextLine();
                                    agenciaDAO.alterar(idAgencia2, valorStr, coluna);
                                    break;
                                case 4:
                                    System.out.println("Qual coluna você deseja usar como parametro?");
                                    String colunaExluir = scan.nextLine();
                                    System.out.println("Que valor da coluna?");
                                    String valorColuna = scan.nextLine();
                                    agenciaDAO.remover(colunaExluir, valorColuna);
                                    break;
                                default:
                                    System.out.println("Coloque um inteiro entre 1 e 4");
                            }
                        } catch (Exception Error){
                            System.out.println("Insira um valor númerico");
                        }
                        break;
                    case 3:
                        opcaoTabela = 0;
                        Menu2();
                        try{
                            opcaoTabela = scan.nextInt();
                            switch (opcaoTabela){
                                case 1:
                                    System.out.println("Digite o ID da Conta:");
                                    String idConta1 = scan.nextLine();
                                    scan.nextLine();
                                    System.out.println("Digite o ID do Cliente");
                                    String idCliente1 = scan.nextLine();
                                    System.out.println("Digite o ID da Agencia:");
                                    String idAgencia1 = scan.nextLine();
                                    System.out.println("Digite o saldo");
                                    Float saldo = scan.nextFloat();
                                    System.out.println("Digite a data de abertura da conta (yyyy-MM-dd):");
                                    String dataAberturaStr = scan.nextLine();
                                    Date dataAbertura = null;
                                    try {
                                        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                                        dataAbertura = format.parse(dataAberturaStr);
                                    } catch (ParseException e) {
                                        System.out.println("Coloque em formato de data");
                                        break;
                                    }
                                    System.out.println("Digite o tipo da Conta");
                                    int tipoConta = scan.nextInt();

                                    boolean ativa = true;

                                    contaDAO.inserir (idConta1, idCliente1, idAgencia1, saldo, (java.sql.Date) dataAbertura, tipoConta, ativa);
                                    break;
                                case 2:
                                   contaDAO.retornarTodos();
                                    break;
                                case 3:
                                    System.out.println("Digite o Id que deseja alterar");
                                    String idConta2 = scan.nextLine();
                                    System.out.println("Qual coluna voce deseja alterar?");
                                    String coluna = scan.nextLine();
                                    System.out.println("Que valor você quer substituir?");
//                                    String valorStr = scan.nextLine();
//                                    contaDAO.alterar(idConta2,valorStr, valorStr,coluna );
                                    break;
                                case 4:
                                    System.out.println("Qual coluna você deseja usar como parametro?");
                                    String colunaExluir = scan.nextLine();
                                    System.out.println("Que valor da coluna?");
                                    String valorColuna = scan.nextLine();
                                    contaDAO.remover(colunaExluir, valorColuna);
                                    break;
                                default:
                                    System.out.println("Coloque um inteiro entre 1 e 4");
                            }
                        } catch (Exception Error){
                            System.out.println("Insira um valor númerico");
                        }
                        break;
                    case 4:
                        opcaoTabela = 0;
                        Menu2();
                        try{
                            opcaoTabela = scan.nextInt();
                            switch (opcaoTabela){
                                case 1:
                                    System.out.println("Digite o ID do Tipo da Conta:");
                                    int idTipoConta1 = scan.nextInt();
                                    System.out.println("Digite o nome do Tipo");
                                    String nome = scan.nextLine();
                                    tipos_conta.inserir(idTipoConta1, nome);
                                    break;
                                case 2:
                                    tipos_conta.retornarTodos();
                                    break;
                                case 3:
                                    System.out.println("Digite o Id que deseja alterar");
                                    int idTipoConta2 = scan.nextInt();
                                    System.out.println("Qual coluna voce deseja alterar?");
                                    String coluna = scan.nextLine();
                                    System.out.println("Que valor você quer substituir?");
                                    String valorStr = scan.nextLine();
                                    tipos_conta.alterar(idTipoConta2, valorStr, coluna);
                                    break;
                                case 4:
                                    System.out.println("Qual coluna você deseja usar como parametro?");
                                    String colunaExluir = scan.nextLine();
                                    System.out.println("Que valor da coluna?");
                                    String valorColuna = scan.nextLine();
                                    tipos_conta.remover(colunaExluir, valorColuna);
                                    break;
                                default:
                                    System.out.println("Coloque um inteiro entre 1 e 4");
                            }
                        } catch (Exception Error){
                            System.out.println("Insira um valor númerico");
                        }
                        break;
                    case 5:
                        opcaoTabela = 0;
                        Menu2();
                        try{
                            opcaoTabela = scan.nextInt();
                            switch (opcaoTabela){
                                case 1:
                                    System.out.println("Digite o numero do cartao:");
                                    int idCartao1 = scan.nextInt();
                                    scan.nextLine();
                                    System.out.println("Digite o limite do Cartao");
                                    int limite = scan.nextInt();
                                    System.out.println("Digite o ID do Cliente:");
                                    String idCliente1 = scan.nextLine();

//                                    cartao.inserir = (idCartao1, limite, idCliente1);
                                    break;
                                case 2:
//                                    List<Cartao> cartao1 = CartaoDAO.buscar();
//                                    if (cartao1 != null) {
//                                        for (Cartao cartao2 : cartao1) {
//                                            System.out.println(cartao2);
//                                        }
//                                    }
                                    break;
                                case 3:
                                    System.out.println("Digite o Id que deseja alterar");
                                    String idCartao2 = scan.nextLine();
                                    System.out.println("Qual coluna voce deseja alterar?");
                                    String coluna = scan.nextLine();
                                    System.out.println("Que valor você quer substituir?");
                                    String valorStr = scan.nextLine();
//                                    cartao.alterar(idCartao2, valorStr, coluna);
                                    break;
                                case 4:
//                                    System.out.println("Qual coluna você deseja como parametro");
//                                    String colunaExluir = scan.nextLine();
//                                    System.out.println("Que valor da coluna?");
//                                    String valorColuna = scan.nextLine();
//                                    CartaoDAO.excluir(colunaExluir, valorColuna);
//                                    break;
                                default:
                                    System.out.println("Coloque um inteiro entre 1 e 4");
                            }
                        } catch (Exception Error){
                            System.out.println("Insira um valor númerico");
                        }
                        break;
                    case 6:
//                        List<Operacao> operacao1 = OperacaoDAO.buscar();
//                        if (Operacao1 != null) {
//                            for (Operacao operacao2 : operacao1) {
//                                System.out.println(operacao2);
//                            }
//                        }
                        break;
                    case 7:
//                        List<Emprestimo> emprestimo1 = ConexaoEmprestimo.();
//                        if (emprestimo1 != null) {
//                            for (Emprestimo emprestimo2 : emprestimo1) {
//                                System.out.println(emprestimo2);
//                            }
//                        }
                        break;
                    case 8:
//                        List<Transferencia> transferencia1 = ConexaoTransferencia.buscar();
//                        if (transferencia1 != null) {
//                            for (Transferencia transferencia2 : transferencia1) {
//                                System.out.println(transferencia2);
//                            }
//                        }
                        break;
                    case 9:
                        System.out.println("Obrigado por usar nosso Sistema!!");
                        break;
                    default:
                        System.out.println("Coloque um inteiro entre 1 e 8");
                }
            } catch (Exception Error){
                System.out.println("Insira um valor númerico");
            }
        }
    }

    public static void Menu(){
        System.out.println("Qual tabela você deseja fazer?");
        System.out.println("1 - Cliente");
        System.out.println("2 - Agencia");
        System.out.println("3 - Conta");
        System.out.println("4 - Tipo de Conta");
        System.out.println("5 - Cartão");
        System.out.println("6 - Operacao");
        System.out.println("7 - Emprestimo");
        System.out.println("8 - Transferencia");
        System.out.println("9 - Sair");
    }

    public static void Menu2(){
        System.out.println("O que você deseja fazer?");
        System.out.println("1 - Cadastrar");
        System.out.println("2 - Consultar");
        System.out.println("3 - Atualizar");
        System.out.println("4 - Excluir");
    }
}