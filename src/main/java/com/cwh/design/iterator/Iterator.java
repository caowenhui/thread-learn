package com.cwh.design.iterator;

public interface Iterator {
    /**
     * 前移
     */
    Object previous();

    /**
     * 后移
     *
     * @return
     */
    Object next();

    boolean hasNext();

    /**
     * 获取第一个元素
     *
     * @return
     */
    Object first();
}
