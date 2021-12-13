package ua.edu.ucu.collections.immutable;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class ImmutableArrayListTest {
    private ImmutableArrayList aL;
    private ImmutableArrayList emptyAL;



    @Before
    public  void setUp(){
        this.aL = new ImmutableArrayList(new Object[]{1,2,3});
        this.emptyAL = new ImmutableArrayList();
    }


    @Test
    public void resizeTest(){
        Object[] expected = new Object[] {1,2,3,null};
        Object[] toChange = new Object[] {1,2,3};
        assertArrayEquals(expected, this.aL.resize(1));
    }

    @Test
    public void moveTest(){
        Object[] expected = new Object[] {1,2,null,null,null,3};
        Object[] toChange = new Object[] {1,2,3};
        assertArrayEquals(expected, ImmutableArrayList.move(2,toChange,3));
    }
    @Test
    public void addTest(){
        ImmutableArrayList expected = new ImmutableArrayList(new Object[]{1,2,3,4});

        assertArrayEquals(expected.toArray(), this.aL.add(4).toArray());
    }

    @Test
    public void addIndexTest(){
        ImmutableArrayList expected = new ImmutableArrayList(new Object[]{1,2,4,3});

        assertArrayEquals(expected.toArray(), this.aL.add(2,4).toArray());
    }

    @Test
    public void addAllTest(){
        ImmutableArrayList expected = new ImmutableArrayList(new Object[]{1,2,3,4,5});

        assertArrayEquals(expected.toArray(), this.aL.addAll(new Object[]{4,5}).toArray());
    }

    @Test
    public void addAllIndexTest(){
        ImmutableArrayList expected = new ImmutableArrayList(new Object[]{1,2,4,5,3});

        assertArrayEquals(expected.toArray(), this.aL.addAll(2,new Object[]{4,5}).toArray());
    }

    @Test
    public void getTest(){
        Object expected = 2;

        assertEquals(expected, this.aL.get(1));
    }

    @Test
    public void removeTest(){
        ImmutableArrayList expected = new ImmutableArrayList(new Object[]{1,3});

        assertArrayEquals(expected.toArray(), this.aL.remove(1).toArray());
    }

    @Test
    public void setTest(){
        ImmutableArrayList expected = new ImmutableArrayList(new Object[]{1,5,3});

        assertArrayEquals(expected.toArray(), this.aL.set(1,5).toArray());
    }
    @Test
    public void indexOfTest(){
        int expected = 1;

        assertEquals(expected, this.aL.indexOf(2));
    }

    @Test
    public void sizeTest(){
        int expected = 3;

        assertEquals(expected, this.aL.size());
    }
    @Test
    public void clearTest(){

        assertArrayEquals(this.emptyAL.toArray(), this.aL.clear().toArray());
    }
    @Test
    public void isEmptyTest(){


        assertTrue( this.emptyAL.isEmpty());
    }
    @Test
    public void toArrayTest(){
        Object[] expected = new Object[]{1,2,3};
        assertArrayEquals(expected, this.aL.toArray());
    }
}