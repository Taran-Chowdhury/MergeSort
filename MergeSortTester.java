package Sort;

import java.io.File;
import java.io.IOException;

public class MergeSortTester {
	/*
	 * create new instance of MergeSorter to read a file with data of type int and
	 * pass into array. sort the data and print sorted array.
	 */
	public static void main(String[] args) throws IOException {
		MergeSorter ms = new MergeSorter();
		File file = new File(
				"C:\\Users\\taran\\Desktop\\CS146\\HW2 - Iterataive sorting\\MergeSort\\bin\\MyList-3.txt");
		int[] MSarr = ms.ReadFile(file, 70);
		ms.mergeSort(MSarr, 0, MSarr.length - 1);
		ms.printArray(MSarr);
	}
}
