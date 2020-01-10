import java.util.Arrays;

public class NumericMatrix extends Matrix<Numeric> {
	public NumericMatrix (Numeric[][] data) {
		super(data);
	}
	// constructors guarantee that datatype is numeric
	public NumericMatrix(int[][] data) {
		super(Numeric.array2DConvert(data));
	}
	
	public NumericMatrix(long[][] data) {
		super(Numeric.array2DConvert(data));
	}
	
	public NumericMatrix(short[][] data) {
		super(Numeric.array2DConvert(data));
	}
	
	public NumericMatrix(byte[][] data) {
		super(Numeric.array2DConvert(data));
	}
	
	public NumericMatrix(float[][] data) {
		super(Numeric.array2DConvert(data));
	}
	
	public NumericMatrix(double[][] data) {
		super(Numeric.array2DConvert(data));
	}
	
	// all functions work for longs and doubles
	// allows for floating point and non floating point calculations
	public void multRow(int row, double d) {
		if (row < rows) {
			for (int i = 0; i < data[row].length; i++) {
				data[row][i].val = Double.parseDouble("" + data[row][i].val) * d;
			}
		}
	}
	
	public void multRow(int row, long l) {
		if (row < rows) {
			for (int i = 0; i < data[row].length; i++) {
				data[row][i].val = Long.parseLong("" + data[row][i].val) * l;
			}
		}
	}
	
	// set row1 to be row1 + row2;
	public void addRowDouble(int row1, int row2) {
		if (row1 < rows && row2 < rows) {
			if (data[row1].length == data[row2].length) {
				for (int i = 0; i < data[row1].length; i++) {
					data[row1][i].val = (double)Double.parseDouble("" + data[row1][i].val) + (double)Double.parseDouble("" + data[row2][i].val);
				}
			}
		}
	}
	
	public void addRowLong(int row1, int row2) {
		if (row1 < rows && row2 < rows) {
			if (data[row1].length == data[row2].length) {
				for (int i = 0; i < data[row1].length; i++) {
					data[row1][i].val = (long)Long.parseLong("" + data[row1][i].val) + (long)Long.parseLong("" + data[row2][i].val);
				}
			}
		}
	}
	// sets row1 = row1 + row2 * number
	public void addRowDoubleNum(int row1, int row2, double num) {
		if (row1 < rows && row2 < rows && row1 >= 0 && row2 >= 0) {
			if (data[row1].length == data[row2].length) {
				for (int i = 0; i < data[row1].length; i++) {
					data[row1][i].val = (double)Double.parseDouble("" + data[row1][i].val) + num * (double)Double.parseDouble("" + data[row2][i].val);
				}
			}
		}
	}
	
	// adds to matrices and returns the result
	public NumericMatrix matAddDouble(NumericMatrix other) {
		if (sameSize(other)) {
			Numeric out[][] = new Numeric[getHeight()][getWidth()]; 
			for (int i = 0; i < getHeight(); i++) {
				for (int j = 0; j < getWidth(); j++) {
					out[i][j] = new Numeric(Double.parseDouble("" + get(i,j).val) + Double.parseDouble("" + other.get(i, j).val));
				}
			}
			return new NumericMatrix(out);
		}
		return null;
	}
	
	public NumericMatrix matAddLong(NumericMatrix other) {
		if (sameSize(other)) {
			Numeric out[][] = new Numeric[getHeight()][getWidth()]; 
			for (int i = 0; i < getHeight(); i++) {
				for (int j = 0; j < getWidth(); j++) {
					out[i][j] = new Numeric(Long.parseLong("" + get(i,j).val) + Long.parseLong("" + other.get(i, j).val));
				}
			}
			return new NumericMatrix(out);
		}
		return null;
	}
	
	// multiplies two matrices and returns the result
	public NumericMatrix matMulDouble(NumericMatrix other) {
		if (isRectangular() && other.isRectangular()) {
			if (getWidth() == other.getHeight()) {
				Numeric out[][] = new Numeric[getHeight()][other.getWidth()];
				for (int i = 0; i < getHeight(); i ++) {
					for (int j = 0; j < other.getWidth(); j++) {
						double val = 0.0;
						for (int k = 0; k < getWidth(); k++) {
							val += Double.parseDouble("" + get(i, k)) * Double.parseDouble("" + other.get(k, j));
						}
						out[i][j] = new Numeric(val);
					}
					
				}
				return new NumericMatrix(out);
			}
		}
		return null;
	}
	
