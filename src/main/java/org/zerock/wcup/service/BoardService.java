package org.zerock.wcup.service;


import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.zerock.wcup.domain.Board;
import org.zerock.wcup.dto.BoardDTO;
import org.zerock.wcup.repository.BoardRepository;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;
    private final ModelMapper modelMapper;

    public BoardDTO get(Long bno){

        Optional<Board> result = boardRepository.findById(bno);
        Board board = result.orElseThrow();
        BoardDTO boardDTO = modelMapper.map(board, BoardDTO.class);
        return boardDTO;
    }

}
