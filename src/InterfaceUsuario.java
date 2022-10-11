import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InterfaceUsuario {

    public void menuPrincipal(){
        Scanner sc = new Scanner(System.in);
        List<Usuario> usuarioList = new ArrayList<>();
        int opcao = 0;

        while (opcao != 9){
            System.out.println("\n\tMenu\n");
            System.out.println("1 - Cadastrar novo usuario");
            System.out.println("2 - Buscar usuarios");
            System.out.println("3 - Listar usuarios");
            System.out.println("4 - Deletar usuarios");
            System.out.println("9 - Sair \n");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao){
                case 1:
                    System.out.println("\n\tCadastro de Usuario ");
                    Usuario usuario = cadastrarUsuario(sc);
                    usuarioList.add(usuario);
                    break;
                case 2:
                    if(usuarioList.isEmpty()){
                        System.out.println("\nNenhum Usuario Cadastrado!");
                        break;
                    }
                    System.out.println("\n\tBuscar Usuarios ");
                    menuBuscarUsuarios(sc, usuarioList);
                    break;
                case 3:
                    if(usuarioList.isEmpty()){
                        System.out.println("\nNenhum Usuario Cadastrado!");
                        break;
                    }
                    System.out.println("\n\tListar Usuarios ");
                    listarUsuarios(usuarioList, sc);
                    break;
                case 4:
                    if(usuarioList.isEmpty()){
                        System.out.println("\nNenhum Usuario Cadastrado!");
                        break;
                    }
                    System.out.println("\n\tDeletar Usuarios ");
                    menuDeletarUsuarios(sc, usuarioList);
                    break;
                case 9:
                    break;
            }
        }
    }

    private void menuBuscarUsuarios(Scanner sc, List<Usuario> usuarioList) {
        int opcao = 0;
        while (opcao != 9) {
            System.out.println("1 - Buscar pelo Nome");
            System.out.println("2 - Buscar pelo CPF");
            System.out.println("3 - Buscar pelo RG");
            System.out.println("4 - Buscar pela Data de Nascimento");
            System.out.println("5 - Buscar pelo Telefone");
            System.out.println("6 - Buscar pelo Email");
            System.out.println("7 - Buscar pela Cidade");
            System.out.println("8 - Buscar pela UF");
            System.out.println("9 - Voltar\n");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao){
                case 1:
                    buscarUsuarios(sc, TipoEntrada.NOME, usuarioList);
                    break;
                case 2:
                    buscarUsuarios(sc, TipoEntrada.CPF, usuarioList);
                    break;
                case 3:
                    buscarUsuarios(sc, TipoEntrada.RG, usuarioList);
                    break;
                case 4:
                    buscarUsuarios(sc, TipoEntrada.DATA_NASCIMENTO, usuarioList);
                    break;
                case 5:
                    buscarUsuarios(sc, TipoEntrada.TELEFONE, usuarioList);
                    break;
                case 6:
                    buscarUsuarios(sc, TipoEntrada.EMAIL, usuarioList);
                    break;
                case 7:
                    buscarUsuarios(sc, TipoEntrada.CIDADE, usuarioList);
                    break;
                case 8:
                    buscarUsuarios(sc, TipoEntrada.UF, usuarioList);
                    break;
                case 9:
                    break;
            }
        }
    }

    private void menuDeletarUsuarios(Scanner sc, List<Usuario> usuarioList) {
        int opcao = 0;
        while (opcao != 9) {
            System.out.println("1 - Deletar pelo Nome");
            System.out.println("2 - Deletar pelo CPF");
            System.out.println("3 - Deletar pelo RG");
            System.out.println("4 - Deletar pela Data de Nascimento");
            System.out.println("5 - Deletar pelo Telefone");
            System.out.println("6 - Deletar pelo Email");
            System.out.println("7 - Deletar pela Cidade");
            System.out.println("8 - Deletar pela UF");
            System.out.println("9 - Voltar\n");
            opcao = sc.nextInt();
            sc.nextLine();

            List<Usuario> usuariosFiltrados = new ArrayList<>();
            switch (opcao){
                case 1:
                    usuariosFiltrados = buscarUsuarios(sc, TipoEntrada.NOME, usuarioList);
                    deletarUsuarios(usuariosFiltrados, usuarioList);
                    break;
                case 2:
                    usuariosFiltrados = buscarUsuarios(sc, TipoEntrada.CPF, usuarioList);
                    deletarUsuarios(usuariosFiltrados, usuarioList);
                    break;
                case 3:
                    usuariosFiltrados = buscarUsuarios(sc, TipoEntrada.RG, usuarioList);
                    deletarUsuarios(usuariosFiltrados, usuarioList);
                    break;
                case 4:
                    usuariosFiltrados = buscarUsuarios(sc, TipoEntrada.DATA_NASCIMENTO, usuarioList);
                    deletarUsuarios(usuariosFiltrados, usuarioList);
                    break;
                case 5:
                    usuariosFiltrados = buscarUsuarios(sc, TipoEntrada.TELEFONE, usuarioList);
                    deletarUsuarios(usuariosFiltrados, usuarioList);
                    break;
                case 6:
                    usuariosFiltrados = buscarUsuarios(sc, TipoEntrada.EMAIL, usuarioList);
                    deletarUsuarios(usuariosFiltrados, usuarioList);
                    break;
                case 7:
                    usuariosFiltrados = buscarUsuarios(sc, TipoEntrada.CIDADE, usuarioList);
                    deletarUsuarios(usuariosFiltrados, usuarioList);
                    break;
                case 8:
                    usuariosFiltrados = buscarUsuarios(sc, TipoEntrada.UF, usuarioList);
                    deletarUsuarios(usuariosFiltrados, usuarioList);
                    break;
                case 9:
                    break;
            }
        }
    }

    private void deletarUsuarios(List<Usuario> usuariosFiltrados, List<Usuario> usuarioList) {
        if(usuariosFiltrados.isEmpty()){
            return;
        }
        boolean removeAll = usuarioList.removeAll(usuariosFiltrados);
        if(removeAll){
            System.out.println("Usuarios deletados com sucesso!");
        } else {
            System.out.println("Erro ao deletar todos os usuarios!");
        }
    }

    private List<Usuario> buscarUsuarios(Scanner sc, TipoEntrada tipoEntrada, List<Usuario> usuarioList) {
        System.out.println("Digite: ");
        String valor = sc.nextLine();
        List<Usuario> usuariosFiltradosList = UsuarioService.buscarUsuarios(valor, tipoEntrada, usuarioList);
        listarUsuarios(usuariosFiltradosList, sc);

        return usuariosFiltradosList;
    }

    private void listarUsuarios(List<Usuario> usuarioList, Scanner sc) {
        if(!usuarioList.isEmpty()){
            System.out.println("\n\t USUARIOS ");
            for (Usuario usuario : usuarioList) {
                System.out.println("\n" + usuario.toString());
                System.out.println("_________________________________________________________________________________\n");
            }
        } else {
            System.out.println("Nao encontrado nenhum usuario.");
        }
        System.out.println("Pressione Enter para continuar...");

        sc.nextLine();
    }

    private Usuario cadastrarUsuario(Scanner sc) {
        String campoNomeUsuario = "Informe o nome e sobrenome do novo usuario: ";
        String nome = entradaDeDados(campoNomeUsuario, sc, TipoEntrada.NOME);

        String campoCPF = "Informe o cpf do novo usuario: ";
        String cpf = entradaDeDados(campoCPF, sc, TipoEntrada.CPF);

        String campoRG = "Informe o rg do novo usuario: ";
        String rg = entradaDeDados(campoRG, sc, TipoEntrada.RG);

        String campoDataNascimento = "Informe a data de nascimento do novo usuario: (dia/mes/ano)";
        String dataNascimentoStr = entradaDeDados(campoDataNascimento, sc, TipoEntrada.DATA_NASCIMENTO);

        String campoTelefone = "Informe o telefone de contato do novo usuario: ((XX) xxxxx-xxxx OU (XX) xxxx-xxxx) ";
        String telefoneContato = entradaDeDados(campoTelefone, sc, TipoEntrada.TELEFONE);;

        String campoEmail = "Informe o email do novo usuario: ";
        String email = entradaDeDados(campoEmail, sc, TipoEntrada.EMAIL);

        String campoCidade = "Informe a cidade do novo usuario: ";
        String cidade = entradaDeDados(campoCidade, sc, TipoEntrada.PADRAO);

        String campoUF = "Informe a uf do novo usuario: ";
        String uf = entradaDeDados(campoUF, sc, TipoEntrada.UF);

        LocalDate dataNascimento = LocalDate.parse(dataNascimentoStr, UsuarioService.formatter);

        return new Usuario(nome, cpf, rg, dataNascimento, telefoneContato, email, cidade, uf, "");
    }

    private String entradaDeDados(String texto, Scanner sc, TipoEntrada tipoEntrada){
        String valor = "";
        do {
            System.out.println(texto);
            valor = sc.nextLine();
        } while (!validarValor(valor, tipoEntrada));

        return valor;
    }

    private boolean validarValor(String valor, TipoEntrada tipoEntrada){
        if(TipoEntrada.PADRAO.equals(tipoEntrada)){
            return UsuarioService.isValidadorPadrao(valor);
        }
        if(TipoEntrada.CPF.equals(tipoEntrada)){
            return UsuarioService.isValidadorCPF(valor);
        }
        if(TipoEntrada.UF.equals(tipoEntrada)){
            return UsuarioService.isValidadorUF(valor);
        }
        if(TipoEntrada.EMAIL.equals(tipoEntrada)){
            return UsuarioService.isValidadorEmail(valor);
        }
        if(TipoEntrada.TELEFONE.equals(tipoEntrada)){
            return UsuarioService.isValidadorTelefone(valor);
        }
        if(TipoEntrada.RG.equals(tipoEntrada)){
            return UsuarioService.isValidadorRG(valor);
        }
        if(TipoEntrada.DATA_NASCIMENTO.equals(tipoEntrada)){
            return UsuarioService.isValidadorDataNascimento(valor);
        }
        if(TipoEntrada.NOME.equals(tipoEntrada)){
            return UsuarioService.isValidadorNomeComleto(valor);
        }

        return true;
    }
}
