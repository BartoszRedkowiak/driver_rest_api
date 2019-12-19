package org.exercise.driver_rest_api.comment;

import lombok.Getter;
import lombok.Setter;
import org.exercise.driver_rest_api.like.CommentLike;
import org.exercise.driver_rest_api.tutorial.Tutorial;
import org.exercise.driver_rest_api.user.User;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String content;

    @ManyToOne
    private User commenter;

    @OneToMany(mappedBy = "originalComment")
    private Set<Comment> replies;

    @ManyToOne
    private Tutorial tutorial;

    @ManyToOne
    private Comment originalComment;

    @OneToMany(mappedBy = "comment")
    private Set<CommentLike> likes;

}
