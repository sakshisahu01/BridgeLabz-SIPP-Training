public class ProfitLossCalculator {
    public static void main(String[] args) {
       
        double costPrice = 129;
        double sellingPrice = 191;

        
        double profit = sellingPrice - costPrice;
        double profitPercentage = (profit / costPrice) * 100;

       
        System.out.println("The Cost Price is INR " + costPrice + 
                           "\nThe Selling Price is INR " + sellingPrice + 
                           "\nThe Profit is INR " + profit + 
                           "\nThe Profit Percentage is " + profitPercentage + "%");
    }
}
