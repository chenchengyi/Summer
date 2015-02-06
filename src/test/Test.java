package test;

public class Test {

	public Test() {
		// TODO Auto-generated constructor stub
	}

	
	public static void main(String[] args) {
		
		String str = "cssssssssssyh";
		StringBuilder sb = new StringBuilder(str);
		sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
		str = sb.toString();
		System.out.println(sb.toString());
	}
}
