package challenge.coding;

public class NumberComplement {
	public static void main(String[] args) {
		NumberComplement nc = new NumberComplement();
		System.out.println(nc.findComplement(5));
	}

	public int findComplement(int num) {
		StringBuilder builder = new StringBuilder();
		StringBuilder complementBuilder = new StringBuilder();
		while (num > 1) {
			builder.append(num % 2);
			complementBuilder.append((num % 2) == 0 ? "1" : "0");
			num /= 2;
		}
		builder.append("1");
		complementBuilder.append("0");
		String complement = complementBuilder.toString();
		int decimalDigit = 0;
		for (int i = 0; i < complement.length(); i++) {
			decimalDigit += (Character.getNumericValue(complement.charAt(i))) * Math.pow(2, i);
		}
		return decimalDigit;
	}
}
