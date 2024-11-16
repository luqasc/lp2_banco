package Banco;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

//Classe do usuário
public class Usuario 
{
    //Dados privados do usuário: nome, CPF, senha e informações de suas contas.
    private String nome, cpf, senha;
    private List<Conta> contas;
    private int numContas;

    //Construtor
    public Usuario(String _nome, String _cpf, String _senha)
    {
        this.nome = _nome;
        this.cpf = _cpf;
        this.senha = _senha;
        this.contas = new ArrayList<>();
        numContas = 0;
    }

    //Getters e setters
    public String getNome()
    {
        return nome;
    }

    public void setNome(String _nome)
    {
        this.nome = _nome;
    }

    public String getCpf()
    {
        return cpf;
    }

    public void setCpf(String _cpf)
    {
        this.cpf = _cpf;
    }

    public String getSenha()
    {
        return senha;
    }

    public void setSenha(String _senha)
    {
        this.senha = _senha;
    }

    public int getNumContas()
    {
        return numContas;
    }

    public List<Conta> getContas()
    {
        return contas;
    }

    /*Método para cadastro de uma nova conta.
     *O sistema adota um método automático simples para numeração das contas: 
     *O primeiro usuário cadastrado tem número "1", 
     *e sua primeira conta criada tem o número 1.000, sua segunda 1.001,
     *e assim por diante. O segundo usuário cadastrado terá as contas
     *2.000, 2.001, 2.002, etc.*/
    public void cadastrarConta(int ind)
    {
        String id = String.valueOf(ind + 1) + ".00" + this.numContas;
        Conta conta = new Conta(0, id);
        contas.add(conta);
        numContas++;
        System.out.println("Sua nova conta tem o número " + id + ".");
    }

    //Lista todas as contas do usuário
    public void listarContas()
    {
        System.out.println("Contas do usuário:");
        for (int i = 0; i < numContas; i++)
        {
            System.out.println("Conta " + this.contas.get(i).getId());
        }
    }

    //Método para acesso ao menu de transações de uma conta específica
    public int acessarConta(Scanner scanner)
    {
        System.out.println("Digite o número da conta.");
        String id = scanner.nextLine();
        boolean achou = false;
        int i;

        //Procura o número digitado pelo usuário entre as contas cadastradas
        for (i = 0; i < this.numContas; i++)
        {
            if (id.equals(contas.get(i).getId()))
            {
                achou = true;
                System.out.println("Acesso liberado.");
                break;
            }
        }
        
        //Se a conta for encontrada, retorna o índice da conta na lista de contas
        if (achou)
        {
            return i;
        }
        //Senão, retorna -1.
        else
        {
            System.out.println("Conta não encontrada!");
            return -1;
        }
    }

    /*Exibe o menu de opções de contas para o usuário
     *Recebe o scanner, o índice do usuário na lista de usuários
     *e a lista de usuários em si (necessária para o método de
     *transferência entre contas).*/
    public void menuContas(Scanner scanner, int ind, List<Usuario> usuarios)
    {
        //"op" é a opção digitada pelo usuário
        int op = 0;
        //Laço repete até que o usuário digite "4" (Sair)
        while (op != 4)
        {
            System.out.println("MENU DO USUÁRIO");
            System.out.println("Digite a opção desejada.");
            System.out.println("1 - Cadastrar nova conta");
            System.out.println("2 - Acessar uma conta");
            System.out.println("3 - Listar suas contas");
            System.out.println("4 - Voltar ao menu principal (logout)");
            
            op = scanner.nextInt();
            scanner.nextLine();
            switch (op)
            {
                //Chama o método para cadastro de conta
                case 1: cadastrarConta(ind);
                        break;
                
                /*Chama o método para acesso de conta; caso a conta digitada exista,
                 *acessa o método do menu de transações da conta, da classe "Conta"*/
                case 2: ind = acessarConta(scanner);
                        if (ind != -1)
                        {
                            this.contas.get(ind).menuTransacoes(scanner, usuarios);
                        }
                        break;
                //Chama o método para listagem de contas do usuário
                case 3: listarContas();
                        break;
                //Quebra o laço (opção de saída)
                case 4: break;
                //Caso de opção inválida
                default: System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}