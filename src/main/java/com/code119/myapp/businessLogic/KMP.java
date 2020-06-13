package com.code119.myapp.businessLogic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.code119.myapp.controller.HomeController;

public class KMP {

	private static int[] getPi(String p){
		int m = p.length(), j = 0;
		int[] pi = new int[p.length()];
		for (int i = 1; i< m; i++) {
			while (j > 0 && p.charAt(i) != p.charAt(j))
				j = pi[j - 1];
			if (p.charAt(i) == p.charAt(j))
				pi[i]=++j;
		}
		return pi;
	}
	
	public static List<Integer> findSubstring(String needle, String haystack) {
		List<Integer> ans = new ArrayList<Integer>();
		int[] pi = getPi(needle);
		int n = haystack.length(), m = needle.length(), j = 0;
		for (int i = 0; i < n; i++) {
			while (j>0 && haystack.charAt(i) != needle.charAt(j))
				j = pi[j - 1];
			if (haystack.charAt(i) == needle.charAt(j)) {
				if (j == m - 1) {
					ans.add(i - m + 1);
					j = pi[j];
				}
				else {
					j++;
				}
			}
		}
		return ans;
	}
	
	
	public static void main(String[] args){
		KMP kmp = new KMP();
		kmp.findSubstring("woienfiwon", "weiongboiwbnaiobnaiwobnw");
	}
}
