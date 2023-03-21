package com.multi.www.web02;

public class Coffee2 {
	int price = 5000;
	String name = "핸드드립";
	public static Coffee2 coffee2;

	private Coffee2(int price, String name) {
	}

	public static Coffee2 getInstance() {
		// 이미 만들지 않았다면
		if (coffee2 == null) { // 아직 안만들어진 것!
			coffee2 = new Coffee2(100, "라떼");
		}
		return coffee2;
	}
}