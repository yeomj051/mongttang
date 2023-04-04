package com.ssafy.mongttang.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QInterestBook is a Querydsl query type for InterestBook
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QInterestBook extends EntityPathBase<InterestBook> {

    private static final long serialVersionUID = 664692392L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QInterestBook interestBook = new QInterestBook("interestBook");

    public final QBook interestbookBookId;

    public final NumberPath<Integer> interestbookId = createNumber("interestbookId", Integer.class);

    public final QUser interestbookUserId;

    public QInterestBook(String variable) {
        this(InterestBook.class, forVariable(variable), INITS);
    }

    public QInterestBook(Path<? extends InterestBook> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QInterestBook(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QInterestBook(PathMetadata metadata, PathInits inits) {
        this(InterestBook.class, metadata, inits);
    }

    public QInterestBook(Class<? extends InterestBook> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.interestbookBookId = inits.isInitialized("interestbookBookId") ? new QBook(forProperty("interestbookBookId"), inits.get("interestbookBookId")) : null;
        this.interestbookUserId = inits.isInitialized("interestbookUserId") ? new QUser(forProperty("interestbookUserId")) : null;
    }

}

