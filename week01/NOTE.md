学习笔记

1. Queue 源码分析
    * 在Java中，Queue是一个Interface，继承了Collection接口；
    * Queue包含了许多实现类，包括了LinkedList、PriorityQueue、ArrayDeque等；
    * 包含的操作有：

        |  方法                  | 分析                                                             |
        |  -------------------- | ---------------------------------------------------------------  |
        | boolean add(E e);     | 插入操作，返回布尔值，如果空间不够抛出IllegalStateException异常；       |
        | boolean offer(E e);   | 插入操作，类似add()方法，区别是空间不够时不抛出异常；                    |
        | E remove();           | 获取并删除Queue首元素，如果队列为空，抛出NoSuchElementException异常；   |
        | E poll();             | 获取并删除Queue首元素，类似remove()，区别是队列为空时不抛异常返回null；   |
        | E element();          | 获取Queue首元素，如果队列为空，抛出NoSuchElementException异常；        |
        | E peek();             | 获取Queue首元素，类似element()，区别是队列为空时不抛异常返回null；       |


2. PriorityQueue源码分析
    * 在Java中，PriorityQueue是一个Class，继承了AbstractQueue抽象类，间接实现Queue接口；
    * 利用平衡二叉堆（Balanced Binary Heap）实现，以Object[] queue数组存放元素，queue[n]的两个子节点分别为queue[2*n+1]和queue[2*n+2]；
    * 默认的初始容量为11；
    * 通过comparator来排序，如果comparator为null，则使用元素的自然序；
    * 默认小顶堆，即最小优先队列；
    * 7个构造函数：前4个对应不同的初始容量和排序方式的入参组合；后3个对应通过传入一个PriorityQueue或SortedSet或者其他Collection的方式来初始化一个PriorityQueue；
    * 主要操作有：

        |  方法                         | 分析                                                             |
        |  --------------------------- | ---------------------------------------------------------------  |
        | boolean add(E e);            | 插入操作，直接调用下面的offer()方法；       |
        | boolean offer(E e);          | 插入操作；如果e为null则抛NullPointerException异常；如果e无法通过该PriorityQueue的排序方式与其已有元素进行比较，则返回ClassCastException异常；容量不够时通过grow()方法进行扩容；                    |
        | boolean remove(Object o);    | 删除操作；当且仅当优先队列中包含该元素或值相等元素时返回true，调用removeAt()方法执行实际的删除；   |
        | boolean removeEq(Object o);  | 删除操作；与remove()方法的区别是使用引用相等，而非值相等的方式，来找到元素执行删除操作；   |
        | E peek();                    | 获取PriorityQueue首元素，如果队列为空，则返回null；        |
        | boolean contains(Object o);         | 判断是否包含某元素；       |
        | Object[] toArray();                        | 返回一个包含了PriorityQueue中所有元素的数组；不再维护排序；该方法是array-based APIs和collection-based APIs之间的桥梁；该方法会新分配一块数组空间；   
        | <T> T[] toArray(T[] a);                         | 与上面的方法类似，区别是该方法会把PriorityQueue中所有元素放到传入的数组中，节省了新分配数组空间的开销；但如果传入的数组长度不够的话，还是会新建一个数组；   
        | Iterator<E> iterator();                         | 返回当前PriorityQueue的一个迭代器；   
        | void clear();                         | 删除当前PriorityQueue中所有元素，使其size为0；  
        | E poll();                        | 删除PriorityQueue首元素，即最小堆堆顶元素；  