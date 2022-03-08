package tis.springcommunityproject.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tis.springcommunityproject.domain.PostEntity;
import tis.springcommunityproject.repository.JpaBoardRepository;
import tis.springcommunityproject.repository.JpaPostRepository;
import tis.springcommunityproject.repository.JpaUserRepository;

import java.util.Objects;

@Service
public class CommunityServiceImpl implements CommunityService{

	private final JpaBoardRepository boardRepository;
	private final JpaPostRepository postRepository;
	private final JpaUserRepository userRepository;

	public CommunityServiceImpl(JpaBoardRepository boardRepository, JpaPostRepository postRepository, JpaUserRepository userRepository) {
		this.boardRepository = boardRepository;
		this.postRepository = postRepository;
		this.userRepository = userRepository;
	}

	@Override
	@Transactional
	public PostEntity create(Long boardId, PostEntity post) {
		return postRepository.save(post);
	}

	@Override
	@Transactional(readOnly = true)
	public PostEntity findOne(Long boardId, Long postId, Long authId) {
		return postRepository.findById(postId).orElseThrow(NotFoundDataException::new);
	}

	@Override
	@Transactional
	public PostEntity updateOne(Long boardId, Long postId, PostEntity post, Long authId) {
		PostEntity findPost = findOne(boardId, postId, authId);
		if (!post.getContent().isEmpty()) {
			findPost.updateContent(post.getContent());
		}
		if (!post.getContent().isEmpty()) {
			findPost.updateTitle(post.getTitle());
		}
		postRepository.save(Objects.requireNonNull(findPost));
		return findPost;
	}

	@Override
	@Transactional
	public void deleteOne(Long boardId, Long postId, Long authId) {
		postRepository.deleteById(postId);
	}
}
