package Java.javaDatastructure;
import java.util.*;

public class BitManipulation {

    public static void get(int num, int i){
        int bitMask = ( 1<<(i-1));
        if( (num&bitMask)==0){
            System.out.println("ith bit is 0");
        }
        else{
            System.out.println("ith bit is 1");
        }
    }

    public static int clearBitsInRange(int num, int start, int end){
        int a = (~0)<<(end);
        int b = ~((~0)<<(start-1));
        int bitMask = a|b;
        return num & bitMask; 
    }
    
    public static void isPowerOfTwo(int num){
        int bitMask = num & (num-1) ;
        if(bitMask == 0){
            System.out.println("it is a power of 2");
        }
        else{
            System.out.println("it is not a power of 2");
        }
    }
    
    public static int countSetBits(int num){
        int count=0;
        while(num>0){
            count +=  (1 & num);
            num = (num>>1) ;
        }
        return count;
    }
    
    public static int fastExponentiation(int a,int n){
        int ans=1;
        while( n>0){
            if( (n & 1) != 0){
                ans = ans*a;
            }
            a = a*a ;
            n = n>>1;
        }
        return ans;
    }
    
    public static void swap( int a,int b){
        a = a^b;
        b = a^b;
        a = a^b;
        System.out.println(a + " and " + b);

    }
    
    public static int minimumBitFlipsToConvert(int start, int goal){
        int bitMask = start^goal;
        int count = 0;
        while( bitMask>0){
            count += (1 & bitMask) ;
            bitMask = bitMask>>1;
        }
        return count;
    }
    
    public static void powerSet(int arr[]){
        int n = arr.length ;               //3
        for(int count=0;count < (1<<n);count++ ){
            for(int i=0;i < n ; i++){ 
                if( (count&( 1<<i))!=0 ){
                     
                    System.out.print(arr[i]+" ");
                }
            }
            System.out.println();
        }
        
    }

    public static int singleOccurOtherTwice(int arr[]){
        int unique=0;
        for(int i=0; i<arr.length; i++){
            unique = unique ^ arr[i] ;
        }
        return unique;
    }

    public static int singleOccurrOtherThrice(int arr[]){
        int singleElement=0;
        for(int i=0;i<32;i++){
            int y = (1<<i);
            int count =0;
            for(int j=0;j<arr.length;j++){
                if( ( arr[j] & y)!=0){
                    count = count + 1;
                }
            }
            if( (count%3)!=0){
                singleElement = singleElement | y;
            }
        }
        return singleElement;
    }
    
    public static void doubleOccurrOtherTwice(int arr[]){
        int xor=0;
        for(int i=0;i<arr.length;i++){
            xor = xor^arr[i];
        }
        int rightMost = ((xor)&(xor-1))^xor;
        int b1=0,b2=0;
        for(int i=0;i<arr.length;i++){

            if( (rightMost&arr[i])!=0 ){
                b1 = b1^arr[i];
            }
            else{
                b2 = b2^arr[i];
            }
        }
        
        System.out.println("the first bucket have "+b1+"\nthe second bucket have "+b2);
    }
    
    public static int xorOfNumberRange(int num){
        if( num%4==1){
            return 1;
        }
        else if( num%4==2){
            return num+1;
        }
        else if( num%4==3){
            return 0;
        }
        else{
            return num;
        }
    }
    
    public static int xorOfRange( int x, int y){
        int ans = xorOfNumberRange(x-1)^xorOfNumberRange(y);
        return ans;
    }

    public static int sumOfBitDifferencesAmongAllPairs(int arr[]){
        int xor = 0;
        int count=0;
        int countAllPairs =0;
        for(int i=0; i<arr.length ; i++){
            for(int j=0; j<arr.length ;j++){
                    xor = arr[i]^arr[j];
                    count=0;
                    while(xor>0){
                        count += 1 & xor ;
                        xor = xor>>1;
                    }
                countAllPairs += count;
            }
        }
        return countAllPairs;
    }
    public static int withoutBitManipulationJosephusProblem(int num){
        int power=1;
        while(power*2<=num){
            power=power*2; 
        }
        int add = num - power;
        return (2*add +1);
    }

    public static void main(String[] args){
        //1.
        // get(5,3);

        //2.
        // int newCBIR = clearBitsInRange(63,2,4);
        // System.out.println("the new Number is "+newCBIR);

        //3.
        // isPowerOfTwo(64);

        //4 
        // int countSB = countSetBits(31);
        // System.out.println("the count of set bits are: "+ countSB);

        //5
        // int newFE = fastExponentiation(3,5);
        // System.out.println("the exponentiation is :"+ newFE);

        //6
        // swap(5,6);

        //7 . Minimum flips are needed to convert start number to goal number
        // int newNBFTC =  minimumBitFlipsToConvert(8,2);
        // System.out.println(newNBFTC);

        //8 . Print all subsets of an array( Power set)
        // int arr[] = {4,7,9};
        // powerSet(arr);

        //9 . find the element that appears once in an array where every other element appears twice
        // int a1[] = { 3,4,3,8,9,4,8};
        // int singleD = singleOccurOtherTwice(a1);
        // System.out.println("the unique element for Twice is "+singleD);

        //10 . find the element that appears once in an array where every other element appears thrice
        // int a2[] = { 4,4,4,5,8,3,3,8,8,3};
        // int singleT = singleOccurrOtherThrice(a2);
        // System.out.println("the unique element for Thrice is "+singleT);

        //11 . find the element that appears two in an array where every other element appears twice
        // int a3[] = { 2,4,2,14,3,7,7,3};
        // doubleOccurrOtherTwice(a3);

        
        //12 . find the xor of range
        // int ans = xorOfRange(4,8);
        // System.out.println("the xor of elements from the range is "+ans);

        //13.
        // int arr[]={ 1,3,5};
        // int count = sumOfBitDifferencesAmongAllPairs( arr);
        // System.out.println(count);

        //14.Josephus Problem Algorithm without using bit-manipulation
        int ans = withoutBitManipulationJosephusProblem(10);
        System.out.println(ans);

        

        
    }
    
}
