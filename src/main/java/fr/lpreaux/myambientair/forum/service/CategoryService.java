package fr.lpreaux.myambientair.forum.service;

import fr.lpreaux.myambientair.forum.entity.Category;
import fr.lpreaux.myambientair.forum.exception.ResourceNotFound;
import fr.lpreaux.myambientair.forum.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public Page<Category> getPaginated(Pageable pageable) {
        return categoryRepository.findAll(pageable);
    }

    public Category findByKey(String key) {
        return categoryRepository.findByKey(key)
                .orElseThrow(() -> new ResourceNotFound("No Category with key name " + key + " found."));
    }
}
