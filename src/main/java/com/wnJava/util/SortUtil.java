package com.wnJava.util;

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
		arrSize = dest.length;
		for (int i = 0; i < dest.length; i++) {
			for (int j = i;j>0&&dest[j-1]>dest[j]; j--) {
				actCount++;
				swap(dest, j, j-1);
			}
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
		int[] descArr = {9,8,7,6,5,4,3,2,1};
		SortUtil sortUtil = new SortUtil();
		printArray(descArr, "before");
		//插入排序
		sortUtil.insertionSort(descArr);
		
		
		
		
		printArray(descArr, "after");
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
