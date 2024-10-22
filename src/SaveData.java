import java.io.FileWriter;
import java.io.IOException;
import java.io.File;

public class SaveData {
    public void saveArrays(Employee[][][] arrays) {
        System.out.println("Saving data...");
        int j = 0;
        //pointer arrays to point to the correct location
        String[] sortMethod = {"Bubble", "Insertion", "Quick", "Merge", "Selection"};
        String[] comps = {"company_a", "company_b", "company_c", "company_e"};
        String location;
        //outputs csv files for each array present in the arrays variable
        for (Employee[][] sortAlg : arrays) {

            for (int i = 0; i < sortAlg.length; i++) {
                File directory = new File(String.format("Sorted/%s", sortMethod[j]));
                if (!directory.exists()){
                    directory.mkdirs();
                }

                location = String.format("Sorted/%s/%s_%s.csv", sortMethod[j], comps[i],sortMethod[j]);
                //will export the data based on the algorithm array given and the location provided
                export(sortAlg[i], location);
            }
            j++;
        }
    }



    private void export(Employee[] array, String location) {
        try {
            //will try to write, line by line, the data into each row in the csv file
            FileWriter writeTo = new FileWriter(location);
            writeTo.append("ID,First,Last,Age\n");
            for (Employee emp : array){
                writeTo.append(emp.toString()+"\n");
            }
            writeTo.close();
        }catch(IOException e) {
            //troubleshooting catch because at some point this wasn't working. Not taking it out as Java get angry without it :c
            System.out.println("Error: " + e.getMessage());
        }
    }
}
