package org.itStep.db;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.Date;

public class PostRepository  {
    CopyOnWriteArrayList<Post> posts;

    private static PostRepository ins = new PostRepository();

    private PostRepository(){
        posts = new CopyOnWriteArrayList<>();
        init();
    }

    public static PostRepository getInstance(){
        return ins;
    }

    public List<Post> getPosts(){
        return posts;
    }

    private void init(){
        posts.add(Post.builder().title("Post Title").content("Lorem ipsum dolor sit amet, consectetur adipisicing elit. Reiciendis aliquid atque, nulla? Quos cum ex quis soluta, a laboriosam. Dicta expedita corporis animi vero voluptate voluptatibus possimus, veniam magni quis!").published(new Date()).build());
        posts.add(Post.builder().title("Post Title").content("Lorem ipsum dolor sit amet, consectetur adipisicing elit. Reiciendis aliquid atque, nulla? Quos cum ex quis soluta, a laboriosam. Dicta expedita corporis animi vero voluptate voluptatibus possimus, veniam magni quis!").published(new Date()).build());
        posts.add(Post.builder().title("Post Title").content("Lorem ipsum dolor sit amet, consectetur adipisicing elit. Reiciendis aliquid atque, nulla? Quos cum ex quis soluta, a laboriosam. Dicta expedita corporis animi vero voluptate voluptatibus possimus, veniam magni quis!").published(new Date()).build());
    }
}
