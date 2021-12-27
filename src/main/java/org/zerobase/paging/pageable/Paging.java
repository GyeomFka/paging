package org.zerobase.paging.pageable;

import org.zerobase.paging.repository.PostRepository;

public class Paging {

    public static final int NOW_PAGE_LIST_COUNT = 10;
    public static final int NOW_VIEW_NAVIGATION_PAGE = 10;

    private int nowPage; // 현재 페이지 ex)1page, 2page
    private int viewNavPage = NOW_VIEW_NAVIGATION_PAGE;  //페이지 네비게이션 보주는 수
    private int pageSize = NOW_PAGE_LIST_COUNT; //한 페이지에서 보여 줄 게시물 수
    private int totalNavPage; //page블록의 개수
    private int totalArticle = PostRepository.getTotalCount(); //전체 게시글 수
    private int startRow; //각 페이지 첫 시작 게시글
    private int endRow; //각 페이지 마지막 게시글

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
            this.totalNavPage = (totalArticle / pageSize) + 1;
        } else {
            this.totalNavPage = totalArticle / pageSize;
        }
    }

    public void setStartRow() {
        int indexPage = nowPage - 1;
        this.startRow = (indexPage * pageSize) + 1;
    }

    public void setEndRow() {
        if(totalArticle % pageSize > 0 && nowPage == totalNavPage) {
            this.endRow = totalArticle;
        } else {
            this.endRow = nowPage * pageSize;
        }
    }

    public int getNowPage() {
        return nowPage;
    }

    public int getTotalPage() {
        return totalNavPage;
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
                ", totalNavPage=" + totalNavPage +
                ", pageSize=" + pageSize +
                ", totalArticle=" + totalArticle +
                ", startRow=" + startRow +
                ", endRow=" + endRow +
                '}';
    }
}
