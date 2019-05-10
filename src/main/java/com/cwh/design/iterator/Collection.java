package com.cwh.design.iterator;

/**
 * @author cwh
 * @date 2019/5/7
 */
public interface Collection {
    Iterator iterator();

    /**
     * 获取元素
     *
     * @param i
     * @return
     */
    Object get(int i);

    /**
     * 集合大小
     *
     * @return
     */
    int size();
}
