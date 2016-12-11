package com.ubb.map.repository.db;

import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.support.ConnectionSource;
import com.ubb.map.domain.Role;
import com.ubb.map.domain.User;
import com.ubb.map.domain.UserRole;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by marius on 11.12.2016.
 */
public class UserRoleRepository extends OrmRepository<Integer, UserRole> {
    public UserRoleRepository(ConnectionSource connection) {
        super(connection, UserRole.class);
    }

    public Collection<Role> getRoles(User user) {
        QueryBuilder<UserRole, Integer> builder = this.dao.queryBuilder();
        try {
            builder.where().eq(UserRole.USER_ID_FIELD_NAME, user);

            List<UserRole> userRoles = this.dao.query(builder.prepare());
            ArrayList<Role> result = new ArrayList<>();
            for (UserRole userRole : userRoles) {
                result.add(userRole.getRole());
            }

            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
