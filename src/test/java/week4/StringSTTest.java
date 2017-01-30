package week4;

import org.junit.Assert;
import org.junit.Test;
import week4.trie.TrieST;

/**
 * Created by matijav on 30/01/2017.
 */
public class StringSTTest {

    @Test
    public void testTrieBackend() {
        StringST<String> st = new StringST<>(new TrieST<>());

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
    }
}
