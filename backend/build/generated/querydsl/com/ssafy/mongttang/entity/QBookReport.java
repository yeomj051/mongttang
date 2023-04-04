package com.ssafy.mongttang.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QBookReport is a Querydsl query type for BookReport
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QBookReport extends EntityPathBase<BookReport> {

    private static final long serialVersionUID = 1650161714L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QBookReport bookReport = new QBookReport("bookReport");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final QBook bookreportBookId;

    public final StringPath bookreportBookTitle = createString("bookreportBookTitle");

    public final StringPath bookreportCategory = createString("bookreportCategory");

    public final StringPath bookreportContent = createString("bookreportContent");

    public final NumberPath<Integer> bookreportId = createNumber("bookreportId", Integer.class);

    public final NumberPath<Integer> bookreportReportUserId = createNumber("bookreportReportUserId", Integer.class);

    public final QUser bookreportUserId;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdTime = _super.createdTime;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedTime = _super.updatedTime;

    public QBookReport(String variable) {
        this(BookReport.class, forVariable(variable), INITS);
    }

    public QBookReport(Path<? extends BookReport> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QBookReport(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QBookReport(PathMetadata metadata, PathInits inits) {
        this(BookReport.class, metadata, inits);
    }

    public QBookReport(Class<? extends BookReport> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.bookreportBookId = inits.isInitialized("bookreportBookId") ? new QBook(forProperty("bookreportBookId"), inits.get("bookreportBookId")) : null;
        this.bookreportUserId = inits.isInitialized("bookreportUserId") ? new QUser(forProperty("bookreportUserId")) : null;
    }

}

