import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * @Author: 小小千千
 * @CreateTime: 2023/4/22 11:05
 * @Description: Junit单元测试Demo
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(value = {ClassDependency.class})
public class JunitStaticMethodTest {

    // 待测试的类
    private static TestService testService;

    @BeforeClass
    public static void init(){
        testService = new TestService();
    }

    @Test
    public void test(){
        PowerMockito.mockStatic(ClassDependency.class);
        PowerMockito.when(ClassDependency.staticTest()).thenReturn(false);
        Assert.assertFalse(testService.callStaticMethod());
    }

}
