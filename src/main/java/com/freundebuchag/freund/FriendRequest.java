package com.freundebuchag.freund;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@RequiredArgsConstructor
@Getter
@Setter
public class FriendRequest {

    String firstName;

    String lastName;

    LocalDate bday;

    String food;

    String animal;

    String dino;

    public Friend toFriend() {
        return Friend.builder()
                .firstName(firstName)
                .lastName(lastName)
                .bday(bday)
                .food(food)
                .animal(animal)
                .dino(dino)
                .build();
    }

    public Friend toFriend(UUID id) {
        return Friend.builder()
                .id(id)
                .firstName(firstName)
                .lastName(lastName)
                .bday(bday)
                .food(food)
                .animal(animal)
                .dino(dino)
                .build();
    }
}
