
public class HW6Q3 {

	public static void main(String[] args) {
        System.out.println(reverse("Hello World"));
        System.out.println(reverse("python is awesome"));
        System.out.println(reverse("kayak"));
    }

    public static String reverse(String s) {
        if (s.isEmpty()) {
            return "";
        } else {
            return s.charAt(s.length() - 1) + reverse(s.substring(0, s.length() - 1));
        }
    }

}
