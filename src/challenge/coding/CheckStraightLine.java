package challenge.coding;

public class CheckStraightLine {
	public static void main(String[] args) {
		//int[][] coordinates = { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 4, 5 }, { 5, 6 }, { 6, 7 } };
		// int[][] coordinates = {{1,1},{2,2},{3,4},{4,5},{5,6},{7,7}};
		int[][] coordinates={{-3,-2},{-1,-2},{2,-2},{-2,-2},{0,-2}};
		CheckStraightLine csl = new CheckStraightLine();
		System.out.println(csl.checkStraightLine(coordinates));
	}

	public boolean checkStraightLine(int[][] coordinates) {
		boolean isStraightLine = true;
		for (int i = 0; i < coordinates.length - 2; i++) {
			boolean sameSlope = hasSameSlope(coordinates[i], coordinates[i + 1], coordinates[i + 2]);
			if (!sameSlope) {
				return false;
			}
		}
		return isStraightLine;
	}

	private boolean hasSameSlope(int[] p1, int[] p2, int[] p3) {
		//y2 - y1 / x2 - x1 == y3 - y2 / x3 - x2
		//(y2 - y1) * (x3 - x2) == (y3 - y2) * (x2 - x1)
		//return (p2[1] - p1[1]) / (p2[1] - p1[1]) == (p3[0] - p2[0]) / (p3[1] - p2[1]);
		return (p2[1] - p1[1]) * (p3[0] - p2[0]) == (p3[1] - p2[1]) * (p2[0] - p1[0]);
	}
}
