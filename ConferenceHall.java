package conferencehall;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class ConferenceHall {

    public static void main(String[] args) throws ParseException {
       Scanner input = new Scanner(System.in);
       Methods m = new Methods();
       /*ArrayList<Events> hallevents = new ArrayList<>();
       
       String sdate = "20/10/2020";
       Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(sdate);
       
       String edate = "25/10/2020";
       Date date2 = new SimpleDateFormat("dd/MM/yyyy").parse(edate);

       Hall h = new Hall();
       h.setName("Hall1");
       h.setPlace("MisrElGedida");
       h.setHallsEvents(hallevents); 
       
       Events e = new Events();
       e.setName("event1");
       e.setId(1);
       e.setStartDate(date1);
       e.setEndDate(date2);
       e.setAvailableSeats(20);
     
       hallevents.add(e);
       Methods.events.add(e);
       Methods.halls.get(0).HallsEvents.add(e);
       */
       
       User user1 = new User();
       user1.setName("sara");
       user1.setPassword("124sara");
       
       Methods.users.add(user1);
       
        while(true)
       {
       System.out.println("Welcome to our Conferene Hall system");
       System.out.println("1- Sign In");
       System.out.println("2- Exit");
       int choose = input.nextInt();
       if(choose == 1)
       {
       m.Login();
       }
       else if (choose == 2)
       {
       System.exit(0);
       }
       }
    }
    
}
