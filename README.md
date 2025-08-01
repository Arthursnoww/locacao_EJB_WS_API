# Locadora de Aparelhos - Projeto Multicliente

Este projeto implementa um sistema para gerenciamento de locação de aparelhos (mesas, geradores, palcos e talheres), com:

- **Servidor em Java (Spring Boot)**
- **Cliente em Python**
- **Cliente em JavaScript (Node.js)**

O objetivo é mostrar como diferentes linguagens podem consumir uma mesma API REST, facilitando a integração de múltiplos sistemas e plataformas.

---

## Funcionalidades

- Cadastro e listagem de **clientes**
- Cadastro e listagem de **aparelhos**
- Registro de **locações**
- Listagem de **locações**

---

## Tecnologias Utilizadas

- **Backend:** Java 17+, Spring Boot, Maven
- **Clientes:**
  - Python 3 (`requests`)
  - JavaScript (Node.js, `node-fetch`)

---

## Estrutura do Projeto

locadora/ <br>
├── pom.xml<br>
├── mvnw / mvnw.cmd<br>
├── src/<br>
│   ├── main/<br>
│   │   ├── java/com/locadora/<br>
│   │   │   ├── LocadoraApplication.java<br>
│   │   │   ├── controller/<br>
│   │   │   │   ├── AparelhoController.java<br>
│   │   │   │   ├── ClienteController.java<br>
│   │   │   │   └── LocacaoController.java<br>
│   │   │   ├── model/<br>
│   │   │   │   ├── Aparelho.java<br>
│   │   │   │   ├──Cliente.java<br>
│   │   │   │   ├──Mesa.java<br>
│   │   │   │   ├──Palco.java<br>
│   │   │   │   ├──Gerador.java<br>
│   │   │   │   ├──Talher.java<br>
│   │   │   │   └──RequisicaoLocacao.java<br>
│   │   │   └── service/<br>
│   │   │   │   └── LocadoraService.java<br>
│   │   └── resources/<br>
│   │   │  └── application.properties<br>
│   └── test/<br>
│   │    └── java/com/locadora/LocadoraApplicationTests.java<br>


