package net.cakecdn.api.admin.user.web;

import net.cakecdn.api.admin.all.domain.dto.AjaxResult;
import net.cakecdn.api.admin.all.domain.dto.CustomPage;
import net.cakecdn.api.admin.user.domain.UserDto;
import net.cakecdn.api.admin.user.service.UserService;
import net.cakecdn.api.admin.all.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public AjaxResult page(@RequestParam int page, @RequestParam int size) {
        CustomPage customPage = userService.listUser(page, size);
        return AjaxResult.success(customPage);
    }

    @GetMapping("/{id}")
    public AjaxResult get(@PathVariable long id) throws ResourceNotFoundException {
        UserDto user = userService.get(id);
        return AjaxResult.success(user);
    }

    @PostMapping
    public AjaxResult add(@RequestBody @Valid UserDto userDto) {
        userService.add(userDto);
        return AjaxResult.success();
    }

    @PutMapping("/{id}")
    public AjaxResult edit(@RequestBody UserDto userDto, @PathVariable long id) throws ResourceNotFoundException {
        userService.edit(userDto, id);
        return AjaxResult.success();
    }

    @DeleteMapping("/{id}")
    public AjaxResult delete(@PathVariable long id) {
        userService.delete(id);
        return AjaxResult.success();
    }
}
