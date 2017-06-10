package com.shanlin.mapper;

import com.shanlin.model.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * 应用程序信息查询
 */
public interface ApplicationRepository extends JpaRepository<Application, Long> {
    @Query("select o from Application o where o.appId = ?1")
    Application selectAppSecrect(@Param("appId") Long appId);

}
