package com.practice.medium;

public class ContainerWithMostWater {
	public static void main(String[] args) {
		ContainerWithMostWater cwmw = new ContainerWithMostWater();
		int[] height = {1,8,6,2,5,4,8,3,7};
		System.out.println(cwmw.maxArea(height));
	}
	
	public int maxArea(int[] height) {
		int maxArea = 0;
		for (int i = 0; i < height.length; i++) {
			int lineA = height[i];
			for (int j = i + 1; j < height.length; j++) {
				int lineB = height[j];
				int area = Math.min(lineA, lineB) * (j - i);
				if (area > maxArea) {
					maxArea = area;
				}
			}
		}
		return maxArea;
	}

}
