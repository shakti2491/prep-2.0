package algods.segmentree;

import java.util.Arrays;

public class SegmentTree {



    private int [] segTree;
    private int size;
    private int length;
    public SegmentTree(int[] arr){
        length = arr.length;
        int log2Length = (int)Math.ceil((Math.log(length)/Math.log(2)));
        size = (int)Math.pow(2,log2Length)*2-1;
        segTree = new int[size];
        Arrays.fill(segTree,Integer.MAX_VALUE);
        this.constructSegmentTree(arr);
    }

    private void constructSegmentTree(int[] arr){
        constructSegmentTree(arr,0, arr.length-1,0 );
        System.out.println("Segment Tree Ready.");
    }

    //pos indicates root of segment binary tree
    private int constructSegmentTree(int[] arr,int low,int high, int pos){
        if(low==high){
            this.segTree[pos] = arr[low];
            return this.segTree[pos];
        }
        int mid = (low+high)/2;
        int left = constructSegmentTree(arr,low,mid,2*pos+1);
        int right = constructSegmentTree(arr,mid+1,high,2*pos+2);
        this.segTree[pos] = Math.min(left,right);
        return this.segTree[pos];
    }

    public int rangeMinQuery(int qLow, int qHigh){
        return rangeMinQuery(qLow,qHigh,0,this.length-1,0);
    }

    private int rangeMinQuery(int qLow, int qHigh, int low, int high, int pos) {
        //total overlap
        if(qLow<=low && qHigh>=high){
            return this.segTree[pos];
        }
        //no overlap
        if(qLow>high || qHigh<low)
            return Integer.MAX_VALUE;

        int mid = (low+high)/2;
        return Math.min(rangeMinQuery(qLow,qHigh,low,mid,2*pos+1),
                rangeMinQuery(qLow,qHigh,mid+1,high,2*pos+2));
    }

    public static void main(String[] args) {

        int[] arr1 = new int[]{-1,2,4,0};
        int[] arr2 = new int[]{-1,3,4,0,2,1};
        SegmentTree segmentTree1 = new SegmentTree(arr1);
        System.out.println(segmentTree1.rangeMinQuery(1,2));
        SegmentTree segmentTree2 = new SegmentTree(arr2);
    }
}
