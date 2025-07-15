package com.meubanco.service;

import com.meubanco.exception.ContaNaoEncontradaException;
import com.meubanco.exception.PoliticaDeTransferenciaException;
import com.meubanco.exception.SaldoInsuficienteException;
import com.meubanco.model.Conta;
import com.meubanco.repository.RepositorioDeContas;

public class ServicoDeTransferencia {

    private final RepositorioDeContas repositorioDeContas;

    public ServicoDeTransferencia(RepositorioDeContas repositorioDeContas) {
        this.repositorioDeContas = repositorioDeContas;
    }
    /**
     * Realiza a transferência entre duas contas após uma série de validações.
     * @param numeroContaOrigem Conta que enviará o dinheiro.
     * @param numeroContaDestino Conta que receberá o dinheiro.
     * @param valor O valor a ser transferido.
     * @throws IllegalArgumentException Se os parâmetros de entrada forem inválidos.
     * @throws PoliticaDeTransferenciaException Se a transferência violar uma política do banco.
     * @throws ContaNaoEncontradaException Se uma das contas não for encontrada.
     * @throws SaldoInsuficienteException Se a conta de origem não tiver saldo para a operação.
     */
    public void realizarTransferencia(String numeroContaOrigem, String numeroContaDestino, double valor) throws IllegalArgumentException, PoliticaDeTransferenciaException, ContaNaoEncontradaException, SaldoInsuficienteException {
        if (valor <= 0) {
            throw new IllegalArgumentException("O valor da transferência deve ser positivo.");
        }
        if (numeroContaOrigem.equals(numeroContaDestino)) {
            throw new IllegalArgumentException("A conta de origem e destino não podem ser a mesma.");
        }
        if (valor > 5000){
            throw new PoliticaDeTransferenciaException("Transferências acima de R$ 5.000,00 não são permitidas.");
        }
        Conta contaOrigem = repositorioDeContas.buscarConta(numeroContaOrigem);
        Conta contaDestino = repositorioDeContas.buscarConta(numeroContaDestino);
        if (contaOrigem.getSaldo() < valor) {
            throw new SaldoInsuficienteException("Saldo insuficiente na conta de origem. Saldo atual:" + contaOrigem.getSaldo());
        }
        System.out.println("Realizando transferência...");
        contaOrigem.sacar(valor);
        contaDestino.depositar(valor);

        System.out.println("Transferência de R$" + valor + " de " + contaOrigem.getNomeTitular() + " para " + contaDestino.getNomeTitular() + " realizada com sucesso!");
    }
}
