package library.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {
    private Connection conn;
    private static MemberDAO instance;
    private MemberDAO() throws SQLException {
        conn = conn = DriverManager.getConnection("jdbc:mysql://localhost/biblioteka", "root", "nsaracpoe2e9db");
    }
    public static MemberDAO getInstance() throws SQLException {
        if(instance==null) {
            instance = new MemberDAO();
        }
        return instance;
    }
    
    public void addMember(Member m) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("insert into members values (null,?,?,?,?,?)",PreparedStatement.RETURN_GENERATED_KEYS);
        ps.setString(1, m.name);
        ps.setString(2, m.jmbg);
        ps.setString(3, m.adress);
        ps.setDate(4, Date.valueOf(m.started));
        ps.setDate(5, Date.valueOf(m.expiring));
        
        ps.execute();
        
        if(ps.getUpdateCount()>0) {
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            m.id = rs.getInt(1);
        }
    }
    
    public void editMember (Member m) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("update members set name=?, jmbg=?, adress=? where id=?");
        ps.setString(1, m.name);
        ps.setString(2, m.jmbg);
        ps.setString(3, m.adress);        
        ps.setInt(4, m.id);
        ps.execute();
    }
    
    public void extendMembership(Member m) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("update members set expiring=? where id=?");
        ps.setDate(1, Date.valueOf(m.expiring));
        ps.setInt(2, m.id);
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
    
    public Member getMember(int id) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("select * from members where id=?");
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        
        if(rs.next()) {
            return new Member(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), LocalDate.parse(rs.getDate(5).toString()), LocalDate.parse(rs.getDate(6).toString()), null);
        } else {
            return null;  
        }
    }    
    
    
    public List<Member> getAllMembers() throws SQLException {
        List<Member> allMembers = new ArrayList<>();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select * from members");
        while(rs.next()) {
            allMembers.add(new Member(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), LocalDate.parse(rs.getDate(5).toString()), LocalDate.parse(rs.getDate(6).toString()), getReturnedBooksByMember(rs.getInt(1))));
        }
        
        return allMembers;
    }
    
    public Book getBook(int id) throws SQLException {        
        PreparedStatement ps = conn.prepareStatement("select books.id, books.title, authors.name, genres.name, books.stock from books join genres on books.genre = genres.id join books_authors on books.id = books_authors.book_id join authors on authors.id = books_authors.author_id where books.id=?");
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();        
        
        if(rs.next()) {
            List<Author> res = getAllAuthorsByBook(id);
            return new Book(rs.getInt(1), rs.getString(2), res, new Genre(0,rs.getString(4)), rs.getInt(5));
        }else{
            return null;
        }
    }
    
    public List<Member> getMembersByRentBook (int book_id) throws SQLException {
        List<Member> members = new ArrayList<>();
        PreparedStatement ps = conn.prepareStatement("select members.id, members.name, members.jmbg, members_books.rent_date, members_books.return_date from members_books join members on members.id = members_books.member_id join books on members_books.book_id=books.id where members_books.book_id=? and members_books.date_of_return is null order by members_books.return_date");
        ps.setInt(1, book_id);
        ResultSet rs = ps.executeQuery();
        
        while(rs.next()) {
            List<RentBook> rentBooks = new ArrayList<>();
            rentBooks.add(new RentBook(getBook(book_id), LocalDate.parse(rs.getDate(4).toString()), LocalDate.parse(rs.getDate(5).toString()), null, 0));
            members.add(new Member(rs.getInt(1), rs.getString(2), rs.getString(3), null, null, null, rentBooks));
        }
        
        return members;
    }
    
    public List<Member> getMembersByReturnedBook (int book_id) throws SQLException {
        List<Member> members = new ArrayList<>();
        PreparedStatement ps = conn.prepareStatement("select members.id, members.name, members.jmbg, members_books.rent_date, members_books.return_date, members_books.date_of_return, members_books.fine_per_book from members_books join members on members.id = members_books.member_id join books on members_books.book_id=books.id where members_books.book_id=? and date_of_return is not null order by members_books.date_of_return");
        ps.setInt(1, book_id);
        ResultSet rs = ps.executeQuery();
        
        while(rs.next()) {
            List<RentBook> rentBooks = new ArrayList<>();
            rentBooks.add(new RentBook(getBook(book_id), LocalDate.parse(rs.getDate(4).toString()), LocalDate.parse(rs.getDate(5).toString()), LocalDate.parse(rs.getDate(6).toString()), rs.getDouble(7)));
            members.add(new Member(rs.getInt(1), rs.getString(2), rs.getString(3), null, null, null, rentBooks));
        }
        
        return members;
    }
    
    public List<Member> getAllMembersRentBooks () throws SQLException {
        List<Member> members = new ArrayList<>();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select books.id, books.title, members.id, members.name, members_books.rent_date, members_books.return_date from members_books join members on members.id = members_books.member_id join books on members_books.book_id=books.id where members_books.date_of_return is null order by members_books.rent_date");
        
        while(rs.next()) {
            List<RentBook> rentBooks = new ArrayList<>();
            rentBooks.add(new RentBook(new Book(rs.getInt(1), rs.getString(2), null, null, 0), LocalDate.parse(rs.getDate(5).toString()), LocalDate.parse(rs.getDate(6).toString()), null, 0));
            members.add(new Member(rs.getInt(3), rs.getString(4), null, null, null, null, rentBooks));
        }
        
        return members;
    }
    
    public List<Member> getAllMembersReturnedBooks () throws SQLException {
        List<Member> members = new ArrayList<>();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select books.id, books.title, members.id, members.name, members_books.rent_date, members_books.return_date, members_books.date_of_return, members_books.fine_per_book from members_books join members on members.id = members_books.member_id join books on members_books.book_id=books.id where members_books.date_of_return is not null order by members_books.date_of_return");
        
        while(rs.next()) {
            List<RentBook> rentBooks = new ArrayList<>();
            rentBooks.add(new RentBook(new Book(rs.getInt(1), rs.getString(2),null,null,0), LocalDate.parse(rs.getDate(5).toString()), LocalDate.parse(rs.getDate(6).toString()), LocalDate.parse(rs.getDate(7).toString()), rs.getDouble(8)));
            members.add(new Member(rs.getInt(3), rs.getString(4), null, null, null, null, rentBooks));
        }
        
        return members;
    }    
    
}
