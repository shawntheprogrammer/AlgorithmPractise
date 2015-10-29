import static org.junit.Assert.*;

import org.junit.Test;

public class ValidParenthesesTest {
    ValidParentheses vp = new ValidParentheses();
    
    @Test
    public void test() {
        String s = "()";
        assertTrue(vp.isValidParentheses(s));
        s = "({}";
        assertFalse(vp.isValidParentheses(s));
    }

}
