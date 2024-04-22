package fr.lpreaux.myambientair.forum.model.assembler;

import fr.lpreaux.myambientair.forum.controller.CommentController;
import fr.lpreaux.myambientair.forum.model.CommentDto;
import fr.lpreaux.myambientair.forum.entity.Comment;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class CommentModelAssembler extends RepresentationModelAssemblerSupport<Comment, CommentDto> {
    public CommentModelAssembler() {
        super(CommentController.class, CommentDto.class);
    }

    @Override
    public CommentDto toModel(Comment entity) {
        CommentDto commentDto = CommentDto.builder()
                .id(entity.getId())
                .message(entity.getMessage())
                .threadId(entity.getThread().getId())
                .threadTitle(entity.getThread().getTitle())
                .replies(entity.getReplies().stream().map(this::toModel).toList())
                .build();
        commentDto.add(linkTo(methodOn(CommentController.class).getByThreadId(entity.getThread().getId())).withSelfRel());
        return commentDto;
    }
}
