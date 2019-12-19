package org.exercise.driver_rest_api.tutorial;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.exercise.driver_rest_api.comment.Comment;
import org.exercise.driver_rest_api.like.TutorialLike;
import org.exercise.driver_rest_api.tag.Tag;
import org.exercise.driver_rest_api.user.User;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@ApiModel(description = "Object ")
public class TutorialDto {

    @ApiModelProperty(notes = "The unique id of the tutorial")
    private Long id;

    @NotBlank(message = "Title must not be blank")
    @ApiModelProperty(notes = "The title of a tutorial")
    private String title;

    @ApiModelProperty(notes = "The text content of a tutorial")
    private String content;

    @ApiModelProperty(notes = "The creation date of a tutorial")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime createdDate;

    @ApiModelProperty(notes = "The creator of a tutorial")
    private User creator;

    @ApiModelProperty(notes = "Comments")
    private Set<Comment> comments;
    private Set<TutorialLike> likes;
    private Set<Tag> tags;

}
