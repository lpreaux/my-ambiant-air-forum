package fr.lpreaux.myambientair.forum.model;

import lombok.Builder;
import lombok.Getter;
import org.springframework.hateoas.PagedModel;
import org.springframework.hateoas.RepresentationModel;

/**
 * DTO for {@link fr.lpreaux.myambientair.forum.entity.Category}
 */
@Getter
@Builder
public class CategoryDto extends RepresentationModel<CategoryDto> {
    private String key;
    private String name;
    private Integer totalThreads;
    private PagedModel<ThreadDto> threads;
}
