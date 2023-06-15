package conferencehall;

import java.util.ArrayList;
public class Hall {
    private String name, place;
    public ArrayList<Events> HallsEvents = new ArrayList<>();

    public Hall(String name, String place, ArrayList<Events> event) {
        this.name = name;
        this.place = place;
        this.HallsEvents = event;
    }

     public Hall(String name, String place) {
        this.name = name;
        this.place = place;
    }

    Hall() {
    }
     
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public ArrayList<Events> getHallsEvents() {
        return HallsEvents;
    }

    public void setHallsEvents(ArrayList<Events> HallsEvents) {
        this.HallsEvents = HallsEvents;
    }
   
    
}
