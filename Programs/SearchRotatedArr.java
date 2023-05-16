
public class SearchRotatedArr {
    public static void main(String[] args) {
        int nums[]={1,3};
        int target=1;
        System.out.println(search(nums,target));
    }
        static int search(int[] nums, int target) {
            int lo=0;
            int hi = nums.length-1;
            while(lo<=hi){
                int mid=lo+(hi-lo)/2;
                if(nums[mid]==target){
                    return mid;
                }
                else if(nums[mid]<nums[0]){
                    if(nums[mid]<target && target<=nums[mid-1]){
                        lo=mid+1;
                    }else{
                        hi=mid-1;
                    }
                }
                else{
                    if(nums[mid]>target && nums[0]<=target){
                        hi=mid-1;
                    }else{
                        lo=mid+1;
                    }
                }
            }
            return -1;
        }

}
