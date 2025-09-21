package net.gotev.uploadservice.placeholders;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import net.gotev.uploadservice.data.UploadElapsedTime;
import net.gotev.uploadservice.data.UploadInfo;
import net.gotev.uploadservice.data.UploadRate;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\tH\u0016J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\tH\u0016¨\u0006\u0012"}, d2 = {"Lnet/gotev/uploadservice/placeholders/DefaultPlaceholdersProcessor;", "Lnet/gotev/uploadservice/placeholders/PlaceholdersProcessor;", "()V", "processPlaceholders", "", "message", "uploadInfo", "Lnet/gotev/uploadservice/data/UploadInfo;", "remainingFiles", "", "totalFiles", "uploadElapsedTime", "Lnet/gotev/uploadservice/data/UploadElapsedTime;", "uploadProgress", "percent", "uploadRate", "Lnet/gotev/uploadservice/data/UploadRate;", "uploadedFiles", "uploadservice_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: DefaultPlaceholdersProcessor.kt */
public class DefaultPlaceholdersProcessor implements PlaceholdersProcessor {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: DefaultPlaceholdersProcessor.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[UploadRate.UploadRateUnit.values().length];
            try {
                iArr[UploadRate.UploadRateUnit.BitPerSecond.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[UploadRate.UploadRateUnit.KilobitPerSecond.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[UploadRate.UploadRateUnit.MegabitPerSecond.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public String uploadElapsedTime(UploadElapsedTime uploadElapsedTime) {
        Intrinsics.checkNotNullParameter(uploadElapsedTime, "uploadElapsedTime");
        if (uploadElapsedTime.getMinutes() == 0) {
            return uploadElapsedTime.getSeconds() + " sec";
        }
        int minutes = uploadElapsedTime.getMinutes();
        return minutes + " min " + uploadElapsedTime.getSeconds() + " sec";
    }

    public String uploadRate(UploadRate uploadRate) {
        String suffix;
        Intrinsics.checkNotNullParameter(uploadRate, "uploadRate");
        switch (WhenMappings.$EnumSwitchMapping$0[uploadRate.getUnit().ordinal()]) {
            case 1:
                suffix = "b/s";
                break;
            case 2:
                suffix = "kb/s";
                break;
            case 3:
                suffix = "Mb/s";
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        return uploadRate.getValue() + " " + suffix;
    }

    public String uploadProgress(int percent) {
        return percent + " %";
    }

    public String uploadedFiles(int uploadedFiles) {
        return String.valueOf(uploadedFiles);
    }

    public String remainingFiles(int remainingFiles) {
        return String.valueOf(remainingFiles);
    }

    public String totalFiles(int totalFiles) {
        return String.valueOf(totalFiles);
    }

    public String processPlaceholders(String message, UploadInfo uploadInfo) {
        Intrinsics.checkNotNullParameter(uploadInfo, "uploadInfo");
        if (message == null) {
            return "";
        }
        int uploadedFiles = uploadInfo.getSuccessfullyUploadedFiles();
        int totalFiles = uploadInfo.getFiles().size();
        return StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(message, Placeholder.ElapsedTime.getValue(), uploadElapsedTime(uploadInfo.getElapsedTime()), false, 4, (Object) null), Placeholder.UploadRate.getValue(), uploadRate(uploadInfo.getUploadRate()), false, 4, (Object) null), Placeholder.Progress.getValue(), uploadProgress(uploadInfo.getProgressPercent()), false, 4, (Object) null), Placeholder.UploadedFiles.getValue(), uploadedFiles(uploadedFiles), false, 4, (Object) null), Placeholder.RemainingFiles.getValue(), remainingFiles(totalFiles - uploadedFiles), false, 4, (Object) null), Placeholder.TotalFiles.getValue(), totalFiles(totalFiles), false, 4, (Object) null);
    }
}
