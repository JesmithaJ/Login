package com.ibm.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Role extends BaseEntity{

    private String name;    
}