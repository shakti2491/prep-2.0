package algods.leetcode;

import java.util.ArrayList;
import java.util.List;

public class FractionAddition {

    public static void main(String[] args) {
        new FractionAddition().fractionAddition("1/3-1/2");
    }
    public String fractionAddition(String expression) {
        String[] pluses = expression.split("\\+");
        List<String> positives = new ArrayList<>();
        List<String> negatives = new ArrayList<>();
        //preprocessing
        for(String plus : pluses ){
            String[] negs = plus.split("-");
            if(!negs[0].equals(""))
                positives.add(negs[0]);
            if(negs.length>1){
                for(int i =1;i<negs.length;i++)
                    negatives.add(negs[i]);
            }
        }
        // preprocessing done

        int[] fraction1 = add(positives);
        int[] fraction2 = add(negatives);

        int[] res = sub(fraction1, fraction2);

        return (res[0]==1?"-":"")+res[1]+"/"+res[2];
    }


    private int[] add(List<String> fractions){
        int[] a = {0,1};
        for(String fraction : fractions){
            String[] frac = fraction.split("/");
            int[] b = {Integer.parseInt(frac[0]), Integer.parseInt(frac[1])};
            int lcm = lcm(a[1],b[1]);
            a = new int[]{(a[0]*(lcm/a[1]))+(b[0]*(lcm/b[1])),lcm};
        }
        int gcd = gcd(a[0],a[1]);
        return new int[]{a[0]/gcd,a[1]/gcd};
    }

    // apositives b negatives
    private int[] sub(int[] a, int[] b){
        int[] fraction = new int[3];


        int lcm = lcm(a[1],b[1]);
        int a1 = a[0]*(lcm/a[1]);
        int b2 = b[0]*(lcm/b[1]);
        int diff = a1-b2;
        if(diff<0)
            fraction[0] = 1;
        diff = Math.abs(diff);
        int gcd = gcd(lcm,diff);
        fraction[1] = diff/gcd;
        fraction[2] = lcm/gcd;
        return fraction;
    }

    private int lcm(int a, int b){
        return a*b/gcd(a,b);
    }

    private int gcd(int a, int b){
        while(b!=0){
            int t = b;
            b = a%b;
            a= t;
        }
        return a;

    }

}
