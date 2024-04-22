package fr.lpreaux.myambientair.forum.model.assembler;

import fr.lpreaux.myambientair.forum.controller.CategoryController;
import fr.lpreaux.myambientair.forum.model.CategoryDto;
import fr.lpreaux.myambientair.forum.entity.Category;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class CategoryModelAssembler extends RepresentationModelAssemblerSupport<Category, CategoryDto> {
    public CategoryModelAssembler() {
        super(CategoryController.class, CategoryDto.class);
    }

    @Override
    public CategoryDto toModel(Category entity) {
        CategoryDto categoryDto = CategoryDto.builder()
                .key(entity.getKey())
                .name(entity.getName())
                .totalThreads(entity.getThreads().size())
                .build();
        categoryDto.add(linkTo(methodOn(CategoryController.class).getOne(entity.getName())).withSelfRel());
        return categoryDto;
    }


}
