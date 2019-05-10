package com.cwh.design.iterator;

/**
 * @author cwh
 * @date 2019/5/7
 */
public class MyCollection implements Collection {
    private String[] strs = {"A", "B", "C", "D", "E", "F", "G"};
    @Override
    public Iterator iterator() {
        return new MyIterator();
    }

    @Override
    public Object get(int i) {
        return strs[i];
    }

    @Override
    public int size() {
        return strs.length;
    }
}
