import java.util.Arrays;
import java.util.Scanner;

public class Sumofpairs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T= sc.nextInt();
        while(T-->0){
            int N=sc.nextInt();
            int target=sc.nextInt();
            int arr[]=new int[N];
            for (int i = 0; i < N; i++) {
                arr[i]=sc.nextInt();
            }
            insertionSort(arr);
            findPairs(arr,target);
        }

    }
    static void findPairs(int arr[],int k){
        int p1=0,p2=1;
        while(p1>0){
            if(arr[p2]-arr[p1]<k){
                p2++;
            }
            else if(arr[p2]-arr[p1]>k){
                p1--;
            }
            else{
                System.out.println("True");
            }
        }
        System.out.println("False");

    }

    static void insertionSort(int arr[]){

        for (int i = 0; i < arr.length-1; i++) {
            int j;
            for ( j = i+1; j > 0 ; j--) {
                if(arr[j]<arr[j-1]){
                    swap(arr,j,j-1);

                }else{
                    break;
                }


            }


        }


    }

    static void swap(int arr[],int first,int second){
        int temp=arr[first];
        arr[first]=arr[second];
        arr[second]=temp;
    }




}
