# Sistema Bancário Simplificado

Este é um projeto em Java que implementa um sistema bancário simplificado. Ele permite o cadastro de usuários, login com CPF e senha, e a gestão de múltiplas contas para cada usuário. Cada conta suporta operações como consulta de saldo, saques, depósitos e transferências.

## Funcionalidades
1. **Cadastro de Usuários**: 
   Registra usuários com nome, CPF e senha.
   
2. **Login**: 
   Autentica usuários com CPF e senha.
   
3. **Gestão de Contas**: 
   Permite criar, listar e acessar contas associadas ao usuário logado.
   
4. **Operações Bancárias**:
   - Consulta de saldo.
   - Saques.
   - Depósitos.
   - Transferências entre contas.

## Estrutura do Projeto
O projeto é composto por três classes principais:

1. **Banco**: 
   Responsável pela interface principal do sistema, onde os usuários podem cadastrar-se, fazer login e listar usuários.
2. **Usuario**: 
   Representa um usuário do banco, contendo métodos para gestão de contas e controle de acessos.
3. **Conta**: 
   Modela as contas bancárias e implementa as operações disponíveis.

## Requisitos
- Java Development Kit (JDK) 8 ou superior.
- Um editor ou IDE para Java (ex.: IntelliJ IDEA, Eclipse, VS Code).

## Como Executar
1. Clone este repositório para sua máquina local.
2. Compile os arquivos `.java` utilizando um terminal ou sua IDE de preferência. Pode ser utilizado o comando javac Banco/*.java, na pasta onde está contida a pasta "Banco".
3. Execute o programa com o comando: java Banco.Banco

4. Siga as instruções do menu principal para interagir com o sistema.

## Exemplo de Uso
1. **Cadastro de um novo usuário**: 
   Informe nome, CPF e uma senha ao escolher a opção 1 do menu inicial.
   
2. **Login**: 
   Insira o CPF e a senha cadastrados ao selecionar a opção 2.
   
3. **Gestão de contas**:
   - Crie uma nova conta.
   - Consulte suas contas existentes.
   - Realize operações como saques, depósitos e transferências (caso exista mais de uma conta cadastrada).

## Observações
- Este sistema é voltado para fins educacionais e de demonstração.
- Não inclui persistência de dados (as informações são mantidas apenas durante a execução do programa).

---

Bom uso!