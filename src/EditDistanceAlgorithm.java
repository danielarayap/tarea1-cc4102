class EditDistanceAlgorithm {

    int computeEditDistance(String s1, String s2){
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

    int computeEditDistanceSpaceEfficient(String s1, String s2) {
        int n = s1.length() + 1;
        int m = s2.length() + 1;
        int[] prevRow = new int[n];
        int[] thisRow = new int[n];
        for (int i = 0; i < n; i++) {
            prevRow[i] = i;
        }
        for (int j = 1; j < m; j++) {
            thisRow = new int[n];
            thisRow[0] = j;
            for (int i = 1; i < n; i++) {
                if (s1.charAt(i-1) == s2.charAt(j-1))
                    thisRow[i] = prevRow[i-1];
                else
                    thisRow[i] = Math.min(thisRow[i-1], Math.min(prevRow[i-1], prevRow[i])) + 1;
            }
            prevRow = thisRow;
        }
        return thisRow[n-1];
    }

    /*
    public static void main(String[] args) {
        int result = computeEditDistance("can", "pan");
        System.out.println(result);
    }
    */
}
