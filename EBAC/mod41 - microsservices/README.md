# Tarefa Módulo 41

## O que são Microsserviços?
Microsserviços são uma abordagem de arquitetura de software onde uma aplicação é composta por pequenos serviços independentes, que são implantados, escalados e gerenciados separadamente. Cada microsserviço implementa uma função de negócio específica (por exemplo: cadastro de usuários, processamento de pagamentos, envio de notificações) e se comunica com outros serviços geralmente via APIs REST, gRPC, ou mensageria (Kafka, RabbitMQ).

## Características dos Microsserviços

- **Desacoplamento**: Cada serviço é isolado e tem sua própria lógica, podendo ser desenvolvido, testado e implantado independentemente.
  
- **Foco no Domínio de Negócio**: Os serviços são organizados de acordo com domínios de negócio (conceito conhecido como Domain-Driven Design).
  
- **Autonomia**: Microsserviços possuem banco de dados próprio e não compartilham dados diretamente com outros serviços.
  
- **Desenvolvimento Independente**: Podem ser desenvolvidos por times diferentes, em linguagens diferentes (Java, Node.js, Go, etc.), usando tecnologias distintas.
  
- **Resiliência**: Falhas em um serviço não necessariamente impactam o sistema inteiro. Serviços podem se recuperar automaticamente ou ser isolados.
  
- **Escalabilidade**: Apenas os serviços que precisam de mais recursos são escalados, otimizando o uso da infraestrutura.

## Tecnologias Comuns em Microsserviços

- **Frameworks**: Spring Boot, Quarkus, Micronaut
- **API Gateway**: Zuul, Spring Cloud Gateway, Kong
- **Service Discovery**: Netflix Eureka, Consul
- **Mensageria**: Kafka, RabbitMQ
- **Autenticação/Segurança**: OAuth2, JWT, Keycloak
- **Monitoramento**: Prometheus, Grafana, Zipkin, ELK Stack
- **Containers e Orquestração**: Docker, Kubernetes

## Vantagens dos Microsserviços

- Maior escalabilidade
- Desenvolvimento paralelo por múltiplos times
- Melhor aproveitamento de recursos
- Maior facilidade de adotar novas tecnologias
- Menor tempo para entrega de novas funcionalidades
- Isolamento de falhas

## Desvantagens / Desafios

- Complexidade de orquestração e deploy
- Comunicação entre serviços pode introduzir latência
- Gerenciamento de dados distribuídos
- Monitoramento e logging mais complexos
- Versão e compatibilidade entre APIs
- Testes de integração mais desafiadores

## Exemplo Prático

Imagine um sistema de e-commerce com arquitetura de microsserviços:

- **Serviço de Catálogo** – Responsável pelos produtos disponíveis.
- **Serviço de Carrinho** – Gerencia itens adicionados pelos usuários.
- **Serviço de Pagamento** – Processa pagamentos e valida cartões.
- **Serviço de Entrega** – Calcula frete e rastreia pedidos.
- **Serviço de Notificação** – Envia emails e SMS ao cliente.

Cada um desses pode ser mantido e implantado separadamente, até mesmo com times diferentes cuidando de cada um.

## Quando usar Microsserviços?

Microsserviços são ideais para sistemas:

- Que crescerão com o tempo (e precisam escalar).
- Que envolvem equipes múltiplas trabalhando de forma paralela.
- Que exigem alta disponibilidade e resiliência.
- Que serão implantados em ambientes baseados em nuvem (Cloud Native).

Mas não são recomendados para projetos pequenos ou que ainda estão em fase inicial de validação, onde a complexidade extra pode ser desnecessária.