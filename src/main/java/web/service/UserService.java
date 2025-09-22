package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.model.User;

import java.util.List;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserDao userDao;

    public List<User> getAllUsers() {
        return userDao.findAll();
    }

    public User getUserById(Long id) {
        User user = userDao.findById(id);
        if (user == null) {
            throw new RuntimeException("User not found with id: " + id);
        }
        return user;
    }

    public void saveUser(User user) {
        userDao.save(user);
    }

    public void updateUser(User user) {
        // Проверяем существование пользователя
        getUserById(user.getId());
        userDao.update(user);
    }

    public void deleteUser(Long id) {
        User user = getUserById(id);
        userDao.delete(user);
    }
}
