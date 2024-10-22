public class timed extends Employee{
    long time;
   //This class extends the original employee class but has a new variable to keep track of the time. I know this is pretty brilliant... :c
    public timed(String id, String fName, String lName, String age, long time) {
        super(id, fName, lName, age);
        this.time = time;
    }

    @Override
    public String toString(){
        return String.format("Total time:, %s seconds!", time/1000000000.0);
    }
}
