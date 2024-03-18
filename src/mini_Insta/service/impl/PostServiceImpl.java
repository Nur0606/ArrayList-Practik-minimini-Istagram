package mini_Insta.service.impl;

import mini_Insta.db.Database;
import mini_Insta.model.Post;
import mini_Insta.model.User;
import mini_Insta.service.PostService;

import java.util.List;

public class PostServiceImpl implements PostService {
    @Override
    public String addPostToUser(Post post) {
        Database.posts.add(post);
        return "Succses saved✅";
    }

    @Override
    public String deletePostbyId(Long id) {
        for (Post post : Database.posts) {
            if (post.getId().equals(id)) {
                Database.posts.remove(post);
                return "Succses deleted✅";
            } else {
                return "Not-Found❌";
            }
        }return null;
    }

    @Override
    public List<Post> getPostByUserId(Long userId) {
        for (User user : Database.users) {
            if (user.getId().equals(userId)){
                return user.getPosts();
            }else
                System.out.println("User Not-Found!");
        }
        return null;
    }
}
