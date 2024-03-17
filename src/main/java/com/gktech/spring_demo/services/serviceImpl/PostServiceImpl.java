package com.gktech.spring_demo.services.serviceImpl;

import com.gktech.spring_demo.entity.Post;
import com.gktech.spring_demo.enums.PEnum;
import com.gktech.spring_demo.repositories.PostRepository;
import com.gktech.spring_demo.services.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor

public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    @Override
    public ResponseEntity<Map<PEnum, Object>> addPost(Post post) {
        HashMap<PEnum,Object> hashMap = new HashMap<>();
        try {
            postRepository.save(post);
            hashMap.put(PEnum.status, true);
            hashMap.put(PEnum.message,"Post is saved");
            hashMap.put(PEnum.result, post);
            return new ResponseEntity<>(hashMap,HttpStatus.OK);
        }catch (Exception ex) {
            hashMap.put(PEnum.status,false);
            hashMap.put(PEnum.error,"Post is not save");
            hashMap.put(PEnum.result,post);
            return new ResponseEntity<>(hashMap,HttpStatus.BAD_REQUEST);
        }

    }

    @Override
    public ResponseEntity<Map<PEnum, Object>> findPostById(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<Map<PEnum, Object>> deletePost(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<Map<PEnum, Object>> updatePost(Post post) {
        return null;
    }

    @Override
    public ResponseEntity<Map<PEnum, Object>> findPostAll(Post post) {
        return null;
    }
}
