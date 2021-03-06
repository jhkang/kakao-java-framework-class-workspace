package kr.ac.jejunu;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;


/**
 * Created by jhkang on 3/25/16.
 */
public class UserDaoTest {
    private UserDao userDao;

    @Before
    public void setUp() {
        ApplicationContext applicationContext
                = new GenericXmlApplicationContext("daoFactory.xml");
        userDao = (UserDao) applicationContext.getBean("userDao");
    }

    @Test
    public void get() {
        Long id = 1L;
        String name = "허윤호";
        String password = "1234";

        User user = userDao.get(id);

        validate(id, name, password, user);
    }

    @Test
    public void add() {
        User user = new User();

        String name = "헐크";
        String password = "2222";

        user.setName(name);
        user.setPassword(password);

        Long id = userDao.add(user);
        User resultUser = userDao.get(id);

        validate(id, name, password, resultUser);
    }

    @Test
    public void deleted() {
        User user = new User();

        String name = "헐크";
        String password = "2222";

        user.setName(name);
        user.setPassword(password);

        Long id = userDao.add(user);

        userDao.delete(id);

        User resultUser = userDao.get(id);
        assertThat(resultUser, nullValue());
    }

    @Test
    public void update() {
        User user = new User();

        String name = "헐크";
        String password = "2222";

        user.setName(name);
        user.setPassword(password);

        Long id = userDao.add(user);

        name = "허윤호";
        password = "1111";

        user.setName(name);
        user.setPassword(password);
        user.setId(id);

        userDao.update(user);

        User resultUser = userDao.get(id);
        validate(id, name, password, resultUser);
    }

    private void validate(Long id, String name, String password, User user) {
        assertThat(user.getId(), is(id));
        assertThat(user.getName(), is(name));
        assertThat(user.getPassword(), is(password));
    }

}
