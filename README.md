# Dio - Bootcamp Java Cloud Native
## Feature: Lab Construindo Arquiteturas no Azure

## CRIAÇÃO GRUPOS DE RECURSO

### 1. Menu de criação:
- Após fazer login na Azure, digite na barra de pesquisa "Grupos de recursos".

- Selecione + Criar para abrir a página de criação.

### 2. Criação:
- Clique em "Criar" e insira os valores principais:

#### 2.1 - Assinatura
Selecione a sua assinatura (terá o menor custo mensal);
#### 2.2 - Grupo de recursos
Digite um grupo de recursos para o sql (nota: leve em conta boas práticas para nomenclatura de grupos);
#### 2.3 - Região
Selecione a região na qual ira criar o recurso (utilize a mais em conta de acordo com pesquisa prévia).

- Clique em "Examinar + criar" para validar as informações digitadas/escolhidas anteriormente e em seguida clique em "Criar". A implantação leva alguns segundos (é mais rápida que as implantações anteriores de banco de dados e de máquinas virutais).

- Por fim, clique em atualizar no menu superior para sincronizar as informações de exibição de grupos de recurso.

### 3. Manipular os Grupos de Recursos:
- Para todas as manipulações, primeiramente, entre no portal da Azure e em seguida para cada uma delas, faça:
#### 3.1 - Listar os Grupos de Recursos
Selecione "Grupos de recursos" e selecione as colunas que deseja visualizar na tela;
#### 3.2 - Abrir os Grupos de Recursos
Após o passo anterior, clique no grupo de recursos que deseja abrir. Neste local você vislumbra as informações do seu grupo de recursos;
#### 3.3 - Operações com o Grupo de Recursos
- Neste ponto você aplicar marcas ao grupo de recursos, bloqueá-lo ou excluí-lo. Basta selecionar a opção correspondente, confirmar, e executar a ação.

- Um grupo de recursos inicialmente parece ser algo simples, mas é importantíssimo para organização da atividade, principalmente quando trabalhamos com Terraform, por exemplo.

Cantuario2 - 18/04/2025
### Rev. 00