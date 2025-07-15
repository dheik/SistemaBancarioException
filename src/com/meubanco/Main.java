package com.meubanco;

import com.meubanco.exception.ContaNaoEncontradaException;
import com.meubanco.exception.PoliticaDeTransferenciaException;
import com.meubanco.exception.SaldoInsuficienteException;
import com.meubanco.repository.RepositorioDeContas;
import com.meubanco.service.ServicoDeTransferencia;

public class Main {
    public static void main(String[] args) {
        RepositorioDeContas repositorio = new RepositorioDeContas();
        ServicoDeTransferencia servico = new ServicoDeTransferencia(repositorio);

        System.out.println("-----Transferência Válida-----");
        try {
            servico.realizarTransferencia("123456-12", "139747-42", 200);
            System.out.println("Saldo final Diogo: " + repositorio.buscarConta("123456-12").getSaldo());
            System.out.println("Saldo final Fabricio: " + repositorio.buscarConta("139747-42").getSaldo());
        } catch (Exception e) {
            System.out.println("Erro inesperado: " + e.getMessage());

        }

        System.out.println("\n-----Saldo Insuficiente-----");
        try {
            servico.realizarTransferencia("987654-32", "139747-42", 2000);
        } catch (SaldoInsuficienteException e) {
            System.out.println("Falha na transferência: " + e.getMessage());

        } catch (Exception e) {
            System.out.println("Erro inesperado: " + e.getMessage());

        }

        System.out.println("\n-----Conta Não Encontrada-----");
        try {
            servico.realizarTransferencia("123456-12", "00000-0", 100.00);
        } catch (ContaNaoEncontradaException e) {
            System.out.println("Falha na transferência: " + e.getMessage());

        } catch (Exception e) {
            System.out.println("Erro inesperado: " + e.getMessage());

        }

        System.out.println("\n-----Violação da Política-----");
        try {
            servico.realizarTransferencia("139747-42", "123456-12", 5001.00);
        } catch (PoliticaDeTransferenciaException e) {
            System.out.println("Falha na transferência: " + e.getMessage());

        } catch (Exception e) {
            System.out.println("Erro inesperado: " + e.getMessage());

        }

        System.out.println("\n-----Argumento Inválido-----");
        try {
            servico.realizarTransferencia("987654-32", "123456-12", -50.00);
        } catch (IllegalArgumentException e) {
            System.out.println("Falha na transferência: " + e.getMessage());

        } catch (Exception e) {
            System.out.println("Erro inesperado: " + e.getMessage());

        }
    }
}
