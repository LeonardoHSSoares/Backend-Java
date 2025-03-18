### Exercício 1: Os 12 Fatores no Desenvolvimento de Microservices

## Fatores Selecionados:

# Configurações

No desenvolvimento de microserviços, a configuração deve ser separada do código-fonte e gerenciada por variáveis de ambiente. Isso garante que o mesmo binário possa ser executado em diferentes ambientes sem modificações no código, aumentando a portabilidade e a segurança. Em uma arquitetura monolítica, configurações costumam estar embutidas no próprio sistema, tornando mais difícil a adaptação entre ambientes.

# Concorrência

Microserviços devem ser projetados para serem escaláveis horizontalmente, utilizando múltiplas instâncias para atender demandas crescentes. O uso de processos concorrentes permite que diferentes partes da aplicação rodem independentemente, otimizando a performance. Em contrapartida, sistemas monolíticos costumam ter maior dependência entre componentes, dificultando a escalabilidade e a concorrência eficiente.

# Logs

O registro de logs deve ser tratado como um fluxo de eventos, direcionado para ferramentas externas de análise e monitoramento. Isso permite que problemas sejam identificados e resolvidos rapidamente, sem depender de armazenamento local. No modelo monolítico, logs geralmente são armazenados localmente ou em arquivos específicos do servidor, o que pode dificultar a coleta e análise centralizada de dados.

Comparativo entre Arquiteturas

Monolítica:

- Configurações acopladas ao código.

- Concorrência limitada devido à estrutura única.

- Logs armazenados localmente, dificultando análise distribuída.

Microserviços:

- Configurações gerenciadas externamente via variáveis de ambiente.

- Concorrência por meio de escalabilidade horizontal.

- Logs coletados e processados externamente.

### Exercício 2: CI/CD e Serviços Stateless

* Microserviços devem ser projetados como stateless (sem estado) para facilitar sua escalabilidade, resiliência e integração com pipelines de CI/CD. Isso significa que um serviço não deve armazenar informações críticas na memória ou no disco local, mas sim em repositórios externos, como bancos de dados ou sistemas de cache distribuído.

## Importância para CI/CD:

- Facilita a implementação de novas versões, pois instâncias podem ser destruídas e recriadas sem perda de dados.

- Permite escalabilidade automática sem preocupação com sincronização de estados entre instâncias.

- Reduz a complexidade da manutenção, pois cada instância é independente.

## Problema ao Ter Estado:

Se um microserviço armazena estado localmente e uma de suas instâncias é desligada, os dados armazenados naquela instância serão perdidos. Isso pode causar inconsistências e falhas na aplicação, além de dificultar a distribuição de carga entre novas instâncias criadas automaticamente.

Por isso, projetar microserviços sem estado é essencial para garantir alta disponibilidade, facilidade de manutenção e implementação eficiente de um pipeline CI/CD.