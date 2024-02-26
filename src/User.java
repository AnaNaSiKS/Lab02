public class User {
    private String firstName;
    private String name;
    private  int id;
    private String pin;

    public String getFirstName(){
        return firstName;
    }
    public String getName() {
        return name;
    }
    public int getId() {
        return id;
    }
    public String getPin() {
        return pin;
    }
    public void setPin(String pin) {
        this.pin = pin;
    }

    public User(String firstName, String name,int id, String pin) {
        this.firstName = firstName;
        this.name = name;
        this.pin = pin;
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", name='" + name + '\'' +
                ", pin='" + pin + '\'' +
                ", id='" + id +'\'' +
                '}';
    }
}