	public NumericMatrix matMulLong(NumericMatrix other) {
		if (isRectangular() && other.isRectangular()) {
			if (getWidth() == other.getHeight()) {
				Numeric out[][] = new Numeric[getHeight()][other.getWidth()];
				for (int i = 0; i < getHeight(); i ++) {
					for (int j = 0; j < other.getWidth(); j++) {
						Long val = 0l;
						for (int k = 0; k < getWidth(); k++) {
							val += Long.parseLong("" + get(i, k)) * Long.parseLong("" + other.get(k, j));
						}
						out[i][j] = new Numeric(val);
					}
					
				}
				return new NumericMatrix(out);
			}
		}
		return null;
	}
	// swaps 2 rows
	public void swapRows(int row1, int row2) {
		if (row1 < rows && row2 < rows && row1 >= 0 && row2 >= 0) {
			if(isRectangular()) {
				for (int i = 0; i < getWidth(); i++) {
					Numeric temp = data[row1][i];
					data[row1][i] = data[row2][i];
					data[row2][i] = temp;
				}
			}
		}
	}
	
	// returns the transpose of the matrix
	public NumericMatrix transpose() {
		if (isRectangular()) {
			Numeric[][] out = new Numeric[getWidth()][getHeight()];
			for (int i = 0; i < getHeight(); i++){
				for (int j = 0; j < getWidth(); j++) {
					out[j][i] = data[i][j];
				}
			}
			return new NumericMatrix(out);
		}
		return null;
	}
	
	// returns the inverse of the matrix
	public NumericMatrix inverse() {
		if (isSquare()) {
			if ((Double.parseDouble("" + determinant())) != 0.0) {
				Numeric copyArr[][] = new Numeric[data.length][data.length];
				for (int i = 0; i < data.length; i++) {
					for (int j = 0; j < data.length; j++) {
						copyArr[i][j] = new Numeric(Double.parseDouble("" + data[i][j]));
					}
				}
				NumericMatrix copy = new NumericMatrix(copyArr);
				int I[][] = new int[getHeight()][getHeight()];
				for (int i = 0; i < getHeight(); i++) {
					for (int j = 0; j < getHeight(); j++) {
						I[i][j] = (i == j) ? 1 : 0;
					}
				}
				NumericMatrix out = new NumericMatrix(I);
				for (int j = 0; j < getHeight(); j++) {
				
					if (Double.parseDouble("" + copy.get(j, j).val) == 0.0) {
						for (int k = j; k < getHeight(); k++) {
							if(Double.parseDouble("" + copy.get(k, j).val) != 0.0) {
								copy.swapRows(j, k);
								out.swapRows(j, k);
								break;
							}
						}
					}
					double num1 = 1.0 / Double.parseDouble("" + copy.get(j, j));
					out.multRow(j, num1);
					copy.multRow(j, num1);
					for (int k = 0; k < getHeight(); k++) {
						if (j != k) {
							double num2 = -1 * Double.parseDouble("" + copy.get(k, j));
							copy.addRowDoubleNum(k, j, num2);
							out.addRowDoubleNum(k, j, num2);
							
						}
					}
					System.out.println(copy);
				}
				return out;
			}
		}
		return null;
	}
	
	// returns the determinant of the matrix
	public Numeric determinant() {
		if (isSquare()) {
			Numeric copyArr[][] = new Numeric[data.length][data.length];
			for (int i = 0; i < data.length; i++) {
				for (int j = 0; j < data.length; j++) {
					copyArr[i][j] = new Numeric(Double.parseDouble("" + data[i][j]));
				}
			}
			NumericMatrix copy = new NumericMatrix(copyArr);
			Double out = 1.0;
			for (int j = 0; j < getHeight(); j++) {
				if (Double.parseDouble("" + copy.get(j, j).val) == 0.0) {
					for (int k = j; k < getHeight(); k++) {
						if(Double.parseDouble("" + copy.get(k, j).val) != 0.0) {
							copy.swapRows(j, k);
							out *= -1;
							break;
						}
					}
				}
			
				out *= Double.parseDouble("" + copy.get(j, j));
				if (Double.parseDouble("" + copy.get(j, j)) == 0.0) {
					return new Numeric(0);
				}
				copy.multRow(j, 1.0 / Double.parseDouble("" + copy.get(j, j)));
				for (int k = j + 1; k < getHeight(); k++) {
					copy.addRowDoubleNum(k, j, -1 * Double.parseDouble("" + copy.get(k, j)));
				}
			}
			
			return new Numeric(out);
		}
		
		return null;
	}
	
	public boolean sameSize(NumericMatrix other) {
		if (isRectangular() && other.isRectangular()) {
			return super.getWidth() == other.getWidth() && getHeight() == other.getHeight();
		}
		return false;
	}
	
}
