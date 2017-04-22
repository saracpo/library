package library.model;

import java.util.List;

public class Book {
    public int id;
    public String title;
    public List<Author> authors;
    public Genre genre;
    public int stock;
    
    public Book(int id, String title, List<Author> authors, Genre genre, int stock) {
        this.id=id;
        this.title=title;
        this.authors=authors;
        this.genre=genre;
        this.stock=stock;
    }
    
}
