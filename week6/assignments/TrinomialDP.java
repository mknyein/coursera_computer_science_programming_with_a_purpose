
public class TrinomialDP {
    // Returns the trinomial coefficient T(n, k).
    public static long trinomial(int n, int k)
    {
      int[][] T = new int[n+2][n+2];
      T[0][0] = 1;

      for(int i = 0; i <= n+1; i++)
      {
        for(int j = 0; j < i; j++)
        {
          if (j == 0) 
          {
            T[i][j] = T[i-1][j] + 2*T[i-1][j+1];
          } else {
            T[i][j] = T[i-1][j-1] + T[i-1][j] + T[i-1][j+1];
          }
        }
      }
      if (k  < -n || k > n ) return 0;
      else if (k < 0) return T[n+1][-k];
      return T[n+1][k];
    }

    // Takes two integer command-line arguments n and k and prints T(n, k).
    public static void main(String[] args)
    {
      int n = Integer.parseInt(args[0]);
      int k = Integer.parseInt(args[1]);
      StdOut.println(trinomial(n,k));
    }
}