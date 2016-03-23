package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



public class Dao {
    
    protected Connection con;
    protected PreparedStatement stmt;
    protected ResultSet rs;

    public Dao() {
    }
    
    public void abrirConexao()throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/aula","root","quirino");
    }
    
    public void fecharConexao(){
        try{
            if(con != null)
                con.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
