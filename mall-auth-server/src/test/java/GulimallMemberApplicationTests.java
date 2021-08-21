import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author hongting
 * @create 2021 08 17 2:01 PM
 */
@SpringBootTest
public class GulimallMemberApplicationTests {

    @Test
    public void contextLoads() {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodePassword = passwordEncoder.encode("asdzxc");
        System.out.println(encodePassword);
    }

}