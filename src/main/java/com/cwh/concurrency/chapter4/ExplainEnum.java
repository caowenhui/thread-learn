package com.cwh.concurrency.chapter4;

public enum ExplainEnum {
    //快乐指数
    _1001(1001, "快乐指数是人们对客观事物态度的体验，是人们的需要是否获得满足的反映，积极的情绪可以提高机体的免疫功能，促进健康；消极的情绪可诱发疾病的产生，降低治疗的效果。", "Happiness index is the experience of people's attitude towards objective things and the reflection of whether people's needs are met. Positive emotions can improve the immune function of the body and promote health. Negative emotions can induce diseases and reduce the effect of treatment."),
    //睡眠质量
    _1002(1002, "反映您的睡眠状况是否良好。", "It reflects whether your sleep is good or not."),
    //营养状态
    _1005(1005, "营养状态与人体的消化、吸收和代谢能力密切相关，可以作为鉴定亚健康、健康和疾病的标准之一。", "The state of nutrition is closely related to the digestion, absorption and metabolism ability of human body, and can be used as one of the criteria for identifying sub-health, health and disease."),
    //免疫能力
    _1006(1006, "免疫能力是指人体免疫监视、防御、调控的能力。", "Immune competence refers to the ability of immune surveillance, defense and regulation of human body."),
    //消化能力
    _1007(1007, "消化能力是摄取、转运、消化食物等过程中整个胃肠道协调的生理活动的能力。", "Digestive ability is the ability of the whole gastrointestinal tract to coordinate physiological activities in the process of ingesting, transporting and digesting food."),
    //吸收能力
    _1008(1008, "人体对摄入食物的利用能力以及利用率。", "The ability of the human body to utilize food intake and its utilization rate."),
    //代谢能力,
    _1009(1009, "人体进行物质代谢和能量代谢的能力。", "The ability of the human body to metabolize substances and energy."),
    //男性功能
    _1010(1010, "男性功能是男性产生生殖细胞，繁殖新个体，分泌性激素和维持副性征的功能。", "Male function is the function of men to produce germ cells, reproduce new individuals, secrete sex hormones and maintain secondary sex characters."),
    //女性功能
    _1011(1011, "女性功能是女性产生生殖细胞，繁殖新个体，分泌性激素和维持副性征的功能。", "Female function is the function of women to produce germ cells, reproduce new individuals, secrete sex hormones and maintain secondary sex characters."),
    //
    ;

    private Integer targetId;
    private String explain;
    private String explainEn;

    ExplainEnum(Integer targetId, String explain, String explainEn) {
        this.targetId = targetId;
        this.explain = explain;
        this.explainEn = explainEn;
    }

    public Integer getTargetId() {
        return targetId;
    }

    public void setTargetId(Integer targetId) {
        this.targetId = targetId;
    }

    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain;
    }

    public String getExplainEn() {
        return explainEn;
    }

    public void setExplainEn(String explainEn) {
        this.explainEn = explainEn;
    }
}
