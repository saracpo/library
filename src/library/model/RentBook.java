package library.model;

import java.time.LocalDate;

public class RentBook {
    public Book book;
    public LocalDate rentDate;
    public LocalDate returnDate;
    public LocalDate dateOfReturn;
    public double finePerBook;
    
    
    public RentBook(Book book, LocalDate rentDate, LocalDate returnDate, LocalDate dateOfReturn, double finePerBook) {
        this.book=book;
        this.rentDate = rentDate;
        this.returnDate= returnDate;   
        this.dateOfReturn=dateOfReturn;
        this.finePerBook=finePerBook;        
    }
    
}
