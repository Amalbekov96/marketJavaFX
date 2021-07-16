package kg.kushtar.market.Mapper.Impl;

import kg.kushtar.market.Mapper.UserMapper;
import kg.kushtar.market.Model.Dto.UserDto;
import kg.kushtar.market.Model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserMapperImpl implements UserMapper {
    @Override
    public User toEntity(UserDto userDto) {
        return UserMapper.INSTANCE.toEntity(userDto);
    }

    @Override
    public UserDto toDto(User user) {
        return UserMapper.INSTANCE.toDto(user);
    }

    @Override
    public List<User> toEntityList(List<UserDto> dtoList) {
        return UserMapper.INSTANCE.toEntityList(dtoList);
    }

    @Override
    public List<UserDto> toDtoList(List<User> entityList) {
        return UserMapper.INSTANCE.toDtoList(entityList);
    }
}
