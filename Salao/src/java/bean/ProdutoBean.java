/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.ProdutoDao;
import entity.Produto;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.ListDataModel;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.joda.time.DateTime;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

@ManagedBean(name = "MBProduto")
@ViewScoped
public class ProdutoBean implements Serializable{
    
    private Produto produto;
    private ListDataModel<Produto> produtoList;

    public ProdutoBean() {
    }

    public ProdutoBean(Produto produto, ListDataModel<Produto> produtoList) {
        this.produto = produto;
        this.produtoList = produtoList;
    }
    
    @PostConstruct
    public void getAllProduto() {
        ProdutoDao produtoDao = new ProdutoDao();
        List<Produto> produtoArrayList = produtoDao.getAll();
        produtoList = new ListDataModel<>(produtoArrayList);
    }
    
     public void prepararProduto() {
        produto = new Produto();
    }
    
    public void saveProduto() {
        ProdutoDao produtoDao = new ProdutoDao();
        produtoDao.salvar(produto);
        ArrayList<Produto> listProduto = (ArrayList<Produto>) produtoDao.getAll();
        produtoList = new ListDataModel<Produto>(listProduto);
    }
    
    public void onRowSelect(SelectEvent event) {
        produto = (Produto) event.getObject();
        System.out.println("nome do produto " + produto.getNome());
    }
           
             
    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public ListDataModel<Produto> getProdutoList() {
        return produtoList;
    }

    public void setProdutoList(ListDataModel<Produto> produtoList) {
        this.produtoList = produtoList;
    }
    
    
    
}
