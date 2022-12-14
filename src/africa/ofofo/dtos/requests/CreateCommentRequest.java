package africa.ofofo.dtos.requests;

import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Data
public class CreateCommentRequest {
    private int postId;
    private String commenterName;
    private String comment;

}