package Sorting;

/**
 * Created by SanthoshVarathan on 04/07/17.
 */
public class SortTestClass {
    public static void main(String ar[]){
        int a[] = {10,8,9,7,5,6,4,3,2,1};
        sorter s = new SelectionSort();
        System.out.print("Selection:");
        s.printArray(s.sort(a.clone()));
        s = new BubbleSort();
        System.out.print("Bubble:");
        s.printArray(s.sort(a.clone()));
        s = new InsertionSort();
        System.out.print("Insertion:");
        s.printArray(s.sort(a.clone()));
        s = new ShellSort();
        System.out.print("Shell:");
        s.printArray(s.sort(a));
    }
}
