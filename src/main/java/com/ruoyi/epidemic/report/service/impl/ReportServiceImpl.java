package com.ruoyi.epidemic.report.service.impl;

import com.ruoyi.epidemic.eperson.domain.EPerson;
import com.ruoyi.epidemic.eperson.mapper.EPersonMapper;
import com.ruoyi.epidemic.etrack.domain.ETrack;
import com.ruoyi.epidemic.etrack.mapper.ETrackMapper;
import com.ruoyi.epidemic.family.domain.EFamily;
import com.ruoyi.epidemic.family.mapper.EFamilyMapper;
import com.ruoyi.epidemic.report.mapper.ReportMapper;
import com.ruoyi.epidemic.report.service.ReportService;
import com.ruoyi.epidemic.report.vo.ReportVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Service
public class ReportServiceImpl implements ReportService {
    @Autowired
    ReportMapper reportMapper;
    @Autowired
    ThreadPoolTaskExecutor threadPoolTaskExecutor;
    @Autowired
    EFamilyMapper familyMapper;
    @Autowired
    EPersonMapper personMapper;
    @Autowired
    ETrackMapper eTrackMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insertReport(ReportVo reportVo) {
        //插入family（同住人员）
        familyMapper.insertEFamilys(reportVo.getE_id(),reportVo.getFamily());
        //插入step3Vo（发现及就诊经过）
        reportMapper.insertStep3Vo(reportVo.getE_id(),reportVo.getStep3Vo());
        //插入step4Vo（流行病学调查情况）
        reportMapper.insertStep4Vo(reportVo.getE_id(),reportVo.getStep4Vo());
        //插入step5Vo（密接者和次密接者调查）
        reportMapper.insertStep5Vo(reportVo.getE_id(),reportVo.getStep5Vo());
        //插入step6Vo（实验室检测情况）
        reportMapper.insertStep6Vo(reportVo.getE_id(),reportVo.getStep6Vo());
        //插入step7Vo（暴露场所管控）
        reportMapper.insertStep7Vo(reportVo.getE_id(),reportVo.getStep7Vo());
        //插入step8Vo（小结）
        reportMapper.insertStep8Vo(reportVo.getE_id(),reportVo.getStep8Vo());
        //插入step9Vo（已采取措施）
        reportMapper.insertStep9Vo(reportVo.getE_id(),reportVo.getStep9Vo());
        //插入step10Vo（下一步工作措施）
        reportMapper.insertStep10Vo(reportVo.getE_id(),reportVo.getStep10Vo());
    }

    @Override
    public Integer checkPerson(Long ryId) {
        //随便选取一张表查询是否存在数据
        return reportMapper.checkPerson(ryId);
    }

    @Override
    public ReportVo getReport(Long ryId) {
        ReportVo reportVo = new ReportVo();
        reportVo.setE_id(ryId);
        CompletableFuture<Void> familyFuture = CompletableFuture.runAsync(() -> {
            EFamily family = new EFamily();
            family.seteId(ryId);
            List<EFamily> eFamilies = familyMapper.selectEFamilyList(family);
            reportVo.setFamily(eFamilies);
        }, threadPoolTaskExecutor);

        CompletableFuture<Void> step3VoFuture = CompletableFuture.runAsync(() -> {
            ReportVo.Step3Vo step3Vos =  reportMapper.getStep3VoByEid(ryId);
            reportVo.setStep3Vo(step3Vos);
        }, threadPoolTaskExecutor);

        CompletableFuture<Void> step4VoFuture = CompletableFuture.runAsync(() -> {
            ReportVo.Step4Vo step4Vos =  reportMapper.getStep4VoByEid(ryId);
            reportVo.setStep4Vo(step4Vos);
        }, threadPoolTaskExecutor);

        CompletableFuture<Void> step5VoFuture = CompletableFuture.runAsync(() -> {
            ReportVo.Step5Vo step5Vos =  reportMapper.getStep5VoByEid(ryId);
            reportVo.setStep5Vo(step5Vos);
        }, threadPoolTaskExecutor);

        CompletableFuture<Void> step6VoFuture = CompletableFuture.runAsync(() -> {
            ReportVo.Step6Vo step6Vos =  reportMapper.getStep6VoByEid(ryId);
            reportVo.setStep6Vo(step6Vos);
        }, threadPoolTaskExecutor);

        CompletableFuture<Void> step7VoFuture = CompletableFuture.runAsync(() -> {
            ReportVo.Step7Vo step7Vos =  reportMapper.getStep7VoByEid(ryId);
            reportVo.setStep7Vo(step7Vos);
        }, threadPoolTaskExecutor);

        CompletableFuture<Void> step8VoFuture = CompletableFuture.runAsync(() -> {
            ReportVo.Step8Vo step8Vos =  reportMapper.getStep8VoByEid(ryId);
            reportVo.setStep8Vo(step8Vos);
        }, threadPoolTaskExecutor);

        CompletableFuture<Void> step9VoFuture = CompletableFuture.runAsync(() -> {
            ReportVo.Step9Vo step9Vos =  reportMapper.getStep9VoByEid(ryId);
            reportVo.setStep9Vo(step9Vos);
        }, threadPoolTaskExecutor);

        CompletableFuture<Void> step10VoFuture = CompletableFuture.runAsync(() -> {
            ReportVo.Step10Vo step10Vos =  reportMapper.getStep10VoByEid(ryId);
            reportVo.setStep10Vo(step10Vos);
        }, threadPoolTaskExecutor);

        CompletableFuture<Void> personFuture = CompletableFuture.runAsync(() -> {
            EPerson person =  personMapper.selectEPersonById(ryId);
            reportVo.setePerson(person);
        }, threadPoolTaskExecutor);

        CompletableFuture<Void> tracksFuture = CompletableFuture.runAsync(() -> {
            ETrack eTrack = new ETrack();
            eTrack.seteId(ryId);
            List<ETrack> eTracks = eTrackMapper.selectETrackList(eTrack);
            reportVo.seteTracks(eTracks);
        }, threadPoolTaskExecutor);

        try {
            CompletableFuture.allOf(familyFuture,step3VoFuture,step4VoFuture,step5VoFuture,step6VoFuture,step7VoFuture,step8VoFuture,step9VoFuture,step10VoFuture,personFuture,tracksFuture).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return reportVo;
    }
}
