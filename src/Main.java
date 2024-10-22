import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws java.io.IOException {
        /*
        I completed this about a week and a half before the due date for this assignment
        I have come to the realization that I did not as a matter of fact need to overcomplicate
        this code as I did. During the time, I believed that this was the most efficient way to do the
        tasks that were laid out in the assignment description. I also think that keeping all the sorting in a single main
        file would work a lot better for me as I did not want to create a new class for each sorting method.
        I am also really proud of the work I did in this project as I faced many challenges developing the code along the
        way...
        tl;dr
        I did this in a way I feel proud of, and I am relatively happy about it.
         */
        Sorter sort = new Sorter();
        SaveData Save = new SaveData();
        //I might go crazy - I did as a matter of fact go crazy at a certain point in this project.
        //This is basically creating a new array from each employee list for each sorting method
        Employee[][] bubble = getList();
        Employee[][] insertion = getList();
        Employee[][] quick = getList();
        Employee[][] merge = getList();
        Employee[][] selection = getList();
        //3D array to keep the data in a simple-to-access array
        Employee[][][] allComps = {bubble, insertion, quick, merge, selection};

        //Bubble Sort - all done on a single line because I don't want my code to look too blocky.
        sort.bSort(allComps[0][0]); sort.bSort(allComps[0][1]);
        sort.bSort(allComps[0][2]); sort.bSort(allComps[0][3]);

        //Insertion Sort
        sort.iSort(allComps[1][0]); sort.iSort(allComps[1][1]);
        sort.iSort(allComps[1][2]); sort.iSort(allComps[1][3]);

        //Quick Sort - 0 added to the end to compensate for time. Algorithm modified to keep track of the time.
        sort.qSort(allComps[2][0], 0, allComps[2][0].length - 1, System.nanoTime());
        sort.qSort(allComps[2][1], 0, allComps[2][1].length - 1, System.nanoTime());
        sort.qSort(allComps[2][2], 0, allComps[2][2].length - 1, System.nanoTime());
        sort.qSort(allComps[2][3], 0, allComps[2][3].length - 1, System.nanoTime());

        //merge Sort - same as quick sort
        allComps[3][0] = sort.mSort(allComps[3][0], 0, allComps[3][0].length - 1, System.nanoTime());
        allComps[3][1] = sort.mSort(allComps[3][1], 0, allComps[3][1].length - 1, System.nanoTime());
        allComps[3][2] = sort.mSort(allComps[3][2], 0, allComps[3][2].length - 1, System.nanoTime());
        allComps[3][3] = sort.mSort(allComps[3][3], 0, allComps[3][3].length - 1, System.nanoTime());

        //Selection Sort
        sort.sSort(allComps[4][0]); sort.sSort(allComps[4][1]);
        sort.sSort(allComps[4][2]); sort.sSort(allComps[4][3]);

        //save method
        Save.saveArrays(allComps);
    }

    //Method to retrieve data from each company and put the contents into an array
    public static Employee[][] getList() throws FileNotFoundException {
        ParseData CSV = new ParseData();
        Employee[][] array = {CSV.getArray("company_a.csv"), CSV.getArray("company_b.csv"), CSV.getArray("company_c.csv"), CSV.getArray("company_e.csv")};
        return array;
    }
}

