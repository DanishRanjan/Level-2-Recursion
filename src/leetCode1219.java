class Solution {
    
    public static int travelAndCollectGold(int[][] arr, int i, int j, boolean[][] visited){
        
        if(i<0 || j<0 || i>=arr.length || j>=arr[0].length || visited[i][j] ==true || arr[i][j] == 0){
            return 0;
        }
        int gold = 0;
        visited[i][j] = true;
        gold = gold + arr[i][j];
        int n = travelAndCollectGold(arr,i - 1,j,visited);//north
        int e = travelAndCollectGold(arr,i,j + 1,visited);//east
        int s = travelAndCollectGold(arr,i + 1,j,visited);//south
        int w = travelAndCollectGold(arr,i,j - 1,visited);//west
        int m = Math.max(Math.max(n,e),Math.max(s,w));
        visited[i][j] = false;
        return gold + m;
        
    }
    
    public int getMaximumGold(int[][] arr) {
        int max = 0;
        boolean[][] visited = new boolean[arr.length][arr[0].length];
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                if(arr[i][j] !=0 && visited[i][j] == false){
                max = Math.max(max, travelAndCollectGold(arr, i , j , visited));   
                }
                
            }
        }
        return max;
    }
}