
public class Fibonacci {
	
	static int fib_sum(int n)
	{
	    if (n == 0)
	        return 0;
	    if (n == 1)
	        return 1;
	    return fib_sum(n-1) + fib_sum(n-2) + 1;
	}
	
	public static void main(String[] args) {
		System.out.println(fib_sum(100));
	}
}
