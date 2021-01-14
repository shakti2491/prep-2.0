package algods.leetcode;

public class CountNumberOfTeams {
    public static int numTeams(int[] rating) {
        int i=0;
        int n = rating.length;
        int count = 0;
        boolean flag=false;
        for(;i<n-2;i++){
            for(int j =i+1;j<n-1;j++){
                if(rating[j]<rating[i]) flag = false;
                else if(rating[j]>rating[i]) flag = true;
                else continue;
                for(int k = j+1;k<n;k++){
                    if(!flag && rating[k]<rating[j])count++;
                    else if(flag && rating[k]>rating[j])count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        numTeams(new int[] {2,5,3,4,1});
    }
}
