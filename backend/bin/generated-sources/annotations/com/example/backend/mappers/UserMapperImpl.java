package com.example.backend.mappers;

import com.example.backend.dtos.RoleResponse;
import com.example.backend.dtos.UserResponse;
import com.example.backend.models.Role;
import com.example.backend.models.User;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-09-19T15:24:28+0700",
    comments = "version: 1.6.3, compiler: Eclipse JDT (IDE) 3.43.0.v20250819-1513, environment: Java 21.0.8 (Eclipse Adoptium)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserResponse toResponse(User user) {
        if ( user == null ) {
            return null;
        }

        UUID id = null;
        String email = null;
        RoleResponse role = null;

        id = user.getId();
        email = user.getEmail();
        role = toRoleResponse( user.getRole() );

        UserResponse userResponse = new UserResponse( id, email, role );

        return userResponse;
    }

    @Override
    public List<UserResponse> toListResponse(List<User> users) {
        if ( users == null ) {
            return null;
        }

        List<UserResponse> list = new ArrayList<UserResponse>( users.size() );
        for ( User user : users ) {
            list.add( toResponse( user ) );
        }

        return list;
    }

    @Override
    public RoleResponse toRoleResponse(Role role) {
        if ( role == null ) {
            return null;
        }

        String name = null;

        name = role.getName();

        RoleResponse roleResponse = new RoleResponse( name );

        return roleResponse;
    }
}
