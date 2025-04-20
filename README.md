# Dio - Bootcamp Java Cloud Native
## Feature: Lab Explorando os Recursos de IA Generativa com Copilot e OpenAI

## MICROSOFT COPILOT

### 1. Acesso:
- Para acesso em qualquer computador, em qualquer sistema operacional, utilize o navegador da internet de sua preferência, acessando o link https://copilot.microsoft.com;

### 2. Prompts de Solicitações:
- Solicitações do Copilot são instruções ou perguntas que você usa para dizer ao Copilot o que você quer. As solicitações podem incluir quatro partes:
- - Objetivo (o que você quer):"Quero uma lista de 3 a 5 tópicos para preparar…"
- - Contexto (por que você precisa disso e quem está envolvido):"…para uma próxima reunião com o João..."
- - Expectativas (como o Copilot deve responder):"Responda com um tom de simpatia e competência…"
- - Fonte (quais informações o Copilot deve usar):"Use emails e chats das últimas duas semanas".

- Você pode colocar pouca ou muita informação em uma solicitação, mas só precisa de um objetivo claro. Se quiser ser mais específico, adicione as outras partes. No campo "Mensagem para o Copilot", digite o seu prompt (a sua pergunta) e pressione [Énter].

- Existem dois modos de resposta do copilot:
- - Resposta rápida (2-3s): melhor para perguntas simples e que não requerem um nível maior de indexação (lembra do laboratório anterior?);
- - Think Deeper (~30s): melhor para perguntas mais complexas ou que requerem um nível mais profundo de indexação para uma resposta mais precisa e/ou de maior nível de completude.

- O resultado será exibido e você pode consumí-lo de acordo com sua necessidade. No prompt você pode solicitar por informações, criação de documentos, imagens e até mesmo áudio, no mesmo campo "Mensagem para o Copilot".


## MICROSOFT OPENAI

### 1. Acesso:
- Em um navegador da web, abra o portal do Azure AI Foundry em https://ai.azure.com e faça login usando suas credenciais do Azure:

### 2. Criação de Hub e Novo Projeto
- Na página inicial, selecione "+ Criar" projeto;

- No assistente "Criar um projeto" , insira um nome válido para o seu projeto e, se um hub existente for sugerido, escolha a opção para criar um novo;

- Selecione "Personalizar" e especifique as configurações para o hub:

#### 2.1 - Nome do hub
Informe um nome válido para o hub;

#### 2.2 - Assinatura
Informe sua assinatura do Azure;

#### 2.3 - Grupo de recursos
Crie ou selecione um grupo de recursos;

#### 2.4 - Localização
Selecione "Ajude-me a escolher" e em seguida selecione "gpt-4o";

#### 2.5 - Conecte o Azure AI Services ou o Azure OpenAI
Crie um novo recurso do AI Services;

#### 2.6 - Conectar a Pesquisa de IA do Azure
Selecione "Pular conexão";

- Selecione "Avançar" e após revisar as opções clique em "Criar" e aguarde a conclusão do provisionamento.

- Após a criação, selecione "Central de Gerenciamento". Selecione "Visão geral" no painel de navegação para visualizar os detalhes do hub criado. Em "Propriedades do Hub", selecione o link para o grupo de recursos associado ao hub e entre com suas credenciais do Azure.

### 3. Adicionar um recurso conectado
- No portal do Azure, na página do seu grupo de recursos, selecione "+ Criar" e pesquise por "Azure AI Services". Nos resultados, selecione "Serviços de IA do Azure".

- Crie um novo recurso do Azure AI Services com as seguintes configurações:

#### 3.1 - Assinatura
Informe sua assinatura do Azure;
#### 3.2 - Grupo de recursos
Informe o grupo de recursos que contém seus recursos existentes do Azure AI Foundry;
#### 3.3 - Região
Selecione qualquer região disponível diferente daquela que contém seus recursos existentes (importante);
#### 3.4 - Nome
Informe um nome adequado para seu segundo recurso do Azure AI Services;
#### 3.5 - Nível de preço
Selecione "Standard S0".

- Aguarde a criação do recurso de Serviços de IA e então retorne à guia do navegador do portal do Azure AI Foundry e, na visualização do Centro de Gerenciamento, no painel de navegação, na seção do seu projeto, visualize a página "Recursos conectados".

- Selecione "+ Nova conexão" e selecione o tipo de recurso "Serviços de IA do Azure". Em seguida, navegue pelos recursos disponíveis para encontrar o recurso Serviços de IA que você criou no portal do Azure e use o botão "Adicionar Conexão" para adicioná-lo ao seu projeto.

- Verifique se os novos recursos conectados para os Serviços de IA do Azure e o Serviço OpenAI do Azure estão presentes.

### 4. Explorar serviços de IA
- Na página Central de gerenciamento selecione "Ir para o projeto";

- No painel de navegação do seu projeto, selecione "Serviços de IA" e depois selecione "Idioma e Tradutor";

- Na seção "Explorar recursos de idioma" localize a guia "Tradução" e selecione "Tradução de texto";

- Na página "Tradução de texto", na seção "Experimente", localize a aba "Experimente com o seu próprio". Selecione um dos seus recursos do Azure AI Services e tente traduzir algum texto de um idioma para outro. Vai dar certo.

### 5. Implantar e testar um modelo de IA generativo
- No painel à esquerda do seu projeto, em "Meus ativos", selecione "Modelos + endpoints";

- Na página "Modelos + endpoints", na guia "Implantações de modelo", no menu "+ Implantar modelo", selecione "Implantar modelo base". Procure o modelo "gpt-4o" na lista, selecione-o e confirme;

- Implante o modelo com as seguintes configurações selecionando Personalizar nos detalhes da implantação:

#### 5.1 - Nome da implantação
Informe um nome válido para a implantação do seu modelo;
#### 5.2 - Tipo de implantação
Selecione "Padrão global";
#### 5.3 - Atualização automática de versão
Deixe "Habilitado";
#### 5.4 - Versão do modelo
Selecione a versão mais recente disponível;
#### 5.5 - Recurso de IA conectado
Selecione a conexão de recurso do Azure OpenAI;
#### 5.6 - Limite de taxa de tokens por minuto (milhares)
Deixe 50 mil (ou o máximo disponível em sua assinatura, se for menor que 50 mil);
#### 5.7 - Filtro de conteúdo
Deixe no padrão "DefaultV2".

- Aguarde a conclusão da implantação e após a implantação do modelo, na página de visão geral da implantação, selecione "Abrir no playground";

- Na página do "playground de bate-papo", certifique-se de que a implantação do seu modelo esteja selecionada na seção "Implantação". Então, no painel "Configuração", na caixa "Fornecer instruções e contexto ao modelo", insira as instruções que você deseja testar (uma frase em inglês, por exemplo, que será analisada pelo modelo);

- Aplique as alterações para atualizar a mensagem do sistema.

- Na janela de bate-papo, insira uma consulta como por exemplo "What are the key events in the history of Scotland?" e veja o modelo lhe dar a resposta.

### 6. Dica de Ouro: Exclua os serviços
- Sempre após conluir a atividade, o estudo ou avaliação, exclua os serviços provisionados para que não haja cobrança adicional.

Cantuario2 - 20/04/2025
### Rev. 00