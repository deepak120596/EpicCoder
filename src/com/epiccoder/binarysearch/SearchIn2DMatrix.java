package com.epiccoder.binarysearch;

public class SearchIn2DMatrix {

	public static void main(String[] args) {
		int [][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
		int target = 13;
		System.out.println(searchMatrix(matrix,target));

	}
	public static boolean searchMatrix(int [][] matrix , int target) {
		if(matrix == null || matrix.length==0 || matrix[0].length==0)
			return false;
		int row = matrix.length,col = matrix[0].length;
		int low = 0, high = (row*col)-1;
		while(low<=high) {
			int mid = high + (low-high)/2;
		    int midValue = matrix[mid/col][mid%col];
		    if(midValue==target)
		    	return true;
		    else if(target>midValue) {
		    	low = mid + 1;
		    }
		    else {
		    	high = mid -1;
		    }
			
		}
		
		return false;
	}

}
