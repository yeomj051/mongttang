package com.ssafy.mongttang.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@NoArgsConstructor
@DynamicInsert
@Table(name = "comment")
public class Comment extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int commentId;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "comment_book_id")
    private Book commentBookId;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "comment_user_id")
    private User commentUserId;

    private String commentContent;

    @NotNull
    @Column(columnDefinition = "boolean default true")
    private Boolean commentStatus;

    public Comment(Book commentBook, User commentUser, String commentContent) {
        this.commentBookId = commentBook;
        this.commentUserId = commentUser;
        this.commentContent = commentContent;
        this.commentStatus = true;
    }

    public void changeStatus(){
        this.commentStatus = false;
    }

}
