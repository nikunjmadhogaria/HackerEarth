//Killjee & subsets

import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    
    static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;
 
        public FastReader()
        {
            br = new BufferedReader(new
                     InputStreamReader(System.in));
        }
 
        String next()
        {
            while (st == null || !st.hasMoreElements())
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException  e)
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
 
        int nextInt()
        {
            return Integer.parseInt(next());
        }
 
        long nextLong()
        {
            return Long.parseLong(next());
        }
 
        double nextDouble()
        {
            return Double.parseDouble(next());
        }
 
        String nextLine()
        {
            String str = "";
            try
            {
                str = br.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }
    }
    
    
    private static FastReader sc;
	private static int n, m, arr[], dp1[][], dp2[][], larNum;
	private static long pow31[], MOD, encryp;
    
    public static void main(String[] args) {
        
        sc = new FastReader();
		n = sc.nextInt();
		arr = new int[n];
		larNum = 0;
		
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
			larNum = max(larNum, arr[i]);
		}
		
		m =  ( 1 << (32 - Integer.numberOfLeadingZeros(larNum)) ) - 1;
        
		dp1 = new int[n+1][m+1];
		dp2 = new int[n+1][m+1];
		
		dp1[0][0] = 1;
		dp2[0][0] = 0;
		for(int i = 1; i <= n; i++) {
			for(int j = 0; j <= m; j++) {				
				dp1[i][j] = dp1[i-1][j] + dp1[i-1][j^arr[i-1]];
				
				if(dp1[i][j] > dp1[i-1][j])
					dp2[i][j] = max(dp2[i-1][j^arr[i-1]] + 1, dp2[i-1][j]);
				else
					dp2[i][j] = dp2[i-1][j];				
			}
		}
		
		pow31 = new long[larNum+1];	
		MOD = 1000000007;
		pow31[0] = 1;
		for(int i = 1; i <= larNum; i++)
			pow31[i] = (pow31[i-1] * 31) % MOD;
		
		encryp = 0;
		for(int i = 0; i <= larNum; i++)
			encryp = ( encryp + ((dp2[n][i] * pow31[i]) % MOD) ) % MOD;
		
		
		System.out.println(encryp);	
		
	}
	
	private static int max(int x, int y) {
		return x > y ? x : y;
	}
	
}


