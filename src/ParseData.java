import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
public class ParseData {
    public Employee[] getArray(String currFile) throws FileNotFoundException {

        Scanner inLine = new Scanner(new File(String.format("companies/%s", currFile)));
        ArrayList<Employee> empList = new ArrayList<>();
        //skips the first row aka the description of the columns
        inLine.nextLine();
        while (inLine.hasNext()) {
            String str = inLine.nextLine();
            //creates a temporary array of strings by splitting the line using each comma as reference
            String[] tempA = str.split(",", 4);
            //creating a new object and applying each contents of tempA into employee
            Employee newEmployee = new Employee(tempA[0], tempA[1], tempA[2], tempA[3]);
            empList.add(newEmployee);
        }
        //finalizes the list by creating a new array the same length as the arraylist
        //I do not want to return an arraylist as arraylists are not necessary past this point
        //plus I wrote everything else using arrays and not arraylists
        //also adds a line for the timed class that keeps track of the time.
        Employee[] finList = new Employee[empList.size()+1];
        for (int i = 0; i < empList.size(); i++){
            finList[i] = empList.get(i);
        }
        //puts an employee here as a placeholder to avoid null complications until the time is collected after each sorting method
        finList[finList.length-1] = new Employee("0","total","time","0");
        //closes the scanner to avoid memory leaks
        inLine.close();
        return finList;
    }

}
