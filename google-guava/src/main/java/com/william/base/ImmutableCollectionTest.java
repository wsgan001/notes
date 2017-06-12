package com.william.base;import com.google.common.collect.ImmutableCollection;import com.google.common.collect.ImmutableList;import com.google.common.collect.ImmutableSet;import com.google.common.collect.Lists;import java.util.ArrayList;import java.util.Collection;import java.util.List;/** * Created by william on 2016/12/30. *//** * 为什么要使用不可变集合?     不可变对象有很多优点，包括：         当对象被不可信的库调用时，不可变形式是安全的；         不可变对象被多个线程调用时，不存在竞态条件问题；         不可变集合不需要考虑变化，因此可以节省时间和空间，所有不可变的集合都比它们的     可变形式有更好的内存利用率（分析和测试细节）；         不可变对象因为有固定不变，可以作为常量来安全使用；         创建对象的不可变拷贝是一项很好的防御性编程技巧，Guava 为所有 JDK 标准集合类型     和 Guava 新集合类型都提供了简单易用的不可变版本。 重要提示：  所有 Guava 不可变集合的实现都不接受 null 值。我们对 Google 内部的代码库做过详细研究，    发现只有 5%的情况需要在集合中允许 null 元素，剩下的 95%场景都是遇到 null 值就快速失败。如果你    需要在不可变集合中使用 null，请使用 JDK 中的 Collections.unmodifiableXXX 方法。更多细节建议请    参考“使用和避免 null”。 * * * * * */public class ImmutableCollectionTest {    public static void main(String[] args) {        useDemo();        defensiveCopyTest();    }    /**     不可变集合可以用如下多种方式创建：     copyOf 方法，如 ImmutableSet.copyOf(set);     of 方法，如 ImmutableSet.of(“a”, “b”, “c”)或 ImmutableMap.of(“a”, 1, “b”, 2);     Builder 工具，如     */    public static void useDemo() {        ImmutableCollection<String> immutableList = ImmutableList.of("william1", "william2", "william1");        System.out.println(immutableList);        ImmutableCollection<String> immutableSet = ImmutableSet.copyOf(immutableList);        System.out.println(immutableSet);        ImmutableSet<String> williamFamily = ImmutableSet.<String>builder().addAll(immutableList)                .add(new String("william3")).build();        System.out.println(williamFamily);    }    public static void defensiveCopyTest() {        ImmutableSet<String> foobar = ImmutableSet.of("foo", "bar", "baz");        defensiveCopy(foobar);    }    private static void defensiveCopy(Collection<String> collection) {        ImmutableList<String> defensiveCopy = ImmutableList.copyOf(collection);        System.out.println(defensiveCopy instanceof List);        /*         ImmutableList.copyOf(foobar)会智能地直接返回 foobar.asList(),它是一个 ImmutableSet 的常量时间复杂度的 List 视图。         作为一种探索，ImmutableXXX.copyOf(ImmutableCollection)会试图对如下情况避免线性时间拷贝：            在常量时间内使用底层数据结构是可能的——例如，ImmutableSet.copyOf(ImmutableList)就不能在常量时间内完成。            不会造成内存泄露——例如，你有个很大的不可变集合 ImmutableList hugeList， ImmutableList.copyOf(hugeList.subList(0, 10))        就会显式地拷贝，以免不必要地持有 hugeList 的引用。            不改变语义——所以 ImmutableSet.copyOf(myImmutableSortedSet)会显式地拷贝，因为和基于比较器的 ImmutableSortedSet 相比，        ImmutableSet对hashCode()和 equals 有不同语义。            在可能的情况下避免线性拷贝，可以最大限度地减少防御性编程风格所带来的性能开销。         */    }    public static void asList() {        /*                所有不可变集合都有一个 asList()方法提供 ImmutableList 视图，来帮助你用列表形式方便地读取集合元素。例如，          你可以使用 sortedSet.asList().get(k)从 ImmutableSortedSet 中读取第 k 个最小元素。                asList()返回的 ImmutableList 通常是——并不总是——开销稳定的视图实现，而不是简单地把元素拷贝进 List。          也就是说，asList 返回的列表视图通常比一般的列表平均性能更好，比如，在底层集合支持的情况下，它总是使用高效的          contains 方法。         */    }    /*    可变集合接口	属于JDK还是Guava	不可变版本    Collection	    JDK	                ImmutableCollection    List	        JDK	                ImmutableList    Set	            JDK	                ImmutableSet    SortedSet/NavigableSet	    JDK	    ImmutableSortedSet    Map	            JDK	                ImmutableMap    SortedMap	    JDK	                ImmutableSortedMap    Multiset	    Guava	            ImmutableMultiset    SortedMultiset	Guava	            ImmutableSortedMultiset    Multimap	    Guava	            ImmutableMultimap    ListMultimap	Guava	            ImmutableListMultimap    SetMultimap	    Guava	            ImmutableSetMultimap    BiMap	        Guava	            ImmutableBiMap    ClassToInstanceMap	        Guava	ImmutableClassToInstanceMap    Table	        Guava	            ImmutableTable     */}