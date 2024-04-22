package fr.lpreaux.myambientair.forum.model.assembler;

import fr.lpreaux.myambientair.forum.controller.ThreadController;
import fr.lpreaux.myambientair.forum.model.ThreadDto;
import fr.lpreaux.myambientair.forum.entity.Thread;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


@Component
public class ThreadModelAssembler extends RepresentationModelAssemblerSupport<Thread, ThreadDto> {
    public ThreadModelAssembler() {
        super(ThreadController.class, ThreadDto.class);
    }

    @Override
    public ThreadDto toModel(Thread entity) {
        ThreadDto threadDto = ThreadDto.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .build();
        threadDto.add(linkTo(methodOn(ThreadController.class).getOne(entity.getId())).withSelfRel());
        return threadDto;
    }
}
