package tis.springcommunityproject.api;

import tis.springcommunityproject.domain.PostEntity;
import tis.springcommunityproject.domain.UserEntity;

import java.time.LocalDateTime;

import static org.springframework.beans.BeanUtils.copyProperties;

public class PostDto {
	private String title;

	private String content;

	private UserEntity user;

	private LocalDateTime createAt;

	private LocalDateTime updateAt;

	public PostDto(PostEntity source) {
		copyProperties(source, this);
	}

	public PostEntity newPostEntity() {
		return PostEntity.of(title, content, user);
	}

}
