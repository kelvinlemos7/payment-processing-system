# Sistema de Pagamentos em Java

Este projeto é um mini sistema de pagamentos em Java, desenvolvido com foco em **Programação Orientada a Objetos (POO)** e **Engenharia de Software**.

A aplicação simula um domínio financeiro simples, utilizando **interfaces como contrato** e **polimorfismo** para desacoplar a regra de negócio das implementações concretas, seguindo princípios utilizados em sistemas backend reais.

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
 │   └─ MetodoPagamento.java
 ├─ infra/
 │   ├─ PixPagamento.java
 │   ├─ CartaoCreditoPagamento.java
 │   ├─ BoletoPagamento.java
 |   └─ DebitoPagamento.java
 ├─ service/
 │   └─ ProcessadorPagamento.java
 └─ Main.java
```

---

## Responsabilidade das camadas

**domain/**  
Contém os contratos e objetos de negócio do sistema, incluindo a interface `Pagamento`, a classe `Recibo` e o `enum MetodoPagamento`.  

**infra/**  
Implementações concretas dos métodos de pagamento (PIX, Cartão de Crédito, Boleto e Débito).  

**service/**  
Camada responsável por orquestrar o fluxo de pagamento (`ProcessadorPagamento`).  

**Main.java**  
Ponto de entrada da aplicação.

---

## Funcionamento do sistema

O sistema possui um **Processador de Pagamentos** que depende apenas da interface `Pagamento`.

Cada forma de pagamento:

- Executa sua própria regra  
- Retorna um objeto `Recibo`  
- Não expõe detalhes internos ao serviço  

### Regras atuais do sistema:

**PIX**  
- Sem taxa  

**Cartão de Crédito**  
- Taxa de 2% sobre o valor  

**Boleto**  
- Desconto fixo de R$ 3,50

**Débito**
- Sem taxa

O resultado de cada pagamento é exibido no console, com data e hora:
```
Metodo: Pix | Valor: R$ 150.0 | Sem taxas | Data: 10/03/2026 20:58
Metodo: Cartão de Crédito | Valor: R$ 326.4 | Taxa: R$ 6.4 | Data: 10/03/2026 20:58
Metodo: Boleto | Valor: R$ 86.5 | Desconto: R$ 3.5 | Data: 10/03/2026 20:58
Metodo: Débito | Valor: R$ 230.0 | Sem taxas | Data: 10/03/2026 20:58
```

## Enumeração de métodos de pagamento

O projeto utiliza um `enum` (`MetodoPagamento`) para representar os métodos disponíveis:

- PIX  
- Cartão de Crédito  
- Boleto  
- Débito

Isso permite adicionar novos métodos facilmente sem alterar código existente.

---

## Extensões futuras

- Cashback ou promoções para PIX  
- Transformação em API RESTful com Spring Boot  
- Autenticação, logging e monitoramento de transações  

---

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
