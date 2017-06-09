package com.shanlin.mapper;

import com.shanlin.model.JpaUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by hezuchao on 2017/6/8.
 */
public interface JpaUserRepository extends JpaRepository<JpaUser, Long> {

    @Query("select o from JpaUser o where o.id = ?1")
    JpaUser findById(@Param("id") Long id);

}
