import java.util.*;
import java.io.*;


public class SelectionSort {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        //Testcase loop
        for(int test=0;test<T;test++){
            int N=sc.nextInt();
            int arr[]=new int[N];
            //array inputs
            for(int i=0;i<N;i++){
                arr[i]=sc.nextInt();
            }
            selectionSort(arr);
            System.out.println();
            System.out.println(Arrays.toString(arr));

        }
    }

    static void selectionSort(int arr[]){
        int count=0;

        for(int i =0;i<arr.length;i++){
            int last=arr.length-i-1;
            int maxIndex = findmax(arr,0,last);
            swap(arr,maxIndex,last);
            if(last!=0){
                System.out.print(maxIndex + " ");

            }


        }
    }

    static int findmax(int arr[],int start,int last){
        int max=start;
        for(int i=start;i<=last;i++){
            if(arr[max]<arr[i]){
                max=i;
            }
        }
        return max;
    }

    static void swap(int arr[],int first,int second){

        int temp=arr[first];
        arr[first]=arr[second];
        arr[second]=temp;


    }

}
