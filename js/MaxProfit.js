function getMaxProfit(prices){
    const diff = [];
    for(let i =0; i<prices.length-1;i++){
        diff.push(prices[i+1]-prices[i]);
    }


    let maxProfit = diff[0];
    let maxProfitSoFar = diff[0];

    for(let i =1;i<diff.length;i++){
        if(maxProfitSoFar+diff[i]<diff[i])
            maxProfitSoFar = diff[i];
        else{
            maxProfitSoFar += diff[i];
        }
        if(maxProfit<maxProfitSoFar){
            maxProfit = maxProfitSoFar;
        }
    }
    return maxProfit;
}

