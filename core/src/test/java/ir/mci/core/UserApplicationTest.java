//package ir.mci.core;
//
//import ir.mci.core.model.User;
//import ir.mci.core.repository.UserRepository;
//import org.assertj.core.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//@SpringBootTest
//class UserApplicationTest {
//@Autowired
//	UserRepository userRepository;
//@Test
//public void givenUserThenSave()  throws NullPointerException{
//	User user=new User(1L,"John","123","Fname","Lname","view1","view2"
//			,"view3","view4","view5","view6");
//	userRepository.save(user);
//	Assertions.assertThat(userRepository.findById(user.getId()).orElse(null)).isNotNull();
//}
//	@Test
//	void contextLoads() {
//
//
//	}
//
//}
