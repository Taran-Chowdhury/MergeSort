package Sort;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MergeSorter {
	/*
	 * Reads a file with integers and creates an array. Returns an array comprising
	 * of integers from the file read.
	 * 
	 * @Precondition file consists data of type int.
	 * 
	 * @param file A file that consists of integers.
	 * 
	 * @param aSize The size of the array that needs to be created.
	 * 
	 * @throws IOException
	 * 
	 * @throws FileNotFoundException if file is not found.
	 * 
	 * @return an array of type int.
	 */
	public int[] ReadFile(File file, int aSize) throws IOException {
		int[] array = new int[aSize];
		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			while (br.ready()) {
				for (int counter = 0; counter < aSize; counter++) {
					array[counter] = Integer.parseInt(br.readLine());
				}
			}
			br.close();
			fr.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		return array;
	}

	/*
	 * sorts the given array using merge sort. Recursively calls merge until the
	 * entire array is divided in half and then sorted and merged back together.
	 * array is divided in half until we have n arrays of one element. an array of
	 * one element is considered sorted.
	 * 
	 * @param array array to be sorted.
	 * 
	 * @param low lower index of the array.
	 * 
	 * @param high higher index of the array.
	 * 
	 */
	void mergeSort(int array[], int low, int high) {

		if (low < high) {
			int mid = (low + high) / 2;

			mergeSort(array, low, mid);
			mergeSort(array, mid + 1, high);

			merge(array, low, mid, high);
		}
	}

	/*
	 * creates a temporary array that stores the sorted array. compares two elements
	 * of the array at a time, one from the left of the middleindex and one from the
	 * right and adds the amaller element to the temp array. copies the remainig
	 * array as is. repeats this step in the next iteration untile the entire array
	 * is merged and sorted.
	 * 
	 * @param array array to be sorted.
	 * 
	 * @param lowerIndex lower index of the array
	 * 
	 * @param higherIndex higher index of the array.
	 * 
	 * @param middleIndex middle index of the array.
	 * 
	 * @precondition the arrays to be merged together are already sorted.
	 */
	public void merge(int[] array, int lowerIndex, int middleIndex, int higherIndex) {
		int n = higherIndex - lowerIndex + 1;
		int[] temp = new int[n];
		int left = lowerIndex, right = middleIndex + 1, bIdx = 0;

		while (left <= middleIndex && right <= higherIndex) {
			if (array[left] <= array[right])
				temp[bIdx++] = array[left++];
			else
				temp[bIdx++] = array[right++];
		}

		while (left <= middleIndex)
			temp[bIdx++] = array[left++];

		while (right <= higherIndex)
			temp[bIdx++] = array[right++];

		for (int k = 0; k < n; k++)
			array[lowerIndex + k] = temp[k];
	}

	/*
	 * Prints the given array's elements horizontally.
	 * 
	 * @param array an array that needs to be printed.
	 */
	public void printArray(int[] a) {

		System.out.println("This is the array using Merge sort:");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}
}
