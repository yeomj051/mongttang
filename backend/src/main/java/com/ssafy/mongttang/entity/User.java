package com.ssafy.mongttang.entity;

import com.ssafy.mongttang.dto.AuthProvider;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Entity
@DynamicInsert
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
public class User extends BaseEntity {

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

    @Builder
    public User(int userId, LocalDateTime userCreateDate, String userEmail, String userNickname,String userGender, AuthProvider userProvider ){
        this.userId = userId;
        this.userCreateDate = userCreateDate;
        this.userEmail = userEmail;
        this.userNickname = userNickname;
        this.userGender = userGender;
        this.userRole = "ROLE_USER";
        this.userProvider = userProvider;
    }

    public void changeNickname(String nickname) {
        this.userNickname = nickname;
    }
}
