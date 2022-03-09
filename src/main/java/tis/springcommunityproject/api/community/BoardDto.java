package tis.springcommunityproject.api.community;

import tis.springcommunityproject.domain.PostEntity;
import tis.springcommunityproject.domain.community.BoardEntity;
import tis.springcommunityproject.domain.community.BoardPostEntity;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class BoardDto {
	private List<BoardPostDto> postList;

	private String title;

	protected BoardDto() {
	}

	public BoardDto(List<BoardPostDto> postList, String title) {
		//유효성 검사

		this.postList = postList;
		this.title = title;
	}

	public BoardDto(BoardEntity source) {
		this(source.getPostList().stream().map(BoardPostDto::new).collect(Collectors.toList()), source.getTitle());
	}

	public List<BoardPostDto> getPostList() {
		return Collections.unmodifiableList(postList);
	}

	public String getTitle() {
		return title;
	}
}
