import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
           int nums1[]={2,3,4,5,0,0,0,0};
           int nums2[]={1,6,7,9};
           int m=4;
           int n=4;
           merge(nums1,m,nums2,n);
           System.out.println(Arrays.toString(nums1));


    }

    static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=m+n-1,p1=m-1,p2=n-1;
        while(p2>=0){
            if(p1>=0 && nums1[p1]>nums2[p2])nums1[i--]=nums1[p1--];
            else nums1[i--]=nums2[p2--];
        }

    }
}