# Dio - Bootcamp Java Cloud Native
## Feature: Lab Azure Cognitive Search: Utilizando AI Search para indexação e consulta de Dados

## AZURE AI SEARCH

### 1. Menu de criação:
- Será necessário criar três recursos necessários para a atividade: pesquisa do Azure AI, serviços de IA do Azure e conta de armazenamento.Após fazer login na Azure, clique "+ Criar unm recurso" e localize "Azure AI Search":

### 2. Criação da Instância de Recurso de Pesquisa do Azure:
- Então, crie um recurso contendo:

#### 2.1 - Assinatura
Selecione a sua assinatura (terá o menor custo mensal);
#### 2.2 - Grupo de recursos
Digite um grupo de recursos para o sql (nota: leve em conta boas práticas para nomenclatura de grupos);
#### 2.3 - Nome do Serviço
Utilize um nome exclusivo (que ainda não tenha sido utilizado), seguindo as regras de nomenclatura (sem maiúsculas e etc.);
#### 2.4 - Localização
Selecione sua região (sugestão: utilize East US 2 para menor custo);
#### 2.5 - Nível de Preço
Selcione "Básico".

- Selecione "Revisar + criar" e depois de receber a resposta de validação bem-sucedida, clique em "Criar". Aguarde a implementação e então clique em "Ir para o recurso".

### 3. Criação da Instância de Serviços de IA do Azure:
- Volte à página inicial do portal do Azure e clique em "+ Criar um recurso" e pesquise por "Serviços de IA do Azure", então clique em "Criar um plano de Serviços de IA do Azure". Crie o recurso contendo:

#### 3.1 - Assinatura
Selecione a sua assinatura (terá o menor custo mensal);
#### 3.2 - Grupo de recursos
Digite um grupo de recursos para o sql (nota: leve em conta boas práticas para nomenclatura de grupos);
#### 3.3 - Região
Selecione sua região (sugestão: utilize East US 2 para menor custo);
#### 3.4 - Nome
Utilize um nome exclusivo (que ainda não tenha sido utilizado), seguindo as regras de nomenclatura (sem maiúsculas e etc.);
#### 3.5 - Nível de Preço
Selcione "Standard SO".

- Marque a caixa "Reconheço que li e compreendi todos os termos..." e então selecione "Revisar + criar" e depois de receber a resposta de validação bem-sucedida, clique em "Criar". Aguarde a implementação.

### 4. Criação da Conta de Armazenamento:
- Volte à página inicial do portal do Azure e clique em "+ Criar um recurso" e pesquise por "conta de armazenamento", então clique em "Conta de armazenamento" e crie o recurso contendo:

#### 4.1 - Assinatura
Selecione a sua assinatura (terá o menor custo mensal);
#### 4.2 - Grupo de recursos
Digite um grupo de recursos para o sql (nota: leve em conta boas práticas para nomenclatura de grupos);
#### 4.3 - Nome da conta de armazenamento
Utilize um nome exclusivo (que ainda não tenha sido utilizado), seguindo as regras de nomenclatura (sem maiúsculas e etc.);
#### 4.4 - Localização
Escolha qualquer uma disponível. Dependerá do seu nível de usuário;
#### 4.5 - Desempenho
Selcione "Padrão";
#### 4.6 - Redundância
Utilize "Armazenamento redundante localmente (LRS)".

- Selecione "Revisar" e depois em "Criar" e aguarde a implementação ser concluída. Então, clique na conta de armazenamento criada e no menu à esquerda clique em "Configuração" e altere a configuração de permissão "Permitira acesso anônimo de Blob" para "Habilitado" e clique em "Salvar".

- O ambiente está pronto para a atividade. Como sugestão do lab, baixe o arquivo "reviews.zip" do link "https://aka.ms/mslearn-coffee-reviews" e extraia-o para seu conteúdo ser utilizado como base de estudo.

### 5. Execução da Atividade de Carga de Documentos:
- Ainda dentro da Conta de Armazenamento, localize no menu à esquerda a opção "Contêineres" e clique nela, em seguida clique em "+ Contêiner" e crie um container com as opções:

#### 5.1 - Nome
Utilize um nome exclusivo (que ainda não tenha sido utilizado), seguindo as regras de nomenclatura (sem maiúsculas e etc.) ou se for utilizar o arquivo de reviews baixado do link sugerido, utilize "coffee-reviews";
#### 5.2 - Nível de acesso público
Utilize "Contêiner (acesso de leitura anônimo para contêineres e blobs)";
#### 5.3 - Avançado
Mantenha o que estiver sugerido;

- Em seguida, selecione o container criado e clique em "Carregar", e em "Carregar blob" clique em "Selecionar um arquivo". Neste momento você fará o upload dos seus arquivos para indexação. Selecione a pasta onde eles estão localizados, selecione todos eles e em seguida clique em "Abrir" e depois em "Carregar". Após a conlusão os arquivos estarão no container criado.

### 6. Execução da Atividade de Indexação dos Documentos:
- Volte à página inicial do Portal Azure e localize o recurso "Azure AI Search" e na página de visão geral, clique em "Importar dados";

- Em "Conectar aos seus dados", em "Fonte de Dados" selecione "Armazenamento de Blobs do Azure" e preencha os detalhes da repo com:

