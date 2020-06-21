package challenge.coding.june;

public class RandomPickWithWeight {
	public static void main(String[] args) {
		String[] subroutines = { "Solution", "pickIndex", "pickIndex", "pickIndex", "pickIndex", "pickIndex" };
		int[] w = { 1, 3 };
		Integer[] output = new Integer[subroutines.length];
		for (int i = 0; i < subroutines.length - 1; i++) {
			RandomPickWithWeight obj = new RandomPickWithWeight(w);
			int param1 = obj.pickIndex();
			output[i + 1] = param1;
		}
		for (Integer i : output) {
			System.out.println(i);
		}
	}

	int[] w = { 1, 3 };
	int[] wAdded;

	public RandomPickWithWeight(int[] w) {
		wAdded = new int[w.length];
		int sum = 0;
		wAdded[0] = w[0];
		for (int i = 0; i < w.length; i++) {
			sum += w[i];
			wAdded[i] = sum;
		}
	}

	public int pickIndex() {
		double justLower = wAdded[wAdded.length - 1] * Math.random();
		for (int i = 0; i < wAdded.length; i++) {
			if (justLower < wAdded[i]) {
				return i;
			}
		}
		return -1;
	}
}
