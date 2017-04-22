package library.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {
    private Connection conn;
    private static BookDAO instance;
    private BookDAO() throws SQLException {
        conn = DriverManager.getConnection("jdbc:mysql://localhost/biblioteka", "root", "nsaracpoe2e9db");
    }
    public static BookDAO getInstance() throws SQLException {
        if(instance==null) {
            instance = new BookDAO();
        }
        return instance;
    }
    
    public void addBook(Book b) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("insert into books values (null,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
        ps.setString(1, b.title);
        ps.setInt(2, b.genre.id);
        ps.setInt(3, b.stock);
        ps.execute();
        
        if(ps.getUpdateCount()>0) {
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            b.id = rs.getInt(1);
        }
    }
    
    public void addBooksAuthors (int book_id, int author_id) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("insert into books_authors values (?,?)");
        ps.setInt(1, book_id);
        ps.setInt(2, author_id);
        ps.execute();
    }
    
    public Book getBook(int id) throws SQLException {        
        PreparedStatement ps = conn.prepareStatement("select books.id, books.title, authors.name, genres.name, books.stock from books join genres on books.genre = genres.id join books_authors on books.id = books_authors.book_id join authors on authors.id = books_authors.author_id where books.id=?");
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();        
        
        if(rs.next()) {
            List<Author> res = getAllAuthorsByBook(id);
            return new Book(rs.getInt(1), rs.getString(2), res, new Genre(0,rs.getString(4)), rs.getInt(5));
        } else {
            return null;
        }
    }
    
    public List<Book> getAllBooks() throws SQLException {
        List<Book> allBooks = new ArrayList<>();
        
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select books.id, books.title, genres.name, books.stock from books join genres on books.genre = genres.id order by books.id");
        
        while(rs.next()) {
            List<Author> authors = getAllAuthorsByBook(rs.getInt(1));
            allBooks.add(new Book(rs.getInt(1), rs.getString(2), authors, new Genre(0,rs.getString(3)), rs.getInt(4)));
        }
        
        return allBooks;
    }
    
    public void editBook(Book b) throws SQLException {        
        PreparedStatement ps = conn.prepareStatement("update books set title=?, genre=?, stock=? where id=?");
        ps.setString(1, b.title);
        ps.setInt(2, b.genre.id);
        ps.setInt(3, b.stock);
        ps.setInt(4, b.id);
        ps.execute();
    }   
    
    
    public void deleteBook (int id) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("delete from books where id=?");
        ps.setInt(1, id);
        ps.execute();
    }
    
    public void deleteBooksAuthors(int book_id) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("delete from books_authors where book_id=?");
        ps.setInt(1, book_id);
        ps.execute();
    }
    
    public List<Author> getAllAuthorsByBook(int book_id) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("select authors.id, authors.name from authors join books_authors on authors.id = books_authors.author_id join books on books.id = books_authors.book_id where books.id=?");
        ps.setInt(1, book_id);
        ResultSet rs = ps.executeQuery();
        List<Author> authors = new ArrayList<>();
        while(rs.next()) {
            authors.add(new Author(rs.getInt(1), rs.getString(2)));
        }
        return authors;
    }
    
    public List<Book> getBooksByAuthor(int author_id) throws SQLException {
        List<Book> res = new ArrayList<>();
        PreparedStatement ps = conn.prepareStatement("select books.id, books.title, authors.name, genres.name, books.stock from books join genres on books.genre = genres.id join books_authors on books.id = books_authors.book_id join authors on authors.id = books_authors.author_id where authors.id=?");
        ps.setInt(1, author_id);
        ResultSet rs = ps.executeQuery();
        while(rs.next()) {
            List<Author> authors = getAllAuthorsByBook(rs.getInt(1));
            res.add(new Book(rs.getInt(1), rs.getString(2), authors, new Genre(0,rs.getString(4)), rs.getInt(5)));
        }
        return res;
    }
    
    public List<Book> getBooksByGenre(int genre_id) throws SQLException {
        List<Book> res = new ArrayList<>();
        PreparedStatement ps = conn.prepareStatement("select books.id, books.title, genres.name, books.stock from books join genres on books.genre = genres.id where genres.id=?");
        ps.setInt(1, genre_id);
        ResultSet rs = ps.executeQuery();
        while(rs.next()) {
            List<Author> authors = getAllAuthorsByBook(rs.getInt(1));
            res.add(new Book(rs.getInt(1), rs.getString(2), authors, new Genre(genre_id,rs.getString(3)), rs.getInt(4)));
        }
        return res;
    }
    
    public List<Book> getBooksByTitle(String title) throws SQLException {
        List<Book> res = new ArrayList<>();
        PreparedStatement ps = conn.prepareStatement("select books.id, books.title, genres.name, books.stock from books join genres on books.genre = genres.id where books.title like '"+title+"%'");
        ResultSet rs = ps.executeQuery();
        while(rs.next()) {
            List<Author> authors = getAllAuthorsByBook(rs.getInt(1));
            res.add(new Book(rs.getInt(1), rs.getString(2), authors, new Genre(0,rs.getString(3)), rs.getInt(4)));
        }
        return res;
    }
}
