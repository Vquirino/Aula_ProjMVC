package control;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Produto;
import persistence.ProdutoDao;

public class ManterEstoque extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String cmd = request.getParameter("cmd");
        if(cmd != null){
            
            if(cmd.equals("cadastrar")){
                
                Produto p = new Produto();
                
                p.setNome(request.getParameter("nome"));
                p.setPreco(Double.parseDouble(request.getParameter("preco")));
                p.setQuantidade(Integer.parseInt(request.getParameter("quantidade")));
                
                ProdutoDao d = new ProdutoDao();
                try{
                    d.abrirConexao();
                    d.salvar(p);
                    request.setAttribute("mensagem", "Produto cadastrado com sucesso!");
                }
                catch(Exception e){
                    request.setAttribute("mensagem", e.getMessage());
                }
                finally{
                    d.fecharConexao();
                    request.getRequestDispatcher("cadastro.jsp").forward(request, response);
                }
            }
            
            if(cmd.equals("acessar")){
                
                Integer acao = Integer.parseInt(request.getParameter("acao"));
                
                switch(acao){
                    case 1:
                        request.getRequestDispatcher("cadastro.jsp").forward(request, response);
                        break;
                    case 2:
                        
                        ProdutoDao d = new ProdutoDao();
                        
                        try{
                            d.abrirConexao();
                            request.setAttribute("dados", d.listar());
                        }
                        catch(Exception e){
                            e.printStackTrace();
                        }
                        finally{
                            d.fecharConexao();
                        }
                        request.getRequestDispatcher("consulta.jsp").forward(request, response);
                        break;
                }
            }
        }
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
