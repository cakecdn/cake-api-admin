package net.cakecdn.api.admin.user.service;

import net.cakecdn.api.admin.all.domain.User;
import net.cakecdn.api.admin.all.domain.dto.CustomPage;
import net.cakecdn.api.admin.all.repository.UserRepository;
import net.cakecdn.api.admin.user.domain.UserDto;
import net.cakecdn.api.admin.all.exception.ResourceNotFoundException;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public CustomPage<UserDto> listUser(int page, int size) {
        Page<User> userPage = userRepository.findAll(PageRequest.of(page, size));

        CustomPage<UserDto> userDtoCustomPage = new CustomPage<>();
        userDtoCustomPage.setPage(page);
        userDtoCustomPage.setPageCount(userPage.getTotalPages());
        userDtoCustomPage.setTotal(userPage.getTotalElements());

        List<UserDto> dtoPageList = userPage.getContent().stream().map(UserDto::new).collect(Collectors.toList());
        userDtoCustomPage.setList(dtoPageList);

        return userDtoCustomPage;
    }

    @Override
    public void add(UserDto userDto) {
        User toBeSaved = userDto.create();
        userRepository.save(toBeSaved);
    }

    @Override
    public void edit(UserDto userDto, long id) throws ResourceNotFoundException {
        User toBeSaved = userDto.update(id);
        if (StringUtils.isBlank(toBeSaved.getPassword())) {
            User existing = userRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
            toBeSaved.setPassword(existing.getPassword());
        }
        userRepository.save(toBeSaved);
    }

    @Override
    public void delete(long id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserDto get(long id) throws ResourceNotFoundException {
        User po = userRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
        return new UserDto(po);
    }
}
