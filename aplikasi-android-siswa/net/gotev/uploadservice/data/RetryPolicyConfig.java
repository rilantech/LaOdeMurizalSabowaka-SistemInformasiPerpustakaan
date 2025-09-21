package net.gotev.uploadservice.data;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\b\u0010\u0016\u001a\u00020\u0017H\u0016R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, d2 = {"Lnet/gotev/uploadservice/data/RetryPolicyConfig;", "", "initialWaitTimeSeconds", "", "maxWaitTimeSeconds", "multiplier", "defaultMaxRetries", "(IIII)V", "getDefaultMaxRetries", "()I", "getInitialWaitTimeSeconds", "getMaxWaitTimeSeconds", "getMultiplier", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "uploadservice_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: RetryPolicyConfig.kt */
public final class RetryPolicyConfig {
    private final int defaultMaxRetries;
    private final int initialWaitTimeSeconds;
    private final int maxWaitTimeSeconds;
    private final int multiplier;

    public static /* synthetic */ RetryPolicyConfig copy$default(RetryPolicyConfig retryPolicyConfig, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = retryPolicyConfig.initialWaitTimeSeconds;
        }
        if ((i5 & 2) != 0) {
            i2 = retryPolicyConfig.maxWaitTimeSeconds;
        }
        if ((i5 & 4) != 0) {
            i3 = retryPolicyConfig.multiplier;
        }
        if ((i5 & 8) != 0) {
            i4 = retryPolicyConfig.defaultMaxRetries;
        }
        return retryPolicyConfig.copy(i, i2, i3, i4);
    }

    public final int component1() {
        return this.initialWaitTimeSeconds;
    }

    public final int component2() {
        return this.maxWaitTimeSeconds;
    }

    public final int component3() {
        return this.multiplier;
    }

    public final int component4() {
        return this.defaultMaxRetries;
    }

    public final RetryPolicyConfig copy(int i, int i2, int i3, int i4) {
        return new RetryPolicyConfig(i, i2, i3, i4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RetryPolicyConfig)) {
            return false;
        }
        RetryPolicyConfig retryPolicyConfig = (RetryPolicyConfig) obj;
        return this.initialWaitTimeSeconds == retryPolicyConfig.initialWaitTimeSeconds && this.maxWaitTimeSeconds == retryPolicyConfig.maxWaitTimeSeconds && this.multiplier == retryPolicyConfig.multiplier && this.defaultMaxRetries == retryPolicyConfig.defaultMaxRetries;
    }

    public int hashCode() {
        return (((((Integer.hashCode(this.initialWaitTimeSeconds) * 31) + Integer.hashCode(this.maxWaitTimeSeconds)) * 31) + Integer.hashCode(this.multiplier)) * 31) + Integer.hashCode(this.defaultMaxRetries);
    }

    public RetryPolicyConfig(int initialWaitTimeSeconds2, int maxWaitTimeSeconds2, int multiplier2, int defaultMaxRetries2) {
        this.initialWaitTimeSeconds = initialWaitTimeSeconds2;
        this.maxWaitTimeSeconds = maxWaitTimeSeconds2;
        this.multiplier = multiplier2;
        this.defaultMaxRetries = defaultMaxRetries2;
    }

    public final int getInitialWaitTimeSeconds() {
        return this.initialWaitTimeSeconds;
    }

    public final int getMaxWaitTimeSeconds() {
        return this.maxWaitTimeSeconds;
    }

    public final int getMultiplier() {
        return this.multiplier;
    }

    public final int getDefaultMaxRetries() {
        return this.defaultMaxRetries;
    }

    public String toString() {
        int i = this.initialWaitTimeSeconds;
        int i2 = this.maxWaitTimeSeconds;
        int i3 = this.multiplier;
        return "{\"initialWaitTimeSeconds\": " + i + ", \"maxWaitTimeSeconds\": " + i2 + ", \"multiplier\": " + i3 + ", \"defaultMaxRetries\": " + this.defaultMaxRetries + "}";
    }
}
