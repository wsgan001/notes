package com.william.example.classloader;

import java.util.Stack;

/**
 * Created by william on 17-10-14.
 */
public class ClassLoaderTest {

    /**
     *  1.类加载器:
     *    引导类加载器     -这里未打印
     *    扩展类加载器     -ExtClassLoader
     *    应用程序类加载器  -AppClassLoader
     */
    public static void main(String[] args) {
        ClassLoader loader = ClassLoaderTest.class.getClassLoader();
        Stack<String> loaderTree = new Stack<String>();
        while (loader != null) {
            loaderTree.push(loader.toString());
            loader = loader.getParent();
        }
        String linePrefix = "|";
        while (!loaderTree.empty()) {
            System.out.println(linePrefix + "  " + loaderTree.pop());
            linePrefix += linePrefix;
        }
    }

    /**
     *  2.
     */
    public void testClassIdentity() {

    }

    public class Sample {
        private Sample instance;

        public void setSample(Object instance) {
            this.instance = (Sample) instance;
        }
    }
}
