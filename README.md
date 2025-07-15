# 💸 Sistema Bancário - Estudo de Caso de Exceções

![Java](https://img.shields.io/badge/Java-17%2B-blue?logo=openjdk&logoColor=white)
![Build](https://img.shields.io/badge/Build-Maven-red?logo=apache-maven)
![License](https://img.shields.io/badge/License-MIT-green)

## 1. Sobre o Projeto

Este projeto é um laboratório prático para o estudo aprofundado do **Tratamento de Exceções** em Java, aplicado a um cenário de sistema bancário simulado. O foco principal não está na complexidade das funcionalidades, mas na implementação de um código robusto, resiliente e seguro, que lida de forma explícita e elegante com diversos cenários de erro.

O sistema simula transferências monetárias entre contas, aplicando um conjunto de validações para garantir a consistência e a integridade dos dados, demonstrando uma abordagem defensiva na programação.

---

## 2. Principais Funcionalidades

* ✔️ **Simulação de Transferências:** Lógica central para debitar de uma conta de origem e creditar em uma conta de destino.
* ✔️ **Validação de Regras de Negócio:** Verifica se o saldo é suficiente e se a transferência obedece às políticas do sistema (ex: limites de valor).
* ✔️ **Validação de Dados de Entrada:** Garante que os argumentos passados para o serviço (como valores e contas) são válidos.
* ✔️ **Tratamento Específico de Erros:** Captura e trata cada falha de forma distinta, provendo feedback claro sobre o problema ocorrido.

---

## 3. Conceitos Aplicados

Este projeto foi desenhado para aplicar e solidificar os seguintes conceitos técnicos:

#### 🧠 Programação Orientada a Objetos (POO)
* **Encapsulamento:** O estado interno dos objetos (como o `saldo` da `Conta`) é protegido e só pode ser modificado através de métodos públicos que garantem sua consistência.
* **Herança:** Utilizada para criar exceções customizadas (`SaldoInsuficienteException extends Exception`), especializando o comportamento padrão de exceções.
* **Composição:** O `ServicoDeTransferencia` *tem um* `RepositorioDeContas`, demonstrando o princípio de "composição sobre herança" para colaboração entre objetos.

#### ⚠️ Tratamento de Exceções Avançado
* **Checked Exceptions:** Criadas para erros de negócio previsíveis (`ContaNaoEncontradaException`, `SaldoInsuficienteException`), forçando o código cliente a lidar com essas falhas.
* **Unchecked Exceptions:** Utilizadas para erros de programação ou uso incorreto da API (`IllegalArgumentException`), sinalizando um bug que deve ser corrigido.

#### 🧱 Design de Software
* **Arquitetura em Camadas:** O projeto é claramente dividido em pacotes por responsabilidade (`model`, `repository`, `service`, `exception`), facilitando a manutenção e a compreensão do código.

---

## 4. Estrutura de Pacotes
```
src/
└── com/meubanco/
    ├── Main.java
    ├── exception/
    │   ├── ContaNaoEncontradaException.java
    │   ├── PoliticaDeTransferenciaException.java
    │   └── SaldoInsuficienteException.java
    ├── model/
    │   └── Conta.java
    ├── repository/
    │   └── RepositorioDeContas.java
    └── service/
        └── ServicoDeTransferencia.java
```
---

## 5. Tecnologias Utilizadas

* **Java (JDK 17 ou superior)**

---

## 6. Como Executar o Projeto

**Pré-requisitos:**
* Java JDK 17 ou superior instalado.
* Git.

**Passos:**

1.  **Clone o repositório:**
    ```bash
    git clone [https://github.com/dheik/SistemaBancarioException.git](https://github.com/dheik/SistemaBancarioException.git)
    ```

2.  **Abra na sua IDE:**
    * Importe o projeto clonado na sua IDE de preferência (IntelliJ IDEA, Eclipse, VS Code)

3.  **Execute a aplicação:**
    * Localize e execute o método `main` na classe `com.meubanco.Main.java`.
    * A saída no console demonstrará os diferentes cenários de teste, incluindo transferências bem-sucedidas e a captura de cada tipo de exceção.

---

## 7. Licença

Este projeto está licenciado sob os termos da Licença MIT.
