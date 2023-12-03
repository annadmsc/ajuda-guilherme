package com.example;

import java.sql.Date;


public class MImi {

    private static AgenciaDAO agenciaDAO = new AgenciaDAO();
    private static ClienteDAO clienteDAO = new ClienteDAO();
    private static ContaDAO contaDAO = new ContaDAO();
    private static Tipos_contaDAO tipos_conta = new Tipos_contaDAO();
    private static ConexaoOperacao operacao = new ConexaoOperacao();
    private static ConexaoCartao cartao = new ConexaoCartao();
    private static ConexaoCartao cartaoc = new ConexaoCartao();


    public static void main(String[] args) {

        agenciaDAO.inserir("oioioi","lala","sp");
        agenciaDAO.alterar("oioioi","mimi","nome");
        agenciaDAO.remover("agenciaid","oioioi");
        agenciaDAO.retornarTodos();
                clienteDAO.inserir("00000B","Rafaella","RJ","11952200","Analista de TI",new Date(2006,01,01));
        clienteDAO.alterar("00000B","CA","cidade");
        clienteDAO.remover("nome","Rafaella");
        clienteDAO.retornarTodos();


                        contaDAO.inserir("00000B","B00004","C00003", 100.4F,new Date(2022,02,02),1,true);
        contaDAO.alterar("00000B",200.6F,"saldo");
        contaDAO.remover("contaid","00000B");
        contaDAO.retornarTodos();
        tipos_conta.inserir(10,"blabla");
        tipos_conta.alterar(10,"mimi","tiponome");
        tipos_conta.remover("tiponome","mimi");
        tipos_conta.retornarTodos();
        operacao.conectar();
         operacao.buscar();
        operacao.desconectar();
        cartao.conectar();
         Cartao cartaoD = new Cartao(13242,200,new Date(2002,02,02),"C00007");
        cartao.inserir("bserv.cartao",cartaoD);
//        cartao.buscar();
        cartao.remover(13242);
        cartao.alterarLimite(13242,220);
        cartao.desconectar();
        Transferencia transferencia = new Transferencia("e873","gg","ufyhe8","ufeo","ufyeh","hfeui","yfhuey",2000F,new Date(2000,01,01));




    }



}
