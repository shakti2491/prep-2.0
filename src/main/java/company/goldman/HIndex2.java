package company.goldman;

public class HIndex2 {
    public int hIndex(int[] citations) {

            int n = citations.length;
            int left = 0, right = n-1;

            int ans = 0;
            while(left<=right){
                int mid = left + (right-left)/2;
                if(citations[mid]>=n-mid){
                    ans = n-mid;
                    right = mid-1;
                }else{
                    left = mid+1;
                }

            }

            return ans;
        }
    
}
