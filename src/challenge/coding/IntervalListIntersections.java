package challenge.coding;

import java.util.ArrayList;
import java.util.List;

public class IntervalListIntersections {
	public static void main(String[] args) {
		IntervalListIntersections ili = new IntervalListIntersections();
		int[][] A = { { 0, 2 }, { 5, 10 }, { 13, 23 }, { 24, 25 } };
		int[][] B = { { 1, 5 }, { 8, 12 }, { 15, 24 }, { 25, 26 } };
		ili.intervalIntersection(A, B);
	}

	public int[][] intervalIntersection(int[][] A, int[][] B) {
		List<int[]> listOfIntArray = new ArrayList<>();
		for (int[] a : A) {
			for (int[] b : B) {
				int[] intersection = findIntersection(a, b);
				if (intersection != null) {
					listOfIntArray.add(intersection);
				}
			}
		}
		int[][] returnedInterval = new int[listOfIntArray.size()][];
		for (int i = 0; i < listOfIntArray.size(); i++) {
			returnedInterval[i] = listOfIntArray.get(i);
		}
		return returnedInterval;
	}

	private int[] findIntersection(int[] x, int[] y) {
		int[] intersection = new int[2];
		if (x[1] < y[0] || y[1] < x[0]) {
			return null;
		}
		intersection[0] = Math.max(x[0], y[0]);
		intersection[1] = Math.min(x[1], y[1]);
		return intersection;
	}
}
