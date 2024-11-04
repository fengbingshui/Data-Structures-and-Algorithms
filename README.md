# Data-Structures-and-Algorithms

# 1、递归

#### 1. 终止条件（Base Case）

$$
f(smallInput) = 直接解决
$$

即：当输入达到最简单的情况时，不再递归。

#### 2. 递归关系（Recursive Case）

$$
f(input)=f(smallerInput) + 某种操作
$$

即：将问题缩小到一个更简单的子问题，递归地求解，然后结合当前的操作完成大问题的解。

1.1、倒序打印单链表

```java
  public static void recursion(ListNode head,ArrayList<Integer> list){
        if(head != null){
            recursion(head.getNext(), list);
            list.add(head.getData());
        }
    } 
```



1.2、反转单链表

```java
public ListNode reverse(ListNode head) {
    // 终止条件：链表为空或只有一个节点
    if (head == null || head.next == null) {
        return head;
    }
    // 递归反转子链表
    ListNode newHead = reverse(head.next);
    // 调整指针方向，完成反转
    head.next.next = head;
    head.next = null;
    // 返回新的头节点
    return newHead;
}
```
