package com.ssafy.mongttang.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QBook is a Querydsl query type for Book
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QBook extends EntityPathBase<Book> {

    private static final long serialVersionUID = 1323054430L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QBook book = new QBook("book");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final QChallenge bookChallengeId;

    public final StringPath bookContent = createString("bookContent");

    public final NumberPath<Integer> bookId = createNumber("bookId", Integer.class);

    public final StringPath bookStatus = createString("bookStatus");

    public final StringPath bookSummary = createString("bookSummary");

    public final StringPath bookTitle = createString("bookTitle");

    public final QUser bookUserId;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdTime = _super.createdTime;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedTime = _super.updatedTime;

    public QBook(String variable) {
        this(Book.class, forVariable(variable), INITS);
    }

    public QBook(Path<? extends Book> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QBook(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QBook(PathMetadata metadata, PathInits inits) {
        this(Book.class, metadata, inits);
    }

    public QBook(Class<? extends Book> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.bookChallengeId = inits.isInitialized("bookChallengeId") ? new QChallenge(forProperty("bookChallengeId")) : null;
        this.bookUserId = inits.isInitialized("bookUserId") ? new QUser(forProperty("bookUserId")) : null;
    }

}

