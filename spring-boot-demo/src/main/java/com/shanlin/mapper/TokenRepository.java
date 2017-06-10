package com.shanlin.mapper;

import com.shanlin.model.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by dell on 2017/6/10.
 */
public interface TokenRepository extends JpaRepository<Token,Long> {
    //
    //利用原生的SQL进行插入操作
    //@Transactional
    //@Modifying
   // @Query(value = "insert into Token(tokenId,userId,appId,token) value(?1,?2,?3,?4)", nativeQuery = true)
    //Token insertIntoToken(Token token);
}
