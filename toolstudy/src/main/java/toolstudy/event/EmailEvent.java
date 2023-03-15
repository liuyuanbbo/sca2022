package toolstudy.event;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class EmailEvent {
    private String email;

    public EmailEvent(String email) {
        this.email = email;
    }
}
