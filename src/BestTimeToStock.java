public class BestTimeToStock {
    public static void main(String[] args) {
        System.out.println(maxProfitSlowSolution(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(maxProfitFastSolution(new int[]{7, 1, 5, 3, 6, 4}));
    }

    // Runtime 8ms
    // Beats 9.68% of users with Java
    // Memory 61.34MB
    // Beats 76.68% of users with Java
    public static int maxProfitSlowSolution(int[] prices) {
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int currentProfit = prices[j] - prices[i];
                if (currentProfit > 0) {
                    if (maxProfit < currentProfit) {
                        maxProfit = currentProfit;
                    }
                } else {
                    break;
                }
            }
        }
        return maxProfit;
    }

    // Runtime 1ms
    // Beats 99.63% of users with Java
    // Memory 60.94MB
    // Beats 92.96% of users with Java
    public static int maxProfitFastSolution(int[] prices) {
        int maxProfit = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > min) {
                maxProfit = Math.max(maxProfit, prices[i] - min);
            } else {
                min = prices[i];
            }
        }
        return maxProfit;
    }
}
