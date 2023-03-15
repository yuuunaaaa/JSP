package multi;

// RAM에 만드는 저장공간을 만든다.
public class MemberVO {
	// MemberVO 가방에 넣은 데이터는 Member 테이블에 들어갈 예정
	// 각 컬럼과 일치시켜 줌
	private String id;
	private String pw;
	private String name;
	private String tel;

	// 가방에 하나씩 값을 넣어주어야 함. ==> setter
	public void setId(String id) {
		this.id = id;
	}

	// 가방에 하나씩 값을 꺼내주어야 함. ==> getter
	public String getId() {
		return id;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getPw() {
		return pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	// 가방에 어떤 값들이 들어있는지 찍어볼 수 있다.
	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", pw=" + pw + ", name=" + name + ", tel=" + tel + "]";
	}

}
