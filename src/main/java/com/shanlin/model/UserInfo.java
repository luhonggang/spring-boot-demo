package com.shanlin.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Entity
@Table(name="t_user")
public class UserInfo {
    @Id
    @GeneratedValue
     Long userId;

     String username;

     String password;

     Date loginTime;

     Date createdAt;

     String createdBy;

     Date updatedAt;

     String updatedBy;

     Long expireTime;
}
