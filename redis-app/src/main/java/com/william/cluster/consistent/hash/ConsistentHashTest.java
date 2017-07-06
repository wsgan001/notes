package com.william.cluster.consistent.hash;

import java.util.stream.IntStream;

/**
 * Created by william on 17-7-6.
 */
public class ConsistentHashTest {
    private static final int DATA_COUNT = 100000;
    private static final String PRE_KEY = "hash_key:";

    public static void main(String[] args) {
//        testNormalHash();
        testConsistentHash();
    }

    public static void testConsistentHash() {
        Cluster cluster = new ConsistencyHashCluster();
        cluster.addNode(new Node("c1.yywang.info", "192.168.0.1"));
        cluster.addNode(new Node("c2.yywang.info", "192.168.0.2"));
        cluster.addNode(new Node("c3.yywang.info", "192.168.0.3"));
        cluster.addNode(new Node("c4.yywang.info", "192.168.0.4"));

        IntStream.range(0, DATA_COUNT)
                .forEach(index -> {
                    Node node = cluster.get(PRE_KEY + index);
                    node.put(PRE_KEY + index, "Test Data");
                });

        printCluster(cluster);
        try {
            Thread.sleep(3000);
            System.out.println("--------------------");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        cluster.addNode(new Node("c5.yywang.info", "192.168.0.5"));
        printCluster(cluster);
    }

    public static void testNormalHash() {
        Cluster cluster = new NormalHashCluster();
        cluster.addNode(new Node("c1.yywang.info", "192.168.0.1"));
        cluster.addNode(new Node("c2.yywang.info", "192.168.0.2"));
        cluster.addNode(new Node("c3.yywang.info", "192.168.0.3"));
        cluster.addNode(new Node("c4.yywang.info", "192.168.0.4"));

        IntStream.range(0, DATA_COUNT)
                .forEach(index -> {
                    Node node = cluster.get(PRE_KEY + index);
                    node.put(PRE_KEY + index, "Test Data");
                });

        printCluster(cluster);
        try {
            Thread.sleep(3000);
            System.out.println("--------------------");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        cluster.addNode(new Node("c5.yywang.info", "192.168.0.5"));
        printCluster(cluster);
    }

    private static void printCluster(Cluster cluster) {
        System.out.println("数据分布情况：");
        cluster.nodes.forEach(node -> {
            System.out.println("IP:" + node.getIp() + ",数据量:" + node.getData().size());
        });

        long hitCount = IntStream.range(0, DATA_COUNT)
                .filter(index -> cluster.get(PRE_KEY + index).get(PRE_KEY + index) != null)
                .count();
        System.out.println("缓存命中率：" + hitCount * 1f / DATA_COUNT);
    }
}
