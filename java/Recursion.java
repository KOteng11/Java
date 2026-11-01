import java.util.Arrays;
import java.util.Scanner;

public class Recursion{
    
    public static long[] F;
    
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter index for Fibonnaci: ");
        int n = input.nextInt();
        F = new long[n];
        Arrays.fill(F, -1);
        System.out.println(mFib(n));
        
    }
    
    public static int sum1(int n){
        if (n == 0){
            return 0;
        }
        return sum(n-1) + n;
    }
    
    public static int sum2(int n){
        int total = 0;
        
        while(n > 0){
            total += n;
            n--;
        }
        
        return total;
    }
    
    public static int sum(int n){
        return (n * (n+1))/ 2;
    }
    
    public static int pow(int m, int n){
        if (n == 0){
            return 1;
        }
        return pow(m, n-1) * m;
    }
    
    public static int fib(int n){
        if (n <= 1){
            return n;
        }
        return fib(n-1) + fib(n-2);
    }
    
    public static long mFib(int n){
        if (n <= 1){
            F[n] = n;
            return n;
        }
        if (F[n-2] == -1){
            F[n-2] = mFib(n-2);
        }
        if (F[n-1] == -1){
            F[n-1] = mFib(n-1);
        }
        return F[n-1] + F[n-2];
    }
}