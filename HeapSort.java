
import java.util.Scanner;
import java.io.*;
public class HeapSort {

	int size_of_array = 0;
	int count = 0;
	int root = 1;
	int [] heapAry;

	HeapSort(int num) {
		size_of_array = num + 1;
		heapAry = new int[size_of_array];
		heapAry[0] = count;
	}

	boolean isHeapEmpty() {
		if (count == 0)		return true;
		else                return false;
	}

	boolean isHeapFull() {
		if (count >= size_of_array)		return true;
		else							return false;
	}

	String printHeap() {
		String str = "" ;
		int num = 0;
		while (num <= count) {
			str = str + " " + heapAry[num];
			num++;
		}
		return str;
	}

	void buildHeap(String inFileName, PrintWriter  debugFile) {
		
		Scanner inFile = null;
		try {
			inFile = new Scanner (new FileReader (inFileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		int intItem;
		while (inFile.hasNext() ) {
			intItem = inFile.nextInt();
			insertOneDataItem(intItem);
			debugFile.write(printHeap() + "\n");			
		}
		inFile.close();

	}

	void insertOneDataItem(int data) {
		count++;
		if (isHeapFull())			return;
		heapAry[0] = count;
		heapAry[count] = data;
		bubbleUp(count);
	}

	void bubbleUp(int index) {
		while (index > root) {
			int parent = index / 2;
			if (heapAry[index] < heapAry[parent]) {
				int temp = heapAry[parent];
				heapAry[parent] = heapAry[index];
				heapAry[index] = temp;
			}
			index = parent;
		}
		return;
	}

	void deleteHeap(String fileName, PrintWriter  debugFile) {

		FileWriter writer = null;
		PrintWriter printWriter = null;
		try {
			writer = new FileWriter(fileName);
			printWriter = new PrintWriter(writer);			
		} catch (IOException e) {
			e.printStackTrace();
		}
				
		while (!isHeapEmpty()) {
			printWriter.write( " " + deleteRoot() + "\n");
			debugFile.write(printHeap() + "\n");
		}
		printWriter.close();
	}

	int deleteRoot() {
		int temp = heapAry[root];
		heapAry[root] = heapAry[count];
		heapAry [0] = --count;
		bubbleDown(root);
		return temp;
	}

	void bubbleDown(int num) {
		while (num < count) {
			int leftChild = num * 2;
			int rightChild = (num * 2) + 1;

			if ((leftChild>count) || (rightChild > count))		return;

			if ((heapAry[num] > heapAry[leftChild]) && (heapAry[leftChild] <= heapAry[rightChild])) {
				int temp = heapAry[num];
				heapAry[num] = heapAry[leftChild];
				heapAry[leftChild] = temp;
				num = leftChild;
			}
			else if ((heapAry[num] > heapAry[rightChild]) && (heapAry[rightChild] < heapAry[leftChild])) {
				int temp = heapAry[num];
				heapAry[num] = heapAry[rightChild];
				heapAry[rightChild] = temp;
				num = rightChild;
			}

			if ((heapAry[num] < heapAry[rightChild]) && (heapAry[rightChild] < heapAry[leftChild])) {
				return;
			}
		}
	}
	
	
	public static void main (String[] args){
		
		String inFileName = new String(args[0]);
		String debugFileName = (args[1]);
		String outFileName = (args[2]);
		
		FileWriter writer;
		PrintWriter printWriter = null;
		try {
			writer = new FileWriter(debugFileName);
			printWriter = new PrintWriter(writer);			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		HeapSort heap = new HeapSort(50);
		heap.buildHeap(inFileName, printWriter);
		heap.deleteHeap(outFileName, printWriter);
		
		printWriter.close();
	}
}
