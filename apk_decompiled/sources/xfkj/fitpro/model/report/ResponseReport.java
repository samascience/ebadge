package xfkj.fitpro.model.report;

import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class ResponseReport {
    private int chickenLegs;
    private int maxHeart;
    private List<MedalListDTO> medalList;
    private int prevSportDuration;
    private int sportDuration;
    private int sportWin;
    private int stepWin;
    private int totalDistance;
    private int totalKcal;
    private int totalSteps;
    private int totalTargetDays;

    public static class MedalListDTO {
        private String id;
        private String msgKey;
        private String name;
        private int type;
        private String url;
        private String winUrl;

        public String getId() {
            return this.id;
        }

        public String getMsgKey() {
            return this.msgKey;
        }

        public String getName() {
            return this.name;
        }

        public int getType() {
            return this.type;
        }

        public String getUrl() {
            return this.url;
        }

        public String getWinUrl() {
            return this.winUrl;
        }

        public void setId(String str) {
            this.id = str;
        }

        public void setMsgKey(String str) {
            this.msgKey = str;
        }

        public void setName(String str) {
            this.name = str;
        }

        public void setType(int i) {
            this.type = i;
        }

        public void setUrl(String str) {
            this.url = str;
        }

        public void setWinUrl(String str) {
            this.winUrl = str;
        }
    }

    public int getChickenLegs() {
        return this.chickenLegs;
    }

    public int getMaxHeart() {
        return this.maxHeart;
    }

    public List<MedalListDTO> getMedalList() {
        return this.medalList;
    }

    public int getPrevSportDuration() {
        return this.prevSportDuration;
    }

    public int getSportDuration() {
        return this.sportDuration;
    }

    public int getSportWin() {
        return this.sportWin;
    }

    public int getStepWin() {
        return this.stepWin;
    }

    public int getTotalDistance() {
        return this.totalDistance;
    }

    public int getTotalKcal() {
        return this.totalKcal;
    }

    public int getTotalSteps() {
        return this.totalSteps;
    }

    public int getTotalTargetDays() {
        return this.totalTargetDays;
    }

    public void setChickenLegs(int i) {
        this.chickenLegs = i;
    }

    public void setMaxHeart(int i) {
        this.maxHeart = i;
    }

    public void setMedalList(List<MedalListDTO> list) {
        this.medalList = list;
    }

    public void setPrevSportDuration(int i) {
        this.prevSportDuration = i;
    }

    public void setSportDuration(int i) {
        this.sportDuration = i;
    }

    public void setSportWin(int i) {
        this.sportWin = i;
    }

    public void setStepWin(int i) {
        this.stepWin = i;
    }

    public void setTotalDistance(int i) {
        this.totalDistance = i;
    }

    public void setTotalKcal(int i) {
        this.totalKcal = i;
    }

    public void setTotalSteps(int i) {
        this.totalSteps = i;
    }

    public void setTotalTargetDays(int i) {
        this.totalTargetDays = i;
    }
}
