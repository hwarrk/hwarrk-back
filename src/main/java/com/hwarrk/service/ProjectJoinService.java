package com.hwarrk.service;

import com.hwarrk.global.common.dto.req.ProjectJoinApplyReq;
import com.hwarrk.global.common.dto.req.ProjectJoinDecideReq;
import com.hwarrk.global.common.dto.res.PageRes;
import org.springframework.data.domain.Pageable;

public interface ProjectJoinService {
    void applyJoin(Long memberId, ProjectJoinApplyReq groupJoinApplyReq);

    void decide(Long loginId,Long projectJoinId, ProjectJoinDecideReq projectJoinDecideReq);

    PageRes getProjectJoins(Long loginId, Long projectJoinId, Pageable pageable);

    PageRes getMyProjectJoins(Long loginId, Pageable pageable);
}
