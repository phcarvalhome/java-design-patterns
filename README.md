# Padrões de Projeto em Java: Sistema Nossa Bolsa de Valores

## Objetivo

  - Exemplificar didaticamente a implementação dos principais padrões de projeto orientados a objetos em Java nativo.

## Abordagem

  - Todos os padrões de projeto são implementados através de casos de uso para um sistema didático de bolsa de valores.
  - Cada padrão de projeto possui:
    - A implementação baseada em um caso de uso que está especificado na sessão de especificações de casos de uso.
    - Um pacote localizado no pacote *com.phcarvalhome.pattern* que possui:
      - Uma classe *<PATTERN_NAME>Test* com os métodos de teste.
      - Um pacote *core* com a implementação principal do padrão de projeto.
      - Um pacote *business* com as implementações complementares necessárias para atender ao caso de uso.

## Especificações de Casos de Uso

### 1. UC01 - Criar notificação para departamento

  - [x] **Padrão de projeto:** Abstract Factory Pattern 
  - **Pré-requisito:** N/A

#### 1.1. Regras de negócio

    1.1.1. Uma notificação deve ser composta por:
      - Destino
      - Tipo de notificação
      - Data e hora de criação
    1.1.2. Apenas as notificações de Mercado Aberto e de Mercado Parado devem ser consideradas.  
    1.1.3. Novas notificações podem ser consideradas posteriomente.  
    1.1.4. Apenas os departamentos de TI e de RH devem ser considerados.  
    1.1.5. Novos departamentos podem ser considerados posteriomente.

#### 1.2. Detalhes de implementação

  - [x] **Pacote:** *com.phcarvalhome.pattern.abstractfactory*
  - Sobre as regras de negócio
    - Cada método da interface *INotificationFactory* representa uma notificação.
    - Cada implementação da interface *INotificationFactory* representa um departamento.
  - Sobre o padrão de projeto
    - Cada implementação da interface *INotificationFactory* representa uma "Factory".
    - As classes *MarketOperation* e *Stock* representam as "Factory".
  
---

### 2. UC02 - Criar notificações em lote

  - [x] **Padrão de projeto:** Singleton Pattern
  - **Pré-requisito:** UC01

#### 2.1. Regras de negócio

    2.1.1. Apenas o lote de notificações de departamento deve ser considerado.  
    2.1.2. Novos lotes podem ser considerados posteriomente.  
    2.1.3. Apenas os departamentos de TI e de RH devem fazer parte do lote de notificações de departamento.  

#### 2.2. Detalhes de implementação

  - [x] **Pacote:** *com.phcarvalhome.pattern.singleton*
  - Sobre as regras de negócio
    - A classe *DepartmentNotificationFactoryBatch* representa o lote de notificações de departamento.
  - Sobre o padrão de projeto
    - A classe *DepartmentNotificationFactoryBatch* representa o "Singleton".
  
---

### 3. UC03 - Duplicar operação de mercado

  - [x] **Padrão de projeto:** Prototype Pattern
  - **Pré-requisito:** N/A
  
  #### 3.1. Regras de negócio

    3.1.1. Uma operação de mercado realizada anteriormente pode ser duplicada.  
    3.1.2. Uma operação de mercado deve ser composta por:
      - Tipo de operação
      - Ação
      - Quantidade de ações
    3.1.3. Uma ação deve ser composta pelo tipo de ação e pelo preço.  
    3.1.4. A operação de mercado duplicada deve ser composta pelos mesmos valores da operação de mercado original, com 
    exceção do valor do preço da ação que deve ser recalculado.

#### 3.2. Detalhes de implementação

  - [x] **Pacote:** *com.phcarvalhome.pattern.prototype*
  - Sobre o padrão de projeto
    - Cada implementação da interface *IPrototype<T>* representa um "Prototype".
    - As classes *MarketOperation* e *Stock* representam os "Prototype".

---