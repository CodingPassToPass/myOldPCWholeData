package LinkList;

public class DoublyLinkedList {
    public static class Node{
        int data;
        Node prev;
        Node next;

        Node(int data){
            this.data  = data;
            this.prev = null;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    //add First
    public void addFirst(int data){
        if(head==null){
            Node newNode = new Node(data);
            head = tail = newNode; 
            size++;
            return;
        }
        Node newNode = new Node(data);
        newNode.next = head; 
        head.prev = newNode;
        head = newNode;
        size++;
    }

    //remove First
    public void removeFirst(){
        if(head==null){
            System.out.println("DLL is empty");
            return;
        }
        head = head.next;
        head.prev = null;
        size--;
    }

    //addLast
    public void addLast(int data){
        if(head==null){
            Node newNode = new Node(data);
            head = tail = newNode;
            size++;
            return;
        }
        
        Node newNode = new Node(data);
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
        size++;
    }
    //remove Last
    public void removeLast(){
        if(head==null){
            System.out.println("DLL is empty");
            return;
        }
        tail = tail.prev;
        tail.next = null;
        size--;
    }

    //reverse Linklist
    public void reverseDLL(){

        Node prev = null;
        Node curr = head;
        Node next;
        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            curr.prev = next;  //only one line is changed
            prev = curr;
            curr = next;
        }
    }

    //print
    public void print(){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data +" "+"->"+" ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String args[]){
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.addFirst(1);
        dll.addFirst(2);
        dll.addFirst(3);
        dll.addFirst(4);
        dll.addFirst(5);
        dll.addLast(1);
        dll.addLast(2);
        dll.addLast(3);
        dll.print();
        dll.removeFirst();
        dll.removeFirst();
        dll.removeLast();
        dll.removeLast();
        dll.print();
        System.out.println("Size of LinkList : "+size);

    }
}
