import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws java.io.IOException {
        Sorter sort = new Sorter();
        SaveData Save = new SaveData();
        //I might go crazy
        Employee[][] bubble = getList();
        Employee[][] insertion = getList();
        Employee[][] quick = getList();
        Employee[][] merge = getList();
        Employee[][] selection = getList();
        Employee[][][] allComps = {bubble, insertion, quick, merge, selection};

        //Bubble Sort - all done on a single line because I don't want my code to look too blocky.
        sort.bSort(allComps[0][0]);sort.bSort(allComps[0][1]);
        sort.bSort(allComps[0][2]);sort.bSort(allComps[0][3]);


        //Insertion Sort
        sort.iSort(allComps[1][0]);sort.iSort(allComps[1][1]);
        sort.iSort(allComps[1][2]);sort.iSort(allComps[1][3]);

        //Quick Sort - 0 added to the end to compensate for time. Algorithm modified to keep track of the time.
        sort.qSort(allComps[2][0], 0, allComps[2][0].length - 1, 0);sort.qSort(allComps[2][1], 0, allComps[2][1].length - 1, 0);
        sort.qSort(allComps[2][2], 0, allComps[2][2].length - 1, 0);sort.qSort(allComps[2][3], 0, allComps[2][3].length - 1, 0);

        //merge Sort - same as quick sort
        allComps[3][0] = sort.mSort(allComps[3][0], 0, allComps[3][0].length - 1, System.nanoTime());
        allComps[3][1] = sort.mSort(allComps[3][1], 0, allComps[3][1].length - 1, System.nanoTime());
        allComps[3][2] = sort.mSort(allComps[3][2], 0, allComps[3][2].length - 1, System.nanoTime());
        allComps[3][3] = sort.mSort(allComps[3][3], 0, allComps[3][3].length - 1, System.nanoTime());

        //Selection Sort
        sort.sSort(allComps[4][0]);sort.sSort(allComps[4][1]);
        sort.sSort(allComps[4][2]);sort.sSort(allComps[4][3]);

        //save method
        Save.saveArrays(allComps);
    }

    public static Employee[][] getList() throws FileNotFoundException {
        ParseData CSV = new ParseData();
        Employee[][] array = {CSV.getArray("company_a.csv"), CSV.getArray("company_b.csv"), CSV.getArray("company_c.csv"), CSV.getArray("company_e.csv")};
        return array;
    }
}

