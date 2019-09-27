public class EditDistanceAlgorithm {

    static int computeEditDistance(String s1, String s2){
        int n = s1.length() + 1;
        int m = s2.length() + 1;
        int[][] graphMatrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i==0)
                    graphMatrix[i][j] = j;
                else if (j==0)
                    graphMatrix[i][j] = i;
                else if (s1.charAt(i-1) == s2.charAt(j-1))
                    graphMatrix[i][j] = graphMatrix[i-1][j-1];
                else
                    graphMatrix[i][j] = Math.min(graphMatrix[i][j-1], Math.min(graphMatrix[i-1][j], graphMatrix[i-1][j-1])) + 1;
            }
        }
        return graphMatrix[n-1][m-1];
    }

    public static void main(String[] args) {
        int result = computeEditDistance("perro", "gato");
        System.out.println(result);
    }
}
