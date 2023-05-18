/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 1112v
 */
public class NewFibonaci {
    
    public static void main(String[] args) {
        int n = 45;
        System.out.println("The " + n + " sequence fibonancci:");
        PrintFiboSequence(n);
    }
    
    private static int Fibonacci(int n) {
        if (n <= 1) {
            return n;
        } else {
            return Fibonacci(n - 1) + Fibonacci(n - 2);
        }
    }

    public static void PrintFiboSequence(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(Fibonacci(i));
            if (i < n - 1) {
                System.out.print(", ");
            }
        }
    }
}
