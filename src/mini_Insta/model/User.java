package mini_Insta.model;

import mini_Insta.enums.Gender;

import java.util.List;

public class User {
    private Long id;
    private String fulName;
    private String email;
    private String password;
    private Gender gender;
    private List<Post> posts;

    public User() {
    }

    public User(Long id, String fulName, String email, String password, Gender gender, List<Post> posts) {
        this.id = id;
        this.fulName = fulName;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.posts = posts;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFulName() {
        return fulName;
    }

    public void setFulName(String fulName) {
        this.fulName = fulName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    @Override
    public String toString() {
        return "User{" +
               "id=" + id +
               ", fulName='" + fulName + '\'' +
               ", email='" + email + '\'' +
               ", password='" + password + '\'' +
               ", gender=" + gender +
               ", posts=" + posts +
               '}';
    }
}