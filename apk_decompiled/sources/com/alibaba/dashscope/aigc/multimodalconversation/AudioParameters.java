package com.alibaba.dashscope.aigc.multimodalconversation;

import defpackage.xm2;
import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class AudioParameters implements Serializable {

    @xm2("voice")
    private Voice voice;

    public enum Voice {
        CHERRY("Cherry"),
        SERENA("Serena"),
        ETHAN("Ethan"),
        CHELSIE("Chelsie"),
        DYLAN("Dylan"),
        JADA("Jada"),
        SUNNY("Sunny"),
        NOFISH("Nofish"),
        JENNIFER("Jennifer"),
        LI("Li"),
        MARCUS("Marcus"),
        ROY("Roy"),
        PETER("Peter"),
        ERIC("Eric"),
        ROCKY("Rocky"),
        KIKI("Kiki"),
        RYAN("Ryan"),
        KATERINA("Katerina"),
        ELIAS("Elias"),
        MOMO("Momo"),
        MOON("Moon"),
        MAIA("Maia"),
        KAI("Kai"),
        BELLA("Bella"),
        AIDEN("Aiden"),
        ELDRIC_SAGE("Eldric Sage"),
        MIA("Mia"),
        MOCHI("Mochi"),
        BELLONA("Bellona"),
        VINCENT("Vincent"),
        BUNNY("Bunny"),
        NEIL("Neil"),
        ARTHUR("Arthur"),
        NINI("Nini"),
        EBONA("Ebona"),
        SEREN("Seren"),
        PIP("Pip"),
        STELLA("Stella"),
        BODEGA("Bodega"),
        SONRISA("Sonrisa"),
        ALEK("Alek"),
        DOLCE("Dolce"),
        SOHEE("Sohee"),
        ONO_ANNA("Ono Anna"),
        LENN("Lenn"),
        EMILIEN("Emilien"),
        ANDRE("Andre"),
        RADIO_GOL("Radio Gol"),
        VIVIAN("Vivian");

        private final String value;

        Voice(String str) {
            this.value = str;
        }

        public String getValue() {
            return this.value;
        }
    }

    public static abstract class b {
        private Voice a;

        public String toString() {
            return "AudioParameters.AudioParametersBuilder(voice=" + this.a + ")";
        }
    }

    private static final class c extends b {
        private c() {
        }
    }

    protected AudioParameters(b bVar) {
        this.voice = bVar.a;
    }

    public static b builder() {
        return new c();
    }

    protected boolean canEqual(Object obj) {
        return obj instanceof AudioParameters;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AudioParameters)) {
            return false;
        }
        AudioParameters audioParameters = (AudioParameters) obj;
        if (!audioParameters.canEqual(this)) {
            return false;
        }
        Voice voice = getVoice();
        Voice voice2 = audioParameters.getVoice();
        return voice != null ? voice.equals(voice2) : voice2 == null;
    }

    public Voice getVoice() {
        return this.voice;
    }

    public int hashCode() {
        Voice voice = getVoice();
        return 59 + (voice == null ? 43 : voice.hashCode());
    }

    public void setVoice(Voice voice) {
        this.voice = voice;
    }

    public String toString() {
        return "AudioParameters(voice=" + getVoice() + ")";
    }
}
