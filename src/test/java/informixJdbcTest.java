import static com.yscard.framework.jdbcrepository.JdbcRepository.pk;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.yscard.framework.common.model.Trader;
import com.yscard.framework.common.service.IFacadeYscardService;
import com.yscard.framework.jdbcrepository.reps.Comment;
import com.yscard.framework.jdbcrepository.reps.CommentRepository;
import com.yscard.framework.jdbcrepository.reps.User;
import com.yscard.framework.jdbcrepository.reps.UserRepository;
import com.yscard.framework.jdbcrepository.ymptp.Admin_Manager;
import com.yscard.framework.jdbcrepository.ymptp.Admin_ManagerRepository;
import com.yscard.framework.service.UserYscardService;

@ContextConfiguration(locations = "classpath:applicationContext.xml")
@RunWith(value = SpringJUnit4ClassRunner.class)
public class informixJdbcTest {

//	@Resource(name = "userYscardService")
//	UserYscardService userService;
//	
	@Resource(name = "ifacadeYscardService")
	IFacadeYscardService ifacadeservice;
	
	@Test
	public void  test1234()
	{
//		System.out.println(adminresitory);
//		Admin_Manager adminmanager =  new Admin_Manager("1", "1", 1, "1", "1", "1");
//		adminresitory.save(adminmanager);
		
		Trader trader = new Trader();
		ifacadeservice.saveAdminString();
		
	}

	// @Before
	// public void setup() {
	// userRepository.save(new User(someUser, new Date(), -1, false));
	// }

	// @Test
	// public void shouldGenerateSubsequentIds() throws Exception {
	// //given
	// final Comment firstComment = new Comment(someUser, "Some content", new
	// Date(), 0);
	// final Comment secondComment = new Comment(someUser, "Some content", new
	// Date(), 0);
	//
	// //when
	// repository.save(firstComment);
	// repository.save(secondComment);
	//
	// }
	
//	@Test
//	public void shouldGenerateSubsequentIds() {
//		Trader trader = new Trader();
//		ifacadeservice.saveSomeTestComment(trader);
//	}
//	
//	@Test
//	public void findAllComment(){
//		Trader trader = new Trader();
//		System.out.println(ifacadeservice.query(trader));
//	}
//	//
	// @Test
	// public void shouldUpdateCommentByGeneratedId() throws Exception {
	// //given
	// final Date oldDate = new Date(100000000);
	// final Date newDate = new Date(200000000);
	// final Comment comment = repository.save(new Comment(someUser,
	// "Some content", oldDate, 0));
	// final int id = comment.getId();
	//
	// //when
	// final Comment updatedComment = repository.save(new Comment(id, someUser,
	// "New content", newDate, 1));
	//
	// }

}
