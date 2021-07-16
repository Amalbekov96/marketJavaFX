package kg.kushtar.market.Mapper;

import kg.kushtar.market.Model.Dto.UserDto;
import kg.kushtar.market.Model.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper extends BaseMapper<User, UserDto>{
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
}
