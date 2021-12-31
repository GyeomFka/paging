package org.zerobase.paging.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.zerobase.paging.domain.Posts;
import org.zerobase.paging.pageable.Pageble;
import org.zerobase.paging.pageable.Paging;
import org.zerobase.paging.service.PagingService;
import org.zerobase.paging.service.PostService;

import java.util.List;
import java.util.Optional;

@Controller
public class PostController {

    private final PostService listService;
    private final PagingService pagingService;

    @Autowired
    public PostController(PostService listService, PagingService pagingService) {
        this.listService = listService;
        this.pagingService = pagingService;
    }

    @GetMapping("/")
    public String welcome() {
        listService.initialSetting();
        return "index";
    }
    
    //http://localhost:8080/postList?page=page
    /*@GetMapping("/postList")
    public String listPage(Model model, @RequestParam("page") Optional<Integer> page) {

        System.out.println("이거냐?");

        int nowPage = page.orElse(1);
        System.out.println("nowPage = " + nowPage);

        Paging paging = new Paging(nowPage);
        List<Posts> postList = listService.getPostList(paging);

        model.addAttribute("postList", postList);
        model.addAttribute("pagingConfigure", paging);

        return "listPage";
    }*/

    @GetMapping("/postList")
    public String listPage(Model model, @RequestParam(value = "page", defaultValue = "1") int nowPage) {

        int count = listService.count();
        int postNum = 10;
        int pageNum = (int)Math.ceil((double)count/postNum);
        int displayPost = (nowPage-1) * postNum;

        List<Posts> postList = listService.getPostList(displayPost, postNum);
        Pageble pageble = new Pageble(nowPage);


        model.addAttribute("postList", postList);
        model.addAttribute("pageble", pageble);

        return "listPage";
    }

}
