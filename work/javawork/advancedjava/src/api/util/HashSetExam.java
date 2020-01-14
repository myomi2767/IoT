package api.util;

import java.util.HashSet;

public class HashSetExam {

	public static void main(String[] args) {
		//다음과 같은 변수명으로 HashSet객체 2개 작성하기
		//set1 -> 1부터 10까지의 점수
		//set2 -> 5부터 15까지의 점수
		HashSet<Integer> set1 = new HashSet<Integer>();
		HashSet<Integer> set2 = new HashSet<Integer>();
		
		for(int i=1;i<=10;i++) {
			set1.add(i);
		}
		//System.out.println("set1의 사이즈"+set1.size());
		for(int i=5;i<=15;i++) {
			set2.add(i);
		}
		//System.out.println("set2의 사이즈"+set2.size());
		//print(set2, "set2");
		//set1과 set2합집합 출력하기
		HashSet<Integer> set3 = new HashSet<Integer>(set1);
		set3.addAll(set2);
		print(set3, "합집합");
		
		//set1과 set2교집합 출력하기
		set1.retainAll(set2);
		print(set1, "교집합");
	}
	public static void print(HashSet<Integer> set, String name) {
		for (Integer data : set) {
			System.out.println(name+"의 요소:"+data);
		}
		System.out.println("===========================");
	}

}
