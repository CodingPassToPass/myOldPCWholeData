import java.util.*;

public class ArrayList1 {
    public static void main( String args[]){

        /*------------------------------------ */
        /*(1). Introduction of all operations with implementation:- */
        /*

        //Java Collection Framework:- 
        // ClassName objectName = new ClassName();
        ArrayList<String> list2 = new ArrayList<String>();
        ArrayList<Integer> list1 = new ArrayList<Integer>(); //() call ArrayList constructor //<> used to specify the type parameter
        ArrayList<Boolean> list3 = new ArrayList<Boolean>();

        //1. add operation ( O(1))
        list1.add(10);
        list1.add(20);
        list1.add(30);
        list1.add(40);
        list1.add(50);
        System.out.println(list1);

        //2. get operation ( O(1))
        int li1 = list1.get(2);
        System.out.println(li1);

        //3. delete operation ( O(n))
        list1.remove(3); 
        System.out.println(list1);

        //4. set element at index ( O(n)) 
        list1.set(1,100);
        System.out.println(list1);


        //5. Contains Element ( O(n)) 
        System.out.println(list1.contains(30));
        System.out.println(list1.contains(100));
        System.out.println(list1.contains(70));

        //6. add element at index ( O(n))
        list1.add(1, 1000);
        System.out.println(list1);

        //7. Size of ArrayList
        System.out.println(list1.size());

        //8. print ArrayList manually 
        System.out.println("the ArrayList is");
        for(int i=0; i< list1.size(); i++){
           
            System.out.println(list1.get(i));
        }

        //9. Sorting ArrayList

        int arr[] = { 3, 54, 2,43, 98, 43};
        Arrays.sort(arr);
        for(int i=0 ; i< arr.length ; i++){
            
            System.out.println(arr[i]);
        
        }
          ArrayList<Integer> second = new ArrayList<>();
          second.add(2); second.add(35); second.add(9); second.add(33); second.add(6);
          
          //ascending order
          Collections.sort(second);
          System.out.println("second "+second);

          //descending order
          Collections.sort(second, Collections.reverseOrder()); //comparator - comparator is a function which defines the logic of sorting
          System.out.println("second "+second);

        
        

        //10. Multi-dimensional ArrayList

          (i). Example:1- [[1,2],[3,4]]
        ArrayList<ArrayList<Integer>> mainList = new ArrayList<>();
        ArrayList<Integer> firstList= new ArrayList<>();
        ArrayList<Integer> secondList= new ArrayList<>();

        firstList.add(1);
        firstList.add(2);
        secondList.add(3);
        secondList.add(4);

        mainList.add(firstList);
        mainList.add(secondList);

        for(int i=0; i< mainList.size();i++){
            System.out.println(mainList.get(i));
            ArrayList<Integer> currList = mainList.get(i);
            for(int j=0;j<currList.size();j++){
                System.out.println(currList.get(j));
            }
        }

        System.out.println(mainList);

        //(ii). Example:2- [[1,2,3,4,5],[2,4,6,8,10],[3,6,9,12,15]]

        ArrayList<ArrayList<Integer>> mainList2 = new ArrayList<>();
''
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        ArrayList<Integer> list3 = new ArrayList<>();

        for(int i=1; i<=5; i++){
            list1.add(i);
            list2.add(i*2);
            list3.add(i*3);
        }

        mainList2.add(list1);
        mainList2.add(list2);
        mainList2.add(list3);
        

        //print
        System.out.println(mainList2);

        //get all from mainList2
        for(int i=0; i<mainList2.size(); i++){
            ArrayList<Integer> currList = mainList2.get(i);
            for(int j=0; j<currList.size();j++){
                System.out.print(currList.get(j)+" ");
            }
            System.out.println();
        }
        */
        
        /*------------------------------------ */
        /*(2). print Reverse of an ArrayList */
        /*
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(11); arr.add(12); arr.add(13); arr.add(14); arr.add(15);
        for(int i=arr.size()-1 ; i>=0; i--){
            System.out.print(arr.get(i)+" ");
        }
        System.out.println();
        */

        /*------------------------------------ */
        /*(3). find Max in an ArrayList */
        /*
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(2); arr.add(5); arr.add(9); arr.add(3); arr.add(6);
        int max = Integer.MIN_VALUE ;
        for(int i=0 ; i< arr.size() ; i++){
            if( max < arr.get(i)){
                max = arr.get(i);
            }
        }
        System.out.println("the max element is "+max);
        */

        /*------------------------------------ */
         /*(4). Swap 2 numbers in ArrayList */
         /* 
         ArrayList<Integer> arr = new ArrayList<>();
         arr.add(2); arr.add(5); arr.add(9); arr.add(3); arr.add(6);
         int idx1=1, idx2=3;
           int temp = arr.get(idx1);
           arr.set(idx1, arr.get(idx2));
           arr.set(idx2, temp);
         System.out.println("the swapped arraylist is "+arr);
         */

         /*------------------------------------ */
        /*(5). contain water */
        //(i). Brute force approach --O(n2)

        /* 
        ArrayList<Integer> height = new ArrayList<>();
        ArrayList<Integer> container = new ArrayList<>();
        
        height.add(1);height.add(8);height.add(6);height.add(2);height.add(5);height.add(4);height.add(8);height.add(3);height.add(7);

        int maxWater=0,min=0,width=0,ht=0;
        for(int i=0;i<height.size();i++){
            for(int j=i+1;j<height.size();j++){
                min = Math.min(height.get(i),height.get(j));
                ht = ( j - i);
                if(min*ht > maxWater){
                    maxWater = min*(j-1);
                }
            }

        }

        System.out.println(maxWater);
        */
        
        //(ii). 2 pointer Approach --O(n)
        /*
        ArrayList<Integer> height = new ArrayList<>();
        height.add(1); height.add(8); height.add(6); height.add(2); height.add(5);height.add(4);height.add(8);height.add(3);height.add(7);

        int maxWater=0, ht, width, lp=0, rp=height.size()-1 ;
        while(lp<rp){

            //calculate Area
            width = rp-lp;
            ht = Math.min( height.get(lp), height.get(rp));
            
            if( ht*width > maxWater){
                maxWater = ht*width;
            }

            //2 pointers appro
            if( height.get(lp)< height.get(rp)){
                lp++;
            }
            else{
                rp--;
            }

        }

        System.out.println(maxWater);
        */
  
        /*------------------------------------ */
        /*(6). Trapping Rain Water */
        //(i). first Approach ( Brute force( O(3N)))):-
        /*
        ArrayList<Integer> height = new ArrayList<>();
        height.add(10);height.add(9);height.add(0);height.add(5);

        int leftMax=0, rightMax=0, findMinFromBoth=0, containWater=0, totalTrappingWater = 0;
        for( int i=1; i<height.size()-1; i++){

            leftMax=0;rightMax=0;containWater=0;
            
            //find left max
            for(int j=i-1; j>=0; j--){

                if(height.get(j)>leftMax){
                    leftMax = height.get(j);
                }
            }

            //find right max
            for(int j=i+1; j<height.size(); j++){
                if(height.get(j)>rightMax){
                    rightMax = height.get(j);
                }
            }

            //find min height from leftMax and rightMax
            findMinFromBoth = Math.min( leftMax, rightMax);

            //now subtract current height from min height
            containWater = Math.abs(findMinFromBoth - height.get(i));

            //add water in total water
            totalTrappingWater += containWater;
        }

           System.out.println(totalTrappingWater);
        
        */

        //(ii). second Approach( optimized approach( O(n))):-  
        /* 
        ArrayList<Integer> height = new ArrayList<>();
        height.add(0);height.add(1);height.add(0);height.add(2);height.add(1);height.add(0);height.add(1);height.add(3);height.add(2);height.add(1);height.add(2);height.add(1);

        int lp =0 ,rp = height.size()-1, leftMax = height.get(0), rightMax = height.get( height.size() - 1 );
        int totalTrappingWater = 0;

        while(lp<rp){

            
            if( leftMax <= rightMax){
                lp++;
                System.out.println("leftIndex "+lp);

                if(height.get(lp) < leftMax){
                    totalTrappingWater += leftMax - height.get(lp);
                }
                else{
                    leftMax = height.get(lp);
                }
            }
            else{
                rp--;
                System.out.println("rightIndex "+rp);
                if(height.get(rp) < rightMax ){
                    totalTrappingWater += rightMax - height.get(rp);
                } 
                else{
                    rightMax = height.get(rp);
                }
            }

        }

        System.out.println(totalTrappingWater);

        */
        
        /*------------------------------------ */
        /*(7). Pair Sum-1 :- sorted array*/

            //(i). first Approach ( Brute force( O(n2) ))):-
            /*
            ArrayList<Integer> list = new ArrayList<>();
            list.add(1); list.add(2); list.add(3); list.add(4); list.add(5); list.add(6);
            int target = 5;

            for( int i=0; i< list.size(); i++){
                for( int j=i+1; j< list.size(); j++){
                    if( ( list.get(i) + list.get(j)) == target ){
                        System.out.println(true);
                        return;
                    }
                }
            }


            System.out.println(false);
            return;

            */

            //(ii). second Approach  ( 2 pointers approach ( O(n)))
            /*
            ArrayList<Integer> list = new ArrayList<>();
            list.add(1); list.add(2); list.add(3); list.add(4); list.add(5); list.add(6);
            int target = 5;

            int lp=0, rp= list.size()-1;
            while( lp!=rp){
                if( ( list.get(lp)+list.get(rp)) == target){
                    System.out.println(true);
                    return;
                }
                else if( list.get(lp)+list.get(rp) < target){
                    lp++;
                }
                else{
                    rp--;
                }
            }

            System.out.println(false);
            */
            
        /*------------------------------------ */
        /*(7). Pair Sum-2 :- sorted and rotated array*/

        //(i). 2 pointers approach( O(n)) using modular arithmetic
        /*
        ArrayList<Integer> list = new ArrayList<>();
        list.add(5); list.add(6); list.add(1); list.add(2); list.add(3); list.add(4); 
        int target = 5;

        int breakPoint = 0;
        int n = list.size();
        for(int i=0; i< n ; i++){
            if(list.get(i)>list.get(i+1)){
                breakPoint = i;
                break;
            }
        }

        int lp = breakPoint+1 , rp = breakPoint; 
        while( lp!=rp){
            if( (list.get(lp)+ list.get(rp)) == target){
                System.out.println(true);
                System.out.println(list.get(lp)+" "+list.get(rp));
                return;
            }
            else if( ( list.get(lp)+list.get(rp)) < target){
                lp = (lp+1)% n;
            }
            else{
                rp = (rp+n-1)%n;
            }
            System.out.println(list.get(lp)+" "+list.get(rp));
        }
        */
    


            
    
    }
}
