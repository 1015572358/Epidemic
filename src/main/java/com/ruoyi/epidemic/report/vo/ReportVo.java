package com.ruoyi.epidemic.report.vo;

import com.ruoyi.epidemic.eperson.domain.EPerson;
import com.ruoyi.epidemic.etrack.domain.ETrack;
import com.ruoyi.epidemic.family.domain.EFamily;

import java.util.List;

/**
 * 报告对象
 */
public class ReportVo {
    private Long e_id;
    private List<EFamily> family;
    private List<ETrack> eTracks;
    private EPerson ePerson;
    private Step3Vo step3Vo;
    private Step4Vo step4Vo;
    private Step5Vo step5Vo;
    private Step6Vo step6Vo;
    private Step7Vo step7Vo;
    private Step8Vo step8Vo;
    private Step9Vo step9Vo;
    private Step10Vo step10Vo;

    public Long getE_id() {
        return e_id;
    }

    public void setE_id(Long e_id) {
        this.e_id = e_id;
    }

    public List<EFamily> getFamily() {
        return family;
    }

    public void setFamily(List<EFamily> family) {
        this.family = family;
    }

    public Step3Vo getStep3Vo() {
        return step3Vo;
    }

    public void setStep3Vo(Step3Vo step3Vo) {
        this.step3Vo = step3Vo;
    }

    public Step4Vo getStep4Vo() {
        return step4Vo;
    }

    public void setStep4Vo(Step4Vo step4Vo) {
        this.step4Vo = step4Vo;
    }

    public Step5Vo getStep5Vo() {
        return step5Vo;
    }

    public void setStep5Vo(Step5Vo step5Vo) {
        this.step5Vo = step5Vo;
    }

    public Step6Vo getStep6Vo() {
        return step6Vo;
    }

    public void setStep6Vo(Step6Vo step6Vo) {
        this.step6Vo = step6Vo;
    }

    public Step7Vo getStep7Vo() {
        return step7Vo;
    }

    public void setStep7Vo(Step7Vo step7Vo) {
        this.step7Vo = step7Vo;
    }

    public Step8Vo getStep8Vo() {
        return step8Vo;
    }

    public void setStep8Vo(Step8Vo step8Vo) {
        this.step8Vo = step8Vo;
    }

    public Step9Vo getStep9Vo() {
        return step9Vo;
    }

    public void setStep9Vo(Step9Vo step9Vo) {
        this.step9Vo = step9Vo;
    }

    public Step10Vo getStep10Vo() {
        return step10Vo;
    }

    public void setStep10Vo(Step10Vo step10Vo) {
        this.step10Vo = step10Vo;
    }

    public List<ETrack> geteTracks() {
        return eTracks;
    }

    public void seteTracks(List<ETrack> eTracks) {
        this.eTracks = eTracks;
    }

    public EPerson getePerson() {
        return ePerson;
    }

    public void setePerson(EPerson ePerson) {
        this.ePerson = ePerson;
    }

    public static class Step3Vo{
        private Long id;
        private Long e_id;
        private String casesSource;
        private String diagnosisProcess;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public Long getE_id() {
            return e_id;
        }

        public void setE_id(Long e_id) {
            this.e_id = e_id;
        }

        public String getDiagnosisProcess() {
            return diagnosisProcess;
        }

        public void setDiagnosisProcess(String diagnosisProcess) {
            this.diagnosisProcess = diagnosisProcess;
        }

        public String getCasesSource() {
            return casesSource;
        }

        public void setCasesSource(String casesSource) {
            this.casesSource = casesSource;
        }
    }

    public static  class Step4Vo{
        private Long id;
        private Long e_id;
        private String history;
        private String contact;
        private String hygiene;
        private String danger;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public Long getE_id() {
            return e_id;
        }

        public void setE_id(Long e_id) {
            this.e_id = e_id;
        }

        public String getHistory() {
            return history;
        }

        public void setHistory(String history) {
            this.history = history;
        }

        public String getContact() {
            return contact;
        }

        public void setContact(String contact) {
            this.contact = contact;
        }

        public String getHygiene() {
            return hygiene;
        }

        public void setHygiene(String hygiene) {
            this.hygiene = hygiene;
        }

        public String getDanger() {
            return danger;
        }

        public void setDanger(String danger) {
            this.danger = danger;
        }
    }

    public static  class Step5Vo{
        private Long id;
        private Long e_id;
        private String contactInvestigation;
        private String secondaryContactInvestigation;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public Long getE_id() {
            return e_id;
        }

        public void setE_id(Long e_id) {
            this.e_id = e_id;
        }

        public String getContactInvestigation() {
            return contactInvestigation;
        }

        public void setContactInvestigation(String contactInvestigation) {
            this.contactInvestigation = contactInvestigation;
        }

        public String getSecondaryContactInvestigation() {
            return secondaryContactInvestigation;
        }

        public void setSecondaryContactInvestigation(String secondaryContactInvestigation) {
            this.secondaryContactInvestigation = secondaryContactInvestigation;
        }
    }

    public static  class Step6Vo{
        private Long id;
        private Long e_id;
        private String nucleate;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public Long getE_id() {
            return e_id;
        }

        public void setE_id(Long e_id) {
            this.e_id = e_id;
        }

        public String getNucleate() {
            return nucleate;
        }

        public void setNucleate(String nucleate) {
            this.nucleate = nucleate;
        }
    }

    public static class Step7Vo{
        private Long id;
        private Long e_id;
        private String exposedPlaces;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public Long getE_id() {
            return e_id;
        }

        public void setE_id(Long e_id) {
            this.e_id = e_id;
        }

        public String getExposedPlaces() {
            return exposedPlaces;
        }

        public void setExposedPlaces(String exposedPlaces) {
            this.exposedPlaces = exposedPlaces;
        }
    }

    public static class Step8Vo{
        private Long id;
        private Long e_id;
        private String briefSummary;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public Long getE_id() {
            return e_id;
        }

        public void setE_id(Long e_id) {
            this.e_id = e_id;
        }

        public String getBriefSummary() {
            return briefSummary;
        }

        public void setBriefSummary(String briefSummary) {
            this.briefSummary = briefSummary;
        }
    }

    public static class Step9Vo{
        private Long id;
        private Long e_id;
        private String takeSteps;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public Long getE_id() {
            return e_id;
        }

        public void setE_id(Long e_id) {
            this.e_id = e_id;
        }

        public String getTakeSteps() {
            return takeSteps;
        }

        public void setTakeSteps(String takeSteps) {
            this.takeSteps = takeSteps;
        }
    }

    public static class Step10Vo{
        private Long id;
        private Long e_id;
        private String nextSteps;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public Long getE_id() {
            return e_id;
        }

        public void setE_id(Long e_id) {
            this.e_id = e_id;
        }

        public String getNextSteps() {
            return nextSteps;
        }

        public void setNextSteps(String nextSteps) {
            this.nextSteps = nextSteps;
        }
    }
}





