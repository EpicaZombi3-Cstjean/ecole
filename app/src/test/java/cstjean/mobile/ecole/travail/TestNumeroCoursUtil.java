package cstjean.mobile.ecole.travail;
import static org.junit.Assert.*;

import org.junit.Test;
public class TestNumeroCoursUtil {

    @Test
    public void testNumeroCoursValide() {
        assertTrue(NumeroCoursUtil.estNumeroCoursValide("101"));
        assertTrue(NumeroCoursUtil.estNumeroCoursValide("3C4"));
        assertFalse(NumeroCoursUtil.estNumeroCoursValide("AAA"));
        assertFalse(NumeroCoursUtil.estNumeroCoursValide("A"));
        assertFalse(NumeroCoursUtil.estNumeroCoursValide("2"));
        assertFalse(NumeroCoursUtil.estNumeroCoursValide("20A"));
    }
}
