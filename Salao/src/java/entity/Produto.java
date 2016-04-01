package entity;

import java.util.Date;

public class Produto {

    private Integer id;
    private String nome;
    private String fornecedor;
    private int qtde;
    private Date dtCompra;
    private double valorCompra;
    private double valorVenda;

    //PARA CADA PRODUTO, ADICIONAR 40% AO VALOR DE COMPRA PARA O VALOR DE VENDA
    //QND A QTDE DE PRODUTOS ATINGIR 2, AVISAR QUE O ESTOQUE ESTÁ BAIXO (MIDAR A COR DA TABLE)
    //RELATORIO DE PRODUTOS VENDIDOS POR PERÍODO
    public Produto() {
    }

    public Produto(Integer id, String nome, String fornecedor, int qtde, Date dtCompra, double valorCompra, double valorVenda) {
        this.id = id;
        this.nome = nome;
        this.fornecedor = fornecedor;
        this.qtde = qtde;
        this.dtCompra = dtCompra;
        this.valorCompra = valorCompra;
        this.valorVenda = valorVenda;
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

    public int getQtde() {
        return qtde;
    }

    public void setQtde(int qtde) {
        this.qtde = qtde;
    }

    public Date getDtCompra() {
        return dtCompra;
    }

    public void setDtCompra(Date dtCompra) {
        this.dtCompra = dtCompra;
    }

    public double getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(double valorCompra) {
        this.valorCompra = valorCompra;
    }

    public double getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(double valorVenda) {
        this.valorVenda = valorVenda;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
