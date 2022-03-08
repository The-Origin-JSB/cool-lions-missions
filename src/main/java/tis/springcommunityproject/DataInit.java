package tis.springcommunityproject;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import tis.springcommunityproject.domain.BoardEntity;
import tis.springcommunityproject.domain.PostEntity;
import tis.springcommunityproject.domain.UserEntity;
import tis.springcommunityproject.repository.JpaBoardRepository;
import tis.springcommunityproject.repository.JpaPostRepository;
import tis.springcommunityproject.repository.JpaUserRepository;

import javax.annotation.PostConstruct;

@Slf4j
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
		BoardEntity boardEntity = boardRepository.save(board);
		log.info("creaete boardEntity {}{}", boardEntity.getId(), boardEntity.getTitle());



		UserEntity user = UserEntity.of(null, "name", null);
		UserEntity userEntity = userRepository.save(user);
		log.info("creaete userEntity {}{}", userEntity.getId(), userEntity.getName());


		PostEntity post = PostEntity.of("test title", "test content");
		PostEntity postEntity = postRepository.save(post);
		log.info("creaete postEntity {}{}", postEntity.getId(), postEntity.getTitle());

	}

}
