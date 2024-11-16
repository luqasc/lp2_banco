package Banco;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

//Classe principal; contém o método main
public class Banco 
{
    //Lista de usuários do banco e número de usuários
    List<Usuario> usuarios;
    int numUsuarios;

    //Construtor
    public Banco()
    {
        usuarios = new ArrayList<>();
        numUsuarios = 0;
    }
    
    //Imprime o menu inicial  
    public void exibirMenuInic()
    {
        System.out.println("MENU PRINCIPAL");
        System.out.println("Digite a opção desejada.");
        System.out.println("1 - Cadastrar novo usuário");
        System.out.println("2 - Fazer login");
        System.out.println("3 - Listar todos os usuários");
        System.out.println("4 - Sair");
    }

    //Cadastro de um novo usuário, com nome, CPF e senha
    public void cadastraUsuario(Scanner scanner)
    {
        String name, id, pswrd;

        System.out.println("Digite o nome do usuário.");
        name = scanner.nextLine();
        
        System.out.println("Digite o CPF do usuário (apenas números).");
        id = scanner.nextLine();

        System.out.println("Digite uma senha para o usuário.");
        pswrd = scanner.nextLine();
        
        Usuario user = new Usuario(name, id ,pswrd);
        usuarios.add(user);
        numUsuarios++;
    }

    //Lista todos os usuários atuais
    public void listaUsuarios()
    {
        System.out.println("Lista de usuários:");
        for (int i = 0; i < this.numUsuarios; i++)
        {
            System.out.println(usuarios.get(i).getNome() + " | CPF: " + usuarios.get(i).getCpf());
        }
    }

    //Faz o login do usuário, pedindo CPF e senha, e checando com os dados armazenados na memória
    public int fazLogin(Scanner scanner)
    {
        System.out.println("Digite o CPF do usuário.");
        String cpf = scanner.nextLine();
        boolean achou = false;
        int i;

        //Procura o CPF digitado entre os usuários já cadastrados
        for (i = 0; i < this.numUsuarios; i++)
        {
            if (cpf.equals(usuarios.get(i).getCpf()))
            {
                achou = true;
                break;
            }
        }

        //Se o CPF for encontrado, pede a senha
        if (achou)
        {
            System.out.println("Digite a senha.");
            String senha = scanner.nextLine();

            //Checa se a senha é igual à cadastrada pelo usuário
            if (senha.equals(usuarios.get(i).getSenha()))
            {
                System.out.println("Bem-vindo(a), " + usuarios.get(i).getNome());
                return i;
            }
            //Se não for, retorna ao menu incial.
            else
            {
                System.out.println("Senha incorreta!");
                return -1;
            }
        }
        //Se o CPF não foi encontrado, retorna ao menu inicial.
        else
        {
            System.out.println("Usuário não encontrado!");
            return -1;
        }
    }
    
    //Método principal (main), com o "switch" do menu principal
    public static void main(String[] args)
    {
        /*Instanciação de um objeto "banco" e do "scanner", que será
         *passado para todos os métodos que precisarem dele no futuro,
         *e será fechado somente ao final da execução, no corpo do main.*/

        Banco banco = new Banco();
        Scanner scanner = new Scanner(System.in);
        
        //"op" é a opção digitada pelo usuário
        int op = 0;

        //O laço pára apenas quando o usuário digita "4" (Sair).
        while (op != 4)
        {
            banco.exibirMenuInic();
            op = scanner.nextInt();
            scanner.nextLine();
            
            switch (op)
            {
                //Chama o método de cadastro de usuário
                case 1: banco.cadastraUsuario(scanner);
                        break;
                
                //Chama o método para login 
                case 2: int ind = banco.fazLogin(scanner);
                        //Caso o login tenha sucesso, passa para o menu de contas do usuário
                        if (ind != -1)
                        {
                            banco.usuarios.get(ind).menuContas(scanner, ind, banco.usuarios);
                        }
                        break;
                
                //Chama o método para listagem de usuários
                case 3: banco.listaUsuarios();
                        break;
                
                //Sai do laço
                case 4: break;

                //Caso em que o usuário digita uma opção inválida
                default: System.out.println("Opção inválida. Tente novamente.");
            }
        }
        //Fechamento do scanner
        scanner.close();
    }
}