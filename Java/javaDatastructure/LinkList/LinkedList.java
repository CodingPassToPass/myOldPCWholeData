package LinkList;

/*Single Linked List */


public class LinkedList {
    //Node class
    public static class Node{
        int data;
        Node next;

        //Node constructor
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    //static variables of type Node
    public static Node head;
    public static Node tail;
    public static int size;       //default 0

    //methods:-
    //(1).add Node to first
    public void addFirst(int data){
        if(head == null){
            Node newNode = new Node(data);
            head = tail = newNode;
        }
        else{
            Node newNode = new Node(data);
            newNode.next = head;
            head = newNode;
        }
        size++;
    }
    //(2).add Node to last
    public void addLast(int data){
        if(tail==null){                       //we can also take head( because when node exists ,head and tail both are null)
            Node newNode = new Node(data);
            head = tail = newNode;
        }
        else{
            Node newNode = new Node(data);
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    //(3). print Linklist data     //Complexity:- O(n)
    public void print(){
        
        Node temp = head;
        while( temp!=null){
            System.out.print( temp.data +" "+"->"+" ");
            temp = temp.next;
        }
        System.out.println("null");

    }

    //(4).Add Node in the Middle           //Complexity:- O(n)
    public void add(int index, int data){

        if(index==0){
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        Node temp = head;
        for(int i=0; i<index-1; i++){
            temp = temp.next;
        }
        newNode.next = temp.next;
        temp.next = newNode;
        
        size++;
    }
    //(5).size of Linklist
    public void sizeOfLinklist(){
        
        if(head==null){
            System.out.println(0);
            return;
        }
        Node temp = head;
        int i=0;
        while( temp!=null){
            temp = temp.next;
            i++;
        }
        System.out.println("size: "+i);

    }
    //(6).Remove Node from first           
    public void removeFirst(){
        if(size==0){
            System.out.println("LinkedList is Empty");
            return;
        }
        if(size==1){
            tail=null;
            head=null;
            return;
        }

        head = head.next;
        size--;
    }
    //(7).Remove Node from last           
    public void removeLast(){
        if(size==0){
            System.out.println("LinkedList is Empty");
            return;
        }
        if(size==1){
            tail=head=null;
            return;
        }

        Node temp=head;
        while(temp.next.next!=null){
            temp = temp.next;
        }

        tail = temp;
        temp.next = null; 

        size--;
    }
    //(8).Remove Node with index
    public void remove(int index){
        Node temp = head;
        for(int i=0;i<index-1;i++){
            temp = temp.next;
        }
        temp.next = temp.next.next;
        size--;
    }
    //(9). Search element in Linklist and return index( Iterative approach)
    public int searchIterative(int element){
        if(head.data==element){
            return 0;
        }
        Node temp = head;
        int i=0;
        while(temp!=null){
            if(temp.data==element){
                return i;
            } 
            i++;
            temp = temp.next;
        }
        return -1;
    }
    //(10). Search element in Linklist and return index( Recursive approach)
    public int findElementLL( Node head, int element){

        //by starting to end increment
        // if(head==null){
        //     return -1;
        // }
        // if(head.data==element){
        //     return i;
        // }
        // return findElementLL( head.next, element, i+1);

        //by end to start increment(without taking extra value for incrementation)
        if(head==null){
            return -1;
        }

        if(head.data==element){
            return 0;
        }

        int i = findElementLL( head.next, element);
        if(i==-1){
            return -1;
        }
        else{
            return i+1;
        }
            
    }
    public int searchRecursive(int element){
        //by starting to end increment
        // return findElementLL( head, element, 0);

         //by end to start increment(without taking extra value for incrementation)
        return findElementLL(head, element);
    }
    //(11). Reverse of a Linklist( Iterative approach) (O(n))
    public void reverseLL(){
        Node prev = null;
        Node curr = head;
        Node next ;

        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        tail = head;
        head = prev;
    }
    //(12). Find and Remove Nth node from End(Iterative approach) (O(n))
    public int findNthRemoveFromEnd(int pos){

        //calculate size of linklist
        Node temp = head;
        int sz = 0;
        while(temp!=null){
            sz++;
            temp = temp.next;
        } 

        temp = head;
        int position = (size-pos)+1;

        if(position==1){
            int find = head.data;
            removeFirst();
            return find;
        }

        for(int i=1; i<position-1 ; i++){
            temp = temp.next;
        }
        int find = temp.next.data;
        temp.next = temp.next.next;
        size--;
        return find;
    }
    //(13). Check if LL is a Palindrome
    public Node findMid_SlowFastApproach(Node head){
        Node slow = head;
        Node fast = head;

        while(fast!=null && fast.next!=null){
            slow = slow.next ; //+1
            fast = fast.next.next ; //+2
        }
        return slow;    //slow is my midNode
    }
    public Boolean isPalindromeLL(){
        //if single element or have no element means palindrome
        if(head==null || head.next==null){
            return true;
        }

        //(i). find mid by using size
            // int mid = size/2;
    
            //first half----
            // Node temp1 = head;
            
            //second half----
            // Node temp2 = head;

            //find the next of mid--
            // for(int i=1;i<=mid;i++){
                // temp2 = temp2.next; 
            // }

            //reverse a second half--
            // Node prev= null;
            // Node curr = temp2;
            // Node next ;
            // while(curr!=null){
            //     next = curr.next;
            //     curr.next = prev;
            //     prev = curr;
            //     curr = next;
            // }
            // temp2 = prev;
    
            //compare first and second half----
            // for(int i=1; i<=mid; i++){
            //     System.out.println("(temp1)first half: "+temp1.data);
            //     System.out.println("(temp2)second half: "+temp2.data);
            //     if(temp1.data!=temp2.data){
            //         return false;
            //     }
            //     temp1 = temp1.next;
            //     temp2 = temp2.next;
            // }
            // return true;

        //(ii). find mid by slow and fast approach

            //first half----
            Node temp1 = head;

            //second half and find mid Node----
            Node temp2 = findMid_SlowFastApproach(head);

            //reverse second half--
            Node prev =null;
            Node curr = temp2;
            Node next ;

            while(curr!=null){
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            temp2 = prev;

            //compare first and second half----
            while(temp1!=null){
                // System.out.println("(temp1)first half: "+temp1.data);
                //     System.out.println("(temp2)second half: "+temp2.data);
                    if(temp1.data!=temp2.data){
                        return false;
                    }
                    temp1 = temp1.next;
                    temp2 = temp2.next;
            }
        return true;

    }
    //(13). Detect a Loop/Cycle in a LL
    public Boolean detectCycleInLL(){
        Node slow = head;
        Node fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            
            //cycle exists
            if(slow==fast){
                System.out.println("they are meet at data "+slow.data);
                return true;
            } 
        }
        return false;
    }
    //(14). Remove a Cycle in a LL after detection
    public void RemoveCycleInLL(){
        Node slow = head;
        Node fast = head;
        Boolean cycle = false;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;

            //fast and slow are meet
            if(slow==fast){
                cycle = true;
                break;
            }
        }

        if(cycle==false){
            System.out.println("it is contains cycle");
            return;
        }

        // find meeting point 
        slow = head;
        Node prev=null; //last node
        while(slow!=fast){
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }
        // remove cycle -> last.next = null
        prev.next = null;
    }
    //(15).MergeSort using LL
    public Node getMidForMS(Node head){
        Node slow = head;
        Node fast = head.next;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public Node merge(Node head1, Node head2 ){
        Node tempLL = new Node(-1);
        Node temp = tempLL;

        while( head1!=null && head2!=null){
            if( head1.data<=head2.data){
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
            }
            else{
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }
        }

        while(head1!=null){
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }

        while(head2!=null){
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }

        return tempLL.next;
    }
    public Node mergeSort(Node head){

        if(head==null || head.next==null){
            return head;
        }

        //find mid
        Node mid = getMidForMS(head);
        //rightHead
        Node leftHead = head; 
        //leftHead
        Node rightHead = mid.next;
        //separate leftHead with rightHead
        mid.next = null;

        Node newLeft = mergeSort( leftHead);
        Node newRight = mergeSort( rightHead);

        return merge( newLeft, newRight);
    }
    //(16). Zig-Zag in LL
    public void zigZagLL(){

        //first half
        Node LH = head;

        //second half
        Node RH;

          //find mid
          Node mid = getMidForMS(head);

          //reverse LL
          Node prev = null;
          Node curr = mid.next;
          mid.next = null;
          Node next;

          while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
          }
          RH = prev;
          
        // Alternate merging approach
        Node nextLH;
        Node nextRH;

        while(LH!=null && RH!=null){
            nextLH = LH.next;
            nextRH = RH.next;
            LH.next = RH;
            RH.next = nextLH;

            //increment both
            LH = nextLH;
            RH = nextRH;

        }

    }
    //(17). Intersection point of two Linked Lists
    public int IntersectionPointOfTwoLinkedList(Node first, Node second){
        /*(i). first approach:-brute force*/
        /*
            Node temp = second;
            while(first!=null){
                temp = second;
                while(temp!=null){
                    //interaction point
                    if(first==temp){
                        return first.data;
                    }
                    temp = temp.next;
                }
                first = first.next;
            }
            return 0;
        */

        /*(ii). second approach*/
        /* 
            Node temp1 = first;
            Node temp2 = second;
            int l1=0;
            int l2=0;

            //find first length
            while(temp1!=null){
                temp1 = temp1.next;
                l1++;
            }
            temp1 = first;
            //find second length
            while(temp2!=null){
                temp2 = temp2.next;
                l2++;
            }
            temp2 = second;


            //find difference and apply condition
            if(l1>l2){
                int l = l1-l2;
                //cut the differnce by balancing both
                for(int i=0; i<l; i++){
                    temp1 = temp1.next;
                }
                
                //check the condition 
                while(temp1!=null){
                    System.out.println(temp1.data + " |+|+|+|+| " + temp2.data);
                    if(temp1==temp2){
                        return temp1.data;
                    }
                    temp1 = temp1.next;
                    temp2 = temp2.next;
                }
            }
            else if(l1<l2){
                int l = l2-l1;
                for(int i=0; i<l; i++){
                    temp2 = temp2.next;
                }
                
                while(temp1!=null){
                    System.out.println(temp1.data + " |-|-|-|-| " + temp2.data);
                    if(temp1==temp2){
                        return temp1.data;
                    }
                    temp1 = temp1.next;
                    temp2 = temp2.next;
                }
            }
            else{
                temp1=first;
                temp2=second;
                
                while(temp1!=null){
                    System.out.println(temp1.data + " ||| " + temp2.data);
                    if(temp1==temp2){
                        return temp1.data;
                    }
                    temp1 = temp1.next;
                    temp2 = temp2.next;
                }
            }

            return 0;
        */

        /*(iii). third approach*/
        
         Node temp1 = first;
         Node temp2 = second;
         while(temp1!=temp2){

            if(temp1==null){
                temp1 = second;
            }
            if(temp2==null){ 
                temp2 = first;
            }

            temp1 = temp1.next;
            temp2 = temp2.next;
         }

         return temp1.data;


    }
    //(18). Delete N Nodes After M Nodes LL
    public void Delete_N_Nodes_After_M_Nodes_LL(int M, int N){
        
        Node tempCurr = head;
        Node tempCount = head;
        int m =M;
        while(tempCurr!=null){
            //condition for head 
            if(tempCount==head){
                m = m-1;
            }
            else{
                m=M;
            }
           
            int i=0;
            while(i!=m){
                if(tempCurr==null){
                    break;
                }
                tempCurr = tempCurr.next;
                i++;
            }
           
            int j=0;
            tempCount = tempCurr;
            while(j!=N+1){

                if(tempCount==null){
                    break;
                }
                tempCount = tempCount.next;
                j++;
            }

            if(tempCurr==null){
                break;
            }

            tempCurr.next = tempCount;
          
        }


    }
    //(19). Swapping Nodes in a Linked List with given Keys
    public void swappingNodesInLL(int x, int y){

        Node temp = head;
        Node tempX = head;
        Node tempY = head;
        int i = 1;
        while(temp!=null){
            if(i==x){
                tempX = temp;  
            }
            if(i==y){
                tempY = temp;
            }
            temp = temp.next;
            i++;
        }

       
        int tempVar=0;
        tempVar = tempX.data;
        tempX.data = tempY.data;
        tempY.data = tempVar;
     

    }
    //(20). Odd Even Linked List(all even numbers appears first and then odd numbers but keep the order same for both)
    public Node OddEvenOrderLL(){

        //even Node
        Node even = new Node(-1);
        Node evenTemp = even;

        //odd Node
        Node odd = new Node(-1);
        Node oddTemp = odd;

        //new Node
        Node newHead = new Node(-1);
        Node newHeadTemp = newHead;

        //even and odd add
        Node temp = head;
        while(temp!=null){
            
            if(temp.data%2==0){
               evenTemp.next = temp;
               evenTemp = evenTemp.next;
                
            }
            else{
                oddTemp.next = temp;
                oddTemp = oddTemp.next;
            }
            temp = temp.next;
        }
        evenTemp.next = null;
        oddTemp.next = null;


        //new Node( contain even and odd)
         //first element is -1
        even = even.next;
        odd = odd.next;
        //even
        while(even!=null){
            System.out.println(even.data);
            newHeadTemp.next = even; 

            even = even.next;
            newHeadTemp = newHeadTemp.next;
        }
        //odd
        while(odd!=null){
            System.out.println(odd.data);
            newHeadTemp.next = odd; 
            
            odd = odd.next;
            newHeadTemp = newHeadTemp.next;
        }

        newHeadTemp.next = null;

        return newHead.next;

    }
    //(21). Merge K Sorted Linked List 
    public Node mergeSortedLL(Node currNode, Node newNode){
        Node temp = new Node(-1);
        Node oTemp = temp;
        while(currNode!=null && newNode!=null){
            if(currNode.data <= newNode.data){
                oTemp.next = currNode;
                currNode = currNode.next;
                oTemp = oTemp.next;
            }
            else{
                oTemp.next = newNode;
                newNode = newNode.next;
                oTemp = oTemp.next;
            }
        }
        while(currNode!=null){
            oTemp.next = currNode;
            currNode = currNode.next;
            oTemp = oTemp.next;
        }
        while(newNode!=null){
            oTemp.next = newNode;
            oTemp = oTemp.next;
            newNode = newNode.next;
        }
        oTemp.next = null;

        return temp.next;
    }
    public Node mergeKSortedLL(Node addressArray[]){
        
        Node first = addressArray[0];

        for(int i=1; i<addressArray.length; i++){
            first = mergeSortedLL(first, addressArray[i]);
        }
        return first;
    }
    public static void main( String args[]){

        LinkedList li = new LinkedList();
        // li.addFirst(1);
        // li.addFirst(2);
        // li.addFirst(3);
        // li.addFirst(2);
        // li.addFirst(1);
        // li.print();
        // li.remove(3);
        // li.print();
        // System.out.println(size);

        //(9).search iterative approach
        // int x=li.searchIterative(2);

        //(10).search recursive approach
        // int x = li.searchRecursive(3);
        // if(x==-1){
        //     System.out.println("element not found");
        // }
        // else{
        //     System.out.println("element found at index: "+x);
        // }

        //(11). Reverse of a Linklist
        // li.reverseLL();
        // li.print();

        //(12). Find and Remove Nth node from End
        // System.out.println("the removed element is "+ li.findNthRemoveFromEnd(1)); 
        // li.print();
        // System.out.println("the removed element is "+ li.findNthRemoveFromEnd(4));
        // li.print();

        //(13). Check if LL is a Palindrome
        // if(li.isPalindromeLL()){
        //     System.out.println("it is a palindrome");
        // }
        // else{
        //     System.out.println("it is not a palindrome");
        // }

        //(14). Detect a Loop/Cycle in a LL
        // head = new Node(1);
        // Node temp = new Node(2);
        // head.next = temp;
        // head.next.next = new Node(3);
        // head.next.next.next = new Node(4);
        // head.next.next.next.next = temp;
        //1->2->3->4->2(cycle formed)

        // if( li.detectCycleInLL() ){
        //     System.out.println("it contains the cycle");
        // }
        // else{
        //     System.out.println("it is not contain any cycle");
        // }


        //(14). Remove a Cycle in a LL after detection
        // if( li.detectCycleInLL() ){
        //     System.out.println("it contains the cycle");
        //     li.RemoveCycleInL();
        //     System.out.println("after remove cycle");
        // }
        // else{
        //     System.out.println("it is not contain any cycle");
        // }

        // li.print();

        // if( li.detectCycleInLL() ){
        //     System.out.println("it contains the cycle");
        // }
        // else{
        //     System.out.println("it is not contain any cycle");
        // }

        //(15).MergeSort using LL
        // li.addFirst(1);
        // li.addFirst(5);
        // li.addFirst(3);
        // li.addFirst(83);
        // li.addFirst(31);
        // li.print();
        // li.head = li.mergeSort(head);
        // li.print();

        //(16). Zig-Zag using LL
        // li.addFirst(5);
        // li.addFirst(4);
        // li.addFirst(3);
        // li.addFirst(2);
        // li.addFirst(1);
        // li.print();
        // li.zigZagLL();
        // li.print();

        /*(17). Interaction Point of two Linked List*/
        // Node first = new Node(1);
        // first.next = new Node(2);
        // first.next.next = new Node(3);
        // first.next.next.next = new Node(4);
        // first.next.next.next.next = new Node(5);

        // Node second = new Node(100);
        // second.next = new Node(99);
        // second.next.next = new Node(98);

        // Node temp = new Node(6); 
        // first.next.next.next.next.next = temp;
        // second.next.next.next = temp;

        // temp.next = new Node(7);
        // temp.next.next = new Node(8);
        // temp.next.next.next = new Node(9);

        // int pointData = li.IntersectionPointOfTwoLinkedList(first, second);
        // System.out.println("the Interaction point is "+pointData);

        /*(18). Delete N Nodes After M Nodes LL*/
        //  li.addLast(1);
        //  li.addLast(2);
        //  li.addLast(3);
        //  li.addLast(4);
        //  li.addLast(5);
        //  li.addLast(6);
        //  li.addLast(7);
        //  li.addLast(8);
        //  li.addLast(9);
        //  li.addLast(10);
        //  li.print();
        //  li.Delete_N_Nodes_After_M_Nodes_LL(3, 2);
        //  li.print();

        /*(19). Swapping Nodes in LL*/
        //  li.addFirst(10);
        //  li.addFirst(9);
        //  li.addFirst(8);
        //  li.addFirst(7);
        //  li.addFirst(6);
        //  li.addFirst(5);
        //  li.addFirst(4);
        //  li.addFirst(3);
        //  li.addFirst(2);
        //  li.addFirst(1);
        //  li.print();
        //  li.swappingNodesInLL(3,6);
        //  li.print();

         /*(20). Odd Even Linked List */
        //  li.addFirst(6);
        //  li.addFirst(1);
        //  li.addFirst(4);
        //  li.addFirst(5);
        //  li.addFirst(10);
        //  li.addFirst(12);
        //  li.addFirst(8);
        //  li.print();
        //  head =li.OddEvenOrderLL();
        //  li.print();

         /*(21). Merge K Sorted Linked List */
         /*
         //list1
         Node first =  new Node(1);
         first.next = new Node(3);
         first.next.next = new Node(5);
         first.next.next.next = new Node(7);

         
         //list2
         Node second =  new Node(2);
         second.next = new Node(4);
         second.next.next = new Node(6);
         second.next.next.next = new Node(8);

         //list3
         Node third =  new Node(0);
         third.next = new Node(9);
         third.next.next = new Node(10);
         third.next.next.next = new Node(11);

          //list4
          Node fourth =  new Node(23);
          fourth.next = new Node(54);
          fourth.next.next = new Node(55);
          fourth.next.next.next = new Node(93);

         //create an array to store node addresses
         Node[] addressArray = new Node[4];

         //array of k sorted linked List initialise the addresses in an array
         addressArray[0] = first;
         addressArray[1] = second;
         addressArray[2] = third;
         addressArray[3] = fourth;
        
        li.print();
        head = li.mergeKSortedLL(addressArray);
        li.print();

        */


 






























    
        // li.head = new Node(1);

        // System.out.println(li.head);
        // System.out.println(li.head.data);
        // System.out.println(li.head.next);
        // System.out.println("-------");

        // li.head.next = new Node(2);

        // System.out.println(li.head);
        // System.out.println(li.head.data);
        // System.out.println(li.head.next);
        // System.out.println(li.head.next.data);
        // System.out.println(li.head.next.next);
        // System.out.println("-------");

        // li.head.next.next = new Node(3);

        // System.out.println(li.head);
        // System.out.println(li.head.data);
        // System.out.println(li.head.next);
        // System.out.println(li.head.next.data);
        // System.out.println(li.head.next.next);
        // System.out.println(li.head.next.next.data);
        // System.out.println(li.head.next.next.next);
        // System.out.println("-------");

        // //all data print manually
        // System.out.println(li.head.data);
        // System.out.println(li.head.next.data);
        // System.out.println(li.head.next.next.data);
        // System.out.println(li.head.next.next.next.data);

    
    
    }
}

