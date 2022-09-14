package com.ruoyi.epidemic.report.mapper;


import com.ruoyi.epidemic.report.vo.ReportVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ReportMapper {

    void insertStep3Vo(@Param("eId") Long e_id,@Param("step3Vo") ReportVo.Step3Vo step3Vo);

    void insertStep4Vo(@Param("eId")Long e_id,@Param("step4Vo") ReportVo.Step4Vo step4Vo);

    void insertStep5Vo(@Param("eId")Long e_id,@Param("step5Vo")  ReportVo.Step5Vo step5Vo);

    void insertStep6Vo(@Param("eId")Long e_id,@Param("step6Vo")  ReportVo.Step6Vo step6Vo);

    void insertStep7Vo(@Param("eId")Long e_id,@Param("step7Vo")  ReportVo.Step7Vo step7Vo);

    void insertStep8Vo(@Param("eId")Long e_id,@Param("step8Vo")  ReportVo.Step8Vo step8Vo);

    void insertStep9Vo(@Param("eId")Long e_id,@Param("step9Vo")  ReportVo.Step9Vo step9Vo);

    void insertStep10Vo(@Param("eId")Long e_id,@Param("step10Vo")  ReportVo.Step10Vo step10Vo);

    Integer checkPerson(Long ryId);

    ReportVo.Step3Vo getStep3VoByEid(Long ryId);

    ReportVo.Step4Vo getStep4VoByEid(Long ryId);

    ReportVo.Step5Vo getStep5VoByEid(Long ryId);

    ReportVo.Step6Vo getStep6VoByEid(Long ryId);

    ReportVo.Step7Vo getStep7VoByEid(Long ryId);

    ReportVo.Step8Vo getStep8VoByEid(Long ryId);

    ReportVo.Step9Vo getStep9VoByEid(Long ryId);

    ReportVo.Step10Vo getStep10VoByEid(Long ryId);
}
