package com.ssafy.mongttang.repository;

import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.ssafy.mongttang.entity.Book;
import com.ssafy.mongttang.entity.QBookLike;

import javax.persistence.EntityManager;
import java.util.List;

public class BookLikeRepositoryCustomImpl implements BookLikeRepositoryCustom{
    private JPAQueryFactory queryFactory;
    QBookLike bookLike = QBookLike.bookLike;

    public BookLikeRepositoryCustomImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }
    @Override
    public List<Book> findTop3LikeBook(int challengeId) {
        Path<Long> book_rank = Expressions.numberPath(Long.class, "book_rank");
        return queryFactory.select(bookLike.booklikeBookId).from(bookLike)
                .where(bookLike.booklikeChallengId.eq(challengeId), bookLike.booklikeBookId.bookStatus.eq("complete"))
                .groupBy(bookLike.booklikeBookId)
                .orderBy(bookLike.booklikeBookId.count().desc())
                .limit(3).fetch();
    }

}
