package com.freundebuchag.freund;

import lombok.AllArgsConstructor;
import lombok.Builder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
@Builder
public class FriendResoucreAssembler {

    private final FriendService friendService;

    public FriendResource toResource(Friend friend) {
        return FriendResource.builder()
                .id(friend.getId())
                .firstName(friend.getFirstName())
                .lastName(friend.getLastName())
                .bday(friend.getBday())
                .food(friend.getFood())
                .animal(friend.getAnimal())
                .dino(friend.getDino())
                .build();
    }

    public List<FriendResource> toListResource(List<Friend> friends) {
        return friends.stream().map(this::toResource).collect(Collectors.toList());
    }
}
