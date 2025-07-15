package com.meubanco.model;

public class Conta {
    private String numeroConta;
    private String nomeTitular;
    private double saldo;

    public Conta(String numeroConta, String nomeTitular, double saldo) {
        this.numeroConta = numeroConta;
        this.nomeTitular = nomeTitular;
        this.saldo = saldo;
    }

    public void depositar(double valor) {
        if(valor > 0){
            this.saldo += valor;
        }
    }
    public void sacar(double valor) {
        if(valor > 0){
            this.saldo -= valor;
        }
    }

    public String getNumeroDaConta() {
        return numeroConta;
    }

    public String getNomeTitular() {
        return nomeTitular;
    }

    public double getSaldo() {
        return saldo;
    }

    @Override
    public String toString() {
        return "Conta{" +
                "numeroConta='" + numeroConta + '\'' +
                ", nomeTitular='" + nomeTitular + '\'' +
                ", saldo=" + saldo +
                '}';
    }
}
