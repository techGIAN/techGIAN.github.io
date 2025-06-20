public class TestLight {

    public static void main(String args[]) {

        System.out.println("Running Light tests...");
        // 1. Test Light()
        Light n = new Light();
        assert n.toString().equals("on white\tnot burnt out");

        // 2. Test Light(o, b, c)
        n = new Light(false, true, "green");
        assert n.toString().equals("off green\tburnt out");

        // 3. Test burn_out()
        n = new Light();
        n.burnOut();
        assert n.toString().equals("off white\tburnt out");

        // 4. Test flip()
        n = new Light(true, false, "white");
        assert n.toString().equals("on white\tnot burnt out");
        n.flip();
        assert n.toString().equals("off white\tnot burnt out");
        n.flip();
        assert n.toString().equals("on white\tnot burnt out");
        n.burnOut();
        n.flip();
        assert n.toString().equals("off white\tburnt out");

        // 5. Test is_on()
        n = new Light();
        assert n.isOn();
        n.flip();
        assert !n.isOn();

        // 6. Test get_color()
        n = new Light(true, false, "red");
        assert n.getColor().equals("red");
        n = new Light(true, false, "green");
        assert n.getColor().equals("green");
        n = new Light(true, false, "blue");
        assert n.getColor().equals("blue");
        n = new Light(true, false, "white");
        assert n.getColor().equals("white");
        n = new Light(true, false, "purple");
        assert n.getColor().equals("white");

        // 7. Test set_color()
        n = new Light();
        n.setColor("red");
        assert n.getColor().equals("red");
        n.setColor("green");
        assert n.getColor().equals("green");
        n.setColor("blue");
        assert n.getColor().equals("blue");
        n.setColor("white");
        assert n.getColor().equals("white");
        n.setColor("purple");
        assert n.getColor().equals("white");

        System.out.println("Tests passed.");
    }
}

