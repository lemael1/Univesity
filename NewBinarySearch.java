
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
public class NewBinarySearch {

    public static void main(String[] args) {
       
        System.out.println("Enter number of Array:");
        int size_array = inputPositiveNumber();
        int[] arr = createArray(size_array);
        int[] arr1 = BubbleSort(arr);
        System.out.println("Sorted array:  [" + arr1[0] + DisplayArray(arr1));
        System.out.println("Enter search value: ");
        int search_value = inputPositiveNumber();
        int needResult=binarySearch0(arr1,search_value);
//        int needResult2 = binaryseach(arr, search_value);
//        System.out.println(needResult2);
        System.out.println("Found"+search_value+" at index: "+needResult);
    }

    private static int inputPositiveNumber() {
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

    private static int[] createArray(int size_array) {
        int[] arr = new int[size_array];

        for (int i = 0; i < size_array; i++) {
            arr[i] = inputPositiveNumber();
        }
        return arr;
    }

    private static String DisplayArray(int[] arr) {
        String x = "";
        for (int i = 1; i < arr.length; i++) {
            x += " ," + arr[i];
        }
        return x + "]";
    }

    private static int binarySearch0(int[] arr, int key) {
        int low=0;
        int high=arr.length-1;
        while(low<=high){
            int mid= low+ (high- low)/2;
            if(arr[mid]==key){
                if(arr[mid+1]!=key||arr[mid-1]!=key){
                    return mid;
                }else{
                    high=mid-1;
                }
                
            }
            if(arr[mid]<key){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return -1;
        
       
        
         
    }


    public static int binaryseach(int[] a, int x) {
        int n = a.length;
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            int mid = right + (right - left) / 2;
            if (a[mid] == x) {
                if (mid == 0 || a[mid - 1] != x) {
                    return mid;
                } else {
                    right = mid - 1;
                }
            } else if (a[mid] > x) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
    private static int[] BubbleSort(int[] arr) {
        int[] arrAfter = arr.clone();
        for (int i = 0; i < arrAfter.length - 1; i++) {
            for (int j = 0; j < arrAfter.length - i - 1; j++) {
                if (arrAfter[j] > arrAfter[j + 1]) {
                    int temp = arrAfter[j];
                    arrAfter[j] = arrAfter[j + 1];
                    arrAfter[j + 1] = temp;
                }
            }
        }

        return arrAfter;

    }
}
