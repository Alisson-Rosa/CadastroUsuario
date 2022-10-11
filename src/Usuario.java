import java.time.LocalDate;

public class Usuario {

    private String nomeCompleto;
    private String cpf;
    private String rg;
    private LocalDate dataNascimento;
    private String telefoneContato;
    private String email;
    private String cidade;
    private String uf;
    private String foto;

    public Usuario() {
    }

    public Usuario(String nomeCompleto, String cpf, String rg, LocalDate dataNascimento, String telefoneContato, String email, String cidade, String uf, String foto) {
        this.nomeCompleto = nomeCompleto;
        this.cpf = cpf;
        this.rg = rg;
        this.dataNascimento = dataNascimento;
        this.telefoneContato = telefoneContato;
        this.email = email;
        this.cidade = cidade;
        this.uf = uf;
        this.foto = foto;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getTelefoneContato() {
        return telefoneContato;
    }

    public void setTelefoneContato(String telefoneContato) {
        this.telefoneContato = telefoneContato;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    @Override
    public String toString() {
        return "Usuario: " + "\n" +
                "Nome Completo: " + nomeCompleto + "\n" +
                "CPF: " + cpf + "\n" +
                "RG: " + rg + "\n" +
                "Data de Nascimento: " + dataNascimento.format(UsuarioService.formatter) + "\n" +
                "Telefone: " + telefoneContato + "\n" +
                "Email: " + email + "\n" +
                "Cidade: " + cidade + "\n" +
                "UF: " + uf + "\n" +
                "Foto: " + foto + "\n"
                ;
    }
}
