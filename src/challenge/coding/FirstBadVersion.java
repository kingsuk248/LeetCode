package challenge.coding;

public class FirstBadVersion {
	private static long fbv = 1702766719;
	private static int n = 2126753390;
	
	public static void main(String[] args) {
		FirstBadVersion fbv = new FirstBadVersion();
		System.out.println(fbv.firstBadVersion(n));
	}
	
	public int firstBadVersion(int n) {
		int startIndex = 1;
		while (!(isBadVersion(n) && !isBadVersion(n - 1))) {
			int mid = (int)(((long)startIndex + (long)n)/2);
			System.out.println(mid);
			if (isBadVersion(mid)) {
				n = mid;
			} else {
				startIndex = mid + 1;
			}
		}
		return n;
	}
	
	private boolean isBadVersion(int n) {
		return n >= fbv;
	}
}
