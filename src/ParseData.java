import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
public class ParseData {
    public Employee[] getArray(String currFile) throws FileNotFoundException {

        Scanner inLine = new Scanner(new File(String.format("companies/%s", currFile)));
        ArrayList<Employee> empList = new ArrayList<>();
        inLine.nextLine();
        while (inLine.hasNext()) {
            String str = inLine.nextLine();
            String[] tempA = str.split(",", 4);

            Employee newEmployee = new Employee(tempA[0], tempA[1], tempA[2], tempA[3]);
            empList.add(newEmployee);
        }
        Employee[] finList = new Employee[empList.size()+1];
        for (int i = 0; i < empList.size(); i++){
            finList[i] = empList.get(i);
        }
        finList[finList.length-1] = new Employee("0","total","time","0");
        inLine.close();
        return finList;
    }

}
