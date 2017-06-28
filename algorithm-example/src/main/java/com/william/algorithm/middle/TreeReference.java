package com.william.algorithm.middle;

/**
 * Created by william on 17-6-27.
 */
public class TreeReference {
    /**
        树(tree)是 n(n >= 0)个结点的有限集。
        1) 或者是一棵空树(n = 0),空树中不包含任何结点。
        2) 或者是一棵非空树(n > 0),此时有且仅有一个特定的称为根(root)的结点;
        当n > 1 时,其余结点可分为m(m > 0)个互不相交的有限集T 1,T 2 ,...,T m ,
        其中每一个本身又是一棵树,并且称为根的子树(sub tree)。

        结点的层次和树的深度  h (h >= 0)
        树中结点的最大层次数称为树的深度(Depth)或高度

        结点的度与树的度     d (d >= 0)
        结点拥有的子树的数目称为结点的度(Degree);
        度为 0 的结点称为叶子(leaf)或终端结点,度不为 0 的结点称为非终端结点或分支结点。

        在树结构中有一个重要的性质如下:
        性质1) 树中的结点数等于树的边数加 1,也等于所有结点的度数之和加 1。
            这是因为除根结点以外每个结点都与指向它的一条边对应,所以除根结点以外的结点数
         等于树中边数之和。因此树中的结点数等于树的边数加 1。而边数之和就是所有结点的度数
         之和,因此树中的结点数也等于所有结点的度数之和加 1。

        树的路径
            在树中k+1 个结点通过k条边连接构成的序列{(v0 , v1),(v1 , v2), ... ,(vk-1 , vk)| k ≥ 0},
        称为长度为k的路径(path)。

        祖先、子孙、堂兄弟

        有序树、m叉树、森林
            如果将树中结点的各子树看成是从左至右是有次序的,则称该树为 有序树;若不考虑子
        树的顺序则称为 无序树。
            树中所有结点最大度数为 m 的有序树称为 m 叉树
            森林(forest)是 m(m ≥ 0 )棵互不相交的树的集合。
     */

    abstract class TreeADT {
        /**
         数据对象 D: D 是具有相同性质的数据元素的集合。
         数据关系 R: 若 D=Φ 则 R =Φ; 若 D≠Φ,则 R = {H},H 是如下二元关系:
             1) 在 D 中存在一个唯一的称为根的元素 root,它在 H 下无前驱;
             2) 除 root 以外,D 中每个结点在 H 下都有且仅有一个前驱。
         */
        //(1) 输入参数:无 返回参数:非负整数 功能:返回树的结点数
        public abstract int getSzie ();

        //(2) 输入参数:无 返回参数:结点 功能:返回树根结点
        public abstract Object getRoot();

        //(3) 输入参数:结点 x 返回参数:结点 功能:返回结点 x 的父结点
        public abstract Object getParent(Object node);

        //(4) 输入参数:结点 x 返回参数:结点 功能:返回结点 x 的第一个孩子
        public abstract Object getFirstChild(Object node);

        //(5) 输入参数:结点 x 返回参数:结点 功能:返回结点 x 的下一个兄弟结点,如果 x 是最后一个孩子,则返回空
        public abstract Object getNextSibling(Object node);

        //(6) 输入参数:无 返回参数:整数 功能:返回以 x 为根的树的高度
        public abstract Object getHeight(Object node);

        //(7) 输入参数:结点 x、结点 child 返回参数:无 功能:将结点 child 为根的子树插入树中,作为结点 x 的子树
        public abstract Object insertChild(Object node, Object child);

        //(8) 输入参数:结点 x、整数 i 返回参数:无 功能:删除结点 x 的第 i 棵子树
        public abstract Object deleteChild(Object node, int i);

        //(9) 输入参数:结点 x, 线性表 list 返回参数:迭代器 功能:先序、后序、按层遍历 x 为根的树。
        public abstract Object preOrder(Object node);
        public abstract Object postOrder(Object node);
        public abstract Object levelOrder(Object node);
    }
}
