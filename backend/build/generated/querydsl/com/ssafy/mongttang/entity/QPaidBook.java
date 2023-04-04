package com.ssafy.mongttang.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPaidBook is a Querydsl query type for PaidBook
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPaidBook extends EntityPathBase<PaidBook> {

    private static final long serialVersionUID = 807371722L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPaidBook paidBook = new QPaidBook("paidBook");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final NumberPath<Integer> bookId = createNumber("bookId", Integer.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdTime = _super.createdTime;

    public final NumberPath<Integer> paidbookId = createNumber("paidbookId", Integer.class);

    public final QUser paidbookUserId;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedTime = _super.updatedTime;

    public QPaidBook(String variable) {
        this(PaidBook.class, forVariable(variable), INITS);
    }

    public QPaidBook(Path<? extends PaidBook> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QPaidBook(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QPaidBook(PathMetadata metadata, PathInits inits) {
        this(PaidBook.class, metadata, inits);
    }

    public QPaidBook(Class<? extends PaidBook> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.paidbookUserId = inits.isInitialized("paidbookUserId") ? new QUser(forProperty("paidbookUserId")) : null;
    }

}

