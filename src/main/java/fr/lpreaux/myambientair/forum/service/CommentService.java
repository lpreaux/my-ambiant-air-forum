package fr.lpreaux.myambientair.forum.service;

import fr.lpreaux.myambientair.forum.entity.Comment;
import fr.lpreaux.myambientair.forum.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CommentService {

    private final CommentRepository commentRepository;

    @Transactional(readOnly = true)
    public List<Comment> getByThreadId(Long threadId) {
        return commentRepository.findByThread_IdAndReplyToNull(threadId);
    }

    @Transactional
    public void createOne(Comment comment) {
        commentRepository.save(comment);
    }
}
