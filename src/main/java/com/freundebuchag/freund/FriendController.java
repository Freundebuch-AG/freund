package com.freundebuchag.freund;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(path = "/friend")
@RequiredArgsConstructor
public class FriendController {

    // index.html/friend?firstName=A&lastName=B&bday=2002-03-02&food=Käse&animal=Schinken&dino=Brot

    private final FriendService friendService;

    private final FriendResoucreAssembler friendResoucreAssembler;

    @PostMapping
    public ResponseEntity<FriendResource> createFriend(@RequestBody FriendRequest friendRequest) {
        Friend friend = friendService.create(friendRequest.toFriend());

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .build(friend.getId());


        return ResponseEntity.created(location).body(friendResoucreAssembler.toResource(friend));
    }

    @GetMapping
    public ResponseEntity<List<FriendResource>> getFriends() {
        return ResponseEntity.ok(friendResoucreAssembler.toListResource(friendService.findAll()));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<FriendResource> getFriend(@PathVariable("id") UUID id) {
        return friendService.findByIdOptional(id)
                .map(friendResoucreAssembler::toResource)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<FriendResource> updateFriend(
            @PathVariable("id") Optional<Friend> friend,
            @RequestBody FriendRequest friendRequest
    ) {
        return friend
                .map(current -> current = friendRequest.toFriend(friend.get().getId()))
                .map(friendService::update)
                .map(friendResoucreAssembler::toResource)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteFriend(@PathVariable("id") Optional<Friend> friend) {
        if (friend.isPresent()) {
            friendService.delete(friend.get());
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
