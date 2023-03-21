package com.ssafy.mongttang.repository;

import com.ssafy.mongttang.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentReportRepository extends JpaRepository<Comment, Integer> {

}
