package Tings.com.tings.room;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

/**
 * Created by giladl1 on 5/13/2018.
 */
@Entity
public class Samples {
    @NonNull
    @PrimaryKey
    private String sampleId;
    private String sampleName;
    private String sampleTime;
    private String sampleLat;
    private String sampleLong;
    private String sampleSpeed;

    public Samples() {
    }

    public String getSampleId() { return sampleId; }
    public void setSampleId(String sampleId) { this.sampleId = sampleId; }
    public String getSampleName() { return sampleName; }
    public void setSampleName (String sampleName) { this.sampleName = sampleName; }

    public String getSampleTime() { return sampleTime; }
    public void setSampleTime(String sampleTime) {
        this.sampleTime = sampleTime;
    }
    public String getSampleLat() { return sampleLat; }
    public void setSampleLat(String sampleLat) {
        this.sampleLat = sampleLat;
    }
    public String getSampleLong() { return sampleLong; }
    public void setSampleLong(String sampleLong) {
        this.sampleLong = sampleLong;
    }
    public String getSampleSpeed() { return sampleSpeed; }
    public void setSampleSpeed(String sampleSpeed) {
        this.sampleSpeed = sampleSpeed;
    }
}
