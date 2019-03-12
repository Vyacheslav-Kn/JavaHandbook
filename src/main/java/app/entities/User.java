package app.entities;

public class User {
    private int Id;
    private String Name;
    private String Password;

    public User(String Name, String Password){
        this.Name = Name;
        this.Password = Password;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
