# Dio - Bootcamp Java Cloud Native
## Feature: Lab Configurando uma instância de Banco de Dados na Azure

## CRIAÇÃO DE VMS NA AZURE

### 1. Menu de criação:
- Após fazer login na Azure, digite na barra de pesquisa "SQL do Azure".

- Selecione + Criar para abrir a página de seleção de opção de implantação do SQL.

### 2. Criação da Instância:
- Escolha "Instância única" na lista suspensa e depois clique em "Criar" para abrir a página de criação de instância Gerenciada de SQL do Azure. Preencha todas as informações solicitadas na seção "Básico":

#### 2.1 - Assinatura
Selecione a sua assinatura (terá o menor custo mensal);
#### 2.2 - Grupo de recursos
Digite um grupo de recursos para o sql (nota: leve em conta boas práticas para nomenclatura de grupos);
#### 2.3 - Região
Selecione a região na qual ira criar o recurso (utilize a mais em conta de acordo com pesquisa prévia);
#### 2.4 - Pool de instâncias
Na pergunta "Pertence a um pool de instâncias?" clique em "Sim";
#### 2.5 - Método de autenticação
Selcione "Usar a autenticação do SQL" para ser mais rápido, depois você configura a autenticação com o Microsoft Entra, se lhe for interessante;
#### 2.6 - Logon de Administrador
Em "Logon de administrador da Instância Gerenciada" utilize um nome válido, lembrando da dica anterior (não use Admin, Administrator), e em "Senha" insira uma senha válida e forte (mínimo de 16 caracteres, usando letras, números, caracteres especiais). Selecione "Aplicar".

### 3. Criação da Instância Gerenciada:
- Na guia de "Detalhes da instância gerenciada", selecione "Configurar instância gerenciada" em "Computação + armazenamento" e defina:
#### 3.1 - Camada de Serviço
Selecione "Uso geral";
#### 3.2 - Geração do Hardware
Mantenha em "Série Standard (Gen X)" (mais em conta);
#### 3.3 - vCores
Essa é a quantidade de cores virtuais de processamento da VM do banco de dados. Aumentar o valor implica em aumento do custo. Mantenha o padrão 8 vCores.
#### 3.4 - Armazenamento
Semelhante ao vCores, quanto maior definimos o armazenamento, maior é o custo do serviço. Informe um valor de acordo com a sua necessidade (certamente há um estudo prévio definindo o tamanho previsto do banco);
#### 3.5 - Licença
Selecione o tipo de licença de acordo com o seu bolso (definido no estudo inicial do CapEx);
#### 3.6 - Redundância
Selecione "Armazenamento de backup com redundância geográfica". Assim você garante a integridade do banco em caso de falhas críticas. Selecione "Aplicar".

### 4. Guia de Rede:
- Na guia de "Rede", preencha as informações adicionais de rede, ou deixe o padrão definido pela Azure:
#### 4.1 - Rede virtual ou Sub-rede
Crie uma rede virtual ou use uma existente;
#### 4.2 - Tipo de conexão
Selecione um tipo de conexão de acordo com sua necessidade;
#### 4.3 - Ponto de extremidade público
Desabilite para que não haja acesso público ao banco e selecione "Sem Acesso" na opção seguinte;
Selecione "Revisar + criar" e clique em "Avançar" para ir pra Guia de Segurança.

### 5. Guia de Segurança:
- Deixe padrão. Clique em "Revisar + criar" e clique em "Avançar para Configurações Adicionais".

### 6. Guia de Configurações Adicionais:
- Na guia de "Configurações Adicionais", preencha as informações adicionais de rede, ou deixe o padrão definido pela Azure:
#### 6.1 - Ordenação
Deixe padrão ou (sugestão) utilize Latin1_General_CP1_CI_AS;
#### 6.2 - Fuso horário
Selecione o fuso horário do banco (procure por GMT -3);
#### 6.3 - Replicação geográfica
Selecione "Não" (aumento de custo se sim, mas provê um failover secundário. Vale à pena a análise);
#### 6.4 - Janela de manutenção
Agende uma janela de manutenção para o serviço do bd.
Selecione "Revisar + criar" e clique em "Avançar" para ir pra Marcações.

### 7. Marcações:
- Crie uma marca para identificar o proprietário do serviço e o tipo de ambiente (dev. prod, hml, etc.).

- Selecione "Examinar + criar", revise as escolhas e clique em "Criar" para implantar a instância. Depois de alguns minutos, concluída a implantação, crie o banco de dados.

### 8. Criação do Banco de Dados:
- Para criar o banco de dados, acesse a Instância Gerenciada de SQL que você criou anteriormente;

- Na página "Visão geral", escolha "+ Novo banco de dados" para abrir a página "Criar banco de dados gerenciado do SQL do Azure";

- Dê um nome para o banco de dados na guia "Básico";

- Na guia "Fonte de dados", selecione "Nenhuma" para um banco de dados vazio;

- Defina as configurações restantes e selecione "Revisar + criar" para confirmar;

- Clique em "Criar" para implantar o banco de dados.

### BONUS: Conexão com o Banco de Dados
- Sem muito mistério. Use a string de conexão clássica:

```c#
string conn = @(
    Server=tcp:<nome_do_servidor>.database.windows.net,1433;Database=<nome_do_banco_de_dados>;User ID=<nome_do_usuário>;Password=<sua_senha>;Encrypt=true;TrustServerCertificate=false;Connection Timeout=30;
);
```

- Funcional com SGBD que utilize string de conexão (SSMS - Sql Server Management Studio da Microsoft, ou DBeaver-ce) ou com seu aplicativo em desenvolvimento (API, aplicativo desktop, ou outro).

Cantuario2 - 17/04/2025
### Rev. 00