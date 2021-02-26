package designpatterns.creational.simplefactory;

public class PostFactory {
    public static Post createPost(String type){

        switch (type) {
            case "blog" :
                return new BlogPost();

            case "news":
                return new NewsPost();

            default:
                throw new IllegalArgumentException("Unknown Post type.");
        }

    }
}
