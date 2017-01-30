package week4;

import org.junit.Assert;
import org.junit.Test;
import week4.trie.TrieST;

/**
 * Created by matijav on 30/01/2017.
 */
public class TrieTest {

    @Test
    public void testPut() {
        TrieST<String> trie = new TrieST<>();
        trie.put("Hello", "World");
        trie.put("test1", "val1");
        trie.put("test12", "val2");
        trie.put("test2", "val3");

        Assert.assertEquals("World", trie.get("Hello"));
        Assert.assertEquals("val1", trie.get("test1"));
        Assert.assertEquals("val2", trie.get("test12"));
        Assert.assertEquals("val3", trie.get("test2"));
    }

    @Test
    public void testGet() {
        TrieST<String> trie = new TrieST<>();
        Assert.assertNull(trie.get("invalid"));
    }

    @Test
    public void testContains() {
        TrieST<String> trie = new TrieST<>();
        trie.put("yes", "yes");

        Assert.assertTrue(trie.contains("yes"));
        Assert.assertFalse(trie.contains("no"));
    }

    @Test
    public void testDelete() {
        TrieST<String> trie = new TrieST<>();
        trie.put("yes", "yes");

        Assert.assertTrue(trie.contains("yes"));
        trie.delete("yes");
        Assert.assertFalse(trie.contains("yes"));
    }
}
