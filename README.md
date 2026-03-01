# Sistema de Pagamentos em Java

Este projeto é um mini sistema de pagamentos em Java, desenvolvido com foco em Programação Orientada a Objetos (POO) e Engenharia de Software.

A aplicação simula um domínio financeiro simples, utilizando interfaces como contrato e polimorfismo para desacoplar a regra de negócio das implementações concretas, seguindo princípios utilizados em sistemas backend reais.

---

## Conceitos aplicados

- Programação Orientada a Objetos (POO)
- Polimorfismo
- Interfaces como contrato
- Baixo acoplamento
- Open/Closed Principle (SOLID)
- Arquitetura em camadas
- Clean Code

---

## Arquitetura do projeto

Estrutura de pastas:

```
src/
 ├─ domain/
 │   ├─ Pagamento.java
 │   └─ Recibo.java
 ├─ infra/
 │   ├─ PixPagamento.java
 │   ├─ CartaoCreditoPagamento.java
 │   └─ BoletoPagamento.java
 ├─ service/
 │   └─ ProcessadorPagamento.java
 └─ Main.java
```
---

## Responsabilidade das camadas

domain/  
Contém os contratos e objetos de negócio do sistema.  
Inclui a interface Pagamento e a classe Recibo.

infra/  
Implementações concretas dos métodos de pagamento  
(PIX, Cartão de Crédito e Boleto).

service/  
Camada responsável por orquestrar o fluxo de pagamento  
(ProcessadorPagamento).

Main.java  
Ponto de entrada da aplicação.

---

## Funcionamento do sistema

O sistema possui um Processador de Pagamentos que depende apenas da interface Pagamento.

Cada forma de pagamento:
- executa sua própria regra
- retorna um objeto Recibo
- não expõe detalhes internos ao serviço

Regras atuais do sistema:

PIX  
Não possui taxa.

Cartão de Crédito  
Taxa de 2 por cento sobre o valor.

Boleto  
Desconto fixo de R$ 3,50.

O resultado de cada pagamento é exibido no console.

---

## Como executar

1. Clonar o repositório  
```git clone https://github.com/kelvinlemos7/payment-processing-system.git```

2. Compilar o projeto  
```javac -d out src/**/*.java```

3. Executar a aplicação  
```java -cp out Main```

---

## Observação

Projeto desenvolvido com foco em aprendizado prático, reforçando conceitos fundamentais de POO, polimorfismo, arquitetura limpa e princípios SOLID.

A estrutura foi pensada para permitir extensões futuras, como novos métodos de pagamento, sem necessidade de alterar código existente.
