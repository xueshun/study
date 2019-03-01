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
常用的散列冲突解决方法有两类，开发寻址法（open addressing）和列表法（chaining）

##### 开发寻址法
##### 链表法

[MD5]:https://zh.wikipedia.org/wiki/MD5
[SHA]:https://zh.wikipedia.org/wiki/SHA%E5%AE%B6%E6%97%8F
[CRC]:https://zh.wikipedia.org/wiki/%E5%BE%AA%E7%92%B0%E5%86%97%E9%A4%98%E6%A0%A1%E9%A9%97