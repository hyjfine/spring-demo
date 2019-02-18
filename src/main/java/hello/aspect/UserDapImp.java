package hello.aspect;

import org.springframework.stereotype.Repository;

@Repository
public class UserDapImp implements UserDao {
    @Override
    public int addUser(String name) {
        System.out.println("add user ----------");
        return 0;
    }

    @Override
    public void updateUser() {
        System.out.println("update user ----------");
    }

    @Override
    public void deleteUser() {
        System.out.println("delete user ----------");

    }

    @Override
    public void findUser() {
        System.out.println("find user ----------");
    }
}
