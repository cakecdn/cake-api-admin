package net.cakecdn.api.admin.user.domain;

import lombok.*;
import net.cakecdn.api.admin.all.domain.Role;
import net.cakecdn.api.admin.all.domain.User;
import org.apache.commons.lang.StringUtils;
import org.hibernate.validator.constraints.URL;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserDto {
    private long id;

    @NotEmpty(message = "用户名不能为空！")
    @Pattern(
            regexp = "^[a-zA-Z][a-zA-Z0-9]{5,15}$",
            message = "用户名为6-16个大小写英文、数字和下划线，且不能以数字开头！"
    )
    private String username;

    @NotEmpty(message = "密码不能为空！")
    @Size(min = 8, max = 32, message = "密码长度需要在3-32位间！")
    private String password;

    @Email(message = "合法的电子邮件格式需要如下：hsong@love.com")
    @NotEmpty(message = "电子邮件不能为空！")
    private String email;

    @Pattern(
            regexp = "^1[0-9]{10}$",
            message = "只支持中国大陆地区11位手机号！"
    )
    private String cellphone;

    @URL(message = "需要合法的URL地址！")
    private String avatar;

    private Date created;

    private Date updated;

    private List<String> roles;

    private boolean disabled;

    public User create() {
        User user = new User();
        user.setUsername(username);
        if (!StringUtils.isBlank(password))
            user.setPassword(new BCryptPasswordEncoder().encode(password));
        if (StringUtils.isBlank(this.avatar))
            this.avatar = "#";
        user.setAvatar(avatar);
        user.setEmail(email);
        user.setCellphone(cellphone);
        user.setCreated(new Date());
        user.setDisabled(disabled);
        user.setAuthorities(Role.build(this.roles));
        return user;
    }

    public User update() {
        User user = create();
        user.setId(id);
        return user;
    }

    public User update(long id) {
        User user = create();
        user.setId(id);
        return user;
    }

    public UserDto(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        // this.password = user.getPassword();
        this.email = user.getEmail();
        this.cellphone = user.getCellphone();
        this.avatar = user.getAvatar();
        this.created = user.getCreated();
        this.updated = user.getUpdated();
        this.disabled = user.isDisabled();
        this.roles = new LinkedList<>();
        for (Role role : user.getAuthorities()) {
            this.roles.add(role.getName());
        }
    }
}
