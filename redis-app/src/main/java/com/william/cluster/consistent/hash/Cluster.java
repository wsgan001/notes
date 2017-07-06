package com.william.cluster.consistent.hash;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * Created by william on 17-7-6.
 */
public abstract class Cluster {

    protected List<Node> nodes;

    public Cluster() {
        this.nodes = Lists.newArrayList();
    }

    public abstract void addNode(Node node);
    public abstract void removeNode(Node node);
    public abstract Node get(String key);

    protected long hash(String str) {
        return Math.abs(Integer.valueOf(str.hashCode()).longValue());
    }
}