#### 6.1 - Fonte de dados
Selecione "Armazenamento de Blobs do Azure";
#### 6.2 - Nome da fonte de dados
Utilize um nome exclusivo (que ainda não tenha sido utilizado), seguindo as regras de nomenclatura (sem maiúsculas e etc.) ou se for utilizar o arquivo de reviews baixado do link sugerido, utilize "coffee-customer-data";
#### 6.3 - Dados a extrair
Utilize "Conteúdo e metadados";
#### 6.4 - Modo de análise
Utilize "Padrão";
#### 6.5 - Cadeia de conexão
Selecione "Escolher uma conexão existente" e em seguida selecione sua conta de armazenamento, o contêiner e clique em "Selecionar";
#### 6.6 - Autenticação de identidade gerenciada
Utilize "Nenhuma";
#### 6.7 - Nome do contêiner
Será preenchido automaticamente após escolher uma conexão existente;
#### 6.8 - Pasta Blob
Deixe em branco;
#### 6.9 - Descrição
Utilize uma descrição que faça sentido com sua atividade, geralmente é a sua situação problema.

- Em seguida, selecione "Próximo: Adicionar habilidades cognitivas" e na seção "Anexar serviços de IA", selecione o recurso de serviços de IA do Azure que foi criado anteriormente.

- Agora vem uma série de configurações. Como eu segui exatamente o roteiro do lab, vou reproduzir a informação de forma fidedigna: na seção "Adicionar enriquecimentos":
- - Altere o nome do Skillset para algumacoisa-skillset;
- - Marque a caixa de seleção Habilitar OCR e mesclar todo o texto no campo merged_content .
Observação: é importante selecionar Ativar OCR para ver todas as opções de campo enriquecidas.

- - Certifique-se de que o campo Dados de origem esteja definido como merged_content .
- - Altere o nível de granularidade de enriquecimento para Páginas (blocos de 5.000 caracteres) .
- - Não selecione Habilitar enriquecimento incremental
- - Selecione os seguintes campos enriquecidos:

- - - Habilidade cognitiva -> Parâmetro	-> ome do campo
- - - Extrair nomes de locais -> " " -> localizações
- - - Extrair frases-chave -> " " -> palavras-chave
- - - Detectar sentimento -> " " -> sentimento
- - - Gerar tags a partir de imagens -> " " -> Etiquetas de imagem
- - - Gerar legendas a partir de imagens -> " " -> legenda da imagem

- Em "Salvar enriquecimentos em um armazenamento de conhecimento", selecione:
- - Projeções de imagens;
- - Documentos;
- - Páginas;
- - Frases-chave;
- - Entidades;
- - Detalhes da imagem;
- - Referências de imagem.

- Selecione "Escolher uma conexão existente" e em seguida selecione a conta de armazenamento que você criou anteriormente. Clique em "+ Contêiner" para criar um novo contêiner chamado "knowledge-store" com o nível de privacidade definido como "Privado" e cliqeu em "Criar". Selecione o contêiner de armazenamento de conhecimento e clique em "Selecionar".

- Selecione "Projeções de blobs do Azure: Documento";

- Selecione "Próximo: Personalizar índice de destino" e altere o nome do índice para "algumacoisa-index";

- Certifique-se de que a Chave esteja definida como "metadata_storage_path". Não altere as sugestões;

- Revise as configurações padrão dos campos de índice. Selecione "filtrável" para todos os campos já selecionados por padrão. Os nomes dos campos que precisam ser marcados como filtráveis ​​incluem: conteúdo, locais, frases-chave, sentimento, conteúdo mesclado, texto, layoutText, imageTags, imageCaption. Selecione, então, "Avançar: Criar um indexador" e altere o nome do indexador para algumacoisa-indexer, e deixe a programação definida para "Uma vez";

- Expanda as opções avançadas, certificando-se de que a opção "Chaves de Codificação Base-64" esteja selecionada, pois isso torna o índice mais eficiente;

- Selecione "Enviar" para criar a fonte de dados, o conjunto de habilidades, o índice e o indexador. O indexador é executado automaticamente e executa o pipeline de indexação, que:
- - Extrai os campos de metadados do documento e o conteúdo da fonte de dados;
- - Executa o conjunto de habilidades cognitivas para gerar campos mais enriquecidos;
- - Mapeia os campos extraídos para o índice.

- Retorne à página de recursos do Azure AI Search. No painel esquerdo, em "Gerenciamento de Pesquisa", selecione "Indexadores". Selecione o 'algumacoisa-indexer' recém-criado. Aguarde e selecione clique em "Atualizar" até que o Status indique sucesso. Geralmente entre um minuto e meio e dois minutos, dependendo da latência da sua rede. Por fim selecione o nome do indexador para ver mais detalhes.

### 7. Fazer consultas no Índice:
- Na página "Visão geral" do serviço de pesquisa, selecione "Explorador de pesquisa":

- O índice selecionado será o índice que você criou. Você pode fazer as consultas com o query view ou com JSON. Fica à seu critério qual a melhor escolha. Sintaxe de pesquisa com o query view:

```sql
search=*&count=true
```
A mesma sintaxe de pesquisa com o JSON:

```json
{
    "search": "*",
    "count": true
}
```

- Faça suas pesquisas de acordo com sua necessidade, filtre o que achar necessário. Um exemplo de busca além da anterior, que trás todos os registros indexados: buscar todos os documentos que contenham a localização Chicago e suas propriedades (caso você tenha carregado os arquivos do arquivo reviews.zip):

```json
{
    "search": "locations:'Chicago'",
    "count": true
}
```

### 8. Dica de Ouro: Exclua os serviços
- Sempre após conluir a atividade, o estudo ou avaliação, exclua os serviços provisionados para que não haja cobrança adicional.

Cantuario2 - 19/04/2025
### Rev. 00