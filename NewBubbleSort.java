
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author 1112v
 */
public class NewBubbleSort {

    public static void main(String[] args) {
        System.out.println("Enter number of array");
        int size_array = InputPositiveNumber();
        int[] arr = CreateArray(size_array);
        DisplayArray(arr,"Unsorted array:");
        BubbleSort(arr);
        System.out.println("");
        DisplayArray(arr,"Sorted array:");

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
            } catch (Exception NegaException) {
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
        int []arr= new int[size_array];
        Random x= new Random();
        for(int i=0;i<size_array;i++){
        arr[i]=x.nextInt(size_array);
    }
        return arr;
    }

    private static void DisplayArray(int[] arr, String msg) {
        System.out.print(msg);
        System.out.print("[");
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]);
            if(i<arr.length-1) System.out.print(", ");
        }
        System.out.print("]");
    }

    private static void BubbleSort(int[] arr) {
        for(int i=0;i<arr.length-1;i++){
            for(int j=0;j<arr.length-i-1;j++){
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
    }
}
