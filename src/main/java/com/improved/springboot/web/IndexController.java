package com.improved.springboot.web;

import com.improved.springboot.config.auth.LoginUser;
import com.improved.springboot.config.auth.dto.SessionUser;
import com.improved.springboot.service.PostsService;
import com.improved.springboot.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user){//어느 컨트롤러든지 @LoginUser만 사용하면 세션정보가져오기 가능
        model.addAttribute("posts",postsService.findAllDesc());

        if(user != null){//세션에 저장된 값이 있을때만 userName등록
            model.addAttribute("userName",user.getName());
        }
        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave(){
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id,Model model){
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("posts",dto);
        return "posts-update";
    }
}
