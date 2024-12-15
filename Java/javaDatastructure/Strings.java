package Java.javaDatastructure;
import java.util.*;
//------------------------------------------------------------------------------------
// public class String {
//     public static void printStr(String name){
//     for(int i=0;i<name.length();i++){
//         System.out.println(name.charAt(i));
//         }
//     }

// public static void main(String[] args) {
//     String s1 = "i am ironman";
//     String s2 = "i am dr.doom";
//     printStr(s1);
//     Scanner ss = new Scanner(System.in);
//     String name1 = ss.next();
//     System.out.println("name: "+name1);
//     String name2 = ss.nextLine();
//     System.out.println("name: "+name2);
//     System.out.println("length"+name2.length());
//     String fName = "gagan";
//     String lName = "yadav";
//     String fullName = fName+" "+lName;
//     System.out.println(fullName);
//     System.out.println(fName.substring(1, 3));
//     printStr( fullName);

//         // equals method:-
//         String ss1 = "tony";
//         String ss2 = "tony";
//         String ss3 = new String("tony");
//         if(ss1==ss2){
//             System.out.println("strings are equal");//
//         }
//         else{
//             System.out.println("strings are not equal");
//         }
//         if(ss1==ss3){
//             System.out.println("strings are equal");
//         }
//         else{
//             System.out.println("strings are not equal");//
//         }
//         if(ss1.equals(ss2)){
//             System.out.println("strings are equal");//
//         }
//         else{
//             System.out.println("strings are not equal");
//         }
//         if(ss1.equals(ss3)){
//             System.out.println("strings are equal");//
//         }
//         else{
//             System.out.println("strings are not equal");
//         }
// // compareTo and compareToIgnoreCase method:-lexicalhraphic
  
//     }
// }
// //Questions on String:-

// class HelloWorld {
// public static int isPalindrom1(String name){
//      int i=0,j=name.length()-1;
//      while(i<name.length()/2){
//          if(name.charAt(i)!=name.charAt(j)){
//              return -1;
//          }
//          else{
//              i++;
//              j--;
//          }
//      }
//      return 1;
// }
//     public static void main(String[] args) {
//         //1. IsPalindrome
//         if(isPalindrom1("dohod")==1){
//             System.out.println("it is palindrome");
//         }
//         else{
//             System.out.println("it is not palindrome");
//         }
//     }
// }
//------------------------------------------------------------------------------------

//------------------------------------------------------------------------------------



//------------------------------------------------------------------------------------

//string questions:- 
public class Strings {
    public static int isPalindrom1(String name){
             int i=0,j=name.length()-1;
             while(i<name.length()/2){
                 if(name.charAt(i)!=name.charAt(j)){
                     return -1;
                 }
                 else{
                     i++;
                     j--;
                 }
             }
             return 1;
        }
    public static float findShortestPath2 (String str){
        int x=0,y=0;
        float path=0;
     for(int i=0;i<str.length();i++){
        char curr = str.charAt(i);
             if('n'==curr){
                y++;
             }
             if('e'==curr){
                x++;
             }
             if('s'==curr){
                 y--;
             }
             if('w'==curr){
                 x--;
             }
           
        }
        path = (float)Math.sqrt((x*x)+(y*y));
        return path;
       }

    public static void main(String[] args) {
     
    //1. IsPalindrome

    // if(isPalindrom1("dohod")==1){
    //     System.out.println("it is palindrome");
    // }
    // else{
    //     System.out.println("it is not palindrome");
    // }
   
    // 2. find Shortest path

    // float path = findShortestPath2("wneenesennn");
    // System.out.println(path);

    // 3. print the largest string by lexicographic

//     String arr[]={ "apple","banana","cherry"};
//         String max = arr[0];
//         for(int i=0;i<arr.length;i++){
//     if((arr[i].compareTo(max))>0){
//                 max = arr[i];
//             }
//         }
//         for(int i=0;i<max.length();i++){
//    System.out.print(max.charAt(i)+" ");
//        }

    // 4. StringBuilder

    // StringBuilder sb = new StringBuilder("");
    // for(char ch='a'; ch<='z'; ch++){
    //     sb.append(ch);
    //     //sb += ch
    // }
    // System.out.println(sb);

    // 5. for a given string convert each the first letter of each word to Uppercase

    //first method:-
    // String str = "i am ironman, and i am dr.Doom";
    // String temp[] = str.split(" ");
    // for( int i=0; i< temp.length ; i++){
    //     String s = temp[i].substring(0,1);
    //     temp[i] = s.toUpperCase() + temp[i].substring(1);
    // }
    // String sb;
    // for( int i=0; i< temp.length ;i++){
    //     sb = sb.concat(" "+temp[i]);
    // }
    // str = sb;
    // System.out.println(str);

    //second method:-
    // String str = "i am ironman, and i am dr.Doom";
    // StringBuilder sb = new StringBuilder("");
    // sb.append(Character.toUpperCase(str.charAt(0)));
    // for( int i=1; i<str.length();i++){
    //     if( str.charAt(i)==' ' && i<str.length()-1){
    //         sb.append(str.charAt(i));
    //         i++;
    //         sb.append(Character.toUpperCase(str.charAt(i)));
    //     }
    //     else{
    //         sb.append(str.charAt(i));
    //     }
    // }
    // System.out.println(sb);

    // 6. find the String Compression ( "aaabbcccdd")=>( "a3b2c3d2")
    
    // String str = "aaabbcccdd";
    // StringBuilder sb = new StringBuilder("");
    // for( int i=0; i< str.length(); i++){
    //     int count=1;
    //     char ch = str.charAt(i);
    //     for(int j=i;j<str.length(); j++){
    //         if(ch==str.charAt(j)){
    //             count++;
    //             i++;
    //         }
    //         else{
    //             sb.append(ch);
    //             sb.append(count);
    //             break;
    //         }
    //     }
    // }
    // System.out.println(sb);


    }
}