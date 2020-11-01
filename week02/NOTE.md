学习笔记

1. HashMap小总结
    * HashMap根据key的hashCode值存储数据，大多数情况下可以直接定位到它的值，因而具有很快的访问速度，但遍历顺序却是不确定的；
    * HashMap最多只允许一条记录的键为null，允许多条记录的值为null；
    * HashMap非线程安全，即任一时刻可以有多个线程同时写HashMap，可能会导致数据的不一致。如果需要满足线程安全，可以用Collections的synchronizedMap方法使HashMap具有线程安全的能力，或者使用ConcurrentHashMap；
    * HashMap是数组+链表+红黑树实现的；
    * HashMap类中有一个非常重要的字段，就是Node[] table，即哈希桶数组；Node是HashMap的一个内部类，实现了Map.Entry接口，本质就是一个键值对映射；
    * HashMap就是使用哈希表来存储的，采用了链地址法，就是数组+链表的结合。在每个数组元素上都有一个链表结构，当数据被hash后，得到数组下标，把数据放到对应下标元素的链表上；
    * 在JDK1.8中，当链表长度太长（默认超过8）时，链表就转换为红黑树，利用红黑树快速增删改查的特性提高HashMap的性能；
    * HashMap常用的方法有：

        |  方法                  | 分析                                                             |
        | --------------------- | ---------------------------------------------------------------  |
        | void clear();  | 删除map中所有映射，即清空map；|
        | boolean containsKey(Object key);  | 如果map中包含指定key的映射关系，返回true；否则返回false；|
        | boolean containsValue(Object value);  | 如果map中有一个或多个key映射到指定value，返回true；否则返回false；|
        | Set<Map.Entry<K,V>> entrySet();  | 返回map中所有映射关系的一个集合；|
        | V get(Object key);  | 返回map中指定key映射到的value值；如果map中不存在这个key的映射关系，返回null；|
        | V getOrDefault(Object key, V defaultValue);  | 返回map中指定key映射到的value值；如果map中不存在这个key的映射关系，返回默认值defaultValue；|
        | boolean isEmpty();  | 如果map中不包含任何键值对的映射关系，返回true；否则返回false；|
        | Set<K> keySet();  | 返回map中所有key的集合；|
        | V put(K key, V value);  | 在map中将指定value与指定key建立起映射关系；|
        | void putAll(Map<? extends K, ? extends V> m);  | 将指定map中所有的映射关系拷贝到当前map中；如果key在当前map中已经存在，则用传入的指定map中的映射关系替换掉当前map中已有的；|
        | V putIfAbsent(K key, V value);  | 如果指定key在当前map中还没有映射关系的话，将其与指定的value建立起映射关系，并返回null；否则，返回它在map中映射到的value值；|
        | V remove(Object key);  | 删除指定key在map中的映射关系；如果之前key有映射到的value值，则返回该value；否则返回null；|
        | boolean remove(Object key, Object value);  | 只有当在map中指定当key映射到指定到value时，删除该映射关系；删除成功返回true，否则返回false；|
        | int size();  | 返回map中键值对的数量；|
        | Collection<V> values();  | 返回map中所有value值的一个集合。|