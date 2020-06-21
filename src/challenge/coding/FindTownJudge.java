package challenge.coding;

public class FindTownJudge {
	public static void main(String[] args) {
		FindTownJudge ftj = new FindTownJudge();
		//int n = 4;
		//int[][] trust = { { 1, 3 }, { 1, 4 }, { 2, 3 }, { 2, 4 }, { 4, 3 } };
		int n = 1;
		int[][] trust = {};
		System.out.println(ftj.findJudge(n, trust));
	}

	public int findJudge(int N, int[][] trust) {
		int n = N;
		int[] counts = new int[n + 1];
		for (int[] i : trust) {
			counts[i[1]]++;
			counts[i[0]]--;
		}
		for (int i = 1; i < counts.length; i++) {
			if (counts[i] == N - 1) {
				return i;
			}
		}
		return -1;
	}
}
