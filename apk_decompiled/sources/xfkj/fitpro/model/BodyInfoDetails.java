package xfkj.fitpro.model;

import defpackage.ts2;
import defpackage.zm1;

/* JADX INFO: loaded from: classes4.dex */
public class BodyInfoDetails {
    int sex = zm1.j();
    int age = zm1.c();
    float bmi = ts2.a();
    int height = zm1.k();
    int weight = zm1.C();
    float fat = ts2.c(this.bmi);
    int score = ts2.e();
    int targetSteps = zm1.u();

    public int getAge() {
        return this.age;
    }

    public float getBmi() {
        return this.bmi;
    }

    public float getFat() {
        return this.fat;
    }

    public int getHeight() {
        return this.height;
    }

    public int getScore() {
        return this.score;
    }

    public int getSex() {
        return this.sex;
    }

    public int getTargetSteps() {
        return this.targetSteps;
    }

    public int getWeight() {
        return this.weight;
    }

    public String toString() {
        return "BodyInfoDetails{sex=" + this.sex + ", age=" + this.age + ", bmi=" + this.bmi + ", height=" + this.height + ", weight=" + this.weight + ", fat=" + this.fat + ", score=" + this.score + ", targetSteps=" + this.targetSteps + '}';
    }
}
