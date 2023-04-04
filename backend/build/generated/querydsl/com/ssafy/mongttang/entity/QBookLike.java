package com.ssafy.mongttang.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QBookLike is a Querydsl query type for BookLike
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QBookLike extends EntityPathBase<BookLike> {

    private static final long serialVersionUID = 1896512021L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QBookLike bookLike = new QBookLike("bookLike");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final QBook booklikeBookId;

    public final NumberPath<Integer> booklikeChallengId = createNumber("booklikeChallengId", Integer.class);

    public final NumberPath<Integer> booklikeId = createNumber("booklikeId", Integer.class);

    public final NumberPath<Integer> booklikeUserId = createNumber("booklikeUserId", Integer.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdTime = _super.createdTime;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedTime = _super.updatedTime;

    public QBookLike(String variable) {
        this(BookLike.class, forVariable(variable), INITS);
    }

    public QBookLike(Path<? extends BookLike> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QBookLike(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QBookLike(PathMetadata metadata, PathInits inits) {
        this(BookLike.class, metadata, inits);
    }

    public QBookLike(Class<? extends BookLike> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.booklikeBookId = inits.isInitialized("booklikeBookId") ? new QBook(forProperty("booklikeBookId"), inits.get("booklikeBookId")) : null;
    }

}

