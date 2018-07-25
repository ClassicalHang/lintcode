//大于等于k个连续的数的和大于lim的最小值
// 1 4 8 2 4
//
//2 7
//array increasing 
public class Solution {
    /**
     * @param k: The number of words in the article
     * @param lim: TThe minimum number of words a phrase should contain 
     * @param str: The article
     * @return: Return the length of shortest phrase
     */
    public int getLength(int k, int lim, String[] str) {
        // Write your code here
        int n = str.length;
        int[] arr = new int[n];
        int res = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = str[i].length();
        }
        int right = 0;
        for (int left = 0; left < n; left++) {
            while (right < n) {
                
                if (sum < lim || right - left < k) {
                    sum += arr[right];
                    right++;
                    continue;
                }
                
                if (sum <= res) {
                    res = sum;
                    sum -= arr[left];
                    break;
                } else {
                    sum -= arr[left];
                    break;
                }
                
            }
        }
        return res;
    }
}