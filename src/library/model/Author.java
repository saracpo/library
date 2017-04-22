package library.model;
public class Author {
    public int id;
    public String name;
    
    public Author(int id, String name) {
        this.id=id;
        this.name=name;
    }
    
    @Override
    public String toString() {
        return this.name;
    }
    
    
}
