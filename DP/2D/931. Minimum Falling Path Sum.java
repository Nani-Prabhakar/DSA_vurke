// Memoization
class Solution {
    public int f(int i,int j,int[][] matrix,int n,int[][] dp){
        if(i==n-1 && (j>=0 &&j<n))return matrix[i][j];
        if(i>n-1 || j>n-1 || j<0)return 100000000;
        if(dp[i][j]!=Integer.MAX_VALUE)return dp[i][j];
        int down=matrix[i][j]+f(i+1,j,matrix,n,dp);
        int left=matrix[i][j]+f(i+1,j-1,matrix,n,dp);
        int right=matrix[i][j]+f(i+1,j+1,matrix,n,dp);

    return dp[i][j]=Math.min(right,Math.min(down,left));
    }
    public int minFallingPathSum(int[][] matrix) {
        int n=matrix.length;
        int [][] dp=new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        }
        int solution=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
           int ans=f(0,i,matrix,n,dp);
           solution=Math.min(solution,ans);

        }
        return solution;
    }
}

//Tabulization
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n=matrix.length;
        int [][] dp=new int[n][n];
        for(int i=0;i<n;i++){
            dp[0][i]=matrix[0][i];
        }
        for(int i=1;i<n;i++){
            for(int j=0;j<n;j++){
                int down=matrix[i][j]+dp[i-1][j];
                int left=Integer.MAX_VALUE,right=Integer.MAX_VALUE;
                if(j-1>=0)left=matrix[i][j]+dp[i-1][j-1];
                if(j+1<n)right=matrix[i][j]+dp[i-1][j+1];
                dp[i][j]=Math.min(right,Math.min(down,left));
            }     
        }
        int min=Integer.MAX_VALUE;
         for(int i=0;i<n;i++){
            min=Math.min(min,dp[n-1][i]);
        }
        return min;
    }
}
//Space Optimization
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n=matrix.length;
        int [] dp=new int[n];
        for(int i=0;i<n;i++){
            dp[i]=matrix[0][i];
        }
        for(int i=1;i<n;i++){
            int cur[]=new int[n];
            for(int j=0;j<n;j++){
                int down=matrix[i][j]+dp[j];
                int left=Integer.MAX_VALUE,right=Integer.MAX_VALUE;
                if(j-1>=0)left=matrix[i][j]+dp[j-1];
                if(j+1<n)right=matrix[i][j]+dp[j+1];
                cur[j]=Math.min(right,Math.min(down,left));
            }
            dp=cur;     
        }
        int min=Integer.MAX_VALUE;
         for(int i=0;i<n;i++){
            min=Math.min(min,dp[i]);
        }
        return min;
    }
}
