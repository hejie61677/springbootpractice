package com.hejie.springbootpractice.util;

import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @Program: springbootpractice
 * @Description: 工具类 Page4Navigator 用以替换 原本分页查询要返回的 org.springframework.data.domain.Page 类。 原因是 Page 类对json 还原不支持，在放如 Redis 之后，再拿出来，就会报错失败。使用 Page4Navigator 对其包裹，就解决了这个问题了。
 * @Author: hejie
 * @Create: 2020-05-25 15:09
 */
public class Page4Navigator<T> {
    private Page<T> page4jpa;
    private int navigatePages;
    private int totalPages;
    private int number;
    private long totalElements;
    private int size;
    private int numberOfElements;
    private List<T> content;
    private boolean isHasContent;
    private boolean first;
    private boolean last;
    private boolean isHasNext;
    private boolean isHasPrevious;
    private int[] navigatepageNums;

    public Page4Navigator() {
        //这个空的分页是为了 Redis 从 json格式转换为 Page4Navigator 对象而专门提供的
    }

    public Page4Navigator(Page<T> page4jpa,int navigatePages) {
        this.page4jpa = page4jpa;
        this.navigatePages = navigatePages;

        totalPages = page4jpa.getTotalPages();
        number  = page4jpa.getNumber() ;
        totalElements = page4jpa.getTotalElements();
        size = page4jpa.getSize();
        numberOfElements = page4jpa.getNumberOfElements();
        content = page4jpa.getContent();
        isHasContent = page4jpa.hasContent();
        first = page4jpa.isFirst();
        last = page4jpa.isLast();
        isHasNext = page4jpa.hasNext();
        isHasPrevious  = page4jpa.hasPrevious();
        calcNavigatepageNums();
    }

    private void calcNavigatepageNums() {
        int[] navigatepageNums;
        int totalPages = getTotalPages();
        int num = getNumber();
        //当总页数小于或等于导航页码数时
        if (totalPages <= navigatePages) {
            navigatepageNums = new int[totalPages];
            for (int i = 0; i < totalPages; i++) {
                navigatepageNums[i] = i + 1;
            }
        } else { //当总页数大于导航页码数时
            navigatepageNums = new int[navigatePages];
            int startNum = num - navigatePages / 2;
            int endNum = num + navigatePages / 2;

            if (startNum < 1) {
                startNum = 1;
                //(最前navigatePages页
                for (int i = 0; i < navigatePages; i++) {
                    navigatepageNums[i] = startNum++;
                }
            } else if (endNum > totalPages) {
                endNum = totalPages;
                //最后navigatePages页
                for (int i = navigatePages - 1; i >= 0; i--) {
                    navigatepageNums[i] = endNum--;
                }
            } else {
                //所有中间页
                for (int i = 0; i < navigatePages; i++) {
                    navigatepageNums[i] = startNum++;
                }
            }
        }
        this.navigatepageNums = navigatepageNums;
    }

    public int getNavigatePages() {
        return navigatePages;
    }

    public void setNavigatePages(int navigatePages) {
        this.navigatePages = navigatePages;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(long totalElements) {
        this.totalElements = totalElements;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getNumberOfElements() {
        return numberOfElements;
    }

    public void setNumberOfElements(int numberOfElements) {
        this.numberOfElements = numberOfElements;
    }

    public List<T> getContent() {
        return content;
    }

    public void setContent(List<T> content) {
        this.content = content;
    }

    public boolean isHasContent() {
        return isHasContent;
    }

    public void setHasContent(boolean isHasContent) {
        this.isHasContent = isHasContent;
    }

    public boolean isFirst() {
        return first;
    }

    public void setFirst(boolean first) {
        this.first = first;
    }

    public boolean isLast() {
        return last;
    }

    public void setLast(boolean last) {
        this.last = last;
    }

    public boolean isHasNext() {
        return isHasNext;
    }

    public void setHasNext(boolean isHasNext) {
        this.isHasNext = isHasNext;
    }

    public boolean isHasPrevious() {
        return isHasPrevious;
    }

    public void setHasPrevious(boolean isHasPrevious) {
        this.isHasPrevious = isHasPrevious;
    }

    public int[] getNavigatepageNums() {
        return navigatepageNums;
    }

    public void setNavigatepageNums(int[] navigatepageNums) {
        this.navigatepageNums = navigatepageNums;
    }
}
