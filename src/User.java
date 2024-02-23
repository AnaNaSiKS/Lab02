public class User {
    String firstName;
    String name;
    int id;
    String pin;

    public String getFirstName(){
        return firstName;
    }
    public void setFirstName(String firstName){
        this.firstName = firstName;
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
    public String getPin() {
        return pin;
    }
    public void setPin(String pin) {
        this.pin = pin;
    }

    public User(String firstName, String name, int id, String pin) {
        this.firstName = firstName;
        this.name = name;
        this.id = id;
        this.pin = pin;
    }


}

