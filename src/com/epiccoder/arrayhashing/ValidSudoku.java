package com.epiccoder.arrayhashing;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {

	public static void main(String[] args) {
		char [][] s ={{'5','3','.','.','7','.','.','.','.'}
		,{'6','.','.','1','9','5','.','.','.'}
		,{'.','9','8','.','.','.','.','6','.'}
		,{'8','.','.','.','6','.','.','.','3'}
		,{'4','.','.','8','.','3','.','.','1'}
		,{'7','.','.','.','2','.','.','.','6'}
		,{'.','6','.','.','.','.','2','8','.'}
		,{'.','.','.','4','1','9','.','.','5'}
		,{'.','.','.','.','8','.','.','7','9'}};
		System.out.println(isValidSudoku(s));;
	}
	
	 public static boolean isValidSudoku(char[][] board) {
		Set<String> uniqueVal = new HashSet<>();
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				if(board[i][j]!='.') {
					String s ="("+board[i][j]+")";
					if(!uniqueVal.add(s+i) || !uniqueVal.add(j+s) || !uniqueVal.add(i/3+s+j/3)) {
						return false;
					}	
				}
				
			}
		}
		return true;
	        
	  }

}
