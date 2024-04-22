package fr.lpreaux.myambientair.forum.repository;

import fr.lpreaux.myambientair.forum.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> findByName(String name);

    Optional<Category> findByKey(String key);
}
