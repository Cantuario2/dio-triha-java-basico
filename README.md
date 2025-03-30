# Dio - Bootcamp Java Cloud Native
## Feature: API REST Bancária na Nuvem Usando Spring Boot 3, Java 21 e Railway

Repositório do Projeto implementação do projeto API REST Bancária na Nuvem Usando Spring Boot 3, Java 21 e Railway do curso "Publicando Sua API REST na Nuvem Usando Spring Boot 3, Java 17 e Railway".
- Diagrama de Classes do Projeto

```mermaid
classDiagram
  class User {
    -String name
    -Account account
    -Feature[] features
    -Card card
    -News[] news
  }

  class Account {
    -String number
    -String agency
    -Number balance
    -Number limit
  }

  class Feature {
    -String icon
    -String description
  }

  class Card {
    -String number
    -Number limit
  }

  class News {
    -String icon
    -String description
  }

  User "1" *-- "1" Account
  User "1" *-- "N" Feature
  User "1" *-- "1" Card
  User "1" *-- "N" News
```

cantuario2 - 29/03/2025
### Rev. 00
