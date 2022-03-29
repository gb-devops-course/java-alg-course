import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class HashTableImpl <K, V> implements HashTable<K, V> {

    private final LinkedList<Item<K, V>>[] data;
    private int size;

    static class Item<K, V> implements Entry<K, V> {
        private final K key;
        private V value;

        public Item(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return String.format("Item{key=%s, value=%s}", key, value);
        }
    }

    public HashTableImpl(int initialCapacity) {
        this.data = new LinkedList[initialCapacity];
    }

    public HashTableImpl() {
        this(16);
    }

    @Override
    public boolean put(K key, V value) {
        if (key == null) {
            return false;
        }

        if (size() == data.length) {
            return false;
        }

        int index = hashFunc(key);
        if (data[index] != null) {
            data[index].add(new Item<>(key, value));
            return true;
        }

        data[index] = new LinkedList<>() {{
            add(new Item<>(key, value));
        }};
        size++;

        return true;
    }

    private int hashFunc(K key) {
        return Math.abs(key.hashCode() % data.length);
    }

    @Override
    public V get(K key) {
        int index = hashFunc(key);
        if (data[index] != null) {
            for (Item<K, V> item : data[index]) {
                if (item.getKey().equals(key)) {
                    return item.value;
                }
            }
        }
        return null;
    }

    @Override
    public V remove(K key) {
        int index = hashFunc(key);

        List<Item<K, V>> values = data[index];
        if (values == null) {
            return null;
        }

        ListIterator<Item<K, V>> listIterator = values.listIterator();
        while (listIterator.hasNext()) {
            Item<K, V> item = listIterator.next();
            if (item.key.equals(key)) {
                listIterator.remove();
                return item.value;
            }
        }

        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void display() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < data.length; i++) {
            sb.append(String.format("%s = [%s]%n", i, data[i]));
        }
        return sb.toString();
    }
}
