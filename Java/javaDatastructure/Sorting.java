package Java.javaDatastructure;
import java.util.*;
import java.util.Collections;

public class Sorting {
    public static void bubbleSort(int arr[]){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length-i-1;j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                 }
            }
        }
    } 
    public static void selectionSort(int arr[]){
      
        for(int i=0;i<arr.length-1;i++){
            int min = i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[min]>arr[j]){ 
                    min=j; 
                }
            }
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
    }
    public static void insertionSort( int arr[]){

        for(int i=0;i<arr.length-1;i++){
           int ins = i+1;
           for(int j=i; j>=0; j--){
              if( arr[ins] < arr[j]){
                int temp = arr[ins];
                arr[ins] = arr[j];
                arr[j] = temp;
                ins=j;
              }
           }
        }
    }
    public static void countingSort(int arr[]){
        //find max element
        int max=arr[0];
        for(int i=1;i<arr.length;i++){
            if(max<arr[i]){
                max=arr[i];
            }
        }
        int temp[] = new int[max+1];
        for(int i=0; i<=max; i++){
            temp[arr[i]]++;
        }
        
        int k=0;
        for(int i=0;i<temp.length;i++){
            while(temp[i]>0){
                arr[k]=i;
                temp[i]--;
                k++;
            }
        }

    }
    public static void merge(int arr[],int si,int mid,int ei){
        int temp[] = new int[ei-si+1];
        int i = si;
        int j = mid+1;
        int k=0; //iterator for temp

        while( i<=mid && j<=ei){
            if(arr[i]<arr[j]){
                temp[k]=arr[i];
                i++;
                k++;
            }
            else{
                temp[k]=arr[j];
                j++;
                k++;
            }
        }

        //left part
        while(i<=mid){
            temp[k++]=arr[i++];
        }

        //right part
        while(j<=ei){
            temp[k++]=arr[j++];
        }

        // copy temp to original array
        k=0;
        for(int z=si;z<=ei;z++){
            arr[z]=temp[k];
            k++;
        }
    }
    public static void mergeSort(int arr[],int si,int ei){
        if(si<ei){
            int mid = si+( ei-si)/2;
            mergeSort(arr, si, mid); //left part
            mergeSort(arr, mid+1, ei); //right part
            merge(arr,si,mid,ei);   
        }
    }
    public static int partition( int arr[], int si, int ei){
        int pivot = arr[ei];
        int i = si-1;
       
        for(int j=si ; j<=ei; j++){
            if(arr[j]<=pivot){
                i++;
                int temp = arr[j];
                arr[j]=arr[i];
                arr[i]=temp;
            }
        }
        return i;
    }
    public static void quickSort(int arr[], int si, int ei){
        if(si<ei){
            int pivot = partition(arr, si, ei);
            quickSort(arr, si, pivot-1);
            quickSort(arr, pivot+1, ei);
        }
    }
    public static int searchInSortedRotatedArray(int arr[], int element, int si, int ei){
        
        if(si>ei){
            return -1;
        }
        int mid = si + (ei-si)/2;
        if(arr[mid]==element){
            return mid;
        }
        if(arr[si] < arr[mid]){
            if( arr[si] <= element && element<=arr[mid]){
              return searchInSortedRotatedArray(arr, element, si, mid-1);
                }
            else{
                return searchInSortedRotatedArray(arr, element, mid+1, ei);
            }
        }
        else{
            if(arr[mid]<=element && element<=arr[ei]){
                return searchInSortedRotatedArray(arr, element, mid+1, ei);
            }
            else{
                return searchInSortedRotatedArray(arr, element, si, mid-1);
            }
        }
    }
    
    public static void main(String args[]){
        // int arr[] = { 2,3,4,5,64,22,1,32,3};
        //1. (MergeSort) [time:- O(nlogn) and space:- O(n)]
        // mergeSort( arr, 0, arr.length-1);

        //2. (QuickSort) [time:- O(nlogn) and space:- O(1)]
        // quickSort( arr, 0, arr.length-1);
        // System.out.println("the sorted array is");
        // for(int i=0;i<arr.length;i++){
        //     System.out.print(arr[i]+" ");
        // }

        //3. (search in sorted rotated array) [time:- nlogn]
        // int arr[] = {4,5,6,7,1,2,3};
        // int index = searchInSortedRotatedArray( arr, 4,6, arr.length-1);
        // System.out.println("the index is "+index);
       
        //4. (BubbleSort)
        // int arr[] = {3,45,2,334,233,23,93,12,542,31};
        // bubbleSort(arr);
        // for(int i=0; i<arr.length; i++){
        //     System.out.print(arr[i]+" ");
        // }

        //5. (SelectionSort)
        // int arr[] = {3,45,2,334,233,23,93,12,542,31};
        // selectionSort(arr);
        // for(int i=0;i<arr.length;i++){
        //     System.out.print(arr[i]+" ");
        // }

        //6. (InsertionSort)
        int arr[] = {3,45,2,334,233,23,93,12,542,31};
        insertionSort(arr);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }

        //7. (InbuildSort)
            //(i). (import java.util.Arrays;)
            // int arr[] = {3,45,2,334,233,23,93,12,542,31};
            // Arrays.sort(arr);
            // Arrays.sort( arr, 0, 5);  //sorted array from index 0 to index 4

            //(ii). ( import java.util.Collections;) [primitive datatypes are not applicable for collections and it needs objects for manipulation(Integer, String, Double)]
            // Integer arr[] = {3,45,2,334,233,23,93,12,542,31};
            // Arrays.sort( arr, Collections.reverseOrder());                                      //reverse sorted an array
            // Arrays.sort( arr, 0, 5, Collections.reverseOrder());                 //reverse sorted array from index 0 to index 4

        //8. (CountingSort) [ only the minimum range of element allowed]
        // int arr[] = {1,4,1,3,2,4,3,7};
        // countingSort(arr);
        // for(int i=0;i<arr.length;i++){
        //     System.out.print(arr[i]+" ");
        // }



    }
}
