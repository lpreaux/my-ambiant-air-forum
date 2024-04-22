package fr.lpreaux.myambientair.forum.repository;

import fr.lpreaux.myambientair.forum.entity.Thread;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ThreadRepository extends JpaRepository<Thread, Long> {
    Page<Thread> findByCategory_Key(String key, Pageable pageable);
}
