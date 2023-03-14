package com.ssafy.mongttang.entity;

import com.ssafy.mongttang.dto.AuthProvider;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Entity
@DynamicInsert
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "follow")
public class Follow {
//    `follow_id`	int	NOT NULL,
//            `follow_follower`	int	NOT NULL,
//            `follow_following`	int	NOT NULL
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "memory_id",columnDefinition = "INT UNSIGNED")
    private int followId;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "follow_from")
    private User followFrom;            //팔로우 하는 사람

    @NotNull
    @ManyToOne
    @JoinColumn(name = "follow_to")
    private User followTo;           //팔로우 당한 사람
}
