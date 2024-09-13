package com.hwarrk.service;

import com.hwarrk.global.common.dto.req.ProjectCreateReq;
import com.hwarrk.global.common.dto.req.ProjectUpdateReq;
import com.hwarrk.global.common.dto.res.ProjectRes;
import com.hwarrk.global.common.dto.res.PageRes;
import org.springframework.data.domain.Pageable;

public interface ProjectService {
    Long createProject(Long loginId, ProjectCreateReq req);

    ProjectRes getProject(Long projectId);

    PageRes<ProjectRes> getProjects(Pageable pageable);

    void deleteProject(Long loginId, Long projectId);

    void updateProject(Long loginId, Long projectId, ProjectUpdateReq req);
}
