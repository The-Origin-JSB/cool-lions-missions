package tis.springcommunityproject;

import org.springframework.stereotype.Component;
import tis.springcommunityproject.domain.BoardEntity;
import tis.springcommunityproject.domain.UserEntity;
import tis.springcommunityproject.repository.JpaBoardRepository;
import tis.springcommunityproject.repository.JpaPostRepository;
import tis.springcommunityproject.repository.JpaUserRepository;

import javax.annotation.PostConstruct;

@Component
public class DataInit {

	private final JpaBoardRepository boardRepository;
	private final JpaPostRepository postRepository;
	private final JpaUserRepository userRepository;

	public DataInit(JpaBoardRepository boardRepository, JpaPostRepository postRepository, JpaUserRepository userRepository) {
		this.boardRepository = boardRepository;
		this.postRepository = postRepository;
		this.userRepository = userRepository;
	}

	@PostConstruct
	public void inIt() {
		BoardEntity board = BoardEntity.of(null, null, "test title");
		boardRepository.save(board);
		UserEntity user = UserEntity.of(null, "name", null, null);
		userRepository.save(user);
	}

}
