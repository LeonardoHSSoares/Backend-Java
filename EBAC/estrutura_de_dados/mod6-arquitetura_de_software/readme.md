 ### Análise das arquiteturas monólito e microsserviços em relação aos cinco pilares da engenharia de software:

### Monólitos

Vantagens:

Consistência – Como tudo está centralizado em um único banco de dados, manter a consistência dos dados é mais fácil.
Performance – Chamadas internas entre módulos são mais rápidas, pois não há comunicação por rede.

Desvantagens:

Escalabilidade – Difícil escalar partes individuais da aplicação; geralmente exige replicação da aplicação inteira.
Testabilidade – Testes podem ser mais demorados, pois exigem que a aplicação inteira esteja rodando.


### Microsserviços

Vantagens:

Escalabilidade – Serviços podem ser escalados independentemente com base na demanda.
Disponibilidade – Uma falha em um serviço específico não afeta a aplicação inteira.

Desvantagens:

Consistência – Pode ser difícil garantir consistência dos dados devido à distribuição entre múltiplos bancos.
Performance – Comunicação entre serviços via rede pode gerar latência e impactar o desempenho.