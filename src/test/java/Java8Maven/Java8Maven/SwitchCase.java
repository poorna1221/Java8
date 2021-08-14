package Java8Maven.Java8Maven;

public class SwitchCase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SwitchCase sc = new SwitchCase();
		System.out.println(sc.getAge("Sowjanya"));

	}

	public Integer getAge(String name) {

		int age;
		switch (name) {
		case "Poorna":
			age = 30;
			break;

		case "Sowjanya":
			age = 27;
			break;

		default:
			age = 0;
			break;
		}

		return age;
	}

}
