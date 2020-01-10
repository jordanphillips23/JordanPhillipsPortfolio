
public class Tester {
	public static void main(String args[]) {
		int[][] arr = {{4,2,3,1},{3,2,1,1},{1,1,2,3},{4,5,6,7}};
		int[][] arr2 = {{1,2,3},{4,5,6}};
		NumericMatrix m = new NumericMatrix(arr);
		NumericMatrix m2 = new NumericMatrix(arr2);
		System.out.println(m);
		System.out.println(m.inverse().matMulDouble(m));
	}
}
