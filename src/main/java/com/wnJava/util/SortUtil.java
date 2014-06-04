package com.wnJava.util;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;

public class SortUtil {
	public static int swapCount = 0;
	public static int arrSize = 0;
	public static int actCount = 0;
	public static Logger logger = Logger.getLogger(SortUtil.class);

	/**
	 * 插入排序（假定i前面的元素都已经排序完毕，依次比较i和他前面的元素，比i大，则和i交换，保证前i个元素是有序的）
	 * 
	 * @autor: wn 2014-6-3 下午5:35:13
	 * @param dest
	 */
	public void insertionSort(int[] dest) {
		for (int i = 0; i < dest.length; i++) {
			for (int j = i; j > 0 && dest[j - 1] > dest[j]; j--) {
				actCount++;
				swap(dest, j, j - 1);
			}
		}
	}

	/**
	 * 思想：对数组中元素从一边开始两两比较大小，将较大的后移，这样一次遍历之后，最大的就沉到了数组的结尾。对前面的n-1个元素继续遍历，直到n=1.
	 * 优化策略： 1.增加标志，当一次遍历没有进行过交换时，说明已经完成了排序，直接结束。
	 * 2.记录最后一次交换的位置，表示在该位置之后的数组部分已经完成了排序，只对位置前面的元素进行排序。这在数组 部分有序 的时候，会提高效率
	 * 
	 * @autor: wn 2014-6-4 上午10:07:01
	 * @param dest
	 */
	public void bubbleSort(int[] dest) {
		boolean swapFlag = false;
		int lastSwapIndex = dest.length - 1;
		int temp = 0;
		while (lastSwapIndex > 0) {
			for (int j = 0; j < lastSwapIndex; j++) {
				actCount++;
				if (dest[j] > dest[j + 1]) {
					swap(dest, j, j + 1);
					swapFlag = true;
					temp = j;
				}
			}
			if (!swapFlag)
				break;
			lastSwapIndex = temp;
		}
	}
	
	

	static int multiply(int n) {
		if (n == 1 || n == 0)
			return n;
		else
			return n * multiply(n - 1);
	}

	private void swap(int[] list, int i, int j) {
		swapCount++;
		int temp = list[i];
		list[i] = list[j];
		list[j] = temp;
	}

	public static void main(String args[]) {
		int[] descArr = { 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		int[] ascArr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		// doSort(descArr,"insertionSort");
		doSort(ascArr, "bubbleSort");
	}

	private static void doSort(int[] arr, String method) {
		arrSize = arr.length;
		printArray(arr, "before");
		try {
			Class<?> sortClass = Class.forName("com.wnJava.util.SortUtil");
			SortUtil sortUtil = (SortUtil) sortClass.newInstance();
			Method sortMethord = sortClass.getMethod(method, int[].class);
			sortMethord.invoke(sortUtil, arr);
		} catch (Exception e) {
			e.printStackTrace();
		}
		printArray(arr, "after");
		printInfo();
	}

	private static void printArray(int[] arr, String info) {
		logger.info(info);
		for (int i : arr) {
			System.out.print(i + "-");
		}
		System.out.println("");
	}

	private static void printInfo() {
		logger.info("数组大小：" + arrSize);
		logger.info("迭代次数：" + actCount);
		logger.info("交换次数：" + swapCount);
	}
}
