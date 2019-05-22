package net.cakecdn.api.admin.user.service;

import net.cakecdn.api.admin.all.domain.dto.CustomPage;
import net.cakecdn.api.admin.user.domain.UserDto;
import net.cakecdn.api.admin.all.exception.ResourceNotFoundException;

public interface UserService {
    CustomPage<UserDto> listUser(int page, int size);

    void add(UserDto userDto);

    void edit(UserDto userDto, long id) throws ResourceNotFoundException;

    void delete(long id);

    UserDto get(long id) throws ResourceNotFoundException;
}
