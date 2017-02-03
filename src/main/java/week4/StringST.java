package week4;

/**
 * Created by matijav on 30/01/2017.
 */
public class StringST<VAL> {
    private Backend<VAL> backend;

    public StringST(Backend<VAL> backend) {
        this.backend = backend;
    }

    public void put(String key, VAL value) {
        backend.put(key, value);
    }

    public VAL get(String key) {
        return backend.get(key);
    }

    public boolean contains(String key) {
        return backend.contains(key);
    }

    public void delete(String key) {
        backend.delete(key);
    }

    public Iterable<String> keys() {
        return backend.keys();
    }

    public Iterable<String> keysWithPrefix(String prefix) {
        return backend.keysWithPrefix(prefix);
    }

    public String longestPrefixOf(String key) {
        return backend.longestPrefixOf(key);
    }
}
