/**
 * 
 */
package q5;

/**
 * @author adalberto
 *
 */
public class Result {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Student s = new Student();
		switch (s.marks) {
		default: System.out.println("100");
		case 10: System.out.println("10");
		case 11: System.out.println("98");
		}
	}

}
