package org.exercise.driver_rest_api.like;

import lombok.Getter;
import lombok.Setter;
import org.exercise.driver_rest_api.comment.Comment;
import org.exercise.driver_rest_api.user.User;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class CommentLike {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne(targetEntity = Comment.class)
    private Comment comment;

}
