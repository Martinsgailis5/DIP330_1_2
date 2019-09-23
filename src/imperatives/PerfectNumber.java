package imperatives;

import java.util.HashSet;
import java.util.Set;

public class PerfectNumber {

	public enum STATE {
		ABUNDANT,
		DEFICIENT,
		PERFECT
	};
	
	public static STATE process(int n) {
		Integer  number = divisors(n).stream().mapToInt(Integer::intValue).filter((num) -> num != n).sum();
		STATE result = null;
		
		if (number == n){
			result = STATE.PERFECT;
		}
		if (number > n){
			result = STATE.ABUNDANT;
		}
		if (number < n){
			result = STATE.DEFICIENT;
		}
		return result;
	}
	
	public static Set<Integer> divisors(int n){
		Set<Integer> sDivisors =  new HashSet<Integer>();
		for (int i=1;i<=n;i++) 
			if (n%i==0)
				sDivisors.add(i);
		
		return sDivisors;
	}
}
