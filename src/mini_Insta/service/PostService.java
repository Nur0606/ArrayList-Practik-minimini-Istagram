package mini_Insta.service;

import mini_Insta.model.Post;

import java.util.List;

public interface PostService {
    String addPostToUser(Post post);
    String deletePostbyId(Long id);
    List<Post> getPostByUserId(Long userId);
}
