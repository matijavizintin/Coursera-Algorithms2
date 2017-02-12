package week4;

import com.google.common.collect.Lists;
import helpers.TestHelper;
import org.junit.Assert;
import org.junit.Test;
import week4.trie.StringST;
import week4.trie.TernarySearchTriesST;
import week4.trie.TrieST;

/**
 * Created by matijav on 30/01/2017.
 */
public class StringSTTest {

    @Test
    public void testTrieBackend() {
        StringST<String> st = new StringST<>(new TrieST<>());
        executeTest(st);
    }

    @Test
    public void testTSTBackend() {
        StringST<String> st = new StringST<>(new TernarySearchTriesST<>());
        executeTest(st);
    }

    private void executeTest(StringST<String> st) {
        st.put("Hello", "World");
        st.put("test1", "val1");
        st.put("test12", "val2");
        st.put("test2", "val3");
        Assert.assertEquals("World", st.get("Hello"));
        Assert.assertEquals("val1", st.get("test1"));
        Assert.assertEquals("val2", st.get("test12"));
        Assert.assertEquals("val3", st.get("test2"));
        Assert.assertNull(st.get("invalid"));

        st.put("yes", "yes");
        Assert.assertTrue(st.contains("yes"));
        Assert.assertFalse(st.contains("no"));
        st.delete("yes");
        Assert.assertFalse(st.contains("yes"));

        TestHelper.assertIterableEquals(Lists.newArrayList("Hello", "test1", "test12", "test2"), st.keys());
        TestHelper.assertIterableEquals(Lists.newArrayList("test1", "test12", "test2"), st.keysWithPrefix("test"));

        st.put("a", "1");
        st.put("aa", "1");
        st.put("aaaa", "1");
        st.put("aaa", "1");
        Assert.assertEquals("aaaa", st.longestPrefixOf("aaaaa"));
    }
}
