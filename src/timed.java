public class timed extends Employee{
    double time;

    public timed(String id, String fName, String lName, String age, long time) {
        super(id, fName, lName, age);
        this.time = time;
    }

    @Override
    public String toString(){
        return String.format("Total time:, %s seconds!", time/1000000000.0);
    }
}
