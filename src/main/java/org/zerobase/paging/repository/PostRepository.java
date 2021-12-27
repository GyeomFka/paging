package org.zerobase.paging.repository;

import org.springframework.stereotype.Repository;
import org.zerobase.paging.domain.Posts;
import org.zerobase.paging.pageable.Paging;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class PostRepository {

    private static final int TOTAL_COUNT = 127;
    public static final String TEMPORARY_NAME = "spring_";
    private static List<Posts> list = new ArrayList<>();

    public static int getTotalCount() {
        return TOTAL_COUNT;
    }

    public void initialSetting() {
        for(int i = 1; i <= TOTAL_COUNT; i++) {
            list.add(new Posts(i, TEMPORARY_NAME + i));
        }
    }

    public List<Posts> findAll() {
        return list;
    }

    public List<Posts> findInBound(Paging paging) {
        List<Posts> listInBound = new ArrayList<>();
        int startRow = paging.getStartRow();
        int endRow = paging.getEndRow();
        for(int i = startRow; i <= endRow; i++) {
            listInBound.add(list.get(i-1));
        }
        return listInBound;
    }
}
