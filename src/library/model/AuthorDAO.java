package library.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AuthorDAO {
    private Connection conn;
    private static AuthorDAO instance;
    private AuthorDAO() throws SQLException {
        conn = DriverManager.getConnection("jdbc:mysql://localhost/biblioteka", "root", "nsaracpoe2e9db");
    }
    public static AuthorDAO getInstance() throws SQLException {
        if(instance==null) {
            instance = new AuthorDAO();
        }
        return instance;
    }
    
    public void addAuthor(Author a) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("insert into authors values (null,?)", PreparedStatement.RETURN_GENERATED_KEYS);
        ps.setString(1, a.name);
        ps.execute(); 
        
        if(ps.getUpdateCount()>0) {
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            a.id = rs.getInt(1);
        }
        
    }
    
    public void deleteAutor(int id) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("delete from authors where id=?");
        ps.setInt(1, id);
        ps.execute();
    }
    
    public void editAuthor (Author a) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("update authors set name=? where id=?");
        ps.setString(1, a.name);
        ps.setInt(2, a.id);
        ps.execute();
    }    
    
    public Author getAuthor(int id) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("select * from authors where id=?");
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        
        if(rs.next()) {
            return new Author(rs.getInt(1), rs.getString(2));
        } else {
            return null;
        }
    } 
    
     
    public List<Author> getAllAuthors() throws SQLException {
        List<Author> allAuthors = new ArrayList<>();
        
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select * from authors order by name");
        
        while(rs.next()) {
            allAuthors.add(new Author(rs.getInt(1), rs.getString(2)));
        }
        
        return allAuthors;
    }
}
