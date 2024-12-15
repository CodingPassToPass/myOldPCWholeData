package Stack;
import java.util.*;

//implementations for Stack
/*
public class Stack1 {
    //(1).implemention with stack
    static class StackArrayList{
        static ArrayList<Integer> list = new ArrayList<>();

        //isEmpty
        public static Boolean isEmpty(){
            return list.size() == 0;
        } 

        //push
        public static void push(int data){
            list.add(data);
        }

        //pop
        public static int pop(){
            if(isEmpty()){
                return -1;
            }
            int top = list.get(list.size()-1);
            list.remove( list.size()-1);
            return top;
        }

        //peek
        public static int peek(){
            if(isEmpty()){
                return -1;
            }
            return list.get(list.size()-1);
        }
    }
     
    //(2).implemention with Linklist
     static class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }
     }
    static class StackNode{
       static Node head = null;
        //isEmpty
        public static boolean isEmpty(){
            return head==null;
        } 

        //push
        public static void push(int data){
            if(head==null){
                Node newNode = new Node(data);
                head = newNode;
                return;
            }
            Node newNode = new Node(data);
            newNode.next = head;
            head = newNode;

        }

        //pop
        public static int pop(){
            if(isEmpty()){
                return -1;
            }
            int top = head.data;
            head = head.next; 
            return top;
        }

        //peek
        public static int peek(){
            if(isEmpty()){
                return -1;
            }
            return head.data;
        }
    }
    
    public static void main(String args[]) {
        //(1).implementaion with Stack
      
        // System.out.println("Stack with ArrayList");
        // StackArrayList s= new StackArrayList();
        // s.push(1);
        // s.push(2);
        // s.push(3);
        // s.push(4);
        // //print all
        // while(!s.isEmpty()){
        //     System.out.println(s.peek());
        //     s.pop();
        // }
       

        //(2).implementation with Node

        // System.out.println("Stack with LinkList");
        // StackNode n = new StackNode();
        // n.push(1);
        // n.push(2);
        // n.push(3);
        // n.push(4);
        // while(!n.isEmpty()){
        //     System.out.println(n.peek());
        //     n.pop();
        // }
        
    
        //(3).implementation with java collections framework
        
        // Stack<Integer> s = new Stack<>();
        // s.push(1);
        // s.push(2);
        // s.push(3);
        // s.push(4);
        // while(!s.empty()){
        //     System.out.println(s.peek());
        //     s.pop();
            
        // }
        

    }
}
*/


//Questions with stack
public class Stack1 {
    //(1). Push at the Bottom of the stack
    public static void pushAtBottom(Stack<Integer> stk, int data){
        if(stk.empty()){
            stk.push(data);
            return;
        }
        int top = stk.pop();
        pushAtBottom(stk, data);
        stk.push(top);
    }
    public static void reverseString(String str){
        //use stack
        Stack<String> stk = new Stack<>();

        //push string one by one to stack
        for(int i=0;i<str.length();i++){
            stk.push( str.substring(i, i+1));
        }

        //pop string one by one from stack
        StringBuilder strb = new StringBuilder("");
        while(!stk.empty()){
            strb.append(stk.peek());
            stk.pop();
        }
        System.out.println(strb);
    }
    public static void reverseStack(Stack<Integer> stk){
        if(stk.empty()){
            return;
        }
        int top = stk.pop();
        reverseStack(stk);
        pushAtBottom(stk,top);
        
    }
    public static void print(Stack<Integer> stk) {
        while(!stk.empty()){
            System.out.println(stk.pop());
        }
    }
    public static boolean isValidParenthesis(Stack<Character> stk, String str){

        for(int i=0; i<str.length();i++){
            char ch = str.charAt(i);
            
            //opening
            if(ch=='(' || ch=='{' || ch=='['){
                stk.push(ch);
            }
            else{
                //means it starts with },),] or any other value or character which are not allowed
                if(stk.empty()){
                    return false;
                }
                
                //closing [],(),{}
                if( (stk.peek()=='(' && ch==')') || (stk.peek()=='[' && ch==']') || ( stk.peek()=='{' && ch=='}') ){
                    stk.pop();
                }
                //means their is any  other character which is not allowed
                else{
                    return false;
                }
            
            }
            
        }

        if(stk.empty()){
            return true;
        }
        else{
            return false;
        }
    }

