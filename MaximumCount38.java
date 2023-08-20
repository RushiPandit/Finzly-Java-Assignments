
class PersonCount {

    public static long getMaximumCount(int n) {
        // Create a table to store the maximum count for each person.
        long[] dp = new long[n + 1];
        dp[1] = 1;

        // Fill in the table.
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] * i);
        }

        // Return the maximum count for the last person.
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 38;
        long maxCount = getMaximumCount(n);
        System.out.println("The maximum count for 38 people is: " + maxCount);
    }
}
