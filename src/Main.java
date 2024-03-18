import mini_Insta.db.Database;
import mini_Insta.enums.Gender;
import mini_Insta.generic_ID.GenericId;
import mini_Insta.model.Post;
import mini_Insta.model.User;
import mini_Insta.service.PostService;
import mini_Insta.service.UserService;
import mini_Insta.service.impl.PostServiceImpl;
import mini_Insta.service.impl.UserServiceimpl;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Post> posts = new ArrayList<>(Arrays.asList(
                new Post(GenericId.genericPostId(), "Not image", "Hello"),
                new Post(GenericId.genericPostId(), "Yes image", "😎"),
                new Post(GenericId.genericPostId(), "Not image", "✌️"),
                new Post(GenericId.genericPostId(), "Yes image", "😊")
        ));
        List<User> users = new ArrayList<>(Arrays.asList(
                new User(GenericId.genericUserId(), "Nurmuhammed Rusbaev", "nur@gmail.com", "2006", Gender.Male, posts),
                new User(GenericId.genericUserId(), "Nurtilek Abdipattaeva", "nurti@gmail.com", "2005", Gender.Female, posts),
                new User(GenericId.genericUserId(), "Adyl Adylova", "adyl@gmail.com", "2009", Gender.Male, posts)
        ));
        Database.posts.addAll(posts);
        Database.users.addAll(users);

        PostService postService = new PostServiceImpl();
        UserService userService = new UserServiceimpl();

        System.out.println("Welcome to miniminimini Instagram!");
        while (true) {
            System.out.println("""
                    1.Sign up
                    2.Sign in
                    """);
            int maincase = scanner.nextInt();
            switch (maincase) {
                case 1:
                    System.out.println(userService.register());
                    break;

                case 2:
                        System.out.println("  Sign in: ");
                        System.out.println("Enter E-mail: ");
                        String email = scanner.next();
                        System.out.println("Enter password: ");
                        String password = scanner.next();
                        System.out.println(userService.login(email, password));
                case 3:
                    boolean wl = true;
                    while (wl) {
                        System.out.println("""
                                   1.Get All User
                                   2.Get User By E-mail
                                   3.Add Post
                                   4.Delete Post
                                   5.Get Post By User id
                                   6.Exit
                                """);
                        int usercase = scanner.nextInt();
                        switch (usercase) {
                            case 1 -> System.out.println(userService.getAllUsers());
                            case 2 -> {
                                System.out.println("Enter E-mail: ");
                                String emaill = scanner.next();
                                System.out.println(userService.getUserByEmail(emaill));
                            }
                            case 3 -> {
                                System.out.println("Enter Image: ");
                                String ima = scanner.next();
                                System.out.println("Enter Description: ");
                                String des = scanner.next();
                                System.out.println(postService.addPostToUser(new Post(GenericId.genericPostId(), ima, des)));
                            }
                            case 4 -> {
                                System.out.println("Enter Post Id: ");
                                Long id = scanner.nextLong();
                                System.out.println(postService.deletePostbyId(id));
                            }
                            case 5 -> {
                                System.out.println("Enter User Id: ");
                                Long id = scanner.nextLong();
                                System.out.println(postService.getPostByUserId(id));
                            }
                            case 6 -> wl = false;
                            default -> System.out.println("There is no such number!!!🙄");

                        }

                    }
                    break;
            }
        }
    }
}
