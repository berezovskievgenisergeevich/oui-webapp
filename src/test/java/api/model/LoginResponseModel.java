package api.model;

import lombok.Data;
import lombok.NonNull;

@Data
@NonNull
public class LoginResponseModel {
    private String a_session_oui_dev_legacy, a_session_oui_dev;

}
