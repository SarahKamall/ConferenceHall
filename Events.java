package conferencehall;

import java.util.Date;

public class Events {
    private String name; private int id;
    private Date StartDate, EndDate;
    private int availableSeats;

    public Events(String name, int id, Date StartDate, Date EndDate, int availableSeats) {
        this.name = name;
        this.id = id;
        this.StartDate = StartDate;
        this.EndDate = EndDate;
        this.availableSeats = availableSeats;
    }

    Events() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getStartDate() {
        return StartDate;
    }

    public void setStartDate(Date StartDate) {
        this.StartDate = StartDate;
    }

    public Date getEndDate() {
        return EndDate;
    }

    public void setEndDate(Date EndDate) {
        this.EndDate = EndDate;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    
    
    
}
