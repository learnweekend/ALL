/** https://leetcode.com/problems/maximum-subarray/description/
 *  Given an integer array contains +ve and -ve numbers.
 *  find the maximum sub array sum and sub array indices.
 *  Assumptions : Assumes the input contain +ve and -ve numbers.
 *  For -ve numbers : the max element in the array is the max sum.
 */

public class MaxSumSubArrayV1 {

	private static long maxsumSubArrayV1(int[] arr) {
		long maximumSum = arr[0];
		long currentMax = arr[0];
		int N = arr.length;

		for (int i = 1; i < N; i++) {
			currentMax = Math.max(currentMax + arr[i], arr[i]);
			maximumSum = Math.max(maximumSum, currentMax);
		}
		return maximumSum;
	}

	private static SubArray maxsumSubArrayV3(int[] arr) {
		int currSum = 0;
		int maxSum = 0;
		int startIdx = 0;

		SubArray range = null;

		for (int i = 0; i < arr.length; i++) {
			currSum += arr[i];
			if (currSum < 0) {
				currSum = 0;
				startIdx = i; // startIdx will be + 1
			}
			if (currSum > maxSum) {
				maxSum = currSum;
				range = new SubArray(maxSum, startIdx + 1, i + 1); // endIdx excluding
			}
		}
		return range;
	}

	private static class SubArray {
		private int start;
		private int end;
		private int maxSum;

		public SubArray(int maxSum, int start, int end) {
			this.maxSum = maxSum;
			this.start = start;
			this.end = end;
		}
	}

	public static void main(String[] args) {
		int[] arr = {-2, -3, 4, -1, -2, 1, 5, -3}; //{ -10, -2, -1, 2, 4, -5 };
		System.out.println("maxsum = " + maxsumSubArrayV1(arr));
		SubArray subArray = maxsumSubArrayV3(arr);
		System.out.println("maxSum = " + subArray.maxSum + ", indices = " + subArray.start + ", " + subArray.end);
	}
}
