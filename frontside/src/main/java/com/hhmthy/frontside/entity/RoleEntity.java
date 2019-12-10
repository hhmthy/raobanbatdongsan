package com.hhmthy.frontside.entity;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "role", schema = "bds")
public class RoleEntity {
    private byte roleId;
    private String roleName;

    /*@OneToMany(mappedBy = "role_id", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Collection<UserEntity> userEntity;

    public Collection<UserEntity> getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(Collection<UserEntity> userEntity) {
        this.userEntity = userEntity;
    }*/

    @Id
    @GeneratedValue
    @Column(name = "role_id", nullable = false)
    public byte getRoleId() {
        return roleId;
    }

    public void setRoleId(byte roleId) {
        this.roleId = roleId;
    }

    @Basic
    @Column(name = "role_name", nullable = true, length = 100)
    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoleEntity that = (RoleEntity) o;
        return roleId == that.roleId &&
                Objects.equals(roleName, that.roleName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roleId, roleName);
    }
}
