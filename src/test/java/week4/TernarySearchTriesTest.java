package week4;

import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Test;
import week4.helpers.TestHelper;
import week4.trie.TernarySearchTriesST;

/**
 * Created by matijav on 31/01/2017.
 */
public class TernarySearchTriesTest {

    @Test
    public void testPut() {
        TernarySearchTriesST<String> trie = new TernarySearchTriesST<>();
        trie.put("Hello", "World");
        trie.put("test1", "val1");
        trie.put("test12", "val2");
        trie.put("test2", "val3");
        trie.put("test3", "val4");

        Assert.assertEquals("World", trie.get("Hello"));
        Assert.assertEquals("val1", trie.get("test1"));
        Assert.assertEquals("val2", trie.get("test12"));
        Assert.assertEquals("val3", trie.get("test2"));
        Assert.assertEquals("val4", trie.get("test3"));
    }

    @Test
    public void testGet() {
        TernarySearchTriesST<String> trie = new TernarySearchTriesST<>();
        Assert.assertNull(trie.get("invalid"));
    }

    @Test
    public void testContains() {
        TernarySearchTriesST<String> trie = new TernarySearchTriesST<>();
        trie.put("yes", "yes");

        Assert.assertTrue(trie.contains("yes"));
        Assert.assertFalse(trie.contains("no"));
    }

    @Test
    public void testDelete() {
        TernarySearchTriesST<String> trie = new TernarySearchTriesST<>();
        trie.put("yes", "yes");

        Assert.assertTrue(trie.contains("yes"));
        trie.delete("yes");
        Assert.assertFalse(trie.contains("yes"));
        trie.delete("invalid");
    }

    @Test
    public void testKeys() {
        TernarySearchTriesST<String> trie = new TernarySearchTriesST<>();
        trie.put("key1", "val1");
        trie.put("key2", "val2");
        trie.put("key4", "val4");
        trie.put("key3", "val3");
        trie.put("key31", "val31");

        TestHelper.assertIterableEquals(Lists.newArrayList("key1", "key2", "key4", "key3", "key31"), trie.keys());
    }

    @Test
    public void testKeysWithPrefix() {
        TernarySearchTriesST<String> trie = new TernarySearchTriesST<>();
        trie.put("random_key", "random_value");
        trie.put("test1", "val1");
        trie.put("test12", "val2");
        trie.put("test2", "val3");
        trie.put("random_key2", "random_value2");
        trie.put("tes", "va");

        TestHelper.assertIterableEquals(Lists.newArrayList("test1", "test12", "test2"), trie.keysWithPrefix("test"));
    }

    @Test
    public void longestPrefixOf() {
        TernarySearchTriesST<Integer> trie = new TernarySearchTriesST<>();
        trie.put("a", -1);
        trie.put("aa", -1);
        trie.put("aaaa", -1);
        trie.put("aaa", -1);
        trie.put("aaab", -1);

        Assert.assertEquals("aaaa", trie.longestPrefixOf("aaaaa"));
    }
}
