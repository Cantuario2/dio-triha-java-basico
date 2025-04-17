# Dio - Bootcamp Java Cloud Native
## Feature: Lab Criando máquinas Virtuais na Azure

## CRIAÇÃO DE VMS NA AZURE

### 1. Menu de criação:
- Após fazer login na Azure, digite na barra de pesquisa "máquinas virtuais" ou somente "virtual" (neste caso a busca terá que ser refinada manualmente, navegando-se pelas opções).

- Em "Serviços" selecione "Máquinas Virtuais", e na página seguinte clique em "Criar" e selecione "Máquina virtual do Azure".

### 2. Criação da Máquina Virtual:
- Depois de aberta a página de criação de máquinas virtuais, siga a sequência:

#### 2.1 - Identificação
Digite o nome da máquina virtual no campo "Nome da Máquina Virtual";
#### 2.2 - Disponibilidade
Selecione a região de acordo com pesquisa prévia de disponibilidade e custo (dica: selecione sempre a região mais barata);
#### 2.3 - Sistema Operacional
Em "Imagem", selecione o sistema operacional que deseja utilizar na vm, de acordo com sua necessidade;
#### 2.4 - Conta Admin
Vá para a guia "Conta de Administrador" e insira as credenciais para a conta de administrador conforme sua necessidade (dica: não use Admin ou Administrator para não facilitar o trabalho do pen tester utilizando brute force, e utilize uma senha forte contendo maiúsculas, números, letras e caracteres especiais);
#### 2.5 - Conectividade
Desça agora para "Regras de Entrada" e escolha em "Portas públicas" a opção "Permitir portas selecionadas" e selecione a porta RDP em "Portas de Entradas Selecionadas";
#### 2.6 - Licenciamento
Caso você tenha alguma licensa válida para um dos sistemas operacionais disponíveis, em "Licenciamento", insira a licensa para a VM e isso reduzirá ainda mais o custo dessa. DICA DE OURO.
#### 2.7 - Finalização da Criação
Clique no botão "Examinar + Criar" no fim da página e após a validação, clique no botão "Criar". Aguarde alguns momentos até a finalização da criação. Concluída a criação (ou provisionamento caso queira utilizar o jargão), clique em "Ir para o recurso".

Pronto! A VM foi criada!

### 3. Conectando-se com a VM:
- Na página de visualização das Máquinas Virtuais, selecione a máquina virtual que foi criada nos passos anteriores. Na tela de detalhes da VM, clique em "Conectar" e em seguida, em "RDP". Sem alterar as opções clique em "Baixar arquivo RDP".

- Windows: Após baixar o arquivo RDP, dê duplo clique nele, aguarde, e clique em "Conectar" quando aparecer o menu. Na guia de Segurança, vá em "Mais opções" e localize "Usar uma conta diferente" e lá digite as credenciais de administrador utilizadas na criação da VM, colocando no campo de nome de usuário localhost/<nome_do_usuario_adm> e no campo de senha, insira a senha definida para o usuário adm. Será solicitado a instalação do certificado da VM da Azure no computador que está tentando o acesso remoto, então clique me "Sim" para aceitar o certificado e depois em "Continuar" para acessar a VM.

- Linux: para acesso remoto com um computador utilizando o Linux, utilize o VNC Viewer (testado). Baixe o arquivo RDP para o seu computador Linux. Instale o VNC Viewer para Linux (apt-get install -y vncviewer) e depois de concluir a instalação, feche e abra novamente o terminal. Então, digite "vncviewer /home/<seu_usuario>/Downloads/arquivo.rdp" e então será solicitado a inserção do nome de usuário e senha da VM do Windows na Azure, então insira as credenciais do usuário adm informadas no ato da criação da VM.

Cantuario2 - 16/04/2025
### Rev. 01
