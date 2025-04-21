# 🌟 API-Para-Gestao-De-Loja-Spring

Este projeto consiste no desenvolvimento de uma API para o gerenciamento de uma loja de eletrônicos e serviços de assistência técnica. A solução permitirá um controle eficiente de produtos, estoque, vendas, ordens de serviço e atendimento ao cliente, proporcionando uma gestão integrada e otimizada para o negócio. 🛒💻

## 📜 Descrição do Projeto

A API permitirá a gestão de produtos, controle de estoque, processamento de pedidos e outras funcionalidades essenciais para o funcionamento eficiente de uma loja de eletrônicos, proporcionando uma experiência aprimorada para os usuários e facilitando a operação do negócio. 🚀

## 📊 Diagrama de Classes

Abaixo está o diagrama de classes que representa a estrutura do projeto e as relações entre as entidades:

```mermaid
classDiagram
    %% ENTIDADES
    class Product {
        - Long id
        - String name
        - String description
        - BigDecimal price
        - String category
        - ZonedDateTime createdAt
        - ZonedDateTime updatedAt
    }

    class Stock {
        - Long id
        - Product product
        - Integer availableQuantity
        - Integer minStock
        - Integer maxStock
        - List<StockMovement> movements
        - ZonedDateTime lastUpdated
    }

    class StockMovement {
        - Long id
        - Stock stock
        - MovementType movementType
        - Integer quantity
        - ZonedDateTime movementDate
    }

    class Order {
        - Long id
        - User user
        - ZonedDateTime orderDate
        - Map<Product, Integer> products
        - BigDecimal totalValue
        - OrderStatus status
    }

    class Sale {
        - Long id
        - Order order
        - ZonedDateTime saleDate
        - PaymentStatus paymentStatus
    }

    class User {
        - Long id
        - String name
        - String email
        - String phone
        - String address
        - String password
        - UserType type
        - UserRole role
        - ZonedDateTime registrationDate
    }

    class Supplier {
        - Long id
        - String name
        - String contact
        - String address
    }

    class Purchase {
        - Long id
        - ZonedDateTime purchaseDate
        - Map<Product, Integer> products
        - BigDecimal totalValue
        - PurchaseStatus status
    }

    class FinancialTransaction {
        - Long id
        - TransactionType type
        - BigDecimal amount
        - ZonedDateTime transactionDate
        - String description
        - Purchase purchase
    }

    %% DTOs
    class ProductDTO {
        <<DTO>>
        + Long id
        + String name
        + String description
        + BigDecimal price
        + String category
    }

    class StockDTO {
        <<DTO>>
        + Long id
        + Long productId
        + Integer availableQuantity
        + Integer minStock
        + Integer maxStock
        + ZonedDateTime lastUpdated
    }

    class StockMovementDTO {
        <<DTO>>
        + Long id
        + Long stockId
        + MovementType movementType
        + Integer quantity
        + ZonedDateTime movementDate
    }

    class OrderDTO {
        <<DTO>>
        + Long id
        + Long userId
        + Map<Long, Integer> productQuantities
        + BigDecimal totalValue
        + OrderStatus status
        + ZonedDateTime orderDate
    }

    class SaleDTO {
        <<DTO>>
        + Long id
        + Long orderId
        + ZonedDateTime saleDate
        + PaymentStatus paymentStatus
    }

    class UserDTO {
        <<DTO>>
        + Long id
        + String name
        + String email
        + String phone
        + String address
        + UserType type
        + UserRole role
    }

    class SupplierDTO {
        <<DTO>>
        + Long id
        + String name
        + String contact
        + String address
    }

    class PurchaseDTO {
        <<DTO>>
        + Long id
        + ZonedDateTime purchaseDate
        + Map<Long, Integer> productQuantities
        + BigDecimal totalValue
        + PurchaseStatus status
    }

    class FinancialTransactionDTO {
        <<DTO>>
        + Long id
        + TransactionType type
        + BigDecimal amount
        + ZonedDateTime transactionDate
        + String description
        + Long purchaseId
    }

    %% Enums
    class OrderStatus {
        <<enumeration>>
        PENDING
        CONFIRMED
        CANCELED
    }

    class PaymentStatus {
        <<enumeration>>
        PENDING
        PAID
        REFUNDED
    }

    class UserType {
        <<enumeration>>
        INDIVIDUAL
        COMPANY
    }

    class UserRole {
        <<enumeration>>
        ADMIN
        EMPLOYEE
        CUSTOMER
    }

    class PurchaseStatus {
        <<enumeration>>
        ORDERED
        RECEIVED
        CANCELED
    }

    class TransactionType {
        <<enumeration>>
        SALE
        PURCHASE
        EXPENSE
        REFUND
    }

    class MovementType {
        <<enumeration>>
        ENTRY
        EXIT
        ADJUSTMENT
    }

    %% RELACIONAMENTOS ENTRE ENTIDADES
    Stock "1" --> "n" StockMovement : logs
    StockMovement "1" --> "1" MovementType : categorized_as
    Stock "1" --> "1" Product : manages
    User "1" --> "n" Order : places
    Order "1" --> "1" Sale : generates
    Sale "1" --> "1" FinancialTransaction : records
    Order "1" --> "n" Product : contains
    Supplier "1" --> "n" Purchase : supplies
    Purchase "1" --> "n" Product : includes
    FinancialTransaction "1" --> "1" Purchase : logs
    User "1" --> "1" UserType : classified_as
    User "1" --> "1" UserRole : authorized_as

    %% RELACIONAMENTO DTO x CLASSES e ENUMS
    ProductDTO --> Product
    StockDTO --> Stock
    StockMovementDTO --> StockMovement
    OrderDTO --> Order
    SaleDTO --> Sale
    UserDTO --> User
    SupplierDTO --> Supplier
    PurchaseDTO --> Purchase
    FinancialTransactionDTO --> FinancialTransaction

    OrderDTO --> OrderStatus
    SaleDTO --> PaymentStatus
    UserDTO --> UserType
    UserDTO --> UserRole
    PurchaseDTO --> PurchaseStatus
    StockMovementDTO --> MovementType
    FinancialTransactionDTO --> TransactionType

```
## ✅ Funcionalidades
🏷️ Cadastro e gerenciamento de produtos     
📦 Controle de estoque   
📝 Processamento de pedidos   
👥 Gerenciamento de clientes    
💰 Registro de movimentações financeiras  
📄 Emissão de faturas 

