import java.util.*;
public class Goldbach {
	//This code tests the Goldbach conjecture, that any even integer can be expressed as the sum of two primes, up to
	//any int input by user (up to 2^31 - 1 of course).
	public static void main(String[] args) {
		//System.out.println(primeTest(2));
		//System.out.println(primeTest(7));
		//System.out.println(primeTest(10));
		/*for(int i = 2; i < 1000; i++) {
			System.out.println(i + " " + primeTest(i));
		}*/
		int N = 0;
		boolean input = false;
		Scanner kb = new Scanner(System.in);
		while(input == false){	
			System.out.println("Check Goldbach conjecture up to which even integer? (< 2,147,483,647 please)");
			N = kb.nextInt();
			if(N % 2 == 0){
				input = true;
				for(int i = 4; i <= N; i+=2)
					gBach(i);
			}else{
				System.out.println("You must input an even integer!");
			}
		}
	}//end of main
	
	public static void gBach(int x) {
		int p1 = 0;
		int p2 = 0;
		ArrayList<Integer> list = new ArrayList<Integer>();
		if(x <= 2) 
			System.out.println("Please input an even integer greater than 2.");
		if(x % 2 != 0){
			System.out.println("Please input an even integer.");
		}else{
			for(int i = 2; i < x; i++) {
				if(primeTest(i) && primeTest(x-i)) {
					p1 = i;
					p2 = x-i;
					if(!list.contains(p1) && !list.contains(p2)){
						list.add(p1);
						list.add(p2);
					}
					//System.out.println(x + " = " + p1 + "+" + p2);
				}
			}
			//System.out.println(x + " = " + p1 + "+" + p2);
			int n = list.size();
			System.out.print(x + " = ");
			for (int j = 0; j < n; j+=2){
				System.out.print(list.get(j) + " + " + list.get(j+1));
				if(j != n - 2)
					System.out.print(" = ");
				if(j % 10 +1 == 0)
					System.out.println();
			}
			System.out.println();
		
		}
	}
	
	public static boolean primeTest(int p) {
		boolean isPrime = true;
		if(p < 2) {
			return false;
		}
		for(int i = 2; i < p; i ++) {
			if(p % i == 0)
				isPrime = false;
		}
		if(p == 2)
			isPrime = true;
		return isPrime;
	}
	

}
