package company.goldman.buysellstock;

public class InfiniteTransactions {
    //use peak valley approach
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for(int i =0;i<prices.length-1;i++){
            if(prices[i+1]>prices[i]){
                maxProfit += prices[i+1]-prices[i];
            }
        }
        return maxProfit;
    }
}
