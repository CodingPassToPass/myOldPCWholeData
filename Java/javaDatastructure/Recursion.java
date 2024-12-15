package Java.javaDatastructure;

public class Recursion {
    public static int sumOfNumber1(int num){
        if(num==0){
            return 0;
        }
        else{
            return num%10 + sumOfNumber1( num/10);
        }
    }
    public static int sumOfArray2( int arr[], int size){
        if(size==0){
            return 0;
        }
        else{
            return arr[size-1] + sumOfArray2( arr, size-1);
        }
    }
    public static int sumOfN3(int n){
        if(n==1){
            return 1;
        }
        else{
            return n + sumOfN3( n-1);
        }
    }
    public static int tilingProblem4(int num){
        if(num==0||num==1){
            return 1;
        }
        if(num==2){
            return 2;
        }
        return tilingProblem4(num-1)+tilingProblem4(num-2);
    }
    public static void reverse5(int arr[], int i, int j){
        if(i<=j){
            arr[i] = arr[i]^arr[j];
            arr[j] = arr[i]^arr[j];
            arr[i] = arr[i]^arr[j];
            reverse5(arr, i+1, j-1); 
        }
    }
    public static int findPower6(int num, int power){
        if(power==0){
            return 1;
        }
        if(power%2==0){
            int ans = findPower6( num, power/2);
            return ans*ans; 
        }
        else{
            int ans = findPower6( num, power/2);
            return num*ans*ans; 
        }
    }
    public static void main( String args[]){
        //1. Sum of Number
        // System.out.println( sumOfNumber1(234));

        //2. Sum of Array
        // int arr[] = { 5,2,6,9,5,2};
        // System.out.println( sumOfArray2( arr , arr.length));

        //3. Sum of N number
        // System.out.println(sumOfN3(5));

        //4. Tiling Problem
        // System.out.println(tilingProblem4(3));

        //5. Reverse an Array
        // int arr[] = { 1,2,3,4,5,6,7,8};
        // reverse5(arr,0,arr.length-1);
        // for(int i=0;i<arr.length;i++){
        //     System.out.print(arr[i]+" ");
        // }

        //6. find power of an element( optimized (log n))
        System.out.println(findPower6(2,5)); 



    }
}
