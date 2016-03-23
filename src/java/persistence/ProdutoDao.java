package persistence;

import java.util.ArrayList;
import java.util.List;
import model.Produto;

public class ProdutoDao extends Dao{

    public ProdutoDao() {
    }
    
    public void salvar(Produto p)throws Exception{
        stmt = con.prepareStatement("insert into produto values(null,?,?,?)");
        stmt.setString(1, p.getNome());
        stmt.setDouble(2, p.getPreco());
        stmt.setInt(3, p.getQuantidade());
        stmt.execute();
    }
    
    public List<Produto> listar()throws Exception{
        stmt = con.prepareStatement("select * from produto");
        rs = stmt.executeQuery();
        
        List<Produto> dados = new ArrayList<Produto>();
        
        while(rs.next()){
            Produto p = new Produto();
            p.setCodigo(rs.getInt("codigo"));
            p.setNome(rs.getString("nome"));
            p.setPreco(rs.getDouble("preco"));
            p.setQuantidade(rs.getInt("quantidade"));
            
            dados.add(p);
        }
        return dados;
    }
    
}
