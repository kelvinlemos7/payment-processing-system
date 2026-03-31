# 💳 Payment Processing System

<div align="center">

**[🇧🇷 Português](#-sistema-de-pagamentos-pt-br) | [🇺🇸 English](#-payment-processing-system-en)**

</div>

---

# 💳 Sistema de Pagamentos (PT-BR)

Este projeto é um mini sistema de pagamentos em Java, desenvolvido com foco em **Programação Orientada a Objetos (POO)** e **Engenharia de Software**.

A aplicação simula um domínio financeiro simplificado, aplicando **polimorfismo, interfaces como contrato e arquitetura em camadas**, conceitos comuns em sistemas backend reais.

---

## 🧠 Conceitos Aplicados

- Programação Orientada a Objetos (POO)
- Polimorfismo
- Interfaces como contrato
- Baixo acoplamento
- Open/Closed Principle (SOLID)
- Arquitetura em camadas
- Clean Code
- Modelagem de domínio

---

## 🧱 Arquitetura do Projeto

```
src/
├─ domain/
│  ├─ Pagamento.java
│  ├─ Recibo.java
│  ├─ MetodoPagamento.java
│  └─ TipoAjuste.java
├─ infra/
│  ├─ PixPagamento.java
│  ├─ CartaoCreditoPagamento.java
│  ├─ BoletoPagamento.java
│  └─ DebitoPagamento.java
├─ service/
│  └─ ProcessadorPagamento.java
└─ Main.java
```

---

## 📂 Responsabilidade das Camadas

**`domain/`**
Contém os contratos e objetos centrais do domínio do sistema.
- `Pagamento` → interface que define o contrato para qualquer método de pagamento
- `Recibo` → representa o resultado da operação de pagamento
- `MetodoPagamento` → enum com os métodos disponíveis
- `TipoAjuste` → enum que representa o tipo de ajuste financeiro aplicado (taxa, desconto, cashback etc.)

**`infra/`**
Implementações concretas dos métodos de pagamento: PIX, Cartão de Crédito, Boleto e Débito. Cada implementação aplica suas próprias regras de negócio.

**`service/`**
Camada responsável por **orquestrar o fluxo de pagamento**, utilizando apenas a interface `Pagamento`. Isso permite que novos métodos sejam adicionados sem modificar o processador.

**`Main.java`**
Ponto de entrada da aplicação, onde diferentes pagamentos são simulados.

---

## ⚙️ Funcionamento do Sistema

O sistema possui um **Processador de Pagamentos** que depende apenas da interface `Pagamento`.

Cada forma de pagamento:
- Executa sua própria regra de negócio
- Retorna um objeto `Recibo`
- Mantém o serviço desacoplado da implementação

---

## 🔐 Regras de Negócio

| Método           | Regra                                                                        |
| ---------------- | ---------------------------------------------------------------------------- |
| **PIX**          | Cashback de **5%** sobre o valor pago                                        |
| **Crédito**      | Taxa de **2%** sobre o valor da transação                                    |
| **Boleto**       | Desconto fixo de **R$ 3,50**                                                 |
| **Débito**       | Sem taxa · Limite diário de **R$ 1.000** (exception se ultrapassar)          |

---

## 💱 Ajustes Financeiros

O enum `TipoAjuste` representa os tipos de modificação no valor final da transação:

`TAXA` · `DESCONTO` · `CASHBACK` · `JUROS` · `NENHUM`

---

## 🖥️ Exemplo de Saída

```
Metodo: Pix          | Valor: R$ 150.0 | Cashback: R$ 7.5  | Data: 11/03/2026 02:00
Metodo: Crédito      | Valor: R$ 326.4 | Taxa: R$ 6.4      | Data: 11/03/2026 02:00
Metodo: Boleto       | Valor: R$ 86.5  | Desconto: R$ 3.5  | Data: 11/03/2026 02:00
Metodo: Débito       | Valor: R$ 220.0 | Sem ajustes       | Data: 11/03/2026 02:00
```

---

## 📈 Extensões Futuras

- Transformação em **API REST com Spring Boot**
- Integração com banco de dados
- Logging de transações
- Autenticação e autorização
- Histórico de pagamentos
- Testes unitários

---

## ▶️ Como Executar

### 1️⃣ Clone o repositório
```bash
git clone https://github.com/kelvinlemos7/payment-processing-system.git
```

### 2️⃣ Compile o projeto
```bash
javac -d out src/**/*.java
```

### 3️⃣ Execute a aplicação
```bash
java -cp out Main
```

---

## 🧑‍💻 Autor

**Kelvin Kauan**

---
---

# 💳 Payment Processing System (EN)

A mini payment processing system built in Java, focused on **Object-Oriented Programming (OOP)** and **Software Engineering** principles.

The application simulates a simplified financial domain, applying **polymorphism, interfaces as contracts, and layered architecture** — concepts common in real-world backend systems.

---

## 🧠 Concepts Applied

- Object-Oriented Programming (OOP)
- Polymorphism
- Interfaces as contracts
- Low coupling
- Open/Closed Principle (SOLID)
- Layered architecture
- Clean Code
- Domain modeling

---

## 🧱 Project Architecture

```
src/
├─ domain/
│  ├─ Pagamento.java
│  ├─ Recibo.java
│  ├─ MetodoPagamento.java
│  └─ TipoAjuste.java
├─ infra/
│  ├─ PixPagamento.java
│  ├─ CartaoCreditoPagamento.java
│  ├─ BoletoPagamento.java
│  └─ DebitoPagamento.java
├─ service/
│  └─ ProcessadorPagamento.java
└─ Main.java
```

---

## 📂 Layer Responsibilities

**`domain/`**
Contains the core contracts and objects of the system's domain.
- `Pagamento` → interface defining the contract for any payment method
- `Recibo` → represents the result of a payment operation
- `MetodoPagamento` → enum with available payment methods
- `TipoAjuste` → enum representing the type of financial adjustment applied (fee, discount, cashback, etc.)

**`infra/`**
Concrete implementations of each payment method: PIX, Credit Card, Bank Slip, and Debit. Each applies its own business rules.

**`service/`**
Responsible for **orchestrating the payment flow**, depending only on the `Pagamento` interface. New payment methods can be added without modifying the processor.

**`Main.java`**
Application entry point, where different payment scenarios are simulated.

---

## ⚙️ How It Works

The system has a **Payment Processor** that depends solely on the `Pagamento` interface.

Each payment method:
- Executes its own business rule
- Returns a `Recibo` (receipt) object
- Keeps the service layer decoupled from the implementation

---

## 🔐 Business Rules

| Method          | Rule                                                          |
| --------------- | ------------------------------------------------------------- |
| **PIX**         | **5% cashback** on the amount paid                            |
| **Credit Card** | **2% fee** on the transaction amount                          |
| **Bank Slip**   | Fixed **R$ 3.50 discount**                                    |
| **Debit**       | No fee · Daily limit of **R$ 1,000** (exception if exceeded)  |

---

## 💱 Financial Adjustments

The `TipoAjuste` enum represents the types of modification applied to the final transaction value:

`FEE` · `DISCOUNT` · `CASHBACK` · `INTEREST` · `NONE`

---

## 🖥️ Sample Output

```
Method: Pix          | Amount: R$ 150.0 | Cashback: R$ 7.5  | Date: 11/03/2026 02:00
Method: Credit Card  | Amount: R$ 326.4 | Fee: R$ 6.4       | Date: 11/03/2026 02:00
Method: Bank Slip    | Amount: R$ 86.5  | Discount: R$ 3.5  | Date: 11/03/2026 02:00
Method: Debit        | Amount: R$ 220.0 | No adjustments    | Date: 11/03/2026 02:00
```

---

## 📈 Planned Improvements

- Migration to a **REST API with Spring Boot**
- Database integration
- Transaction logging
- Authentication and authorization
- Payment history
- Unit tests

---

## ▶️ How to Run

### 1️⃣ Clone the repository
```bash
git clone https://github.com/kelvinlemos7/payment-processing-system.git
```

### 2️⃣ Compile the project
```bash
javac -d out src/**/*.java
```

### 3️⃣ Run the application
```bash
java -cp out Main
```

---

## 🧑‍💻 Author

**Kelvin Kauan**
