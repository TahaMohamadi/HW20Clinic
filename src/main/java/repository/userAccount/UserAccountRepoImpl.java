package repository.userAccount;

import base.repository.impl.BaseRepositoryImpl;
import entity.UserAccount;
import jakarta.persistence.EntityManager;
import util.Hibernate;

import java.util.Optional;

public class UserAccountRepoImpl extends BaseRepositoryImpl<UserAccount> implements UserAccountRepo {
    public UserAccountRepoImpl(EntityManager em) {
        super(em);
    }

    @Override
    public Class<UserAccount> getEntityClass() {
        return UserAccount.class;
    }

    @Override
    public Optional<UserAccount> findUserAccount(String username, String password) {
        String jpql = """
                select u from UserAccount u where u.username = :username and u.password = :password
                """;
        return Optional.ofNullable(Hibernate.getEntityManagerFactory().createEntityManager().createQuery(jpql, UserAccount.class)
                .setParameter("username", username).setParameter("password", password).getSingleResult());
    }

    @Override
    public Optional<UserAccount> findUserAccount(String username) {
        String jpql = """
                select u from UserAccount u where u.username = :username
                """;
        return Optional.ofNullable(Hibernate.getEntityManagerFactory().createEntityManager().createQuery(jpql, UserAccount.class)
                .setParameter("username", username).getSingleResult());
    }

}
