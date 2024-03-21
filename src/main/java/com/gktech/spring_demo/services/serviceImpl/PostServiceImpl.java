package com.gktech.spring_demo.services.serviceImpl;

import com.gktech.spring_demo.entity.Post;
import com.gktech.spring_demo.enums.PEnum;
import com.gktech.spring_demo.repositories.PostRepository;
import com.gktech.spring_demo.services.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static com.gktech.spring_demo.enums.PEnum.*;

@RequiredArgsConstructor
@Service

public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;

    @Override
    public ResponseEntity<Map<PEnum, Object>> addPost(Post post) {
        HashMap<PEnum, Object> hashMap = new HashMap<>();
        try {
            postRepository.save(post);
            hashMap.put(PEnum.status, true);
            hashMap.put(PEnum.message, "Post is saved");
            hashMap.put(PEnum.result, post);
            return new ResponseEntity<>(hashMap, HttpStatus.OK);
        } catch (Exception ex) {
            hashMap.put(PEnum.status, false);
            hashMap.put(PEnum.error, "Post is not save");
            hashMap.put(PEnum.result, post);
            return new ResponseEntity<>(hashMap, HttpStatus.BAD_REQUEST);
        }

    }

    @Override
    public ResponseEntity<Map<PEnum, Object>> findPostById(Long id) {
        HashMap<PEnum, Object> hashMap = new HashMap<>();
        Post post = postRepository.findById(id).orElse(null);
        if (post != null) {
            hashMap.put(status, true);
            hashMap.put(result, post);
            return new ResponseEntity<>(hashMap, HttpStatus.OK);
        }
        hashMap.put(status, false);
        hashMap.put(error, "Not Found Post With " + id);
        return new ResponseEntity<>(hashMap, HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<Map<PEnum, Object>> deletePost(Long id) {
        HashMap<PEnum, Object> hashMap = new HashMap<>();
        boolean hasPost = postRepository.existsById(id);
        if (hasPost) {
            postRepository.deleteById(id);
            hashMap.put(status, true);
            hashMap.put(message, "User is deleted");
            return new ResponseEntity<>(hashMap, HttpStatus.OK);
        }
        hashMap.put(status, false);
        hashMap.put(error, "Not Found Post");
        return new ResponseEntity<>(hashMap, HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<Map<PEnum, Object>> updatePost(Post post) {
        HashMap<PEnum, Object> hashMap = new HashMap<>();
        Optional<Post> optionalPost = postRepository.findById(post.getId());
        if (optionalPost.isPresent()) {
            postRepository.saveAndFlush(post);
            hashMap.put(PEnum.status, true);
            hashMap.put(PEnum.message, "Post is updated.");
            hashMap.put(PEnum.result, post);
            return new ResponseEntity<>(hashMap, HttpStatus.OK);
        }
        hashMap.put(PEnum.status, false);
        hashMap.put(PEnum.error, "Post is not updated.");
        hashMap.put(PEnum.result, post);
        return new ResponseEntity<>(hashMap, HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<Map<PEnum, Object>> findPostAll() {
        //return null;
        HashMap<PEnum, Object> hashMap = new HashMap<>();
        try {
            hashMap.put(status, true);
            hashMap.put(message, "List OK for posts");
            hashMap.put(result, postRepository.findAll()); //EAGER ise burada veriler yuklenir
            return new ResponseEntity<>(hashMap, HttpStatus.OK);
        } catch (Exception ex) {
            hashMap.put(status, false);
            hashMap.put(error, "List error for all posts");
            return new ResponseEntity<>(hashMap, HttpStatus.BAD_REQUEST);
        }

    }
}
