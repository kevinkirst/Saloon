package entity;

public class Cliente {

    private String nome;
    private String telefone;
//    private String celular; INSERIR
    private String endereco;
//    private String email;  INSERIR
    private String bairro;
    private String numero;

    //CADASTRAR FICHA TECNICA DO CLIENTE JUNTO COM O CADASTRO DA PESSOA (MESMA TELA)
    //private String corCabelo; //NATURAL OU COSMÉTICA
    //private String tipoCabelo; //afro, liso, asiático, ondulado
    //private String percentualBranco;
    //private String alergia; //sim ou não
    //private String alisamento; //progressiva, definitiva ou N/A
    
    //MOSTRAR NA CONSULTA DE CLIENTE O ÚLTIMO SERVIÇO PRESTADO, ASSIM COMO A DATA
    
    public Cliente() {
    }

    public Cliente(String nome, String telefone, String endereco, String bairro, String numero) {
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.bairro = bairro;
        this.numero = numero;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }  
}