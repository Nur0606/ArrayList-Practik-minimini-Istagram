package mini_Insta.generic_ID;

public class GenericId {
    public static Long userId = 0L;
    public static Long postId = 0L;
    public static long genericPostId(){
        return ++postId;
    }
    public static long genericUserId(){
        return ++userId;
    }
}
