 //Memoization------>
class Solution {
    public int f(int i,int j,int[][] dp,int grid[][]){
        if(i==0 && j==0)return grid[i][j];
        if(i<0 || j<0)return 100000009;
        if(dp[i][j]!=-1)return dp[i][j];
        int up=grid[i][j]+f(i-1,j,dp,grid);
        int left=grid[i][j]+f(i,j-1,dp,grid);
        return dp[i][j]=Math.min(up,left);
    }


    public int minPathSum(int[][] grid) {
        int m=grid.length,n=grid[0].length;
        
        int [][] dp=new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(dp[i],-1);
        }
        return f(m-1,n-1,dp,grid);
        
    }
}

//Tabulization--------->

class Solution {
    public int minPathSum(int[][] grid) {
        int m=grid.length,n=grid[0].length;
        int [][] dp=new int[m][n];
       for(int i=0;i<m;i++){
           for(int j=0;j<n;j++){
               if(i==0 && j==0)dp[i][j]=grid[i][j];
               else{
                   int up=grid[i][j];
                   if(i>0)up=up+dp[i-1][j];
                   else up=up+100000009;

                   int left=grid[i][j];
                   if(j>0)left+=dp[i][j-1];
                   else left+=100000009;
                   dp[i][j]=Math.min(up,left);
               }
           }
       }
       return dp[m-1][n-1];
        
    }
}


// Space Optimization---------->
class Solution {
    public int minPathSum(int[][] grid) {
        int m=grid.length,n=grid[0].length;
        int []dp=new int[n];
       for(int i=0;i<m;i++){
           int temp[]=new int[n];
           for(int j=0;j<n;j++){
               if(i==0 && j==0)temp[j]=grid[i][j];
               else{
                   int up=grid[i][j];
                   if(i>0)up=up+dp[j];
                   else up=up+10000;

                   int left=grid[i][j];
                   if(j>0)left+=temp[j-1];
                   else left+=10000;
                   temp[j]=Math.min(up,left);
               }
           }
           dp=temp;
       }
       return dp[n-1];
        
    }
}
