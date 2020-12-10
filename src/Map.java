
/**
 * @author Silhouette76
 */
public interface Map<K, V>
{
    public abstract V get(K key);
    public abstract V put(K key, V value);
    public abstract V remove(K key);
}