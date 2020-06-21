package challenge.coding;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
	public boolean isHappy(int n) {
		Set<Integer> intSet = new HashSet<>();
		int[] individualNums = getIndividualNums(n);
		while (true) {
			int individualSquareSum = Arrays.stream(individualNums).map((elem) -> (int) Math.pow(elem, 2)).sum();
			if (individualSquareSum == 1) {
				return true;
			}
			if (!intSet.add(individualSquareSum)) {
				return false;
			}
			individualNums = getIndividualNums(individualSquareSum);
		}
	}
	
	private int[] getIndividualNums(int n) {
		long divisor = 1;
		int noOfDigits = 0;
		while (n % divisor != n) {
			noOfDigits++;
			divisor *= 10;
		}
		divisor /= 10;
		int[] individualNums = new int[noOfDigits];
		for (int i = 0; i < noOfDigits; i++) {
			individualNums[i] = (int) (n / divisor);
			n %= divisor;
			divisor /= 10;
		}
		return individualNums;
	}

	public static void main(String[] args) {
		HappyNumber hn = new HappyNumber();
		int n = 1012321673;
		System.out.println(hn.isHappy(n));
	}
}
