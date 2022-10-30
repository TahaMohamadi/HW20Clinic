package service.UserAccount;

import base.service.BaseService;
import entity.UserAccount;

import java.util.Optional;

public interface UserAccountService extends BaseService<UserAccount> {
    Optional<UserAccount> findUserAccount(String username, String password);
    Optional<UserAccount> findUserAccount(String username);

}
