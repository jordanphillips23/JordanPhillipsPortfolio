public class Numeric {
	Object val;
	public Numeric(int i) {
		val = i;
	}
	
	public Numeric(long l) {
		val = l;
	}
	
	public Numeric(short s) {
		val = s;
	}
	
	public Numeric(byte b) {
		val = b;
	}
	
	public Numeric(float f) {
		val = f;
	}
	
	public Numeric(double d) {
		val = d;
	}
	
	public static Numeric[][] array2DConvert(int[][] data) {
		Numeric out[][] = new Numeric[data.length][];
		for (int i = 0; i < data.length; i++) {
			out[i] = new Numeric[data[i].length];
			for (int j = 0; j < data[i].length; j++) {
				out[i][j] = new Numeric(data[i][j]);	
			}
		}
		return out;
	}
	public static Numeric[][] array2DConvert(long[][] data) {
		Numeric out[][] = new Numeric[data.length][];
		for (int i = 0; i < data.length; i++) {
			out[i] = new Numeric[data[i].length];
			for (int j = 0; j < data[i].length; j++) {
				out[i][j] = new Numeric(data[i][j]);	
			}
		}
		return out;
	}
	public static Numeric[][] array2DConvert(short[][] data) {
		Numeric out[][] = new Numeric[data.length][];
		for (int i = 0; i < data.length; i++) {
			out[i] = new Numeric[data[i].length];
			for (int j = 0; j < data[i].length; j++) {
				out[i][j] = new Numeric(data[i][j]);	
			}
		}
		return out;
	}
	public static Numeric[][] array2DConvert(byte[][] data) {
		Numeric out[][] = new Numeric[data.length][];
		for (int i = 0; i < data.length; i++) {
			out[i] = new Numeric[data[i].length];
			for (int j = 0; j < data[i].length; j++) {
				out[i][j] = new Numeric(data[i][j]);	
			}
		}
		return out;
	}
	public static Numeric[][] array2DConvert(float[][] data) {
		Numeric out[][] = new Numeric[data.length][];
		for (int i = 0; i < data.length; i++) {
			out[i] = new Numeric[data[i].length];
			for (int j = 0; j < data[i].length; j++) {
				out[i][j] = new Numeric(data[i][j]);	
			}
		}
		return out;
	}
	public static Numeric[][] array2DConvert(double[][] data) {
		Numeric out[][] = new Numeric[data.length][];
		for (int i = 0; i < data.length; i++) {
			out[i] = new Numeric[data[i].length];
			for (int j = 0; j < data[i].length; j++) {
				out[i][j] = new Numeric(data[i][j]);	
			}
		}
		return out;
	}
	
	@Override
	public String toString() {
		return "" + val;
	}
}
