package com.gktech.spring_demo.restControllers;

import com.gktech.spring_demo.entity.Post;
import com.gktech.spring_demo.enums.PEnum;
import com.gktech.spring_demo.services.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.event.PaintEvent;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/post")
public class PostController {
    @Autowired
    private PostService postService;
    @PostMapping("/add")
    public ResponseEntity<Map<PEnum,Object>> addPost(@RequestBody Post post) {
        /*System.out.println(post.getTitle());
        System.out.println("ID: " + post.getId());
        post.setId(Long.valueOf(1));
        System.out.println("ID2s: " + post.getId()); */
        return postService.addPost(post);
    }

    @PutMapping("/update")
    public ResponseEntity<Map<PEnum,Object>> updatePost(@RequestBody Post post) {
        return postService.updatePost(post);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Map<PEnum,Object>> deletePost(@RequestParam Long id) {
        return postService.deletePost(id);
    }

    @GetMapping("/getPost")
    public ResponseEntity<Map<PEnum,Object>> findPostById(@RequestParam Long id) {
        return postService.findPostById(id);
    }

    @GetMapping("/getAllPost")
    public ResponseEntity<Map<PEnum,Object>> findPostAll() {
        return postService.findPostAll();
    }
}
