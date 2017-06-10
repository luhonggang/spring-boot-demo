package com.shanlin.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name="application")
public class Application implements Serializable {
    @Id
    @GeneratedValue
    private Long appId;
    private String appName;
    private Long appKey;
    private String appSecrect;
    private static final long serialVersionUID = 1L;
}