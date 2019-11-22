class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];

        int end = n*n;

        int i =0, j =0;
        int val =1;
        String order = "right";
        while(val != end){
            switch(order){
                case "right":
                    res[i][j] = val++;
                    j++;
                    if(j == n-1 || res[i][j+1] != 0){
                        order = getOrder(order);
                    }
                    break;
                case "left":
                    res[i][j] = val++;
                    j--;
                    if(j == 0 || res[i][j-1] != 0){
                        order = getOrder(order);
                    }
                    break;
                case "down":
                    res[i][j] = val++;
                    i++;
                    if(i == n-1 || res[i+1][j] != 0){
                        order = getOrder(order);
                    }
                    break;
                case "up":
                    res[i][j] = val++;
                    i--;
                    if(i == 0 || res[i-1][j] != 0){
                        order = getOrder(order);
                    }
                    break;
            }
        }

        res[i][j] = end;

        return res;
    }

    private String getOrder(String o){
        if(o.equals("right"))return "down";
        if(o.equals("down"))return "left";
        if(o.equals("left"))return "up";
        if(o.equals("up"))return "right";

        return null;
    }
}
