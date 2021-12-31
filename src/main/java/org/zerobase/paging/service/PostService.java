package org.zerobase.paging.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerobase.paging.domain.Posts;
import org.zerobase.paging.pageable.Paging;
import org.zerobase.paging.repository.PostRepository;

import java.util.List;

@Service
public class PostService {

    private final PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public void initialSetting() {
        postRepository.initialSetting();
    }

    public int count() {
        return postRepository.count();
    }

    public List<Posts> getAllList() {
        return postRepository.findAll();
    }

    public List<Posts> getPostList(Paging paging) {
        return postRepository.findInBound(paging);
    }

    public List<Posts> getPostList(int viewStartNumber, int postCount) {
        return postRepository.findInBound(viewStartNumber, postCount);
    }

}
