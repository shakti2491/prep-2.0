package algods.sorting;

import java.util.Arrays;

public class MergeSort {


    public  int mergeSortAndInvCount(int[] arr,int[] temp, int start, int end){
        int mid,invCount = 0;
        if(end>start) {
            mid = start + ((end - start) / 2);
            invCount += mergeSortAndInvCount(arr, temp, start, mid);
            invCount += mergeSortAndInvCount(arr, temp, mid + 1, end);

            //merging two sorted arrays
            invCount += mergeAndCountInv(arr, temp, start, mid+1, end);
            return invCount;
        }
        return invCount;
    }

    private int mergeAndCountInv(int[] arr,int temp[], int start, int mid, int end) {
        int i,j,k;
        int invCount = 0;

        i = start;
        j = mid;
        k = start;
        while(i<=mid-1 && j<=end){
            // no inversions
            if(arr[i]<=arr[j])
                temp[k++] = arr[i++];
            else{
                //inversions
                temp[k++] = arr[j++];
                invCount = invCount+ (mid-i);
            }

        }

        while (i<=mid-1)
            temp[k++] = arr[i++];
        while(j<=end){
            temp[k++] = arr[j++];
        }

        for( i = start;i<=end;i++){
            arr[i] = temp[i];
        }
        return invCount;
    }

}
