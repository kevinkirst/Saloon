package servlet;

import dao.ProdutoDao;
import entity.Produto;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import util.DataConversor;

/**
 *
 * @author Adonis Amarante
 */
public class AppServletProduto extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String acao = req.getParameter("acao");
        if (acao.equals("listar")) {
            List<Produto> minhaLista;
            ProdutoDao dao = new ProdutoDao();
            minhaLista = dao.getAll();
            req.setAttribute("lista", minhaLista);

            RequestDispatcher rd = req.getRequestDispatcher("produto/listProduto.jsp");
            rd.forward(req, resp);//
        }

        if (acao.equals("novoProduto")) {
            Produto produto = new Produto();

            req.setAttribute("produto", produto);
            RequestDispatcher rd = req.getRequestDispatcher("produto/editProduto.jsp");
            rd.forward(req, resp);
        }
        if (acao.equals("editarProduto")) {            
            DataConversor data = new DataConversor();
            Integer id = Integer.parseInt(req.getParameter("id"));
            ProdutoDao dao = new ProdutoDao();
            Produto produto = dao.getById(id);
            Date datatest = produto.getDtCompra();
            String a = data.UStoBRdate(datatest);
            
            System.out.println(produto.getDtCompra());
            req.setAttribute("produto", produto);
            req.setAttribute("a", a);
            RequestDispatcher rd = req.getRequestDispatcher("produto/editProduto.jsp");
            rd.forward(req, resp);

        }
        if (acao.equals("salvarProduto")) {
            DataConversor data = new DataConversor();
            String idAsString = req.getParameter("id");
            
            Produto produto = new Produto();
            produto.setNome(req.getParameter("campoNome"));
            produto.setFornecedor(req.getParameter("campoFornecedor"));
            produto.setQtde(Integer.parseInt(req.getParameter("campoQuantidade")));
            produto.setDtCompra(data.formatoData(req.getParameter("campoDtCompra")));
            produto.setValorCompra(Double.parseDouble(req.getParameter("campoValorCompra")));
            produto.setValorVenda(Double.parseDouble(req.getParameter("campoValorVenda")));
            
            if (!idAsString.equals("null")) {
                produto.setId(Integer.parseInt(idAsString));
            }
            ProdutoDao dao = new ProdutoDao();
            System.out.println("nome "+ produto.getNome());
            dao.salvar(produto);

            RequestDispatcher rd = req.getRequestDispatcher("salao?acao=listar");
            rd.forward(req, resp);
        }

        if (acao.equals("excluirProduto")) {
            Integer idVitima = Integer.parseInt(req.getParameter("id"));
            ProdutoDao dao = new ProdutoDao();
            Produto produto = dao.getById(idVitima);
            dao.excluir(produto);

            RequestDispatcher rd = req.getRequestDispatcher("salao?acao=listar");
            rd.forward(req, resp);
        }

    }
    
     

}
