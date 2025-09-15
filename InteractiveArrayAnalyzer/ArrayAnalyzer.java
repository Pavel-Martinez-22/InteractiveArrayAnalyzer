import java.util.Scanner;

import java.lang.System;
/*
Brief Description: This program contains a main display with 9 options that allow you to see different ways an array can be implemented. The array first will initiated to 25 random numbers and then will be implemented in a variety of ways.
 */

public class ArrayAnalyzer {
	// Main method
	public static void main(String[] args) {
		// Create Scanner
		Scanner input = new Scanner(System.in);
		// Initialize variable
		int choice;
		int key = -1;

		// 1. Declare an int array of size 25
		int[] arr = new int[25];

		// 2. Initialize the array by calling initializeArray function
		initializeArray(arr);
		int[] arrSorted = new int[arr.length];

		do {
			// 0.Display input Selection menu
			menu();
			System.out.println();
			System.out.print("Please enter your choice: ");
			choice = input.nextInt();
			System.out.println();

			// Switch Structure
			switch (choice) {
			case 1:

				// 3. Print out the array by calling printArray function
				System.out.println("Print Original Array:");
				printArray(arr);

				break;

			case 2:

				// 4. Print out the largest and smallest value of the array by using
				// System.out.println and calling the largest and smallest functions
				System.out.println("Largest Value: " + largest(arr));
				System.out.println("Smalles Value: " + smallest(arr));

				break;
			case 3:

				// 5. Print out the range of the array
				System.out.println("Range: " + range(arr));

				break;

			case 4:

				// 6. Print out the average of the array elements
				System.out.println("Average: " + average(arr));

				break;
			case 5:

				// 7. Ask user to enter a search key
				System.out.println("Enter the number (Search key) you wish to search for, using Linear Search Option.");
				System.out.print("Enter Search Key: ");
				key = input.nextInt();

				System.out.println();

				break;

			case 6:

				// 8. Call the linearSearch function with array and key. Based on result print
				// out appropriate message

				// Testing to see if the array is sorted
				boolean unSortedArr = true;

				for (int e : arrSorted) {
					if (e > 0) {
						unSortedArr = false;
						break;
					}
				}

				// Depending on if the array is sorted or not the correct array will be used in
				// the linear search
				if (unSortedArr) {
					System.out.println("You have entered: " + key + ", as your search key.");
					int index = linearSearch(arr, key);
					if (index != -1) {
						System.out.println(
								"Your search key was found in index: " + index + ", within the unsorted array.");
					} else {
						System.out.println("Your search key was not found in the array");
					}
				} else {
					System.out.println("You have entered: " + key + ", as your search key.");
					int index = linearSearch(arrSorted, key);

					if (index != -1) {
						System.out
								.println("Your search key was found in index: " + index + ", within the sorted array.");
					} else {
						System.out.println("Your search key was not found in the array");
					}
				}

				break;
			case 7:

				// 9. Call the selectSort function to sort the array

				System.arraycopy(arr, 0, arrSorted, 0, arr.length);
				selectSort(arrSorted);
				System.out.print("Your array has been sorted.");
				System.out.println();

				break;

			case 8:
				// 10. Print our array again to see the sorted array

				System.out.println("Print Sorted Array:");
				printArray(arrSorted);

				break;
			case 9:
				System.out.print("Thanks for using the program. Goody-by");
				break;
			default:
				System.out.print("Wrong choic. Please choose 1-9 from menu");
				break;
			}

			System.out.println();

		} while (choice != 9);
		System.exit(0); // Normal termination
	}

	// 0. Display input selection menu, ( 1 - 9 labels for action and option 9 to
	// re-run or exit the program, public static void menu()
	public static void menu() {
		System.out.println("**************************************");
		System.out.println("*       Please choose form menu      *");
		System.out.println("* 1. Print Array                     *");
		System.out.println("* 2. Print Largest & Smallest Value  *");
		System.out.println("* 3. Print Range                     *");
		System.out.println("* 4. Print Average                   *");
		System.out.println("* 5. Enter Search key                *");
		System.out.println("* 6. Linear Search Array             *");
		System.out.println("* 7. Select Sort Array               *");
		System.out.println("* 8. Print Sorted Array              *");
		System.out.println("* 9. Exit program                    *");
		System.out.println("**************************************");
	}

	// 1.assign 25 elements in array with random numbers between 1 and 100,
	// inclusive, public static void initializeArray(int arr[])

	public static void initializeArray(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (1 + Math.random() * 100);
		}

	}

	// 2. return the index of the first occurrence of key in arr if key is not found
	// in arr, return a, -1, public static int linearSearch(int arr[], int key)

	public static int linearSearch(int arr[], int key) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == key) {
				return i;
			}
		}
		return -1;

	}

	// 3. sort the arr from the least to largest by using select sort algorithm
	// public static void selectSort(int arr[])
	public static void selectSort(int arr[]) {
		// Iterate through array
		for (int i = 0; i < arr.length; i++) {
			int currentMin = arr[i];
			int currentMinIndex = i;

			// iterate through array checking values for smallest
			for (int j = i + 1; j < arr.length; j++) {
				if (currentMin > arr[j]) {
					currentMin = arr[j];
					currentMinIndex = j;
				}
			}

			// Swap If we find a smaller number we swap
			if (currentMinIndex != i) {
				arr[currentMinIndex] = arr[i];
				arr[i] = currentMin;
			}
		}
	}

	// 4. print out all array elements (5) elements per line, public static void
	// printArray(int arr[])
	public static void printArray(int arr[]) {

		System.out.println();

		for (int i = 0; i < arr.length; i++) {
			System.out.printf("%-5d", arr[i]);
			if ((i + 1) % 5 == 0) {
				System.out.println();
			}
		}
		System.out.println();
	}

	// 5. find the range of all array elements, the range is defined as the
	// difference between the largest and smallest elements, public static int
	// range(int arr[])

	public static int range(int arr[]) {
		return largest(arr) - smallest(arr);
	}

	// 6. find the largest element in, public static int largest(int arr[])
	public static int largest(int arr[]) {
		int max = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}

		return max;
	}

	// 7.find the smallest element in array, public static int smallest(int arr[])
	public static int smallest(int arr[]) {
		int min = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] < min) {
				min = arr[i];
			}
		}

		return min;
	}

	// 8. find the average value of all elements in array(arr), public static double
	// average(int arr[])

	public static double average(int arr[]) {
		double sum = 0;
		double average = 0;

		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}

		average = (double) sum / arr.length;

		return average;
	}

}
