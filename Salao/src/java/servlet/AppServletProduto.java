package servlet;

import dao.ProdutoDao;
import entity.Produto;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

            RequestDispatcher rd = req.getRequestDispatcher("listProduto.jsp");
            rd.forward(req, resp);//
        }

        if (acao.equals("novoProduto")) {
            Produto produto = new Produto();

            req.setAttribute("produto", produto);
            RequestDispatcher rd = req.getRequestDispatcher("editProduto.jsp");
            rd.forward(req, resp);
        }
        if (acao.equals("editarProduto")) {
            Integer id = Integer.parseInt(req.getParameter("id"));
            ProdutoDao dao = new ProdutoDao();
            Produto produto = dao.getById(id);

            req.setAttribute("produto", produto);
            RequestDispatcher rd = req.getRequestDispatcher("editProduto.jsp");
            rd.forward(req, resp);

        }
        if (acao.equals("salvarProduto")) {
            String idAsString = req.getParameter("id");
            String nome = req.getParameter("campoNome");
            String telefone = req.getParameter("campoTelefone");
            Produto produto = new Produto();

            produto.setNome(nome);
     //     produto.setTelefone(telefone);            //não utilizado, mas salvo para usar como exemplo
            if (!idAsString.equals("null")) {
                produto.setId(Integer.parseInt(idAsString));
            }
            ProdutoDao dao = new ProdutoDao();
            dao.salvar(produto);

            RequestDispatcher rd = req.getRequestDispatcher("servlet?acao=listar");
            rd.forward(req, resp);
        }

        if (acao.equals("excluirProduto")) {
            Integer idVitima = Integer.parseInt(req.getParameter("id"));
            ProdutoDao dao = new ProdutoDao();
            Produto produto = dao.getById(idVitima);
            dao.excluir(produto);

            RequestDispatcher rd = req.getRequestDispatcher("servlet?acao=listar");
            rd.forward(req, resp);
        }

    }

}
