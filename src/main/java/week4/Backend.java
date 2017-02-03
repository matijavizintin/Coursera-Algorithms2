package week4;

/**
 * Created by matijav on 30/01/2017.
 */
public interface Backend<VAL> {

    void put(String key, VAL val);

    VAL get(String key);

    boolean contains(String key);

    void delete(String key);

    Iterable<String> keys();

    Iterable<String> keysWithPrefix(String prefix);

    String longestPrefixOf(String key);
}
