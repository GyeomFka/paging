package org.zerobase.paging.pageable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.zerobase.paging.repository.PostRepository;

public class Paging {

    public static final int NOW_PAGE_LIST_COUNT = 10;

    private int nowPage; // 1,2,3 현재 페이징
    private int totalPage; //page블록의 개수
    private int pageSize = NOW_PAGE_LIST_COUNT;
    private int totalArticle = PostRepository.getTotalCount();
    private int startRow;
    private int endRow;

    public Paging(int nowPage) {
        validateNowPage(nowPage);
        setTotalPage();
        setStartRow();
        setEndRow();
        System.out.println(toString());
    }

    private void validateNowPage(int nowPage) {
        if(nowPage <= 0) {
          this.nowPage = 1;
        }
        this.nowPage = nowPage;
    }

    public void setTotalPage() { //끝자리의 몇개인지도 구해야함.
        if(totalArticle % pageSize > 0) {
            this.totalPage = (totalArticle / pageSize) + 1;
        } else {
            this.totalPage = totalArticle / pageSize;
        }
    }

    public void setStartRow() {
        int indexPage = nowPage - 1;
        this.startRow = (indexPage * pageSize) + 1;
    }

    public void setEndRow() {
        if(totalArticle % pageSize > 0 && nowPage == totalPage) {
            this.endRow = totalArticle;
        } else {
            this.endRow = nowPage * pageSize;
        }
    }

    public int getNowPage() {
        return nowPage;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public int getTotalArticle() {
        return totalArticle;
    }

    public int getStartRow() {
        return startRow;
    }

    public int getEndRow() {
        return endRow;
    }

    @Override
    public String toString() {
        return "Paging{" +
                "nowPage=" + nowPage +
                ", totalPage=" + totalPage +
                ", pageSize=" + pageSize +
                ", totalArticle=" + totalArticle +
                ", startRow=" + startRow +
                ", endRow=" + endRow +
                '}';
    }
}
