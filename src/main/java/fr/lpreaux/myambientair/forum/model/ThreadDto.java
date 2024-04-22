package fr.lpreaux.myambientair.forum.model;

import lombok.Builder;
import lombok.Getter;
import org.springframework.hateoas.RepresentationModel;

/**
 * DTO for {@link fr.lpreaux.myambientair.forum.entity.Thread}
 */
@Getter
@Builder
public class ThreadDto extends RepresentationModel<ThreadDto> {
    private Long id;
    private String title;
}
