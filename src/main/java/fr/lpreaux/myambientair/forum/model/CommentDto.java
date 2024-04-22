package fr.lpreaux.myambientair.forum.model;

import fr.lpreaux.myambientair.forum.entity.Comment;
import lombok.Builder;
import lombok.Getter;
import org.springframework.hateoas.RepresentationModel;

import java.util.List;

/**
 * DTO for {@link Comment}
 */
@Getter
@Builder
public class CommentDto extends RepresentationModel<CommentDto> {
    private Long id;
    private String message;
    private Long threadId;
    private String threadTitle;
    private List<CommentDto> replies;
}
