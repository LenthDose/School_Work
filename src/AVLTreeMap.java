import java.util.Collection;
import java.util.Map;
//import java.util.Set;
//
///**
// * @author Silhouette76
// */
//public class AVLTreeMap<K extends Comparable<? super K>, V>  implements Map<K,V>
//{
//    AVLTree<SortedKeyValue<K,V>> set;
//    public AVLTreeMap()
//    {
//        this.set = new AVLTree<SortedKeyValue<K,V>>();
//    }
//
//    public V get(K key)
//    {
//        SortedKeyValue<K,V> kv = new SortedKeyValue<K,V>(key,null);
//        AVLNode<SortedKeyValue<K,V>> find = this.set.Search(kv);
//        return find!=null ? find.data.value : null;
//    }
//
//    @Override
//    public int size() {
//        return 0;
//    }
//
//    @Override
//    public boolean isEmpty() {
//        return false;
//    }
//
//    @Override
//    public boolean containsKey(Object key) {
//        return false;
//    }
//
//    @Override
//    public boolean containsValue(Object value) {
//        return false;
//    }
//
//    @Override
//    public V get(Object key) {
//        return null;
//    }
//
//    @Override
//    public V put(K key, V value)
//    {
//        SortedKeyValue<K,V> kv = new SortedKeyValue<K,V>(key,value);
//            this.set.insert(kv);
//        return value;
//    }
//
//    @Override
//    public V remove(Object key) {
//        return null;
//    }
//
//    @Override
//    public void putAll(Map<? extends K, ? extends V> m) {
//
//    }
//
//    @Override
//    public void clear() {
//
//    }
//
//    @Override
//    public Set<K> keySet() {
//        return null;
//    }
//
//    @Override
//    public Collection<V> values() {
//        return null;
//    }
//
//    @Override
//    public Set<Entry<K, V>> entrySet() {
//        return null;
//    }
//
//    public V remove(K key)
//    {
//        return this.set.delete(new SortedKeyValue<K,V>(key,null)).value;
//    }
//
//    @Override
//    public String toString()
//    {
//        return this.set.toString();
//    }
//
//}
