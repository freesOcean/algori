
/**
 * 基于链表实现的跳表 跳表的插入，删除和查找时间复杂度是O(logn)
 * 
 * redis中使用跳表，而非红黑树 相比红黑树，它的代码实现逻辑更加简单，所以不易出错 另外，redis中的查找指定区间的值，用跳表更加快速。
 */
public class SkipList {

    public int MAX_LEVEL = 16;
    public float SKIP_P = 0.5f;
    public Node head = new Node();
    public int skip_level = 1;

    public Node find(int value) {

        Node p = head;
        for (int i = skip_level; i >= 0; --i) {
            while (p.forward[i] != null && p.forward[i].data < value) {
                p = p.forward[i];
            }
        }

        if (p.forward[0] != null && p.forward[0] == value) {
            return p.forward[0];
        } else {
            return null;
        }
    }

    public void insert(int value) {
        // 随机产生一个层级，在这些层级中插入该数
        int level = RandomLevel();

        // 准备要插入的结点
        Node newNode = new Node();
        newNode.data = value;
        newNode.maxlevel = level;

        // 查找每一级中最后一个小于插入值的值，并存起来
        Node[] update = new Node[level];
        Node p = head;
        for (int i = level - 1; i >= 0; --i) {
            while (p.forward[i] != null && p.forward[i].data < value) {
                p = p.forward[i];
            }
            update[i] = p;
        }

        // 更新update中接后继指针
        for (int i = 0; i < level; ++i) {
            newNode.forward[i] = update[i].forward[i];
            update[i].forward[i] = newNode;
        }

        // 更新skip_level
        if (level > skip_level) {
            skip_level = level;
        }
    }

    public void delete(int value) {

        Node[] update = new Node[skip_level];
        Node p = head;
        for (int i = skip_level; i >= 0; --i) {
            while (p.forward[i] != null && p.forward[i].data < value) {
                p = p.forward[i];
            }

            update[i] = p;
        }

        // 如果删除的节点存在
        if (p.forward[0] != null && p.forward[0] == value) {
            for (int i = skip_level - 1; i >= 0; --i) {
                if (update[i].forward[i] != null && update[i].forward[i] == value) {
                    update[i].forward[i] = update[i].forward[i].forward[i];
                }
            }
        }

        // 更新总索引层级：保证最高层级至少有两个节点
        while (skip_level > 1 && head.forward[skip_level] != null) {
            --skip_level;
        }

    }

    /**
     * 随机生成一个层级，理论上，出现 1的概率是50%， 出现2的概率是 25% ， ....
     * 
     * @return
     */
    public int RandomLevel() {
        int level = 1;
        while (Math.random() > SKIP_P && level < MAX_LEVEL) {
            level+=1;
        }
        return level;
    }

    class Node {
        public int data = -1;
        //记录节点的后继指针，不同层级的后继指针放在不同的下标处。
        public Node[] forward = new Node[MAX_LEVEL];
        //当前节点的最高层级
        public int maxlevel = 0;

        @Override
        public String toString() {
            return "data:" + data + "level:" + maxlevel;
        }
    }

}
