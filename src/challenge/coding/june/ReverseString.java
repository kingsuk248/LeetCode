package challenge.coding.june;

public class ReverseString {
	public static void main(String[] args) {
		ReverseString rs = new ReverseString();
		char[] s = { 'h', 'e', 'l', 'l', 'o' };
		rs.reverseString(s);
	}

	public void reverseString(char[] s) {
		int l = s.length;
		for (int i = 0; i < l/2; i++) {
			char tempCh = s[i];
			s[i] = s[l - 1 - i];
			s[l - 1 - i] = tempCh;
		}
		for (char c: s) {
			System.out.print(c);
		}
	}
}
