# Sistema de Pagamentos em Java

Este projeto é um mini sistema de pagamentos em Java, desenvolvido com foco em **Programação Orientada a Objetos (POO)** e **Engenharia de Software**.

A aplicação simula um domínio financeiro simplificado, aplicando **polimorfismo, interfaces como contrato e arquitetura em camadas**, conceitos comuns em sistemas backend reais.

---

## Conceitos aplicados

- Programação Orientada a Objetos (POO)
- Polimorfismo
- Interfaces como contrato
- Baixo acoplamento
- Open/Closed Principle (SOLID)
- Arquitetura em camadas
- Clean Code
- Modelagem de domínio

---

## Arquitetura do projeto

Estrutura de pastas:

```
src/
├─ domain/
│ ├─ Pagamento.java
│ ├─ Recibo.java
│ ├─ MetodoPagamento.java
│ └─ TipoAjuste.java
├─ infra/
│ ├─ PixPagamento.java
│ ├─ CartaoCreditoPagamento.java
│ ├─ BoletoPagamento.java
│ └─ DebitoPagamento.java
├─ service/
│ └─ ProcessadorPagamento.java
└─ Main.java
```
---

## Responsabilidade das camadas

**domain/**  
Contém os contratos e objetos centrais do domínio do sistema.

- `Pagamento` → interface que define o contrato para qualquer método de pagamento  
- `Recibo` → representa o resultado da operação de pagamento  
- `MetodoPagamento` → enum com os métodos disponíveis  
- `TipoAjuste` → enum que representa o tipo de ajuste financeiro aplicado (taxa, desconto, cashback etc.)

---

**infra/**  
Implementações concretas dos métodos de pagamento:

- PIX  
- Cartão de Crédito  
- Boleto  
- Débito  

Cada implementação aplica suas próprias regras de negócio.

---

**service/**  
Camada responsável por **orquestrar o fluxo de pagamento**, utilizando apenas a interface `Pagamento`.

Isso permite que novos métodos sejam adicionados sem modificar o processador.

---

**Main.java**

Ponto de entrada da aplicação, onde diferentes pagamentos são simulados.

---

# Funcionamento do sistema

O sistema possui um **Processador de Pagamentos** que depende apenas da interface `Pagamento`.

Cada forma de pagamento:

- Executa sua própria regra
- Retorna um objeto `Recibo`
- Mantém o serviço desacoplado da implementação

---

# Regras atuais do sistema

### PIX
- Cashback de **5%** sobre o valor pago

### Cartão de Crédito
- Taxa de **2%** sobre o valor da transação

### Boleto
- Desconto fixo de **R$ 3,50**

### Débito
- Sem taxa
- Limite diário de **R$ 1000**
- Caso ultrapasse o limite, uma **exception é lançada**

---

## Ajustes financeiros

O sistema utiliza o enum `TipoAjuste` para representar diferentes tipos de modificações no valor final da transação:

- `TAXA`
- `DESCONTO`
- `CASHBACK`
- `JUROS`
- `NENHUM`

Isso permite que o recibo represente corretamente o impacto financeiro de cada operação.

---

## Exemplo de saída no console

```
Metodo: Pix | Valor: R$ 150.0 | Cashback: R$ 7.5 | Data: 11/03/2026 02:00
Metodo: Cartão de Crédito | Valor: R$ 326.4 | Taxa: R$ 6.4 | Data: 11/03/2026 02:00
Metodo: Boleto | Valor: R$ 86.5 | Desconto: R$ 3.5 | Data: 11/03/2026 02:00
Metodo: Débito | Valor: R$ 220.0 | Sem ajustes | Data: 11/03/2026 02:00
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

- Transformação em **API REST com Spring Boot**
- Integração com banco de dados
- Logging de transações
- Autenticação e autorização
- Histórico de pagamentos
- Testes unitários

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
