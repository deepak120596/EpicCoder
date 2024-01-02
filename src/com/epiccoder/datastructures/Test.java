package com.epiccoder.datastructures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		List<Integer> invoiceIds = new ArrayList<>();
		invoiceIds.add(12);
		invoiceIds.add(13);
		invoiceIds.add(14);
		invoiceIds.add(15);
		invoiceIds.add(16);
		invoiceIds.add(17);
		invoiceIds.add(18);
		invoiceIds.add(19);
		Iterator<Integer> it = invoiceIds.iterator();
		
		while(it.hasNext()) {
			int num = it.next();
			System.out.println(num);
			invoiceIds.removeAll(invoiceIds);
			
		}

	}

}
