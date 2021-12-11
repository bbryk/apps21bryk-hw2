package ua.edu.ucu.collections.immutable;

import junit.framework.TestCase;

import static org.junit.Assert.assertArrayEquals;

public class ImmutableArrayListTest extends TestCase {

    public void testGet(){
        Object[][] inputArr = {{"a"}, {"b"}, {"c"}};
        ImmutableArrayList arr = new ImmutableArrayList(inputArr);

        assertArrayEquals(arr.toArray(), inputArr);
        assertEquals(inputArr[1], arr.get(1));
        Object []el = (Object[]) arr.get(1);
        el[0] = "c";
        inputArr = new Object[][]{{"a"}, {"b"}, {"c"}};
        assertArrayEquals(arr.toArray(), inputArr);
    }

}