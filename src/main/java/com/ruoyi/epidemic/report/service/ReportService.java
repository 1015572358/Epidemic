package com.ruoyi.epidemic.report.service;

import com.ruoyi.epidemic.report.vo.ReportVo;

public interface ReportService {
    void insertReport(ReportVo reportVo);

    Integer checkPerson(Long ryId);

    ReportVo getReport(Long ryId);
}
