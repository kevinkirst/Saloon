package entity;

public class Cliente {

    private String nome;
    private String CPF;
    private String telefone;
    private String endereço;

    public Cliente() {
    }

    public Cliente(String nome, String CPF, String telefone, String endereço) {
        this.nome = nome;
        this.CPF = CPF;
        this.telefone = telefone;
        this.endereço = endereço;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereço() {
        return endereço;
    }

    public void setEndereço(String endereço) {
        this.endereço = endereço;
    }
}