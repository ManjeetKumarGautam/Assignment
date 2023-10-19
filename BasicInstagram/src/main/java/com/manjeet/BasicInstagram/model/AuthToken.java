package com.manjeet.BasicInstagram.model;

import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthToken {

    private Long tokenId;
    private String token;
    private LocalDate tokenCreationDate;

    @OneToOne
    private User user  ;

    public AuthToken(User user) {
        this.user = user;
        this.tokenCreationDate = LocalDate.now();
        this.token = UUID.randomUUID().toString();
    }
}
