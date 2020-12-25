import java.security.KeyException;
import java.security.PublicKey;

/**
 * @author Silhouette76
 */
public class SortedKeyValue<K extends Comparable<? super K>, V> extends KeyValue<K,V> implements Comparable<SortedKeyValue<K, V>> {
    public SortedKeyValue(K key, V value)
    {
        super(key,value);
    }

    @Override
    public int compareTo(SortedKeyValue<K,V> kv)
    {
        return this.key.compareTo(kv.key);
    }


    public PublicKey getPublicKey() throws KeyException {
        return null;
    }


    public boolean isFeatureSupported(String feature) {
        return false;
    }
}