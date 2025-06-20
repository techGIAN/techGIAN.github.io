import java.util.Locale;

public class Light {
    public static String RED = "red";
    public static String BLUE = "blue";
    public static String GREEN = "green";
    public static String WHITE = "white";

    boolean burntOut;
    boolean on;
    String color;

    public Light() {
        this(true, false, WHITE);
//    	this(true, false, "white");
    }

    public Light(boolean o, boolean b, String c) {
        this.burntOut = b;
        this.on = !b && o;
//        this.color = c;
        this.setColor(c);
    }

    public void burnOut() {
        this.burntOut = true;
        this.on = false;
    }

    public void flip() {
        this.on = !this.on && !this.burntOut;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String c) {
        this.color = c.toLowerCase();
        if (this.color != RED && this.color != BLUE && this.color != GREEN) {
        	this.color = WHITE;
        }
    }

    public boolean isOn() {
        return this.on;
    }

    @Override
    public String toString() {
        return (this.on ? "on " : "off ") + this.color + (this.burntOut ? "\t" : "\tnot ") + "burnt out";
    }
}


