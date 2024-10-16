public class Employee {
    private String fName, lName;
    private int id, age;

    public Employee(String id, String fName, String lName, String age) {
        this.fName = fName;
        this.lName = lName;
        this.id = Integer.parseInt(id);
        this.age = Integer.parseInt(age);
    }
    //UGH WRITING ALL OF THESE GETTERS AND SETTERS SUUUUUCK
    public void setID(int id) {this.id = id;}
    public int getID() {
        return id;
    }
    public void setfName(String fName) {
        this.fName = fName;
    }
    public String getfName() {
        return fName;
    }
    public void setlName() {
        this.lName = lName;
    }
    public String getlName() {
        return lName;
    }
    public void setAge(int age){
        this.age = age;
    }
    public int getAge() {
        return age;
    }

    @Override
    public String toString(){
        return String.format("%d,%s,%s,%d", id, fName, lName, age);
    }
}
