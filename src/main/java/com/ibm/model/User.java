package com.ibm.model;
import com.ibm.model.Role;

import javax.persistence.*;

import java.util.List;
import java.util.Arrays;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User extends BaseEntity{

    private String username;
    private String password;
    @OneToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    private List<Role> roles;
    private boolean active;

}