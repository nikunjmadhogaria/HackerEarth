//Destroying balls

import java.util.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TestClass {
    
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
    private static int t, n, color, minCol, maxCol, distinct, colFreq[][];
    private static HashMap<Integer, Integer> hm;
    
    public static void main(String[] args) {
        
        sc = new FastReader();        
        
        t = sc.nextInt();
        
        while(t > 0) {
            hm = new HashMap<Integer, Integer>();
            n = sc.nextInt();
            color = sc.nextInt();
            hm.put(color, 1);
            minCol = maxCol = color;
            distinct = 1;
            
            for(int i = 1; i <= n-1; i++) {
                color = sc.nextInt();
                
                if(minCol > color)
                    minCol = color;
                if(maxCol < color)
                    maxCol = color;
                
                if(hm.get(color) == null) {
                    hm.put(color, 1);
                    distinct++;
                }
                else
                    hm.put(color, hm.get(color) + 1);
            }
            
            if(distinct == n && minCol == 1 && maxCol == n)
                System.out.println("YES");
            
            else if(hm.get(n) == null)
                System.out.println("NO");
            
            else {
                colFreq = new int[hm.size()][2];
                int count = 0;
                for(Map.Entry<Integer,Integer> entry : hm.entrySet()){
                    colFreq[count][0] = entry.getKey();
                    colFreq[count][1] = entry.getValue();
                    count++;
                }
                Arrays.sort(colFreq, new Comparator<int[]>() {
                    public int compare(int[] a, int[] b) {
                       return Integer.compare(b[0], a[0]);
                    }
                });
                /*for(int i = 0; i < distinct; i++)
                    System.out.println(Arrays.toString(colFreq[i]));
                System.out.println("------");*/
                int ballsLeft = n;
                for(int i = 0; i < distinct; i++) {
                    if(colFreq[i][0] == ballsLeft)
                        ballsLeft -= colFreq[i][1];
                    else 
                        break;
                }
                if(ballsLeft == 0)
                    System.out.println("YES");
                else
                    System.out.println("NO");
            }
            
            t--;
        }
        
    }
}