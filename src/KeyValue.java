/**
 * @author Silhouette76
 */
public class KeyValue<K, V>
{
    final K key;
    V value;

    public KeyValue(K key, V value)
    {
        this.key = key;
        this.value = value;
    }
    @Override
    public String toString()
    {
        return "("+this.key+","+this.value+")";
    }
    @Override
    public final int hashCode()
    {
        return this.key.hashCode();
    }
    @Override
    public boolean equals(Object obj)
    {
        return obj==this ||
                obj instanceof KeyValue<?,?> && this.key.equals(((KeyValue<K,V>)obj).key);
    }
}
