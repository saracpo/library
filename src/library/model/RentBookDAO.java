package library.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RentBookDAO {
    private Connection conn;
    private static RentBookDAO instance;
    private RentBookDAO() throws SQLException {
        conn = DriverManager.getConnection("jdbc:mysql://localhost/biblioteka", "root", "nsaracpoe2e9db");
    }
    public static RentBookDAO getInstance() throws SQLException {
        if(instance==null) {
            instance = new RentBookDAO();
        }
        return instance;
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
    
    public List<RentBook> getRentBooksByMember(int id) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("select books.id, books.title, genres.name, books.stock,members_books.rent_date, members_books.return_date from members_books join members on members_books.member_id=members.id join books on members_books.book_id=books.id join genres on books.genre=genres.id where member_id=? and members_books.date_of_return is null order by rent_date");
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        List<RentBook> res = new ArrayList<>();
        
            while(rs.next()) {
                List<Author> authors = getAllAuthorsByBook(rs.getInt(1));
                res.add(new RentBook(new Book(rs.getInt(1), rs.getString(2), authors, new Genre(0,rs.getString(3)), rs.getInt(4)), LocalDate.parse(rs.getDate(5).toString()), LocalDate.parse(rs.getDate(6).toString()),null,0));
            }    
        
        return res;
    }
    
    public List<RentBook> getReturnedBooksByMember(int id) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("select books.id, books.title, genres.name, books.stock,members_books.rent_date, members_books.return_date, members_books.date_of_return, members_books.fine_per_book from members_books join members on members_books.member_id=members.id join books on members_books.book_id=books.id join genres on books.genre=genres.id where members.id=? and date_of_return is not null order by rent_date");
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        List<RentBook> res = new ArrayList<>();
        
            while(rs.next()) { 
                List<Author> authors = getAllAuthorsByBook(rs.getInt(1));
                res.add(new RentBook(new Book(rs.getInt(1), rs.getString(2), authors, new Genre(0,rs.getString(3)), rs.getInt(4)), LocalDate.parse(rs.getDate(5).toString()), LocalDate.parse(rs.getDate(6).toString()), LocalDate.parse(rs.getDate(7).toString()),rs.getDouble(8)));
            }    
        
        return res;
    }
    
    public void rentBook(Member m, RentBook rb) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("insert into members_books values (?,?,?,?,null,null)");
        ps.setInt(1, m.id);
        ps.setInt(2, rb.book.id);
        ps.setDate(3, Date.valueOf(rb.rentDate));
        ps.setDate(4, Date.valueOf(rb.returnDate));
        ps.execute();
        rb.book.stock-=1;
        PreparedStatement ps1 = conn.prepareStatement("update books set stock=? where id=?");
        ps1.setInt(1, rb.book.stock);
        ps1.setInt(2, rb.book.id);
        ps1.execute();
    }
    
    public void returnBook(Member m, RentBook rb) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("update members_books set date_of_return=?, fine_per_book=? where member_id=? and book_id=?");
        ps.setDate(1, Date.valueOf(rb.dateOfReturn));
        ps.setDouble(2, rb.finePerBook);
        ps.setInt(3, m.id);
        ps.setInt(4, rb.book.id);
        ps.execute();
        rb.book.stock+=1;
        PreparedStatement ps1 = conn.prepareStatement("update books set stock=? where id=?");
        ps1.setInt(1, rb.book.stock);
        ps1.setInt(2, rb.book.id);
        ps1.execute();
    }
    
    public void extendBook (Member m, RentBook rb) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("update members_books set return_date=? where member_id=? and book_id=?");
        ps.setDate(1, Date.valueOf(rb.returnDate));
        ps.setInt(2, m.id);
        ps.setInt(3, rb.book.id);
        ps.execute();
    }
}
