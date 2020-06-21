package challenge.coding;

public class ValidPerfectSquare {
	public static void main(String[] args) {
		ValidPerfectSquare vps = new ValidPerfectSquare();
		int num = 200;
		System.out.println(vps.isPerfectSquare(num));
	}

	public boolean isPerfectSquare(int num) {
		int left = 1;
		int right = num;
		int mid = 1;
		while (left <= right) {
			mid = (left + right) / 2;
			if (mid * mid == num) {
				return true;
			} else if (mid * mid < num) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return false;
	}
}
