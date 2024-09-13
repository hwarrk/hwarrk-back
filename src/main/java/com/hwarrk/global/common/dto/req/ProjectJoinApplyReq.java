package com.hwarrk.global.common.dto.req;

import com.hwarrk.global.common.constant.JoinType;
import jakarta.validation.constraints.NotNull;

public record ProjectJoinApplyReq(
        @NotNull
        Long projectId,
        @NotNull
        JoinType joinType
) {

}
