package com.ssafy.mongttang.entity;

import com.ssafy.mongttang.dto.AuthProvider;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    @Column(length = 30)
    @NotNull
    private String userEmail;

    @Column(length = 10)
    private String userRole;

    @Column(length = 50)
    private String userNickname;

    @Column(length = 6)
    private String userGender;

    @CreatedDate
    private LocalDateTime userCreateDate;

    @Enumerated(EnumType.STRING)
    @Column(length = 6)
    private AuthProvider userProvider;

    @Column
    private String userInfo;

    public void changeNickname(String nickname) {
        this.userNickname = nickname;
    }
}
