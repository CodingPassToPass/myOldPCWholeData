
/*functions*/
/*in java only call by value occurs(means copy of arguments)
in cpp both call by value and call by reference(pointers) occurs*/

/*
public class functions {
  
    public static void calculatesum(int a, int b) {
      int sum=a+b;
      System.out.println("the sum is: " + sum);
    }
    
    public static int calculatesumreturn(int a, int b){
      int sum = a+b;
      return sum;
    }
    
    public static void swap(int a, int b) {
      int temp;
      temp=a;
      a=b;
      b=temp;
      System.out.println("the value of a is "+a);
      System.out.println("the value of b is "+b);
      
    }
    
    public static int factorial(int n) {
      int f=1;
      for(int i=1;i<=n;i++){
        f=f*i;
      }
      return f;
    }
    
    public static void binomialcoef(int n, int r) {
      int fn = factorial(n);
      int fr = factorial(r);
      int fx = factorial(n-r);
      
      int b = fn/(fr*fx);
      System.out.println("the binomial coefficient is : " + b);
      
      
    }
    
    
    public static void main(String args[]) {  
      //calculate sum
      calculatesum(4,7);
      int x = calculatesumreturn(5,55);
      System.out.println("the sum in return is "+ x);

      //swap two numbers
      swap(3, 6);

      //Factorial
      int f = factorial(5);
      System.out.println("factorial : "+f);

      //Binomial Coefficient
      binomialcoef(5,2);
  }
}
*/

/*functions Overloading:- Multiple functons with the same name but different parameters and datatypes*/
/*
public class fun{
            // Using parameters //
  //function to calc sum of 2 nums
  public static int sum(int a,int b){
    return a+b;
  }
  //function to calc sum of 3 numbers
  public static int sum(int a,int b,int c){
    return a+b+c;
  }

   // Using datatypes //
  // function to calc float sum
  public static float sum(float a,float b){
    return a+b;
  }

  public static void main(String args[]){
    int sum1=sum(4,6);
    System.out.println(sum1);
    int sum2=sum(5,43,2);
    System.out.println(sum2);
    float sum3=sum(3.6f,8.2f);
    System.out.println(sum3);


  }
}
*/

/*Questions on functions */

public class functions{

  //check if a number is prime or not
  public static boolean isprime(int num){
    for(int i=2;i<num;i++) {
      if(num%i==0) {
        return false;
      }
    }
      return true;
  }

  //print all prime numbers from 2 to n range
  public static void allprimeprint(int n) {
    for(int i=2;i<n;i++){
      if(isprime(i)) {
        System.out.print(i+" ");
      }
    }
    System.out.println();
  }
  
  //Convert from Binary to  Decimal
  public static int binarytodecimal(int binary) {
    int lastDigit;
    int decimal=0;
    int pow=0;
    while(binary>0) {
      lastDigit = binary % 10;
      decimal = decimal + lastDigit * (int)Math.pow(2,pow); 
      binary = binary/10;
      pow++;
    }
    return decimal;
  }
   //Convert from Decimal to Binary
  public static int decimaltobinary(int decimal) {
    int lastDigit;
    int binary=0;
    int pow=0;
    while(decimal>0) {
      lastDigit = decimal % 2;
      binary = binary + lastDigit * (int)Math.pow(10,pow); 
      decimal = decimal/2;
      pow++;
    }
    return binary;
  }

   //Reverse a number
   public static int revnum(int num) {
    int rnum=0;
    int x;
    while(num>0) {
      x = num%10;
      rnum = rnum*10 + x;
      num=num/10;
    }
    return rnum;
   }

  public static void main(String args[]){
    System.out.println(isprime(23));
    allprimeprint(100);
    System.out.println(binarytodecimal(1001001));
    System.out.println(decimaltobinary(73));
    System.out.println(revnum(123459876));
  }
}









