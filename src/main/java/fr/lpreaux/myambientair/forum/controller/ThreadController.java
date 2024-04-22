package fr.lpreaux.myambientair.forum.controller;

import fr.lpreaux.myambientair.forum.model.CommentDto;
import fr.lpreaux.myambientair.forum.model.assembler.ThreadModelAssembler;
import fr.lpreaux.myambientair.forum.model.ThreadDto;
import fr.lpreaux.myambientair.forum.entity.Thread;
import fr.lpreaux.myambientair.forum.service.ThreadService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("threads")
public class ThreadController {
    private final ThreadService threadService;
    private final PagedResourcesAssembler<Thread> pagedRessourceAssembler;
    private final ThreadModelAssembler threadModelAssembler;

    @GetMapping(produces = { "application/hal+json" })
    public PagedModel<ThreadDto> getPaginated(Pageable pageable) {
        Page<Thread> paginated = threadService.getPaginated(pageable);
        return pagedRessourceAssembler.toModel(paginated, threadModelAssembler);
    }

    @GetMapping("{id}")
    public ThreadDto getOne(@PathVariable long id) {
        Thread entity = threadService.getOne(id);
        return threadModelAssembler.toModel(entity);
    }

    @PostMapping("{id}/comments")
    @ResponseStatus(HttpStatus.CREATED)
    public void addOnePost(@PathVariable("id") long threadId, @RequestBody CommentDto commentDto) {
        threadService.addOneComment(threadId, commentDto);
    }
}
