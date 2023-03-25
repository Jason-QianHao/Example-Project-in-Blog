import com.jason.repository.UserRepository;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @Author: 小小千千
 * @CreateTime: 2023/3/25 13:35
 * @Description:
 */
public class UserRepositoryTest {

    /**不配置也可以都去，建议配置*/
    @BeforeClass
    public static void setLogger(){
        System.setProperty("logging.config", "classpath:log4j2-test.xml");
    }

    @Test
    public void test(){
        new UserRepository().getUserByName("test");
    }
}
