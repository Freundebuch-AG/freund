package com.freundebuchag.freund;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.time.LocalDate;
import java.util.UUID;

@AllArgsConstructor
@Getter
@EqualsAndHashCode(callSuper = false)
@Builder
public class FriendResource {
    @JsonProperty(value = "_id")
    private final UUID id;

    String firstName;

    String lastName;

    LocalDate bday;

    String food;

    String animal;

    String dino;
}
