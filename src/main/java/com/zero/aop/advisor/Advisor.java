package com.zero.aop.advisor;

public class Advisor {
    private Advice advice;

    private PointCut pointCut;

    public Advice getAdvice() {
        return advice;
    }

    public void setAdvice(Advice advice) {
        this.advice = advice;
    }

    public PointCut getPointCut() {
        return pointCut;
    }

    public void setPointCut(PointCut pointCut) {
        this.pointCut = pointCut;
    }
}
