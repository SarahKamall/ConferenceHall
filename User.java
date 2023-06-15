package conferencehall;

import java.util.ArrayList;

public class User {
    private String name, password;
    private int ID;
    public ArrayList<Hall> ReservedHalls = new ArrayList<>();

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }
    public User(String name, String password, int ID, ArrayList<Hall> ReservedHalls) {
        this.name = name;
        this.password = password;
        this.ID = ID;
        this.ReservedHalls = ReservedHalls;
    }

    User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public ArrayList<Hall> getReservedHalls() {
        return ReservedHalls;
    }

    public void setReservedHalls(ArrayList<Hall> ReservedHalls) {
        this.ReservedHalls = ReservedHalls;
    }

   
}
