package com.ssafy.mongttang.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QIllust is a Querydsl query type for Illust
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QIllust extends EntityPathBase<Illust> {

    private static final long serialVersionUID = 342545026L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QIllust illust = new QIllust("illust");

    public final QBook illustBookId;

    public final StringPath illustFilePath = createString("illustFilePath");

    public final NumberPath<Integer> illustId = createNumber("illustId", Integer.class);

    public final StringPath illustOriginalFilename = createString("illustOriginalFilename");

    public final NumberPath<Integer> illustPageNumber = createNumber("illustPageNumber", Integer.class);

    public QIllust(String variable) {
        this(Illust.class, forVariable(variable), INITS);
    }

    public QIllust(Path<? extends Illust> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QIllust(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QIllust(PathMetadata metadata, PathInits inits) {
        this(Illust.class, metadata, inits);
    }

    public QIllust(Class<? extends Illust> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.illustBookId = inits.isInitialized("illustBookId") ? new QBook(forProperty("illustBookId"), inits.get("illustBookId")) : null;
    }

}

