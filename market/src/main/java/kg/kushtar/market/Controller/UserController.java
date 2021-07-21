package kg.kushtar.market.Controller;

import kg.kushtar.market.Mapper.UserMapper;
import kg.kushtar.market.Model.Dto.UserDto;
import kg.kushtar.market.Model.User;
import kg.kushtar.market.Service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController implements BaseCrudController<UserDto, Long>{

    private UserService userService;
    private UserMapper userMapper;

    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @Override
    public UserDto save(UserDto userDto) {
        return userMapper.toDto(userService.create(userMapper.toEntity(userDto)));
    }

    @Override
    public UserDto update(UserDto userDto) {
        return userMapper.toDto(userService.create(userMapper.toEntity(userDto)));
    }

    @Override
    public List<UserDto> findAll() {
        return userMapper.toDtoList(userService.findAll());
    }

    @Override
    public UserDto findById(Long aLong) {
        return userMapper.toDto(userService.findById(aLong));
    }

    @Override
    public void deleteById(Long aLong) {
        userService.deleteById(aLong);
    }

    @Override
    public UserDto findByName(String name) {
        return userMapper.toDto(userService.findByName(name));
    }
}
