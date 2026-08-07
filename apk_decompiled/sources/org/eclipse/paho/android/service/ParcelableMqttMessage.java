package org.eclipse.paho.android.service;

import android.os.Parcel;
import android.os.Parcelable;
import org.eclipse.paho.client.mqttv3.MqttMessage;

/* JADX INFO: loaded from: classes4.dex */
public class ParcelableMqttMessage extends MqttMessage implements Parcelable {
    public static final Parcelable.Creator<ParcelableMqttMessage> CREATOR = new a();
    String a;

    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ParcelableMqttMessage createFromParcel(Parcel parcel) {
            return new ParcelableMqttMessage(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public ParcelableMqttMessage[] newArray(int i) {
            return new ParcelableMqttMessage[i];
        }
    }

    ParcelableMqttMessage(Parcel parcel) {
        super(parcel.createByteArray());
        this.a = null;
        setQos(parcel.readInt());
        boolean[] zArrCreateBooleanArray = parcel.createBooleanArray();
        setRetained(zArrCreateBooleanArray[0]);
        setDuplicate(zArrCreateBooleanArray[1]);
        this.a = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByteArray(getPayload());
        parcel.writeInt(getQos());
        parcel.writeBooleanArray(new boolean[]{isRetained(), isDuplicate()});
        parcel.writeString(this.a);
    }
}
