package tsoy.sergey.boot311.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tsoy.sergey.boot311.dao.UserDao;
import tsoy.sergey.boot311.models.User;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    private final UserDao userDao;

    @Autowired
    public UserServiceImp( UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> getAll() {
        return userDao.getAll();
    }

    @Transactional
    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        userDao.delete(id);
    }

    @Transactional
    @Override
    public User getById(Long id) {
        return (User) userDao.getById(id);
    }

    @Transactional
    @Override
    public User getByName(String name) {
        return (User) userDao.getByName(name);
    }

    @Transactional
    @Override
    public void update(Long id, User updatedUser) {
        userDao.update(id, updatedUser);
    }
}
