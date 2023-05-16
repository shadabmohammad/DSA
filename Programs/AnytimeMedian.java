import java.io.*;
import java.util.*;
class maxHeap{
    List<Integer> l = new ArrayList<>();
    maxHeap(){ }
    void insert(int x){
        l.add(x);
        int i = l.size()-1;
        while((i-1)/2>=0 && l.get((i-1)/2)<l.get(i)){
            int temp = l.get((i-1)/2);
            l.set((i-1)/2,l.get(i));
            l.set(i,temp);
            i=(i-1)/2;
        }
    }
    int getMax(){
        if(l.isEmpty()){
            return Integer.MIN_VALUE;
        }
        return l.get(0);
    }
    void delMax(){
        if(l.isEmpty()){
            return;
        }
        l.set(0,l.get(l.size()-1));
        l.remove(l.size()-1);
        int i =0;
        while(2*i+1<l.size()){
            int max =0;
            int left=2*i+1;
            int right=2*i+2;
            if(right<l.size()){
                max=Math.max(l.get(left),l.get(right));
            }else if(left<l.size()){
                max=l.get(left);
            }
            if(l.get(i)<max){
                if(max==l.get(left)){
                    int temp = l.get(left);
                    l.set(left,l.get(i));
                    l.set(i,temp);
                    i=left;
                }else if(max==l.get(right)){
                    int temp = l.get(right);
                    l.set(right,l.get(i));
                    l.set(i,temp);
                    i=right;
                }
            }else{
                return;
            }
        }
    }
    int size(){
        return l.size();
    }
}
class minHeap{
    List<Integer> l = new ArrayList<>();
    minHeap(){ }
    void insert(int x){
        l.add(x);
        int i = l.size()-1;
        while((i-1)/2>=0 && l.get(i)<l.get((i-1)/2)){
            int temp=l.get(i);
            l.set(i,l.get((i-1)/2));
            l.set((i-1)/2,temp);
            i=(i-1)/2;
        }
    }
    int getMin(){
        if(l.isEmpty()){
            return Integer.MAX_VALUE;
        }
        return l.get(0);
    }
    void delMin(){
        if(l.isEmpty()){
            return;
        }
        l.set(0,l.get(l.size()-1));
        l.remove(l.size()-1);
        int i =0;
        while(2*i+1<l.size()){
            int left = 2*i+1;
            int right = 2*i+2;
            int min =0;
            if(right<l.size()){
                min=Math.min(l.get(left),l.get(right));
            }
            else if(left<l.size()){
                min=l.get(left);
            }
            if(l.get(i)>min){
                if(min==l.get(left)){
                    int temp=l.get(i);
                    l.set(i,l.get(left));
                    l.set(left,temp);
                    i=left;
                }else if(min==l.get(right)){
                    int temp=l.get(i);
                    l.set(i,l.get(right));
                    l.set(right,temp);
                    i=right;
                }
            }else{
                return;
            }
        }
    }
    int size(){
        return l.size();
    }
}
class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T-->0){
            int N = sc.nextInt();
            int arr[]=new int[N];
            for(int i =0;i<N;i++){
                arr[i]=sc.nextInt();
            }
            maxHeap MH= new maxHeap();
            minHeap mh = new minHeap();
            MH.insert(arr[0]);
            System.out.print(MH.getMax()+" ");
            for(int i =1;i<N;i++){
                int max = MH.getMax();
                if(arr[i]<max){
                    MH.insert(arr[i]);
                }
                else if(arr[i]>max){
                    mh.insert(arr[i]);
                }
                int M = MH.size();
                int m = mh.size();
                if(M-m!=1 || M-m!=0){
                    if(M-m > 1){
                        int k = MH.getMax();
                        mh.insert(k);
                        MH.delMax();
                    }else{
                        int j = mh.getMin();
                        MH.insert(j);
                        mh.delMin();
                    }
                }

                System.out.print(MH.getMax()+" ");
            }
            System.out.println();
        }
    }
}
