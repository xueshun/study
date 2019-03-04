
<!-- TOC -->

- [散列表](#散列表)
    - [散列表的核心](#散列表的核心)
        - [散列函数设计](#散列函数设计)
        - [散列冲突解决](#散列冲突解决)
            - [开放发寻址法](#开放发寻址法)
            - [链表法](#链表法)
    - [如何打造一个工业级水平的散列表？](#如何打造一个工业级水平的散列表)
        - [散列函数](#散列函数)
        - [装载因子过大怎么办？](#装载因子过大怎么办)
        - [如何避免低效地扩容？](#如何避免低效地扩容)
        - [如何选择解决冲突方法？](#如何选择解决冲突方法)
            - [开放寻址法](#开放寻址法)
            - [链表法](#链表法-1)
        - [工业级的散列表应该具有哪些特性？](#工业级的散列表应该具有哪些特性)
        - [如何设计这样的散列表](#如何设计这样的散列表)

<!-- /TOC -->
## 散列表
散列表用的是数组支持按照下标随机访问数据的特性，所以散列表起始就是数组的一中扩展，
又数组演化而来。可以说，如果没有数组，就没有散列表。

### 散列表的核心
1. 散列函数设计
2. 散列冲突解决

#### 散列函数设计
散列函数设计的基本要求
1. 散列函数计算得到的散列值是一个非负整数；
2. 如果key1 = key2,那hash(key1)==hash(key2);
3. 如果key1 ≠ key2,那hash(key1)≠hash(key2);

这个要求看起来合情合理，但是在真实的情况下，要想找到一个不同的 key 对应的散列值都不一样的散列函数，几乎是不可能的。
即便像业界著名的[MD5]、[SHA]、[CRC]等哈希算法，也无法避免这种散列冲突。

#### 散列冲突解决
常用的散列冲突解决方法有两类，开放寻址法（open addressing）和列表法（chaining）

##### 开放发寻址法
开放寻址法的核心思想,如果出现了散列冲突，我们就重新探测一个空闲微信，将其插入。那如何重新探测新的位置呢？
1. 线性特测（Linear Probing）。 当我们往散列表中插入数据时，如果某个数据经过散列函数散列之后。存储位置已经被占用了，我们就从当前位置开始，依次往后查找，看是否有空闲位置，直到找到为止
2. 二次探测（Quadratic Probing）。所谓二次探测，跟线性探测很像，线性探测的步长是1(hash(key)+0,hash(key)+1,....)。二次探测的步长就变成了原来的“二次方”，也就是说，它的探测下标就是hash(key)+0,hash(key)+1<sup>2</sup>,hash(key)+2<sup>2</sup>
3. 双重散列(Double hasHing)。所谓双重散列，意思就是不仅要使用一个散列函数。我们使用一组散列函数 hash1(key)，hash2(key)，hash3(key)……我们先用第一个散列函数，如果计算得到的存储位置已经被占用，再用第二个散列函数，依次类推，直到找到空闲的存储位置。

`装载因子（load factor）`
```
散列表的装载因子 = 填入表中的元素个数 / 散列表的长度
```
装载因子越大，说明空闲位置越少，冲突越多，散列表的性能会下降。

##### 链表法
可以参考Java hashMap

### 如何打造一个工业级水平的散列表？

如何设计一个可以应对各种异常情况的工业级散列表，来避免在散列冲突的情况下，散列表性能的急剧下降，并且能抵抗散列碰撞攻击？

#### 散列函数
首先，散列函数的设计不能太复杂。过于复杂地散列函数，势必会消耗很多计算时间，也就间接地影响到散列表地性能。
其次，散列函数生成的值尽可能随机并且均匀分布，这样才能避免或者最小化散列冲突，而且即便出现冲突，散列到每个槽的数据也会比较均匀，不会出现某个槽内数据特别多的情况。

#### 装载因子过大怎么办？
当散列表的装载因子超过某个阈值时，就需要进行扩容。装载因子阈值需要选择得当。如果太大，会导致冲突过多；如果太小，会导致内存浪费严重。

装载因子阈值的设置要权衡时间、空间复杂度。如果内存空间不紧张，对执行效率要求很高，可以降低负载因子的阈值；相反，如果内存空间紧张，对执行效率要求又不高，可以增加负载因子的值，甚至可以大于 1。

#### 如何避免低效地扩容？

当有新数据要插入时，我们将新数据插入新散列表中，并且从老的散列表中拿出一个数据放入到新散列表。每次插入一个数据到散列表，我们都重复上面的过程。经过多次插入操作之后，老的散列表中的数据就一点一点全部搬移到新散列表中了。这样没有了集中的一次性数据搬移，插入操作就都变得很快了。

这期间的查询操作怎么来做呢？对于查询操作，为了兼容了新、老散列表中的数据，我们先从新散列表中查找，如果没有找到，再去老的散列表中查找。

通过这样均摊的方法，将一次性扩容的代价，均摊到多次插入操作中，就避免了一次性扩容耗时过多的情况。这种实现方式，任何情况下，插入一个数据的时间复杂度都是 O(1)。

#### 如何选择解决冲突方法？

两种主要的散列冲突的解决办法，开放寻址法和链表法。这两种冲突解决办法在实际的软件开发中都非常常用。比如，Java 中 LinkedHashMap 就采用了链表法解决冲突，ThreadLocalMap 是通过线性探测的开放寻址法来解决冲突。那你知道，这两种冲突解决方法各有什么优势和劣势，又各自适用哪些场景吗？

##### 开放寻址法
1. 优点：开放寻址法不像链表法，需要拉很多链表。散列表中的数据都存储在数组中，可以有效地利用 CPU 缓存加快查询速度。而且，这种方法实现的散列表，序列化起来比较简单。链表法包含指针，序列化起来就没那么容易。可不要小看序列化，很多场合都会用到的。
2. 缺点：用开放寻址法解决冲突的散列表，删除数据的时候比较麻烦，需要特殊标记已经删除掉的数据。而且，在开放寻址法中，所有的数据都存储在一个数组中，比起链表法来说，冲突的代价更高。所以，使用开放寻址法解决冲突的散列表，装载因子的上限不能太大。这也导致这种方法比链表法更浪费内存空间。

当数据量比较小、装载因子小的时候，适合采用开放寻址法。这也是 Java 中的的ThreadLocalMap使用开放寻址法解决散列冲突

##### 链表法
首先，链表法对内存的利用率比开放寻址法要高。因为链表结点可以在需要的时候再创建，并不需要像开放寻址法那样事先申请好。实际上，这一点也是链表优于数组的地方。
我总结一下，基于链表的散列冲突处理方法比较适合存储大对象、大数据量的散列表，而且，比起开放寻址法，它更加灵活，支持更多的优化策略，比如用红黑树代替链表

#### 工业级的散列表应该具有哪些特性？

- 支持快速的查询、插入、删除操作
- 内存占用合理，不能浪费过多的内存空间
- 性能稳定，极端境况下，散列的性能也不会退化到无法结束的情况。

#### 如何设计这样的散列表

- 设计一个合适的散列函数
- 定义装载因子阈值，并且设置动态扩容策略
- 选择合适的散列冲突解决方法。

[MD5]:https://zh.wikipedia.org/wiki/MD5
[SHA]:https://zh.wikipedia.org/wiki/SHA%E5%AE%B6%E6%97%8F
[CRC]:https://zh.wikipedia.org/wiki/%E5%BE%AA%E7%92%B0%E5%86%97%E9%A4%98%E6%A0%A1%E9%A9%97