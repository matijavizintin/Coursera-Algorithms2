package week4;

import com.google.common.collect.Lists;
import helpers.TestHelper;
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

    @Test
    public void testKeys() {
        TrieST<String> trie = new TrieST<>();
        trie.put("key1", "val1");
        trie.put("key2", "val2");
        trie.put("key4", "val4");
        trie.put("key3", "val3");

        TestHelper.assertIterableEquals(Lists.newArrayList("key1", "key2", "key3", "key4"), trie.keys());
    }

    @Test
    public void testKeysWithPrefix() {
        TrieST<String> trie = new TrieST<>();
        trie.put("random_key", "random_value");
        trie.put("test1", "val1");
        trie.put("test12", "val2");
        trie.put("test2", "val3");
        trie.put("random_key2", "random_value2");

        TestHelper.assertIterableEquals(Lists.newArrayList("test1", "test12", "test2"), trie.keysWithPrefix("test"));
    }

    @Test
    public void longestPrefixOf() {
        TrieST<Integer> trie = new TrieST<>();
        trie.put("a", -1);
        trie.put("aa", -1);
        trie.put("aaaa", -1);
        trie.put("aaa", -1);

        Assert.assertEquals("aaaa", trie.longestPrefixOf("aaaaa"));
    }
}
