package com.freundebuchag.freund;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

import static lombok.AccessLevel.PROTECTED;

@Service
@Transactional
@RequiredArgsConstructor(access = PROTECTED)
public class FriendService {

    @NonNull
    private final FriendRepository friendRepository;

    public Friend create(Friend transientEntitiy) {
        return friendRepository.saveAndFlush(transientEntitiy);
    }

    public Friend findById(UUID id) {
        return friendRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    public Optional<Friend> findByIdOptional(UUID id) {
        return friendRepository.findById(id);
    }

    public List<Friend> findAll() {
        return friendRepository.findAll();
    }

    public Friend update(Friend entity) {
        return friendRepository.saveAndFlush(entity);
    }

    public void delete(Friend entity) {
        friendRepository.delete(entity);
    }
}
