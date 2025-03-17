1 - Diferença entre Contêineres e Microservices:

Explicar com suas palavras a diferença entre os dois conceitos.

Os contêineres são uma forma de empacotar e isolar aplicações junto com suas dependências, garantindo que rodem de maneira consistente em diferentes ambientes. Eles utilizam tecnologias como Docker e Kubernetes para fornecer um ambiente leve e portátil.

Os microservices, por outro lado, são uma abordagem arquitetural para desenvolver sistemas como um conjunto de pequenos serviços independentes, cada um responsável por uma funcionalidade específica. Cada microservice pode ser desenvolvido, implantado e escalado separadamente.

Pergunta Extra: É possível subir microservices em uma máquina virtual?

Sim, é possível executar microservices em máquinas virtuais (VMs). No entanto, o uso de contêineres oferece benefícios significativos, como menor consumo de recursos, inicialização mais rápida e melhor escalabilidade. Máquinas virtuais criam um ambiente mais pesado, pois cada VM executa um sistema operacional completo, enquanto contêineres compartilham o kernel do host, tornando a execução mais eficiente.


2 - Integração Contínua:

Explicar a importância do merge frequente de mudanças de código para que a integração contínua funcione adequadamente.

A integração contínua (CI) depende de merges frequentes porque, quanto mais tempo um desenvolvedor mantém mudanças isoladas, maior a chance de conflitos e bugs complexos quando for integrá-las ao código principal. Ao realizar commits pequenos e frequentes, é possível detectar problemas mais cedo, garantindo um fluxo de desenvolvimento mais estável e ágil.


3 - Entrega Contínua:

Explicar por que é necessária uma cobertura abrangente de testes para que a entrega contínua funcione.

A entrega contínua (CD - Continuous Delivery) requer uma cobertura abrangente de testes porque seu objetivo é permitir que qualquer versão do software possa ser implantada a qualquer momento com confiança. Sem uma boa suíte de testes (unitários, integração e aceitação), há um risco maior de implantar código com falhas, comprometendo a qualidade e estabilidade do sistema.


4 - Implantação Contínua:

Explicar as diferenças entre entrega contínua e implantação contínua.

A entrega contínua (Continuous Delivery) garante que o código está sempre pronto para ser implantado, mas a decisão de realmente implantar é manual. Já a implantação contínua (Continuous Deployment) vai além, automatizando completamente a liberação do software, de modo que cada mudança aprovada nos testes é automaticamente implantada em produção.