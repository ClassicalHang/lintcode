 public class Solution {
    /**
     * @param A: as indicated in the description
     * @param E: as indicated in the description
     * @return: Return the number of edges on the longest path with same value.
     */
    //0 <= j <= N - 2
    int ans = 0;
    public int LongestPathWithSameValue(int[] A, int[] E) {
        // write your code here
        int lengthA = A.length;
        int lengthE = E.length;
        int maxlength = 0;
        boolean[] isVisited = new boolean[lengthA];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i <= lengthA - 2; i++) {
            if (!map.containsKey(E[2 * i])) {
                map.put(E[2 * i], new ArrayList<Integer>());
                map.get(E[2 * i]).add(E[2 * i + 1]);
            } else {
                map.get(E[2 * i]).add(E[2 * i + 1]);
            }
            
            if (!map.containsKey(E[2 * i + 1])) {
                map.put(E[2 * i + 1], new ArrayList<Integer>());
                map.get(E[2 * i + 1]).add(E[2 * i]);
            } else {
                map.get(E[2 * i + 1]).add(E[2 * i]);
            }
        }
        for (int i = 1; i <= lengthA; i++) {
            maxlength = Math.max(dfs(map, i, isVisited, A), maxlength);
        }
        return maxlength;
    }
    
    private int dfs(Map<Integer, List<Integer>> map, int start, boolean[] isVisited, int[] A) {
        int res = 0;
        for (int i : map.get(start)) {
            if (isVisited[i - 1]) {
                continue;
            }
            if (A[i - 1] == A[start - 1]) {
                isVisited[start - 1] = true;
                res = Math.max(dfs(map, i, isVisited, A) + 1, res);
                isVisited[start - 1] = false;
            }
        }
        return res;
    }
}