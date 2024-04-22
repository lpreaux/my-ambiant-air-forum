package fr.lpreaux.myambientair.forum.controller;

import fr.lpreaux.myambientair.forum.model.assembler.CategoryModelAssembler;
import fr.lpreaux.myambientair.forum.model.assembler.ThreadModelAssembler;
import fr.lpreaux.myambientair.forum.model.CategoryDto;
import fr.lpreaux.myambientair.forum.model.ThreadDto;
import fr.lpreaux.myambientair.forum.entity.Category;
import fr.lpreaux.myambientair.forum.entity.Thread;
import fr.lpreaux.myambientair.forum.service.CategoryService;
import fr.lpreaux.myambientair.forum.service.ThreadService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("categories")
public class CategoryController {
    private final CategoryService categoryService;
    private final PagedResourcesAssembler<Category> pagedResourcesAssembler;
    private final CategoryModelAssembler categoryModelAssembler;

    private final ThreadService threadService;
    private final PagedResourcesAssembler<Thread> threadPagedRessourceAssembler;
    private final ThreadModelAssembler threadModelAssembler;

    @GetMapping
    public PagedModel<CategoryDto> getPaginated(Pageable pageable) {
        Page<Category> paginated = categoryService.getPaginated(pageable);
        return pagedResourcesAssembler.toModel(paginated, categoryModelAssembler);
    }

    @GetMapping("{key}")
    public CategoryDto getOne(@PathVariable String key) {
        Category category = categoryService.findByKey(key);
        return categoryModelAssembler.toModel(category);
    }

    @GetMapping("{key}/threads")
    public PagedModel <ThreadDto> getPaginatedThreads(@PathVariable String key, Pageable pageable) {
        Page<Thread> paginated = threadService.getPaginated(pageable, key);
        return threadPagedRessourceAssembler.toModel(paginated, threadModelAssembler);
    }
}
