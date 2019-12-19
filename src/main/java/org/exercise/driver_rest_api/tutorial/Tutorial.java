package org.exercise.driver_rest_api.tutorial;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;
import org.exercise.driver_rest_api.comment.Comment;
import org.exercise.driver_rest_api.like.TutorialLike;
import org.exercise.driver_rest_api.tag.Tag;
import org.exercise.driver_rest_api.user.User;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Getter
@Setter
public class Tutorial {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private LocalDateTime createdDate;

    @ManyToOne
    private User creator;

    @OneToMany(mappedBy = "tutorial")
    private Set<Comment> comments;

    @OneToMany(mappedBy = "tutorial")
    private Set<TutorialLike> likes;

    @ManyToMany
    @JoinTable(name = "tutorials_tags",
    joinColumns = @JoinColumn(name = "tutorial_id"),
    inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private Set<Tag> tags;

    @PrePersist
    private void prePersist(){ createdDate = LocalDateTime.now();}



}
