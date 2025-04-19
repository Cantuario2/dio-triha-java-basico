# Dio - Bootcamp Java Cloud Native
## Feature: Lab Análise de Sentimentos com Language Studio no Azure AI

## AZURE SPEECH STUDIO E LANGUAGE STUDIO

### AZURE SPEECH STUDIO

### Conceito:
- O Azure Speech Studio é um conjunto de ferramentas integradas no serviço de Fala de IA do Azure, que permitem criar e integrar recursos como conversão de fala em texto, conversão de texto em fala, tradução de fala, e reconhecimento do locutor, em aplicações e serviços. 

### 1. Utilização:
- Faça o login no portal do Azure Foundry (https://ai.azure.com/?azure-portal=true) com sua conta da Azure, e:

#### 1.1 - Criação do Projeto
Selecione "+ Criar um projeto". Na aba de criação de projeto haverá um nome sugerido, que você pode manter ou trocar, e selecione "Criar um novo recurso", então dê um nome para o recurso e clique em "Avançar";
#### 1.2 - Localização
Selecione East US 2 na licalização (para menor custo) e então clique em "Criar";
#### 1.3 - Serviços de IA
Após a criação, na página principal, selecione "Serviços de IA" no menu e selecione, por exemplo, "Serviços de Fala". Será aberta a página correspondente ao serviço e lá você poderá testar as possibilidades. Você pode escrever um texto e ouvir a transcrição do áudio, ou fazer o upload de um arquivo de vídeo (avi ou m4a são mais rápidos, sendo o avi mais pesado e mais demorado no upload, mas mais rápido na transcrição), e visualizar a transcrição de fala para texto. Isso é bastante interessante para fazer legenda em tempo real de fala, o que é bastante aplicado em acessibilidade atualmente.
#### 1.4 - Dica de Ouro - Exclua os Recursos
Para evitar custos adicionais não previstos (recurso provisionado e não utilizado), exclua os recursos utilizados no serviço, caso sejam apenas testes ou algo que não será implementado imediatamente em algum serviço ou aplicação.


### AZURE LANGUAGE STUDIO

### Conceito:
- O Azure Language Studio é uma ferramenta do Azure que permite interação com a Linguagem de IA do Azure, um serviço de IA baseado em nuvem para processamento de linguagem natural (NLP). Oferece funcionalidades como análise de texto, extração de entidades, análise de sentimentos, entre outras, para facilitar a criação de aplicações inteligentes.

### 2. Utilização:
- Faça o login no portal do Azure Foundry (https://ai.azure.com/?azure-portal=true) com sua conta da Azure, e:

#### 2.1 - Criação do Projeto
Selecione "+ Criar um projeto". Na aba de criação de projeto haverá um nome sugerido, que você pode manter ou trocar, e selecione "Criar um novo recurso", então dê um nome para o recurso e clique em "Avançar";
#### 2.2 - Localização
Selecione East US 2 na licalização (para menor custo) e então clique em "Criar";
#### 2.3 - Playgrounds
Após a criação, na página principal, selecione "Playgrounds" no menu e selecione "Extrair informação", e em seguida:

- Selecione "Extrair entidades nomeadas". Será aberta uma aba "Exemplo", onde você deve escrever o texto que deseja avaliar e extrair as entidades. Insira as informações e selecione "Executar". O texto será avaliado e na guia lateral "Detalhes" será exibida a informação extraída e categorizada.

- Selecione "Extrair frases chave". Será aberta uma aba "Exemplo", onde você deve escrever o texto que deseja avaliar e extrair as entidades. Insira as informações e selecione "Executar". O texto será avaliado e na guia lateral "Detalhes" será exibida a informação extraída e categorizada assim como ocorreu em "Extrair entidades".
#### 2.4 - Resumir Texto
Na guia de Playground, clique em "Resumo de Texto". Será aberta uma aba "Exemplo", onde você deve escrever o texto que deseja avaliar e extrair as entidades. Insira as informações e selecione "Executar". O texto será avaliado e na guia lateral "Detalhes" será exibida a informação extraída e categorizada assim como ocorreu ateriormente, exibindo as sentenças por relevância.
#### 2.5 - Dica de Ouro - Exclua os Recursos
Para evitar custos adicionais não previstos (recurso provisionado e não utilizado), exclua os recursos utilizados no serviço, caso sejam apenas testes ou algo que não será implementado imediatamente em algum serviço ou aplicação.

Cantuario2 - 19/04/2025
### Rev. 00