
public class Fibonacci {

	public static void main(String[] args) {
		
		int f1, f2, f3;
		
		f2 = 0;
		f3 = 1;
		
		System.out.println(f2);
		System.out.println(f3);
		
		while(f3 < 100) {
			f1 = f2;
			f2 = f3;
			f3 = f1 + f2;
			System.out.println(f3);
		}

	}

}
