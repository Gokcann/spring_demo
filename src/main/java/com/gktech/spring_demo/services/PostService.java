package com.gktech.spring_demo.services;

import com.gktech.spring_demo.entity.Post;
import com.gktech.spring_demo.enums.PEnum;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface PostService {
    public ResponseEntity<Map<PEnum,Object>> addPost(Post post);
    public ResponseEntity<Map<PEnum,Object>> findPostById(Long id);
    public ResponseEntity<Map<PEnum,Object>> deletePost(Long id);
    public ResponseEntity<Map<PEnum,Object>> updatePost(Post post);

    public ResponseEntity<Map<PEnum,Object>> findPostAll(Post post);
}
