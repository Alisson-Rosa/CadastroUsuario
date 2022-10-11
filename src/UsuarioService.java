import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UsuarioService {

    public static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static boolean isValidadorEmail(String email) {
        boolean validator = false;
        if (email != null && email.length() > 0) {
            String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
            Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(email);
            validator = matcher.matches();
        }

        if(!validator){
            System.out.println("\nEmail no formato invalido! Digite novamente.\n");
        }
        return validator;
    }

    public static boolean isValidadorTelefone(String telefone) {
        boolean validator = false;
        if (telefone != null && telefone.length() > 0) {
            String expression = "^(\\([0-9]{2}\\))\\s([9]{1})?([0-9]{4})-([0-9]{4})$"; //formato (41) 9999-9999 ou (41) 99999-9999
            Pattern pattern = Pattern.compile(expression);
            Matcher matcher = pattern.matcher(telefone);
            validator = matcher.matches();
        }

        if(!validator) {
            System.out.println("\nTelefone no formato invalido! Digite novamente.\n");
        }
        return validator;
    }

    public static boolean isValidadorCPF(String cpf) {
        boolean validator = false;
        if (cpf != null && cpf.length() > 0) {
            String expression = "^[0-9]{3}.?[0-9]{3}.?[0-9]{3}-?[0-9]{2}";
            Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(cpf);
            validator = matcher.matches();
        }

        if(!validator){
            System.out.println("\nCPF no formato invalido! Digite novamente.\n");
        }
        return validator;
    }

    public static boolean isValidadorRG(String rg) {
        boolean validator = false;
        if (rg != null && rg.length() > 0) {
            String expression = "(^\\d{1,2}).?(\\d{3}).?(\\d{3})-?(\\d{1}|X|x$)";
            Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(rg);
            return matcher.matches();
        }

        if(!validator){
            System.out.println("\nRG no formato invalido! Digite novamente.\n");
        }
        return validator;
    }

    public static boolean isValidadorNomeComleto(String nome) {
        String[] nomeSobrenome = nome.split(" ");
        if(nomeSobrenome.length > 1){
            return true;
        }

        System.out.println("\nValor invalido! Digite o nome e sobrenome do usuario. \n");
        return false;
    }

    public static boolean isValidadorDataNascimento(String dataNascimentoStr) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate.parse(dataNascimentoStr, formatter);
            return true;
        } catch (DateTimeParseException e){
            System.out.println("\nData no formato invalido! Digite novamente.\n");
            return false;
        }
    }

    public static boolean isValidadorUF(String uf) {
        if(uf != null && uf.length() == 2){
            return true;
        }

        System.out.println("UF no formato invalido! Digite novamente. ");
        return false;
    }

    public static boolean isValidadorPadrao(String valor) {
        if(valor != null && !valor.equals("")){
            return true;
        }

        System.out.println("Entrada de valor invalido! Digite novamente. ");
        return false;
    }

    public static List<Usuario> buscarUsuarios(String valor, TipoEntrada tipoEntrada, List<Usuario> usuarioList) {
        if(TipoEntrada.NOME.equals(tipoEntrada)){
            return usuarioList.stream().filter(u -> u.getNomeCompleto().toLowerCase().equals(valor.toLowerCase())).toList();
        }
        if(TipoEntrada.CPF.equals(tipoEntrada)){
            return usuarioList.stream().filter(u -> u.getCpf().toLowerCase().equals(valor.toLowerCase())).toList();
        }
        if(TipoEntrada.RG.equals(tipoEntrada)){
            return usuarioList.stream().filter(u -> u.getRg().toLowerCase().equals(valor.toLowerCase())).toList();
        }
        if(TipoEntrada.DATA_NASCIMENTO.equals(tipoEntrada)){
            return usuarioList.stream().filter(u -> u.getDataNascimento().format(formatter).equals(valor.toLowerCase())).toList();
        }
        if(TipoEntrada.EMAIL.equals(tipoEntrada)){
            return usuarioList.stream().filter(u -> u.getEmail().toLowerCase().equals(valor.toLowerCase())).toList();
        }
        if(TipoEntrada.TELEFONE.equals(tipoEntrada)){
            return usuarioList.stream().filter(u -> u.getTelefoneContato().toLowerCase().equals(valor.toLowerCase())).toList();
        }
        if(TipoEntrada.CIDADE.equals(tipoEntrada)){
            return usuarioList.stream().filter(u -> u.getCidade().toLowerCase().equals(valor.toLowerCase())).toList();
        }
        if(TipoEntrada.UF.equals(tipoEntrada)){
            return usuarioList.stream().filter(u -> u.getUf().toLowerCase().equals(valor.toLowerCase())).toList();
        }

        return new ArrayList<>();
    }
}
