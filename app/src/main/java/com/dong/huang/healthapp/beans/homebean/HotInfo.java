package com.dong.huang.healthapp.beans.homebean;

import java.util.List;

/**
 * Created by dong on 16/2/15.
 * 热门资讯
 */
public class HotInfo {
    /** 热门资讯列表 */
    private List<HotData> list;
    /** 每页大小 */
    private int pageSize;
    /** 当前页码 */
    private int pageNo;
    /** 总条目 */
    private int totalCount;

    public HotInfo() {
    }

    public HotInfo(List<HotData> list, int pageSize, int pageNo, int totalCount) {
        this.list = list;
        this.pageSize = pageSize;
        this.pageNo = pageNo;
        this.totalCount = totalCount;
    }

    public List<HotData> getList() {
        return list;
    }

    public void setList(List<HotData> list) {
        this.list = list;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    @Override
    public String toString() {
        return "HotInfo{" +
                "list=" + list +
                ", pageSize=" + pageSize +
                ", pageNo=" + pageNo +
                ", totalCount=" + totalCount +
                '}';
    }
}
