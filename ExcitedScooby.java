import java.util.Scanner;
class ExcitedScooby {
    public static void main(String args[] ) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t, a, b, n, arr[], k, i, pos, count, sol[];
        
        t = sc.nextInt();
		sol = new int[t];
        
        for(i = 0; i < t; i++) {
            
            a = sc.nextInt();
            b = sc.nextInt();
            n = sc.nextInt();
            
            arr = new int[n];
            pos = a - 1;
            
            do {
                arr[pos] = 1;
                pos += b;
				pos = pos % n;
            } while (pos != (a - 1));
            
            count = 0;
            
            for(k = 0; k < n; k++)
                count += arr[k];
			
			sol[i] = count;
            
        }
		
		for(i = 0; i < t; i++)
			System.out.println(sol[i]);
    }
}
