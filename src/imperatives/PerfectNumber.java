package imperatives;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.IntStream;

public class PerfectNumber {

	public enum STATE {
		ABUNDANT,
		DEFICIENT,
		PERFECT
	};
	
	public static STATE process(int n) {
		Integer  number = divisors(n).stream().mapToInt(Integer::intValue).filter((num) -> num != n).sum();
		STATE result = null;
		
		Optional<Integer> state = Optional.of(0);
		Predicate<Integer> isAbundant = i -> number > n;
		Predicate<Integer> isPerfect = i -> number == n;
		Supplier<STATE> giveOther = () -> state.filter(isAbundant).map(i -> STATE.ABUNDANT).orElse(STATE.DEFICIENT);
		result = state.filter(isPerfect).map(i -> STATE.PERFECT).orElse(giveOther.get());

		return result;
	}
	
	public static Set<Integer> divisors(int n){
		Set<Integer> sDivisors =  new HashSet<Integer>();
		int nsqr = (int) Math.round(Math.sqrt(n)) + 1;
		System.out.println(n);
		IntStream.range(1, nsqr).forEach( (num) ->{
			System.out.println(n);
			if (n%num == 0){
				sDivisors.add(num);
				sDivisors.add(n/num);
			}
		});
		return sDivisors;
	}
}
