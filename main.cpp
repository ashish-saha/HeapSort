#include<iostream>
#include<fstream>
#include<sstream>
using namespace std;

string to_String(int i) {

	int Number = i;
	string Result;
	ostringstream convert;
	convert << Number;

	Result = convert.str();
	return Result;

}

class HeapSort {
public:
	int size_of_array = 0;
	int count = 0;
	int root = 1;
	int* heapAry;
	
	HeapSort(int num) {
		size_of_array = num + 1;
		heapAry = new int[size_of_array];
		heapAry[0] = count;
	}

	bool isHeapEmpty() {
		if (count == 0)		return true;
		else                return false;
	}

	bool isHeapFull() {
		if (count >= size_of_array)		return true;
		else							return false;
	}

	string printHeap() {
		string str;
		int num = 1;
		while (num <= count) {
			str = str + " " + to_String(heapAry[num]);
			num++;
		}
		return str;
	}

	void buildHeap(string infileName, ofstream& debugFile) {
		ifstream inFile;
		inFile.open(infileName);
		int intItem;
		while (inFile >> intItem) {

			insertOneDataItem(intItem);
			debugFile << count << printHeap() << endl;
		}
		inFile.close();
	}

	void insertOneDataItem (int data) {
		count++;
		if (isHeapFull ())			return;
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

	void deleteHeap(string fileName, ofstream& debugFile) {
		ofstream outFile;
		outFile.open(fileName);         
		while (!isHeapEmpty()) {
			outFile <<deleteRoot() << endl;
			debugFile << count << printHeap() << endl;
		}
		outFile.close();
	}

	int deleteRoot() {
		int temp = heapAry[root];
		heapAry[root] = heapAry[count];
		count--;
		bubbleDown(root);
		return temp;
	}

	void bubbleDown (int num)	{
		int index = 0;
		while (num < count)	{
			int leftChild = num * 2;
			int rightChild = (num * 2) + 1;

			if ((leftChild>count) || (rightChild > count))		return;

			if ((heapAry[num] > heapAry[leftChild]) && (heapAry[leftChild] <= heapAry[rightChild]))  {
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

	~HeapSort() {
		delete[] heapAry;
	}
};


int main (int argc, char *argv[]) {

	int count = 0;
	ifstream inFile;
	ofstream debugFile;
	
	string infilename(argv[1]);             
 	string outFileName(argv[3]);			
	
	inFile.open(argv[1]);                                              
	debugFile.open(argv[2]);              

	int intItem1;
	while (inFile >> intItem1) 	count++;	
	inFile.close();

	HeapSort heap (count);

	heap.buildHeap(infilename ,debugFile);
	heap.deleteHeap(outFileName, debugFile);

	debugFile.close();
	return 0;
}