package fr.lpreaux.myambientair.forum.repository;

import fr.lpreaux.myambientair.forum.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findByThread_IdAndReplyToNull(@NonNull Long id);
}
