package library.model;

import java.time.LocalDate;
import java.util.List;

public class Member {
    public int id;
    public String name;
    public String jmbg;
    public String adress;
    public LocalDate started;
    public LocalDate expiring;
    public List<RentBook> rentBooks;    
    
    
    public Member (int id, String name, String jmbg, String adress, LocalDate started, LocalDate expiring, List<RentBook> rentBooks) {
        this.id=id;
        this.name=name;
        this.jmbg=jmbg;
        this.adress=adress;
        this.started=started;
        this.expiring=expiring;
        this.rentBooks=rentBooks;
        
    }
    
        
    
}
