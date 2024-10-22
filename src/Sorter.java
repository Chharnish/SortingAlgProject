public class Sorter {
    //bubble sort
    public Employee[] bSort(Employee[] array){
        System.out.println("now Bubble Sorting...");
        long startTime = System.nanoTime();
        int n = array.length;
        int i,j;
        boolean swapped;
        for(i = 0; i < n-1; i++){
            swapped = false;
            for (j = 0; j < n - i - 1; j++){
                if (array[j].getAge() > array[j+1].getAge()){
                    swap(array, j, j+1);
                    swapped = true;
                }

              }
            if (!swapped){
                break;
            }
        }
        long endTime = System.nanoTime();
        long totalTime = endTime- startTime;
        array[0] = new timed("0", "Bubble", "time", "0", totalTime);
        System.out.println(array[0]);
        return array;
    }
    //Insertion Sort
    Employee[] iSort(Employee[] array) {
        System.out.println("Now Insertion sorting...");
        long startTime = System.nanoTime();
        for (int i = 1; i < array.length; i++){
            Employee key = array[i];
            int j = i-1;

            while (j >= 0 && array[j].getAge() > key.getAge()) {
                array[j + 1] = array[j];
                j = j - 1;
            }

            array[j+1] = key;

        }
        long endTime = System.nanoTime();
        long totalTime = endTime - startTime;
        array[0] = new timed("0", "Insertion", "time", "0", totalTime);
        System.out.println(array[0]);
        return array;
    }

    //Quick Sort
    void qSort(Employee[] array, int lowIndex, int highIndex, long startTime) {
        if (lowIndex >= highIndex) {
            return;
        }
        if(lowIndex == 0 && highIndex == array.length-1){
            System.out.println("Now Quick sorting...");
        }
        int pivot = array[highIndex].getAge();
        int pivotIndex = partition(array, lowIndex, highIndex, pivot);
        qSort(array,lowIndex, pivotIndex-1,startTime);
        qSort(array,pivotIndex+1, highIndex, startTime);
        if (lowIndex == 0 && highIndex == array.length-1){
            long stopTime = System.nanoTime();
            array[0] = new timed("0", "Quick", "time", "0", stopTime - startTime);
            System.out.println(array[0]);
        }
    }
    int partition(Employee[] array, int lowIndex, int highIndex, int pivot) {
        int leftPointer = lowIndex;
        int rightPointer = highIndex;
        while (leftPointer < rightPointer) {
            while(array[leftPointer].getAge() <= pivot && leftPointer < rightPointer) {
                leftPointer++;
            }
            while(array[rightPointer].getAge() >= pivot && leftPointer < rightPointer) {
                rightPointer--;
            }
            swap(array, leftPointer, rightPointer);
        }
        swap(array, leftPointer, highIndex);
        return leftPointer;
    }
    void swap(Employee[] array, int index1, int index2){
        Employee temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
    //merge sort
    Employee[] mSort(Employee[] array, int lowIndex, int highIndex, long startTime){
        boolean first = false;
        if (lowIndex == highIndex) {
            return new Employee[]{array[lowIndex]};
        }else if(lowIndex == 0 && highIndex == array.length-1){
            System.out.println("Now Merge sorting...");
            first = true;
        }
        int midIndex = (highIndex + lowIndex)/2;
        Employee[] leftHalf = mSort(array, lowIndex, midIndex, startTime);
        Employee[] rightHalf = mSort(array,midIndex + 1, highIndex, startTime);
        return merge(leftHalf, rightHalf, startTime, first);

    }
    Employee[] merge(Employee[] leftArray, Employee[] rightArray, long startTime, boolean first) {
        Employee[] result = new Employee[leftArray.length+rightArray.length];
        int left = 0, right = 0, index = 0;
        while (left < leftArray.length && right < rightArray.length) {
            if (leftArray[left].getAge() < rightArray[right].getAge()) {
                result[index] = leftArray[left];
                left++; index++;
            }
            else{
                result[index] = rightArray[right];
                right++; index++;
            }
        }
        while (left < leftArray.length) {
            result[index] = leftArray[left];
            left++; index++;
        }
        while (right < rightArray.length) {
            result[index] = rightArray[right];
            right++; index++;
        }
        if (first) {
            long stopTime = System.nanoTime();
            result[0] = new timed("0", "Merge", "time", "0", stopTime - startTime);
            System.out.println(result[0]);
        }
        return result;
    }

    //selection sort
    Employee[] sSort(Employee[] array) {
        System.out.println("Now Selection sorting...");
        long startTime = System.nanoTime();
        for (int i =0; i <array.length; i++){
            int minIndex = i;
            for (int j = i+1; j < array.length; j++){
                if (array[j].getAge() < array[minIndex].getAge()){
                    minIndex = j;
                }
            }
            if (minIndex != i){
                swap(array, i, minIndex);
            }
        }
        long endTime = System.nanoTime();
        array[0] = new timed("0", "Selection", "time", "0", endTime-startTime);
        System.out.println(array[0]);
        return array;
    }
}
