Size of Segment Tree with Holes
-------------------------------
A segment tree is a data structure that allows for efficient querying and updating of an array of values. It is particularly useful for answering range queries and performing range updates. Segment trees are commonly used in scenarios where there are frequent updates and queries on a range of elements.


n leaves (values in the array)
2n - 1 nodes

1 + 2 + 4 + 8 + 16 + ...
= 2 * (some power of 2) - 1

n = 2^3 + 1 = 9
```
                     (0-9)
                (0-4)    (5-9)
        (0-2) (3-4)        (5-7) (8-9)
    (0-1) 2    3 4      (5-6) 7     8 9
     0 1 _ _  __ _ _     5 6  __   __ __
     
10, 20, 30, 40, 50, 60, 60, 80, 90
```

n = 2^3 = 8
