#  Sistema de Pagamentos - Java

Este repositório contém um exemplo de **polimorfismo em Java**, aplicado a um **domínio financeiro simples**.

O objetivo é demonstrar como o uso de **interfaces como contrato** permite desacoplar a **regra de negócio** das implementações concretas.

---

## 🧠 Conceitos aplicados
- Polimorfismo
- Interface como contrato
- Baixo acoplamento
- Princípio **Open/Closed** (SOLID)
- Arquitetura em camadas (Domain, Infra, Service)

---

## 📦 Estrutura do sistema
O sistema possui um **Processador de Pagamentos** que trabalha com diferentes formas de pagamento:

- **PIX**
- **Cartão de Crédito**
- **Boleto**

Cada pagamento gera um **Recibo** com informações do método e do valor pago.  
O **ProcessadorPagamento** depende apenas da interface **Pagamento**, sem conhecer detalhes das implementações.  

O sistema imprime os recibos de cada pagamento no console.

---

## ▶️ Como executar

Clone o repositório:
```bash
git clone https://github.com/SeuUsuario/payment-processing-system.git
```

## 📌 Observação

Projeto desenvolvido com foco em aprendizado e prática de conceitos fundamentais de Engenharia de Software, incluindo:

Polimorfismo

Interfaces

Baixo acoplamento

Princípio Open/Closed (SOLID)

Arquitetura limpa e em camadas