## 🚀 Padrões de Commits

Adotado os seguintes prefixos para descrever o propósito de cada commit:

✨ feat: Nova funcionalidade.<br>
🐛 fix: Correção de bugs. <br>
📝 docs: Alterações na documentação.<br>
💅 style: Mudanças que não afetam a lógica do código (formatação, espaços, etc.).<br>
🔨 refactor: Melhorias na estrutura do código sem adicionar funcionalidades ou corrigir bugs.<br>
✅ test: Adição ou modificação de testes.<br>
🧹 chore: Tarefas de manutenção (configurações, dependências, etc.)<br>

## 📄 Licença  
Este projeto é licenciado sob a **Licença de Uso Não Comercial e Sem Alterações**. Você pode usar, copiar e distribuir o código-fonte e a documentação associados a este software exclusivamente para **fins de estudo**, desde que faça isso de forma não comercial. Para mais informações, consulte o arquivo LICENSE.

## 👤 Sobre o Autor

🔧 **Desenvolvedor:** Silas Sefas de Souza Aquino  
🌐 **LinkedIn:** [silassefas](https://www.linkedin.com/in/silassefas/)  
:octocat: **GitHub:** [silassefas1](https://github.com/silassefas1)
Sinta-se à vontade para me conectar nas redes sociais! Estou sempre aberto a novas oportunidades e colaborações. 🚀


## ⚠ Aviso

Este projeto é de caráter **educacional** e está em constante desenvolvimento.  
Mudanças significativas podem ocorrer ao longo do tempo, incluindo ajustes na estrutura, funcionalidades e até mesmo na tecnologia utilizada.

Sinta-se à vontade para contribuir e melhorar o projeto! Quaisquer sugestões ou colaborações são bem-vindas. 😊  
