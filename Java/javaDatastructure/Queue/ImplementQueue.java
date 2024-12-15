package Queue;

public class ImplementQueue {
    static class Queue{
        static int arr[];
        static int size;
        static int rear;

        Queue(int n){
            arr = new int[n];
            size = n;
            rear = -1;
        }

        //isEmpty
        public static boolean isEmpty(){
            return rear==-1;
        } 

        //add
        public static void add(int ele){
            rear = rear+1;
            arr[rear] = ele;
        }
    }
    public static void main(String args[]){
    //implement queue with array
    }

}
