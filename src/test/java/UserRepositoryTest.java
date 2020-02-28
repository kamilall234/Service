import com.kamil.serwis.model.SQL.User;
import com.kamil.serwis.repository.dao.SQL.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryTest {
    @Mock
    UserRepository userRepository;

    @Test
    void addUserToDB() {
        User newCreatedUser = new User("TestUser");
        
    }
}