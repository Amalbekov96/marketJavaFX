package kg.kushtar.market.Service.Impl;

import kg.kushtar.market.Model.User;
import kg.kushtar.market.Repository.UserRepo;
import kg.kushtar.market.Service.UserService;
import kg.kushtar.market.Service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends BaseServiceImpl<User, UserRepo> implements UserService {
}
