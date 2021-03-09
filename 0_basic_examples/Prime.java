
public class Prime {

	public static void main(String[] args) { 
		
		for (int n=2; n< 1000; ++n) {
			boolean prime = true;
			for(int t = 2; t < n; ++t) {
				if(n % t == 0) {
					prime = false;
				}
			}
			if(prime) {
				System.out.print("\n" + n);
			}
		}
		
	}

}