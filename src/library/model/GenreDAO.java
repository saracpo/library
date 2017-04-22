package library.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GenreDAO {
    private Connection conn;
    private static GenreDAO instance;
    private GenreDAO() throws SQLException {
        conn = DriverManager.getConnection("jdbc:mysql://localhost/biblioteka", "root", "nsaracpoe2e9db");
    }
    public static GenreDAO getInstance() throws SQLException {
        if(instance==null) {
            instance = new GenreDAO();
        }
        return instance;
    }
    
    public void addGenre(Genre g) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("insert into genres values (null,?)", PreparedStatement.RETURN_GENERATED_KEYS);
        ps.setString(1, g.name); 
        ps.execute();       
        
    }    
    
    
    public void deleteGenre(int id) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("delete from genres where id=?");
        ps.setInt(1, id);
        ps.execute();
    }
    
    public void editGenre(Genre g) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("update genres set name=? where id=?");
        ps.setString(1, g.name);
        ps.setInt(2, g.id);
        ps.execute();
    }
    
    public List<Genre> getAllGenres() throws SQLException {
        List<Genre> allGenres = new ArrayList<>();
        
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select * from genres order by name");
        
        while(rs.next()) {
            allGenres.add(getGenre(rs.getInt(1)));
        }
        
        return allGenres;
    }
    
    public Genre getGenre(int id) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("select * from genres where id=?");
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if(rs.next()) {
            return new Genre(rs.getInt(1), rs.getString(2));
        } else {
            return null;
        }
    }
}
