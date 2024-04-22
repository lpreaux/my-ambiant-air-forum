package fr.lpreaux.myambientair.forum.controller;

import fr.lpreaux.myambientair.forum.entity.Comment;
import fr.lpreaux.myambientair.forum.model.assembler.CommentModelAssembler;
import fr.lpreaux.myambientair.forum.model.CommentDto;
import fr.lpreaux.myambientair.forum.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("comments")
public class CommentController {
    private final CommentService commentService;
    private final CommentModelAssembler commentModelAssembler;

    @GetMapping
    public List<CommentDto> getByThreadId(@RequestParam Long threadId) {
        return commentService.getByThreadId(threadId).stream()
                .map(commentModelAssembler::toModel)
                .toList();
    }

}
