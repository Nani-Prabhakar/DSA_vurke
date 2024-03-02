// Memoization

class Solution {
    public int f(int i,int j,List<List<Integer>> list,int n,int[][] dp){
        if(i==n-1)return list.get(i).get(j);
        if(dp[i][j]!=-1)return dp[i][j];
        int d=list.get(i).get(j)+f(i+1,j,list,n,dp);
        int dia=list.get(i).get(j)+f(i+1,j+1,list,n,dp);
         
        return dp[i][j]=Math.min(d,dia);
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        int[][] dp=new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return f(0,0,triangle,n,dp);
        
    }
}

//Tabulization
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        int[][] dp=new int[n][n];
        for(int i=0;i<n;i++){
            dp[n-1][i]=triangle.get(n-1).get(i);
        }

        for(int i=n-2;i>=0;i--){
            for(int j=i;j>=0;j--){
                int down=triangle.get(i).get(j)+dp[i+1][j];
                int dia=triangle.get(i).get(j)+dp[i+1][j+1];
                dp[i][j]=Math.min(down,dia);
            }
        }
        return dp[0][0];
        
    }
}

//Space Optimization
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        int[] dp=new int[n];
        for(int i=0;i<n;i++){
            dp[i]=triangle.get(n-1).get(i);
        }
        for(int i=n-2;i>=0;i--){
            int[] temp=new int[n];
            for(int j=i;j>=0;j--){
                int down=triangle.get(i).get(j)+dp[j];
                int dia=triangle.get(i).get(j)+dp[j+1];
                temp[j]=Math.min(down,dia);
            }
            dp=temp;
        }
        return dp[0]; 
    }
}
