package com.shanlin.mapper;

import com.shanlin.model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * 类注释
 * @author: luhonggang
 * @date: 2017/6/9
 * @time: 19:14
 * @see: 链接到其他资源
 * @since: 1.0
 */
public interface UserRepository extends JpaRepository<UserInfo, Long> {
    @Query("select o from UserInfo o where o.username = ?1")
    UserInfo selectUserByUserName(@Param("userName") String userName);
}
