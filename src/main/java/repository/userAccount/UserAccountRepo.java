package repository.userAccount;

import base.repository.BaseRepository;
import entity.UserAccount;

import java.util.Optional;

public interface UserAccountRepo extends BaseRepository<UserAccount> {
    Optional<UserAccount> findUserAccount(String username, String password);

    Optional<UserAccount> findUserAccount(String username);
}
