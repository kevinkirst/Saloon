package entity;

public class Produto {

    private String nome;
    private String qtde;
    private String fornecedor;
    private String dtCompra;
    private String valorCompra;
    private String valorVenda;

    //PARA CADA PRODUTO, ADICIONAR 40% AO VALOR DE COMPRA PARA O VALOR DE VENDA
    //QND A QTDE DE PRODUTOS ATINGIR 2, AVISAR QUE O ESTOQUE ESTÁ BAIXO (MIDAR A COR DA TABLE)
    //RELATORIO DE PRODUTOS VENDIDOS POR PERÍODO
    
    public Produto() {
    }

    public Produto(String nome, String qtde, String fornecedor, String dtCompra, String valorCompra, String valorVenda) {
        this.nome = nome;
        this.qtde = qtde;
        this.fornecedor = fornecedor;
        this.dtCompra = dtCompra;
        this.valorCompra = valorCompra;
        this.valorVenda = valorVenda;
    }

    public String getQtde() {
        return qtde;
    }

    public void setQtde(String qtde) {
        this.qtde = qtde;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public String getDtCompra() {
        return dtCompra;
    }

    public void setDtCompra(String dtCompra) {
        this.dtCompra = dtCompra;
    }

    public String getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(String valorCompra) {
        this.valorCompra = valorCompra;
    }

    public String getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(String valorVenda) {
        this.valorVenda = valorVenda;
    }
    
    
    
}
