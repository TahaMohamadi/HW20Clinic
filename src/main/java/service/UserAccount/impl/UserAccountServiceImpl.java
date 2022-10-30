package service.UserAccount.impl;

import base.service.impl.BaseServiceImpl;
import entity.UserAccount;
import repository.userAccount.UserAccountRepo;
import repository.userAccount.UserAccountRepoImpl;
import service.UserAccount.UserAccountService;
import util.Hibernate;

import java.util.Optional;

public class UserAccountServiceImpl extends BaseServiceImpl<UserAccount, UserAccountRepo> implements UserAccountService {

    private final UserAccountRepo userAccountRepo = new UserAccountRepoImpl(Hibernate.getEntityManagerFactory().createEntityManager());

    public UserAccountServiceImpl(UserAccountRepoImpl repository) {
        super(repository);
    }


    public Optional<UserAccount> findUserAccount(String username, String password) {
        try {
            return userAccountRepo.findUserAccount(username, password);
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<UserAccount> findUserAccount(String username) {
        try {
            return userAccountRepo.findUserAccount(username);
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}
