package com.ssafy.mongttang.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QChallenge is a Querydsl query type for Challenge
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QChallenge extends EntityPathBase<Challenge> {

    private static final long serialVersionUID = -1941978354L;

    public static final QChallenge challenge = new QChallenge("challenge");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final StringPath challengeContent = createString("challengeContent");

    public final DateTimePath<java.time.LocalDateTime> challengeEndDate = createDateTime("challengeEndDate", java.time.LocalDateTime.class);

    public final NumberPath<Integer> challengeId = createNumber("challengeId", Integer.class);

    public final DateTimePath<java.time.LocalDateTime> challengeStartDate = createDateTime("challengeStartDate", java.time.LocalDateTime.class);

    public final StringPath challengeSummary = createString("challengeSummary");

    public final StringPath challengeTitle = createString("challengeTitle");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdTime = _super.createdTime;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedTime = _super.updatedTime;

    public QChallenge(String variable) {
        super(Challenge.class, forVariable(variable));
    }

    public QChallenge(Path<? extends Challenge> path) {
        super(path.getType(), path.getMetadata());
    }

    public QChallenge(PathMetadata metadata) {
        super(Challenge.class, metadata);
    }

}

