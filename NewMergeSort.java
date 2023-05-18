
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class NewMergeSort {

    public static void main(String[] args) {
        System.out.println("Enter number of array:");
        int size_array = InputPositiveNumber();
        int[] arr = CreateArray(size_array);
        System.out.println("Unsorted array: [" + arr[0] + DisplayArray(arr));
         MergeSort(arr);
         System.out.println("Unsorted array: [" + arr[0] + DisplayArray(arr));
         
        

    }

    private static int InputPositiveNumber() {
        Scanner sc = new Scanner(System.in);
        String input;
        double n;
        do {
            input = sc.nextLine();
            if (input.isEmpty()) {
                System.out.println("Please input positive number");
                continue;
            }
            try {
                n = Double.parseDouble(input);
                if (n <= 0) {
                    throw new Exception();
                }
                if ((int) n != n) {
                    throw new Error();
                } else {
                    break;
                }
            } catch (NumberFormatException exception) {
                System.out.println("Please input positive number");
                continue;
            } catch (Exception NegaNumError) {
                System.out.println("Please input positive number");
                continue;
            } catch (Error RealError) {
                System.out.println("Please input positive number");
                continue;
            }

        } while (true);
        return (int) n;

    }

    private static int[] CreateArray(int size_array) {

        int[] array = new int[size_array];
   
        for (int i = 0; i < size_array; i++) {
            array[i] = InputPositiveNumber();
        }
        return array;
    }

    private static void MergeSort(int[] arr) {
        int length = arr.length;
        if (length <= 1) return;
            
        

        int midle = length / 2;
        int[] leftArray = new int[midle];
        int[] rightArray = new int[length - midle];

        int i = 0, j = 0;
        for (int k = 0; k < length; k++) {
            if (k < midle) {
                leftArray[i] = arr[k];
                i++;
            }else{
                rightArray[j]=arr[k];
                j++;
            }
        }
        MergeSort(leftArray);
        MergeSort(rightArray);
        merge(leftArray,rightArray,arr);
    }

    private static String DisplayArray(int[] arr) {
        String x = "";
        for (int i = 1; i < arr.length; i++) {
            x += " ," + arr[i];
        }
        return x + "]";
    }

    private static void merge(int[] leftArray, int[] rightArray, int[] arr) {
        int length=arr.length;
        int leftsize=length/2;
        int rightsize=length-leftsize;
        int i=0,l=0,r=0;
        while(l<leftsize&&r<rightsize){
            if(leftArray[l]<rightArray[r]){
                arr[i]=leftArray[l];
                i++;
                l++;
            }else{
                arr[i]=rightArray[r];
                i++;
                r++;
            }
        }
        while(l<leftsize){
            arr[i]=leftArray[l];
            i++;
            l++;
        }
        while(r<rightsize){
            arr[i]=rightArray[r];
            i++;
            r++;
        }
        
    }

}
