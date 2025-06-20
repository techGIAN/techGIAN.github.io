import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestLight {
	
	private Light l;

	@Test
	void test1() {
		// 1. Test Light()
		l = new Light();
        assertEquals("on white\tnot burnt out", l.toString());
	}
	
	@Test
	void test2() {
		// 2. Test Light(o, b, c)
		l = new Light(false, true, "green");
        assertEquals("off green\tburnt out", l.toString());
	}
	
	@Test
	void test3() {
		// 3. Test burn_out()
		l = new Light();
        l.burnOut();
        assertEquals("off white\tburnt out", l.toString());
	}
	
	@Test
	void test4() {
		// 4. Test flip()
        l = new Light(true, false, "white");
        assertEquals("on white\tnot burnt out", l.toString());
        
        l.flip();
        assertEquals("off white\tnot burnt out", l.toString());
        
        l.flip();
        assertEquals("on white\tnot burnt out", l.toString());
        
        l.burnOut();
        l.flip();
        assertEquals("off white\tburnt out", l.toString());
	}
	
	@Test
	void test5() {
		// 5. Test is_on()
        l = new Light();
        assertTrue(l.isOn());
        
        l.flip();
        assertFalse(l.isOn());
	}
	
	@Test
	void test6() {
		// 6. Test get_color()
        l = new Light(true, false, "red");
        assertEquals("red", l.getColor());
        
        l = new Light(true, false, "green");
        assertEquals("green", l.getColor());
        
        l = new Light(true, false, "blue");
        assertEquals("blue", l.getColor());
        
        l = new Light(true, false, "white");
        assertEquals("white", l.getColor());
        
        l = new Light(true, false, "purple");
        assertEquals("white", l.getColor());
	}
	
	@Test
	void test7() {
		// 7. Test set_color()
        l = new Light();
        
        l.setColor("red");
        assertEquals("red", l.getColor());
        
        l.setColor("green");
        assertEquals("green", l.getColor());
        
        l.setColor("blue");
        assertEquals("blue", l.getColor());
        
        l.setColor("white");
        assertEquals("white", l.getColor());
        
        l.setColor("purple");
        assertEquals("white", l.getColor());
	}
	

}


