package company.goldman;

public class MedianOfTwoSortedArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if(nums1.length > nums2.length)
            return findMedianSortedArrays(nums2, nums1);

        int x = nums1.length;
        int y = nums2.length;

        int low = 0;
        int high = x;


        while(low<=high){
            int partitionX = (low+high)/2;
            int partitionY = (x+y+1)/2-partitionX;

            // if partitionX is zero it means nothing is there on left side .. use Integer.MIN_VALUE
            //if partitionX is length of input then there is nothing on right side. Use Integer.MAX_VALE

            int maxLeftX = partitionX==0? Integer.MIN_VALUE : nums1[partitionX-1];
            int minRightX = partitionY==x ? Integer.MAX_VALUE : nums1[partitionX];

            int maxLeftY = partitionY == 0 ? Integer.MIN_VALUE : nums2[partitionY-1];
            int minRightY= partitionY == y ? Integer.MAX_VALUE : nums2[partitionY];

            if(maxLeftX <= minRightY && maxLeftY <= minRightX){
                // found the correct partition

                if((x+y)%2 == 0)
                    return (double)(Math.max(maxLeftX, maxLeftY)+Math.min(minRightX,minRightY))/2;
                else{
                    return Math.max(minRightX,minRightY);
                }

            }
            else if(maxLeftX>minRightY){
                high = partitionX-1;
            }
            else{
                low = partitionX+1;
            }

        }
        throw new IllegalArgumentException();
    }


    public static void main(String[] args) {
        int[] x = {1,3,8,9,15};
        int[]y = {7,11,19,21,25};

        System.out.println(findMedianSortedArrays(x,y));
    }
}
