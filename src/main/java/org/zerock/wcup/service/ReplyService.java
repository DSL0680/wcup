package org.zerock.wcup.service;


import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.zerock.wcup.domain.Reply;
import org.zerock.wcup.dto.ReplyDTO;
import org.zerock.wcup.repository.ReplyRepository;

@Service
@Log4j2
@Transactional
@RequiredArgsConstructor
public class ReplyService {

    private final ReplyRepository replyRepository;
    private final ModelMapper modelMapper;

    public Long register(ReplyDTO replyDTO) {
        //dto -> 엔티티로 변환 -> save -> rno

        Reply reply = modelMapper.map(replyDTO, Reply.class);

        log.info(reply);
        log.info(reply.getBoard());

        replyRepository.save(reply);

        return reply.getRno();
    }

}
