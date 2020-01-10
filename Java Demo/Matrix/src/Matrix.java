import java.util.Arrays;
 
public class Matrix<T> {
	protected T data[][];
	protected int xSizes[] = new int[0];
	protected int rows = 0;
	
	public Matrix(T data[][]) {
		this.data = data;
		for (T row[] : data) {
			rows++;
			xSizes = Arrays.copyOf(xSizes, xSizes.length + 1);
			xSizes[xSizes.length - 1] = row.length;
		}
	}
	
	public void addRow(T values[]) {
		data = Arrays.copyOf(data, data.length + 1); 
		rows++;
		data[data.length - 1] = values;
		xSizes = Arrays.copyOf(xSizes, xSizes.length + 1);
		xSizes[xSizes.length - 1] = values.length;
	}
	
	public void addToRow(int row, T val) {
		if (row < rows) {
			data[row] = Arrays.copyOf(data[row], data[row].length + 1);
			data[row][data[row].length - 1] = val;
			xSizes[row]++;
		}
	}
	
	public void set(int row, int col, T val) {
		if (row < rows) {
			if (col < xSizes[row]) {
				data[row][col] = val;
			}
		}
	}
	
	public T get(int row, int col) {
		if (row < rows) {
			if (col < xSizes[row]) {
				return data[row][col];
			}
		}
		return null;
	}
	
	public T[] getRow(int row) {
		if (row < rows) {
			return data[row];
		}
		return null;
	}
	
	public Object[] getCol(int col) {
		Object out[] = new Object[rows];
		for (int i = 0; i < data.length; i++) {
			if (col < xSizes[i]) {
				out[i] = data[i][col];
			}
		}
		return out;	
	}
	
	public boolean isRectangular() {
		for (int i = 0; i < xSizes.length - 1; i++) {
			if (xSizes[i] != xSizes[i + 1]) {
				return false;
			}
		}
		return true;
	}
	
	public boolean isSquare() {
		return (xSizes[0] == rows) && isRectangular();
	}
	
	public int getHeight() {
		return rows;
	}
	
	public int getWidth() {
		if (isSquare()) {
			return rows;
		}
		if (isRectangular()) {
			return xSizes[0];
		}
		return -1;
	}
	
	
	@Override
	public String toString() {
		String out = "";
		for (T row[] : data) {
			
			for (T val: row) {
				out += val + " ";
			}
			out += "\n";
		}
		return out;
	}
}
