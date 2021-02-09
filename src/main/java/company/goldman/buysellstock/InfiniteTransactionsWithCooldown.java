package company.goldman.buysellstock;

public class InfiniteTransactionsWithCooldown {
    public int maxProfit(int[] prices) {
      int t_i0 = 0, t_i1 = Integer.MIN_VALUE, t_i0_pre = 0;

      for(int price: prices){
          int old = t_i0;
          t_i0 = Math.max(t_i0,t_i1+price);
          t_i1 = Math.max(t_i1, t_i0_pre-price);
          t_i0_pre = old;
      }
      return t_i0;
    }
}