    public static boolean isDuplicateParenthesis(Stack<Character> stk, String str){
        
        for(int i=0; i<str.length(); i++){

            char ch = str.charAt(i);

            //closing pair find
            if( ch==')' ){
                int count=0;
                while( stk.peek()!='(' ){
                    count++;
                    stk.pop();
                }
                if(count<1){
                    //duplicate
                    return true;
                }
                else{
                    //opening pair remove
                    stk.pop();
                }
            }
            else{
                //opening ( adding all characters)
                stk.push(ch);
            }
        }
        return false;
    
    }
    public static void main(String args[]) {
        //(1). Push at the Bottom of the stack
        /* 
        Stack<Integer> stk = new Stack<>();
        stk.push(1);
        stk.push(2);
        stk.push(3);
        stk.push(4);

        pushAtBottom(stk,8);

        while(!stk.empty()){
            System.out.println(stk.peek());
            stk.pop();
        }
        
        */

        //(2). reverse a String using a Stack

        // String str = new String();
        // reverseString( "apple"); 

        //(3). reverse a Stack             ---(without using extra stack)
    
        /*
        Stack<Integer> stk = new Stack<Integer>();
        stk.push(1); stk.push(2); stk.push(3); stk.push(4);
        
        reverseStack(stk);
        */
        
        //(4). Stock Span problem

        //(i). [first approach with array] if i do it with an array( O(n2)):-
        /*
        int stock[] = { 100, 80, 60, 70, 60, 85, 100};

        int maxSpan=1;
        for( int i=0;i<stock.length; i++){
            for(int j=i-1; j>=-1; j--){

                //if their is no previous high, all are lower
                if(j==-1){
                    maxSpan = i+1;  
                    break;
                }

                if(stock[j] > stock[i]){
                    //span = high - prevHigh
                    maxSpan = i-j;
                  
                    break;
                    
                }

                
    
            }
            System.out.println("maxSpan "+maxSpan);
           
        }
        System.out.println(maxSpan);

        */
        
        //(ii). [second approach with stack]( O(n))
        /*
        Stack<Integer> stk = new Stack<Integer>();
        // int stock[] = { 10, 4, 5, 90, 120, 80};
        int stock[] = { 100, 80, 60, 70, 60, 75,85};

        int span[] = new int[stock.length];  

        
        for(int i=0; i< stock.length; i++){

            while( !stk.empty() && stock[stk.peek()] <= stock[i] ){
                stk.pop();
            }

            if(stk.isEmpty()){
                span[i] = i+1;
            }
            else{
                int prevMax = stk.peek();
                span[i] = i - prevMax;
            }

            stk.push(i);
        }
      
        //check answers
        for(int i=0;i<stock.length;i++){
            System.out.println(span[i]);
        }

        */

        //(5). Next Greater Element Problem:- the next greator element of some element x in an array is the first greater element that is to the right of x in the same array
        
         //(i). [first approach with array] if i do it with an array( O(n2)):-
         /* 
        int arr[] = { 6, 8, 0, 1, 3};
        int ans[] = new int[arr.length];

        for(int i=0;i<arr.length;i++){
          for(int j=i+1;j<arr.length;j++){
            if(arr[i]<arr[j]){
                ans[i]=arr[j];
                break;
            }
            ans[i]=-1;
          }
          
        }
        */

        //(ii). [second approach with stack]( O(n))
        /* THis logic can solve 4 types of questions:- next Greater Right, next Greater Left, next Smaller Right, next Smaller Left */
        
        /*next greater left */
        
        /* 
        int arr[] = { 6, 8, 0, 1, 3};
        int ans[] = new int[arr.length];

        Stack<Integer> stk = new Stack<>();
 
        for(int i= arr.length-1; i>=0; i--){

            //remove values which are lesser than current element from stack
            while( !stk.empty() && arr[stk.peek()]<arr[i]){
                stk.pop();
            }   

            //empty means no greater value than current value
            if(stk.empty()){
                ans[i] = -1;
            }
            else{
                //greater value than current but lesser than others
                ans[i] = arr[stk.peek()];
            }

            stk.push(i);
        }

        for(int i=0; i<arr.length;i++){
            System.out.println(ans[i]);
        }
        
        */
        

        //(6). Valid Parentheses -(O(n))
        /*
        String str= "{(){}[]}{}";
        Stack<Character> stk = new Stack<>();

        System.out.println(isValidParenthesis(stk,str));
        */

        //(7). Deplicate Parentheses -(O(n))
        /* 
        String str= "(((a+b)+(a+b)))";
        Stack<Character> stk = new Stack<>();
  
        System.out.println(isDuplicateParenthesis(stk,str));
        */

        //(8). Max Area in Histogram -(O(n))
        /*
        int heights[] = { 2, 1, 5, 6, 2, 3};
       
        int left[] = new int[heights.length];
        int right[] = new int[heights.length];

        Stack<Integer> rightSTK = new Stack<>();
        Stack<Integer> leftSTK = new Stack<>();

        //find next smaller left
        for(int i=0; i<heights.length; i++){

            while( !leftSTK.empty() &&  heights[leftSTK.peek()] > heights[i]){
                leftSTK.pop();
            } 

            if(leftSTK.empty()){
                left[i] = -1;
            }
            else{
                left[i] = leftSTK.peek();
            }

            leftSTK.push(i);

        }
        for(int i=0;i<left.length;i++){
            System.out.print(left[i]+" ");
        }

        //find next smaller right
        for(int i=heights.length-1; i>=0; i--){

            while( !rightSTK.empty() && heights[rightSTK.peek()] > heights[i]){
                rightSTK.pop();
            }

            if(rightSTK.empty()){
                right[i] = heights.length;
            }
            else{
                right[i] = rightSTK.peek();
            }

            rightSTK.push(i);
        }

        System.out.println();
        for(int i=0;i<right.length;i++){
            System.out.print(right[i]+" ");
        }

        //find Max Area in Histogram
        int maxArea=0;
        for(int i=0; i<heights.length;i++){

            //width*height and width=(j-i-1) and height[index];
            int area = (heights[i]*(right[i]-left[i]-1));
            if(maxArea< area){
                maxArea = area;
            }

        }

        System.out.println("the max area is "+maxArea);
        */

        //(9). Trapping Rain Water using Stack -(O(n))

        /* 
        int height[] = { 9, 1, 4, 0, 2, 8, 6, 3, 5};
        Stack<Integer> stk = new Stack<>();


        int totalTrappingWater = 0;
        for(int i=0; i<height.length; i++){
            while( !stk.empty() &&  height[i] > height[stk.peek()] ){
                int top = height[stk.pop()];
                int width = i - stk.peek() - 1 ;
                int minHeight = Math.min( height[i] , height[stk.peek()]) - top ;
                System.out.println("the "+minHeight*width);
                totalTrappingWater += minHeight*width;
            }

            stk.push(i);

        }
        
        System.out.println("the total Trapping Water is "+totalTrappingWater);
        */
    
        //(10). Decode string

        /*
        String str = new String("2[ab4[c]3[r]]");
        Stack<Integer> numStk = new Stack<>();
        Stack<String> strStk = new Stack<>();

        for(int i=0; i<str.length(); i++){
            
            Character ch= str.charAt(i);
            if(ch==']'){
                
                StringBuilder strB = new StringBuilder();
                
                while( !strStk.empty() && strStk.peek().charAt(0)!='['){
                    strB.insert(0,strStk.peek());
                    strStk.pop();
                }

                StringBuilder strTemp = new StringBuilder();

                if(!numStk.empty()){
                    for(int j=0; j<numStk.peek(); j++){
                        strTemp.append(strB);
                    }  
    
                    numStk.pop();   // pop num from num stack
                    strStk.pop();   // remove '['
                    strStk.push(strTemp.toString());
                }
            
            }
            else{
                try{
                    numStk.push(Integer.parseInt(ch.toString()));   //agar number string hai to number stack main push ho jayegi warna error ki wajah sa string stack main push hogi
                    numStk.peek();
                }
                catch(NumberFormatException err){
                    strStk.push(ch.toString());
                }
                
            }
        }

        System.out.println(strStk);
        */
    
        //(11).  Simplify the directory Path( Unix like)
        
        /*

        //test cases:--
        
        // String str = new String("/a//b//c///////d");
        String str = new String("//a/./b/../../c/");
        // String str = new String("/../../../../../a");
        // String str = new String("/a/./b/./c/./d/");
        // String str = new String("/a/../.././../../.");
        // String str = new String("/a//b//c//////d");
        // String str = new String("/home/");

    

        Stack<String> strStk = new Stack<>();

        //split this string
        String newStr[] = str.split("/");


        for(int i=0;i<newStr.length;i++){

            if( newStr[i].equals("") || newStr[i].equals(".")){
                continue;
            }
            else if( newStr[i].equals("..")){
                if(!strStk.empty()){
                    strStk.pop();
                } 
                continue;
                    
            }
            else{
                strStk.push( newStr[i]);
            }

        }

        StringBuilder strB = new StringBuilder();
        while(!strStk.empty()){
            strB.insert(0, strStk.pop());
            strB.insert(0, "/");
        }

        System.out.println(strB);

        */


        //(12). if linkedlist is palindrome or not
        
        Stack<Character> stkCh = new Stack<>();

        LinkedList<Character> ll = new LinkedList<Character>();
        ll.add('A');ll.add('B');ll.add('C');ll.add('B');ll.add('A');


        //push character in linklist
        for(Character llCh : ll){
            stkCh.push(llCh);
        }

        //compare stack and linklist
        Boolean check=true;
        for(Character llCh: ll){
            if(llCh!=stkCh.peek()){
                check=false;
            }
            stkCh.pop();
        }

        System.out.println(check);




    }
}
