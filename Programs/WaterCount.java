import java.util.*;
public class WaterCount {


        public static void main(String[] args) {
            /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
            Scanner sc = new Scanner(System.in);
            int T = sc.nextInt();
            while(T-->0){
                int N = sc.nextInt();
                int arr[]=new int [N];
                for(int i =0;i<N;i++){
                    arr[i]=sc.nextInt();
                }
                int ans=0;
                int l[]=new int[N];
                int r[]=new int[N];
                l[0]=arr[0];
                r[N-1]=arr[N-1];
                maxfill(arr,l,r,N);
                for(int i =0;i<N;i++){
                    ans+=Math.min(l[i],r[i])-arr[i];
                }
                System.out.println(ans);
            }
        }
        static void maxfill(int arr[],int l[],int r[],int N){
            for(int i =1;i<=N-1;i++){
                l[i]=Math.max(arr[i],l[i-1]);
            }
            for(int i=N-2;i>0;i--){
                r[i]=Math.max(arr[i],r[i+1]);
            }
        }
   /* static int max(int first,int second){
        if(first>second){
            return first;
        }
        return second;
    }
    static int min(int first,int second){
        if(first<second){
            return first;
        }
        return second;
    }*/

}
