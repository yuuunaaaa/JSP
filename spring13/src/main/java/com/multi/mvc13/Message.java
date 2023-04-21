package com.multi.mvc13;

//������(Ŭ���̾�Ʈ)�� �Է��ؼ� ������ ������ ������ �޴� ���� 
//���������� ä��â�� �ִ� �����͸� �������� ���� �� ����� vo
public class Message extends Object {

	private String from;
	private String text;

	public Message(String from, String text) {
		super(); //�θ�Ŭ������ Object()�� ���� ȣ���Ͽ� ���� ��ü�� ������.!
		//super()�� ������ �� ����!!, �ڵ�ȣ��(���� ����)
		this.from = from;
		this.text = text;
	}

	public Message() {
		//super();
		// TODO Auto-generated constructor stub
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return "Message [from=" + from + ", text=" + text + "]";
	}
}
