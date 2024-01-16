package org.zerock.wcup.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class ReplyDTO {

    private Long rno;
    private String replyText;
    private String replyer;
    private Long bno;
    private LocalDateTime regDate;
    private LocalDateTime modDate;

    public ReplyDTO(Long rno, String replyText, String replyer, Long bno, LocalDateTime regDate, LocalDateTime modDate) {
        this.rno = rno;
        this.replyText = replyText;
        this.replyer = replyer;
        this.bno = bno;
        this.regDate = regDate;
        this.modDate = modDate;
    }
}
