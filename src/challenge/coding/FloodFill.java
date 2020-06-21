package challenge.coding;

public class FloodFill {
	public static void main(String[] args) {
		FloodFill ff = new FloodFill();
		int[][] image = { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } };
		int sr = 1;
		int sc = 1;
		int newColor = 2;
		ff.floodFill(image, sr, sc, newColor);
	}

	public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
		int oriColor = image[sr][sc];
		if (oriColor != newColor) {
			fill(image, sr, sc, newColor, oriColor);
		}
		return image;
	}

	private void fill(int[][] image, int sr, int sc, int newColor, int oriColor) {
		if (image[sr][sc] == oriColor) {
			image[sr][sc] = newColor;
			if (sr >= 1) {
				fill(image, sr - 1, sc, newColor, oriColor);
			}
			if (sc >= 1) {
				fill(image, sr, sc - 1, newColor, oriColor);
			}
			if (sr + 1 < image.length) {
				fill(image, sr + 1, sc, newColor, oriColor);
			}
			if (sc + 1 < image[0].length) {
				fill(image, sr, sc + 1, newColor, oriColor);
			}
		}
	}

}
