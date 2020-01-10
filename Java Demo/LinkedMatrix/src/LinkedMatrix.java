import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class LinkedMatrix<T>{
	MatNode<T> root;
	
	public LinkedMatrix (List<List<T>> data) {
		root = new MatNode<T>(data.get(0).get(0));
		MatNode<T> current = root;
		ListIterator<List<T>> outerIterator = data.listIterator();
		ListIterator<T> innerIterator;
		while (outerIterator.hasNext()) {
			List<T> row = outerIterator.next();
			innerIterator = row.listIterator();
			// skips already created first element
			innerIterator.next();
			while (innerIterator.hasNext()) {
				if (current.right != null) {
					current
				}
				else {
					T val = innerIterator.next();
					current.right = new MatNode<T>(val);
				}
				if (outerIterator.hasNext()) {
					T downVal = outerIterator.next().get(innerIterator.previousIndex());
					current.down = new MatNode<T>(downVal);
					outerIterator.previous();
				}
				current = current.right;
			} 
		}
			
			// connects the matrix leftwards
			current = root;
			while(current != null) {
				while (current.right!= null) {
					current.right.left = current;
					current = current.right;
				}
				while (current.left != null) {
					current = current.left;
				}
				current = current.down;
			}
			// connects the matrix rightwards
			current = root;
			while (current != null) {
				while (current.down != null) {
					current.down.up = current;
					current = current.down;
				}
				while (current.up != null) {
					current = current.up;
				}
				current = current.right;
			}
		
		}
		
	
	
	public int width() {
		int count = 0;
		MatNode<T> current = root;
		while (current != null) {
			count++;
			current = current.right;
		}
		return count;	
	}
	
	public int height() {
		int count = 0;
		MatNode<T> current = root;
		while (current != null) {
			count++;
			current = current.down;
		}
		return count;	
	}
	
	public MatNode<T> get(int x, int y) {
		if (x >= width() || x < 0) {
			return null;
		}
		if (y >= height() || y < 0) {
			return null;
		}
		MatNode<T> current = root;
		for (int i = 0; i < x; i++) {
			current = current.right;
		}
		for (int j = 0; j < y; j++) {
			current = current.down;
		}
		return current;
	}
	
	public String toString() {
		MatNode<T> current;
		String out = "";
		for (int i = 0; i < height(); i++) {
			current = get(0, i);
			while(current != null) {
				out += " " + current.val + " ";
				current = current.right;
			}
			out += "\n";
			
		}
		return out;
	}
	
	public LinkedList<T> getRow(int i) {
		MatNode<T> current = root;
		for (int j = 0; j < i; j++) {
			current = current.down;
		}
		LinkedList<T> out = new LinkedList<T>();
		while (current.right != null) {
			out.add(current.val);
			current = current.right;
		}
		return out;
	}
	
	public LinkedList<T> getColumn(int i) {
		MatNode<T> current = root;
		for (int j = 0; j < i; j++) {
			current = current.right;
		}
		LinkedList<T> out = new LinkedList<T>();
		while (current.down != null) {
			out.add(current.val);
			current = current.down;
		}
		return out;
	}
	
	public static void main(String args[]) {
		ArrayList<Integer> a1 = new ArrayList<>();
		a1.add(1);
		a1.add(2);
		a1.add(3);
		ArrayList<Integer> a2 = new ArrayList<>();
		a2.add(4);
		a2.add(5);
		a2.add(6);
		List<List<Integer>> list = new ArrayList<>();
		list.add(a1);
		list.add(a2);
		LinkedMatrix<Integer> a = new LinkedMatrix<Integer>(list);
		System.out.println(a.toString());
		
		
	}

	
	class MatNode<T> {
		T val;
		MatNode<T> right = null;
		MatNode<T> down = null;
		MatNode<T> up = null;
		MatNode<T> left = null;
		
		public MatNode(T val) {
			this.val = val;
		}
	}
}
