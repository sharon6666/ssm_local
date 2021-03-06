package com.utils;

/**
 * Created by hspcadmin on 2018/9/28.
 */

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/**
 * 分页实体对象，包含了详细的数据信息，包括分页相关信息。
 * 添加transform方法用来转换类型
 */
public class Page<T> implements Serializable {
    private static final long serialVersionUID = 3509375972998939764L;
    public static String CURRENT_INDEX = "currentIndex";
    public static String PAGE_SIZE = "pageSize";
    public static String INDEX = "index";
    /**
     * 当前页
     */
    private int currentIndex;

    /**
     * 每页记录数
     */
    private int pageSize;

    /**
     * 总记录数
     */
    private int totalNumber;

    /**
     * 总页数
     */
    private int totalPage;

    /**
     * 下一页
     */
    private int nextIndex;

    /**
     * 上一页
     */
    private int preIndex;

    /**
     * 当前页的数据记录
     */
    private List<T> Items = Collections.emptyList();


    /**
     * @return
     */
    public int getPageSize() {
        return pageSize;
    }

    /**
     * @param totalNumber
     * @param currentIndex
     * @param pageSize
     * @param items
     */
    public Page(int totalNumber, int currentIndex, int pageSize, List<T> items) {
        this.totalNumber = totalNumber;
        this.currentIndex = currentIndex;
        this.pageSize = pageSize;
        this.Items = items;
    }

    public Page() {
        this.totalNumber = 0;
        this.currentIndex = 1;
        this.pageSize = 10;
    }

    /**
     * @param pageSize
     */
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * @return
     */
    public int getCurrentIndex() {
        return currentIndex;
    }

    /**
     * @param currentIndex
     */
    public void setCurrentIndex(int currentIndex) {
        this.currentIndex = currentIndex;
    }

    /**
     * @return
     */
    public int getTotalNumber() {
        return totalNumber;
    }

    /**
     * @param totalNumber
     */
    public void setTotalNumber(int totalNumber) {
        this.totalNumber = totalNumber;
    }

    /**
     * 总页数
     *
     * @return
     */
    public int getTotalPage() {

        int size = this.totalNumber / this.pageSize;
        if (this.totalNumber % this.pageSize != 0) {
            size = size + 1;
        }
        this.totalPage = size;

        return this.totalPage;
    }

    /**
     * 当前页的下一页，如果当前耶大于等于最后一页
     * 那么下一页就是最后一页。
     *
     * @return
     */
    public int getNextIndex() {

        if (this.currentIndex >= this.getTotalPage()) {
            this.nextIndex = this.currentIndex;
        } else {
            this.nextIndex = this.currentIndex + 1;
        }
        return nextIndex;
    }

    /**
     * 当前页的上一页，如果当前页小于第一页那么上一页为0
     *
     * @return
     */
    public int getPreIndex() {

        if (this.currentIndex <= 1) {
            this.preIndex = 0;
        } else {
            this.preIndex = this.currentIndex - 1;
        }

        return preIndex;
    }

    /**
     * @return
     */
    public List<T> getItems() {
        return Items;
    }

    /**
     * @param items
     */
    public void setItems(List<T> items) {
        Items = items;
    }

    public String replaceUrl(String url, int page) {

        if (url != null && url.indexOf("?") == -1) {
            return url + "?" + INDEX + "=" + page;
        }
        if (url != null && url.indexOf("index=") == -1) {
            return url + "&" + INDEX + "=" + page;
        }
        return url == null ? "" : url.replaceAll("index=\\d{1,}", INDEX + "=" + page);
    }

}