package org.zerobase.paging.pageable;

public class Pageble {
    int count = 127;
    int postNum = 10;
    int pageNum = 13;
    int displayPost = 10;
    int nowPage;

    public Pageble(int nowPage) {
        this.nowPage = nowPage;
    }

    public int getCount() {
        return count;
    }

    public int getPostNum() {
        return postNum;
    }

    public int getPageNum() {
        return pageNum;
    }

    public int getDisplayPost() {
        return displayPost;
    }

    public int getNowPage() {
        return nowPage;
    }
}
