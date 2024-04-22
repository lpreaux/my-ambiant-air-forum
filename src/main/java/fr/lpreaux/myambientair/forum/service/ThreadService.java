package fr.lpreaux.myambientair.forum.service;

import fr.lpreaux.myambientair.forum.entity.Comment;
import fr.lpreaux.myambientair.forum.entity.Thread;
import fr.lpreaux.myambientair.forum.exception.ResourceNotFound;
import fr.lpreaux.myambientair.forum.model.CommentDto;
import fr.lpreaux.myambientair.forum.repository.CommentRepository;
import fr.lpreaux.myambientair.forum.repository.ThreadRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ThreadService {

    private final ThreadRepository threadRepository;
    private final CommentRepository commentRepository;

    public Page<Thread> getPaginated(Pageable pageable) {
        return threadRepository.findAll(pageable);
    }

    public Page<Thread> getPaginated(Pageable pageable, String categoryKey) {
        return threadRepository.findByCategory_Key(categoryKey, pageable);
    }

    public Thread getOne(long id) {
        return threadRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("No Thread with id " + id + " found."));
    }

    public void addOneComment(long threadId, CommentDto commentDto) {
        threadRepository.findById(threadId)
                .map(thread -> {
                    Comment comment = new Comment();
                    comment.setThread(thread);
                    comment.setMessage(commentDto.getMessage());
                    return commentRepository.save(comment);
                })
                .orElseThrow(() -> new ResourceNotFound("No Thread with id " + threadId + " found."));
    }
}
