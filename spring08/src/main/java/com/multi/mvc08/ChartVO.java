package com.multi.mvc08;

public class ChartVO {
	int Coding;
	int Eat;
	int Rest;
	int Sleep;
	public int getCoding() {
		return Coding;
	}
	public void setCoding(int coding) {
		Coding = coding;
	}
	public int getEat() {
		return Eat;
	}
	public void setEat(int eat) {
		Eat = eat;
	}
	public int getRest() {
		return Rest;
	}
	public void setRest(int rest) {
		Rest = rest;
	}
	public int getSleep() {
		return Sleep;
	}
	public void setSleep(int sleep) {
		Sleep = sleep;
	}
	@Override
	public String toString() {
		return "ChartVO [Coding=" + Coding + ", Eat=" + Eat + ", Rest=" + Rest + ", Sleep=" + Sleep + "]";
	}
	
}
