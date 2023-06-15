package conferencehall;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Methods {

    Scanner input = new Scanner(System.in);
    int choose;
    public static ArrayList<User> users = new ArrayList<>();
    public static ArrayList<Hall> halls = new ArrayList<>();
    public static ArrayList<Events> events = new ArrayList<>();

    //11 methods
    public void OptionMenu() throws ParseException {
        int num = 0;
        System.out.println("Welcome, you are now in the main menu");
        System.out.println("1- Add new hall");
        System.out.println("2- Delete an exist hall");
        System.out.println("3- Show record of event");
        System.out.println("4- Show hall details");
        System.out.println("5- Reserve Hall");
        System.out.println("6- Show the reserved halls");
        System.out.println("7- Cancel the reservation");
        System.out.println("8- Search the event in which hall");
        System.out.println("9- Logout");
        choose = input.nextInt();
        switch (choose) {

            case 1:
                System.out.println("enter the number of halls you want to add");
                num = input.nextInt();
                for (int i = 0; i < num; i++) {
                    AddHall();
                }
                OptionMenu();
                break;
            case 2:
                DeleteHall();
                OptionMenu();
                break;
            case 3:
                showRecord();
                OptionMenu();
                break;
            case 4:
                ShowHallDetails();
                OptionMenu();
                break;
            case 5:
                reserveHalls();
                OptionMenu();
                break;
            case 6:
                showReservedHalls();
                OptionMenu();
                break;
            case 7:
                cancelReservation();
                OptionMenu();
                break;
            case 8:
                SearchEventHall();
                OptionMenu();
                break;
            case 9:
                return;
            default:
                System.out.println("You have entered an invalid number, please try again :( ");
                OptionMenu();
                break;
        }
    }

    public void Login() throws ParseException {
        System.out.print("Enter your username: ");
        String name = input.next();
        System.out.print("Enter your password: ");
        String pass = input.next();
        Boolean check = false;
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getName().equals(name) && users.get(i).getPassword().equals(pass)) {
                OptionMenu();
                check = true;
                break;
            }
        }
        if (!check) {
            System.out.println("You've entered an invalid username or password, please try again :(");
            Login();
        }
    }

    public void CreateEvents(Hall h) throws ParseException {
        System.out.println("How many events do you need to add to this hall? ");
        int no = input.nextInt();
        if (no != 0) {
            for (int i = 0; i < no; i++) {
                System.out.println("Enter the name of the event: ");
                String name = input.next();
                System.out.println("Enter the ID of this event: ");
                int ID = input.nextInt();
                System.out.println("Enter the start date of the event: ");
                String sdate = input.next();
                Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(sdate);
                System.out.println("Enter the end date of the event: ");
                String edate = input.next();
                Date date2 = new SimpleDateFormat("dd/MM/yyyy").parse(edate);
                System.out.println("Enter the number of the available seats in the event: ");
                int number = input.nextInt();

                Events e = new Events(name, ID, date1, date2, number);
                h.HallsEvents.add(e);
                events.add(e);
            }
        } else {
            System.out.println("Not valid......!");
        }
    }

    public int N_Check(String name) {
        for (int i = 0; i < halls.size(); i++) {
            if (halls.get(i).getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    public void AddHall() throws ParseException {
        System.out.print("Enter the name of the hall: ");
        String hallname = input.next();
        if (N_Check(hallname) != -1) {
            System.out.println("This hall is already found..");
            return;
        } else {
            System.out.print("Enter the place of the hall: ");
            String place = input.next();
            Hall hall = new Hall(hallname, place);
            CreateEvents(hall);
            halls.add(hall);
        }
    }

    public void DeleteHall() {
        System.out.print("Enter the name of the hall you want to delete: ");
        
        String name = input.next();
        int Hall_Index = N_Check(name);
        if (Hall_Index == -1) {
            System.out.println("This hall is not found..");
            return;
        }
       for(int i =0; i < events.size(); i++)
       {
           for(int j =0; j < halls.get(Hall_Index).HallsEvents.size(); j++ ){
       if(halls.get(Hall_Index).HallsEvents.get(j).getName().equals(events.get(i).getName()))
           events.remove(i);
           }
       }
       halls.remove(Hall_Index);
        System.out.println("The hall is deleted successfully.");
    }

    public void showRecord() {
        for (int i = 0; i < events.size(); i++) {
            System.out.println("The name of the event: " + events.get(i).getName());
            System.out.println("The ID of the event: " + events.get(i).getId());
            System.out.println("The start date of the event: " + events.get(i).getStartDate());
            System.out.println("The end date of the event: " + events.get(i).getEndDate());
            System.out.println("The available seats to the event: " + events.get(i).getAvailableSeats());
        }
    }

    public void ShowHallDetails() {
        boolean check = false;
        System.out.print("Please enter the name of the hall you want to show its details: ");
        String name = input.next();
        for (int i = 0; i < halls.size(); i++) {
            if (halls.get(i).getName().equals(name)) {
                System.out.println("The name of the hall: " + halls.get(i).getName());
                System.out.println("The place of the hall: " + halls.get(i).getPlace());
                for (int j = 0; j < halls.get(i).HallsEvents.size(); j++) {
                    System.out.println("The name of the event: " + halls.get(i).HallsEvents.get(j).getName());
                    System.out.println("The ID of the event: " + halls.get(i).HallsEvents.get(j).getId());
                    System.out.println("The start date of the event: " + halls.get(i).HallsEvents.get(j).getStartDate());
                    System.out.println("The end date of the event: " + halls.get(i).HallsEvents.get(j).getEndDate());
                    System.out.println("The available seats to the event: " + halls.get(i).HallsEvents.get(j).getAvailableSeats());
                }
                check = true;
                break;
            }
        }
        if (!check) {
            System.out.println("Sorry, we don't have this hall here");
        }
    }

    public void reserveHalls() throws ParseException {
        System.out.println("Enter the name of the hall you want to reserve");
        String name = input.next();
        Boolean check = false;
        int Hall_Index = N_Check(name);;
        if (Hall_Index == -1) {
            System.out.println("This hall is not found..");
            return;
        }
        System.out.println("Enter the start date and the end date of the hall you want to reserve  (dd/MM/yyyy)");
        String sdate = input.next();
        Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(sdate);
        String edate = input.next();
        Date date2 = new SimpleDateFormat("dd/MM/yyyy").parse(edate);
        for (int j = 0; j < halls.get(Hall_Index).HallsEvents.size(); j++) {
            if( (date1.compareTo(halls.get(Hall_Index).HallsEvents.get(j).getStartDate() ) < 0 && date2.compareTo(halls.get(Hall_Index).HallsEvents.get(j).getStartDate() ) < 0) || ((date1.compareTo(halls.get(Hall_Index).HallsEvents.get(j).getEndDate()) > 0 && date2.compareTo(halls.get(Hall_Index).HallsEvents.get(j).getEndDate()) > 0) )  ){
                for (int k = 0; k < users.size(); k++) {
                    users.get(k).ReservedHalls.add(new Hall(halls.get(Hall_Index).getName(), halls.get(Hall_Index).getPlace(), halls.get(Hall_Index).getHallsEvents()));
                    System.out.println("You have reserved this hall successfully.");
                    check = true;
                    break;
                }
            }
        }

        if (!check) {
            System.out.println("There is no available halls in this time");
        }
    }

    public void showReservedHalls() {
        for (int i = 0; i < users.size(); i++) {
            for (int j = 0; j < users.get(i).ReservedHalls.size(); j++) {
                System.out.println("The name of the reserved hall: " + users.get(i).ReservedHalls.get(j).getName());
                System.out.println("The place of the reserved hall: " + users.get(i).ReservedHalls.get(j).getPlace());
                for (int k = 0; k < users.get(i).ReservedHalls.get(j).HallsEvents.size(); k++) {
                    System.out.println("The name of the event: " + users.get(i).ReservedHalls.get(j).HallsEvents.get(k).getName());
                    System.out.println("The ID of the event: " + users.get(i).ReservedHalls.get(j).HallsEvents.get(k).getId());
                    System.out.println("The start date of the event: " + users.get(i).ReservedHalls.get(j).HallsEvents.get(k).getStartDate());
                    System.out.println("The end date of the event: " + users.get(i).ReservedHalls.get(j).HallsEvents.get(k).getEndDate());
                    System.out.println("The available seats to the event: " + users.get(i).ReservedHalls.get(j).HallsEvents.get(k).getAvailableSeats());
                }
            }
        }

    }

    public void cancelReservation() {
        System.out.println("Enter the name of the reserved hall you want to cancel");
        String name = input.next();
        boolean check = false;
        for (int i = 0; i < users.size(); i++) {
            for (int j = 0; j < users.get(i).ReservedHalls.size(); j++) {
                if (users.get(i).ReservedHalls.get(j).getName().equals(name)) {
                    users.get(i).ReservedHalls.remove(j);
                    System.out.println("The reservation is cancelled successfully ");
                    check = true;
                    break;
                }
            }
        }
        if (!check) {
            System.out.println("This reservation is not found ....! ");
        }
    }

    public void SearchEventHall() {
        Boolean check = false;
        System.out.print("Please enter the name of event you want to know in which hall: ");
        String name = input.next();
        for (int i = 0; i < halls.size(); i++) {
            for (int j = 0; j < halls.get(i).HallsEvents.size(); j++) {
                if (halls.get(i).HallsEvents.get(j).getName().equals(name)) {
                    System.out.println("This event is in the hall: " + halls.get(i).getName());
                    check = true;
                    break;
                }
            }
        }
        if (!check) {
            System.out.println("This event is not found in any hall......!");
        }
    }
    
}
