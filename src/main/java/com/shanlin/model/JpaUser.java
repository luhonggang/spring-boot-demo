package com.shanlin.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by hezuchao on 2017/6/8.
 */
@Data
@Entity
@Table(name="test_user")
public class JpaUser {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Integer age;
}
