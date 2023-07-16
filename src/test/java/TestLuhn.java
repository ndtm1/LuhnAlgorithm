import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestLuhn {

    LuhnAlgorithm luhn = new LuhnAlgorithm();

    @Test
    public void testCorrectCheckDigit() {
        String checkSum = String.valueOf(luhn.makeCheckSum("534531000774539").charAt("534531000774539".length()));
        assertEquals("7", checkSum);

        checkSum = String.valueOf(luhn.makeCheckSum("530466848718089").charAt("530466848718089".length()));
        assertEquals("1", checkSum);

        checkSum = String.valueOf(luhn.makeCheckSum("426730717339220").charAt("426730717339220".length()));
        assertEquals("9", checkSum);
    }

    @Test
    public void testVerify() {
        assertTrue(luhn.verifyCheckSum("4650582598399261"));
        assertTrue(luhn.verifyCheckSum("3555347603409358"));
        assertTrue(luhn.verifyCheckSum("5432429461"));

        assertFalse(luhn.verifyCheckSum("465058259839926"));
        assertFalse(luhn.verifyCheckSum("355534760340935"));
        assertFalse(luhn.verifyCheckSum("543242946"));
    }
}
