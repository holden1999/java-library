package com.enigma.Library.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter@Setter
@NoArgsConstructor
public class MemberSearchDTO {
    private String searchMemberFullname;
    private String searchMemberUsername;
}
