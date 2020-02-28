import com.kamil.serwis.repository.dao.SQL.UserRepository;
import com.kamil.serwis.service.User.UserService;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {

    @Mock
    UserRepository userRepository;

    @InjectMocks
    UserService userService;


}