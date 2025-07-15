package com.meubanco.repository;

import com.meubanco.exception.ContaNaoEncontradaException;
import com.meubanco.model.Conta;

import java.util.HashMap;
import java.util.Map;

public class RepositorioDeContas {
    private final Map<String, Conta> contas = new HashMap<>();

    public RepositorioDeContas() {
        contas.put("123456-12", new Conta("123456-12", "Diogo Garcia", 15000));
        contas.put("139747-42", new Conta("139747-42", "Fabricio Marconato", 9000));
        contas.put("987654-32", new Conta("987654-32", "Meire Regina", 1700));
    }
    /**
     * Busca uma conta pelo número. Lança uma exceção se não encontrar.
     * @param numeroConta O número da conta a ser buscada.
     * @return O objeto Conta encontrado.
     * @throws ContaNaoEncontradaException Se a conta não existir no repositório.
     */
    public Conta buscarConta(String numeroConta) throws ContaNaoEncontradaException {
        Conta conta = contas.get(numeroConta);
        if (conta == null) {
            throw new ContaNaoEncontradaException("A conta com número " + numeroConta + " não foi encontrada.");
        }
        return conta;
    }
}
