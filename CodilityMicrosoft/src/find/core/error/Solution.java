package find.core.error;

/*************************************************************************
 * 
 * @author mssantan
 * @description: class to find the error in the code and provide solution
 * @answer: any % (mod) with 10 is equal to zero. In this case the function
 * never works. The solution would be change the mod used to put value in 
 * the enable_print variable.
 * 
 *************************************************************************/
 
class Solution {
	
	public static void solution(int N) {
		
		int enable_print = N % 10;
		System.out.println("Enable Print value:" + enable_print);
		
		while (N > 0) {
			if (enable_print == 0 && N % 10 != 0) {
				enable_print = 1;
			}
			else if (enable_print == 1) {
				System.out.print(N % 10);
			}
			N = N / 10;
		}
	}
	
	// call solution method
	public static void main(String[] args) {
		solution(10);
	}
}
