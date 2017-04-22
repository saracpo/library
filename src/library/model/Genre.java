package library.model;
public class Genre {
    public int id;
    public String name;
    
    public Genre (int id, String name) {
        this.id=id;
        this.name=name;
    }
    
    @Override
    public String toString() {
        return this.name;
    }
    
    
}
