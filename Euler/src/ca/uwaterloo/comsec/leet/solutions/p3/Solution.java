package ca.uwaterloo.comsec.leet.solutions.p3;

public class Solution {

	public boolean isOn(Point p1, Point p2, Point p3, int a, int b, int c) {
		if (p1.x == p2.x && p1.y == p2.y)
			return false;
		// return (((p2.y - p1.y) * p3.x + p1.y * p2.x - p2.y * p1.x) == (p2.x -
		// p1.x) * p3.y);
		return ((a * p3.x + b) == c * p3.y);
	}

	public int maxPoints(Point[] points) {
		int len = points.length, a, b, c, max = 0, tmp;
		int[][][] visited = new int[len][len][len];

		if (points.length == 1)
			return 1;
		else if (points.length == 2)
			return 2;

		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				for (int k = 0; k < len; k++) {
					visited[i][j][k] = -1;
				}
			}
		}

		for (int i = 0; i < len; i++) {
			for (int j = i + 1; j < len; j++) {
				a = points[j].y - points[i].y;
				b = points[i].y * points[j].x - points[j].y * points[i].x;
				c = points[j].x - points[i].x;
				for (int k = j + 1; k < len; k++) {
					if (visited[i][j][k] != -1) {
						System.out.println("!=-1");
						continue;
					}
					if (isOn(points[i], points[j], points[k], a, b, c)) {
						visited[i][j][k] = 1;
						visited[j][k][i] = 1;
						visited[k][i][j] = 1;
						visited[j][i][k] = 1;
						visited[i][k][j] = 1;
						visited[k][j][i] = 1;
					} else {
						visited[i][j][k] = 0;
						visited[j][k][i] = 0;
						visited[k][i][j] = 0;
						visited[j][i][k] = 0;
						visited[i][k][j] = 0;
						visited[k][j][i] = 0;
					}
				}
			}
		}

		for (int i = 0; i < len; i++) {
			for (int j = i + 1; j < len; j++) {
				tmp = 2;
				for (int k = 0; k < len; k++) {
					if (i == k || j == k)
						continue;
					if (visited[i][j][k] == 1)
						tmp++;
				}
				if (tmp > max)
					max = tmp;
			}
		}
		return max;
	}
	
	public static void main(String[] args) {
		Solution s = new Solution();
		Point[] points = {new Point(1,1), new Point(1,1), new Point(1,1)};
		int ret = s.maxPoints(points);
		System.out.println(ret);
	}
}
