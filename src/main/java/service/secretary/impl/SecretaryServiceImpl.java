package service.secretary.impl;

import base.service.impl.BaseServiceImpl;
import entity.Secretary;
import repository.secretary.SecretaryRepo;
import repository.secretary.impl.SecretaryRepoImpl;
import service.secretary.SecretaryService;
import util.Hibernate;

public class
SecretaryServiceImpl extends BaseServiceImpl<Secretary, SecretaryRepo> implements SecretaryService {

    public SecretaryServiceImpl(SecretaryRepo repository) {
        super(repository);
    }
}
