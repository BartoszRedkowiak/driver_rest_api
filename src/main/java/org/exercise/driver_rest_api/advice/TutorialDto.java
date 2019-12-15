package org.exercise.driver_rest_api.advice;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class TutorialDto {

    @ApiModelProperty(notes = "The unique id of the advice")
    private Long id;

    @ApiModelProperty(notes = "The title of an advice")
    private String title;

    @ApiModelProperty(notes = "The text content of an advice")
    private String content;

    @ApiModelProperty(notes = "The image source related to advice")
    private String youTubeUrl;

    @ApiModelProperty(notes = "The creation date of an advice")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime createdDate;

}
