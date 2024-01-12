package org.zerock.wcup.service;


import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.zerock.wcup.domain.Board;
import org.zerock.wcup.dto.BoardDTO;
import org.zerock.wcup.dto.PageRequestDTO;
import org.zerock.wcup.dto.PageResponseDTO;
import org.zerock.wcup.repository.BoardRepository;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;
    private final ModelMapper modelMapper;

    public PageResponseDTO<BoardDTO> list(PageRequestDTO pageRequestDTO){

        Pageable pageable = PageRequest.of(
                pageRequestDTO.getPage() -1,
                pageRequestDTO.getSize(),
                Sort.by("bno").descending()
                );
        Page<Board> result = boardRepository.findAll(pageable);

        long total = result.getTotalElements();
        int current = pageRequestDTO.getPage();
        int size = pageRequestDTO.getSize();

        java.util.List<BoardDTO> dtoList =
                result.map(board -> modelMapper.map(board, BoardDTO.class)).stream().toList();

        return new PageResponseDTO<>(total,current,size,dtoList);
    }

    public BoardDTO get(Long bno){

        Optional<Board> result = boardRepository.findById(bno);
        Board board = result.orElseThrow();
        BoardDTO boardDTO = modelMapper.map(board, BoardDTO.class);
        return boardDTO;
    }

}
